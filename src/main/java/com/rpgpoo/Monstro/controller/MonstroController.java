package com.rpgpoo.Monstro.controller;

import com.rpgpoo.Gerenciador.Gerenciador;
import com.rpgpoo.Monstro.model.MonstroModel;
import com.rpgpoo.Monstro.view.MonstroView;

import javax.swing.*;
import javax.swing.table.DefaultTableModel;
import java.util.ArrayList;
import java.util.List;

public class MonstroController {
    private final MonstroView view;
    private final Gerenciador gerenciador;

    // TODO: Quando existir um banco de dados real, trocar estas listas pelos seus respectivos Repositories/DAOs
    // ex: private final MonstroRepository monstroRepository;
    private List<MonstroModel> monstrosMock = new ArrayList<>();
    private List<String> racasMock = new ArrayList<>();
    private List<String> armasMock = new ArrayList<>();

    public MonstroController(MonstroView view, Gerenciador gerenciador) {
        this.view = view;
        this.gerenciador = gerenciador;

        this.view.getBtnSalvar().addActionListener(e -> btnSalvarClick());
        this.view.getBtnExcluir().addActionListener(e -> btnExcluirClick());
        this.view.getBtnAdicionarLoot().addActionListener(e -> btnAdicionarLootClick());
        this.view.getBtnRemoverLoot().addActionListener(e -> btnRemoverLootClick());

        this.view.getCbxSelecionar().addActionListener(e -> aoSelecionarMonstro());

        carregarMockups();
        atualizarView();
    }

    private void carregarMockups() {
        // Mockups de Raças
        racasMock.add("Nenhuma");
        racasMock.add("Goblinóide");
        racasMock.add("Morto-Vivo");
        
        // Mockups de Armas
        armasMock.add("Desarmado");
        armasMock.add("Espada Curta");
        armasMock.add("Machado de Batalha");

        // Mockups de Monstros
        MonstroModel goblin = new MonstroModel("Goblin Saqueador", 1, 3, 7, 12, null, new ArrayList<>(), null, 10);
        MonstroModel orc = new MonstroModel("Orc Enfurecido", 2, 5, 15, 14, null, new ArrayList<>(), null, 12);
        monstrosMock.add(goblin);
        monstrosMock.add(orc);
    }

    private void atualizarView() {
        // Preenche Raças
        view.getCbxRaca().removeAllItems();
        for (String raca : racasMock) {
            view.getCbxRaca().addItem(raca);
        }

        // Preenche Armas
        view.getCbxArma().removeAllItems();
        for (String arma : armasMock) {
            view.getCbxArma().addItem(arma);
        }

        atualizarComboSelecionar();
    }

    private boolean isUpdatingCombo = false;

    private void atualizarComboSelecionar() {
        isUpdatingCombo = true;
        view.getCbxSelecionar().removeAllItems();
        view.getCbxSelecionar().addItem("Novo Monstro...");
        for (MonstroModel m : monstrosMock) {
            view.getCbxSelecionar().addItem(m.getNome());
        }
        isUpdatingCombo = false;
    }

    private void aoSelecionarMonstro() {
        if (isUpdatingCombo) return;
        
        int index = view.getCbxSelecionar().getSelectedIndex();
        if (index <= 0) {
            // "Novo Monstro..." selecionado ou lista vazia
            limparFormulario();
        } else {
            // O index 0 é "Novo Monstro...", então o monstro na lista está em index - 1
            MonstroModel monstroSelecionado = monstrosMock.get(index - 1);
            preencherFormulario(monstroSelecionado);
        }
    }

    private void limparFormulario() {
        view.getTxtNome().setText("");
        view.getTxtNivel().setText("");
        view.getTxtVida().setText("");
        view.getTxtDefesa().setText("");
        view.getTxtAtaque().setText("");
        view.getTxtDt().setText("");
        view.getCbxRaca().setSelectedIndex(0);
        view.getCbxArma().setSelectedIndex(0);
        // Limpar tabela de loot
        DefaultTableModel model = (DefaultTableModel) view.getTblLoot().getModel();
        model.setRowCount(0);
    }

    private void preencherFormulario(MonstroModel m) {
        view.getTxtNome().setText(m.getNome());
        view.getTxtNivel().setText(String.valueOf(m.getNivel()));
        view.getTxtVida().setText(String.valueOf(m.getVida()));
        view.getTxtDefesa().setText(String.valueOf(m.getDefesa()));
        view.getTxtAtaque().setText(String.valueOf(m.getAtaque()));
        view.getTxtDt().setText(String.valueOf(m.getDt()));
        
        // Em um sistema real com BD, você setaria o Item selecionado do ComboBox buscando pelo ID
        if (m.getRaca() != null && m.getRaca().getNome() != null) {
            view.getCbxRaca().setSelectedItem(m.getRaca().getNome());
        } else {
            view.getCbxRaca().setSelectedIndex(0);
        }

        if (m.getArma() != null && m.getArma().getNome() != null) {
            view.getCbxArma().setSelectedItem(m.getArma().getNome());
        } else {
            view.getCbxArma().setSelectedIndex(0);
        }

        // TODO: Popular a JTable de Loot com os dados de m.getLoot()
        DefaultTableModel model = (DefaultTableModel) view.getTblLoot().getModel();
        model.setRowCount(0);
        // Exemplo: 
        // for (ItemModel item : m.getLoot()) { model.addRow(new Object[]{ icone, item.getNome(), item.getRaridade() }); }
    }

    public void btnSalvarClick() {
        String nome = view.getTxtNome().getText();
        if (nome == null || nome.trim().isEmpty()) {
            JOptionPane.showMessageDialog(view, "O nome do monstro não pode estar vazio.", "Erro de Validação", JOptionPane.ERROR_MESSAGE);
            return;
        }

        try {
            int nivel = parseCampo(view.getTxtNivel());
            int vida = parseCampo(view.getTxtVida());
            int defesa = parseCampo(view.getTxtDefesa());
            int ataque = parseCampo(view.getTxtAtaque());
            int dt = parseCampo(view.getTxtDt());

            if (nivel < 0 || vida < 0 || defesa < 0 || ataque < 0 || dt < 0) {
                JOptionPane.showMessageDialog(view, "Os atributos numéricos não podem ser menores que zero.", "Erro de Validação", JOptionPane.ERROR_MESSAGE);
                return;
            }

            int index = view.getCbxSelecionar().getSelectedIndex();
            MonstroModel alvo;
            
            if (index <= 0) {
                // Criar Novo
                alvo = new MonstroModel(nome, nivel, ataque, vida, defesa, null, new ArrayList<>(), null, dt);
                monstrosMock.add(alvo);
                JOptionPane.showMessageDialog(view, "Novo monstro cadastrado com sucesso!", "Sucesso", JOptionPane.INFORMATION_MESSAGE);
            } else {
                // Editar Existente
                alvo = monstrosMock.get(index - 1);
                alvo.setNome(nome);
                alvo.setNivel(nivel);
                alvo.setVida(vida);
                alvo.setDefesa(defesa);
                alvo.setAtaque(ataque);
                alvo.setDt(dt);
                JOptionPane.showMessageDialog(view, "Monstro atualizado com sucesso!", "Sucesso", JOptionPane.INFORMATION_MESSAGE);
            }

            // Mockando Raca e Arma de forma bem simples para visualização temporária
            if (view.getCbxRaca().getSelectedIndex() > 0) {
                alvo.setRaca(new com.rpgpoo.Raca.model.RacaModel((String) view.getCbxRaca().getSelectedItem(), null));
            } else {
                alvo.setRaca(null);
            }

            if (view.getCbxArma().getSelectedIndex() > 0) {
                alvo.setArma(new com.rpgpoo.Arma.model.ArmaModel((String) view.getCbxArma().getSelectedItem(), null, 0, null, 0, 0, 0, 0, null));
            } else {
                alvo.setArma(null);
            }

            // Atualiza os ComboBoxes para refletir a nova lista
            atualizarComboSelecionar();
            // Mantém a seleção correta (no novo elemento ou no atualizado)
            isUpdatingCombo = true;
            view.getCbxSelecionar().setSelectedItem(nome);
            isUpdatingCombo = false;

        } catch (NumberFormatException ex) {
            JOptionPane.showMessageDialog(view, "Por favor, preencha todos os atributos numéricos com valores válidos.", "Erro de Validação", JOptionPane.ERROR_MESSAGE);
        }
    }

    private int parseCampo(JTextField campo) throws NumberFormatException {
        String texto = campo.getText().trim();
        if (texto.isEmpty()) {
            throw new NumberFormatException("Campo vazio");
        }
        return Integer.parseInt(texto);
    }

    public void btnExcluirClick() {
        int index = view.getCbxSelecionar().getSelectedIndex();
        if (index <= 0) {
            JOptionPane.showMessageDialog(view, "Selecione um monstro existente para excluir.", "Atenção", JOptionPane.WARNING_MESSAGE);
            return;
        }

        int confirm = JOptionPane.showConfirmDialog(view, "Deseja realmente excluir este monstro?", "Confirmação", JOptionPane.YES_NO_OPTION);
        if (confirm == JOptionPane.YES_OPTION) {
            MonstroModel monstroParaExcluir = monstrosMock.get(index - 1);
            monstrosMock.remove(monstroParaExcluir);
            
            // TODO: Chamada de banco de dados para deletar: monstroRepository.delete(monstroParaExcluir.getId());
            
            JOptionPane.showMessageDialog(view, "Monstro excluído.", "Sucesso", JOptionPane.INFORMATION_MESSAGE);
            atualizarComboSelecionar();
            limparFormulario();
        }
    }

    public void btnAdicionarLootClick() {
        JOptionPane.showMessageDialog(view, "A funcionalidade de Adicionar Item ao loot será implementada com o repositório de Itens.", "Aviso", JOptionPane.INFORMATION_MESSAGE);
    }

    public void btnRemoverLootClick() {
        JOptionPane.showMessageDialog(view, "A funcionalidade de Remover Item do loot será implementada com o repositório de Itens.", "Aviso", JOptionPane.INFORMATION_MESSAGE);
    }
}
