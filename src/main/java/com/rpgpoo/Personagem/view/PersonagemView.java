package com.rpgpoo.Personagem.view;

import javax.swing.*;
import java.awt.*;

public class PersonagemView extends JPanel {
    // ficha do personagem

    JPanel fichaPanel = new JPanel(new GridBagLayout());
    JPanel armaPanel = new JPanel(new GridBagLayout());
    JPanel inventarioPanel = new JPanel(new GridBagLayout());
    JPanel botoesPanel = new JPanel(new FlowLayout(FlowLayout.RIGHT));

    JLabel lblFichaPersonagem = new JLabel("FICHA DO PERSONAGEM");
    JLabel lblNome = new JLabel("Nome");
    JLabel lblNivel = new JLabel("Nível");
    JLabel lblRaca = new JLabel("Raca");
    JLabel lblClasse = new JLabel("Classe");
    JLabel lblDinheiro = new JLabel("Dinheiro (GP)");
    JLabel lblCampanha = new JLabel("Campanha");
    JLabel lblAtributoBase = new JLabel("ATRIBUTOS BASE");
    JLabel lblStatusCombate = new JLabel("STATUS DE COMBATE");
    JLabel lblHpAtual = new JLabel("HP Atual");

    JTextField txtNome = new JTextField(20);
    JTextField txtNivel = new JTextField(3);
    JComboBox<String> cbRaca = new JComboBox<>(new String[]{"A", "B", "C"});
    JComboBox<String> cbClasse = new JComboBox<>(new String[]{"A", "B", "C"}); //definir aqui e no de cima quais as classes e raca
    JTextField txtDinheiro = new JTextField(10);
    JComboBox<String> cbCampanha = new JComboBox<>(new String[]{"A", "B", "C"});//definir campanha

    String[] nomeAtributos = {"A", "B", "C"};//definir atributos
    JTextField[] txtAtributos = new JTextField[6];
    String[] nomeStatus = {"A", "B", "C"};//definir nomes
    JTextField[] txtStatus = new JTextField[3];
    JProgressBar hpBar = new JProgressBar(0, 500);

    // arma equipada
    JLabel lblArmaEquipada = new JLabel("ARMA EQUIPADA");
    JLabel lblArmaNome = new JLabel("Nome");
    JLabel lblArmaDano = new JLabel("Dano");
    JLabel lblArmaAlcance = new JLabel("Alcance");
    JLabel lblArmaDurabilidade = new JLabel("Durabilidade");

    JTextField txtArmaNome = new JTextField(20);
    JTextField txtArmaDano = new JTextField(3);
    JTextField txtArmaAlcance = new JTextField(5);
    JTextField txtArmaDurabilidade = new JTextField(5);
    JComboBox<String> cbTipoDado = new JComboBox<>(new String[]{"D6", "D20"});//ADICIONAR RESTANTE

    //Inventario
    JLabel lblInventario = new JLabel("INVENTARIO");
    String[] colunas = {"Item", "Tipo", "Raridade", "GP"};
    Object[][] dadosInventario = {{"Poção de vida","Consumível","Comum", 50} //Fazer o restante
    };
    JTable tabelaInventario = new JTable(dadosInventario, colunas);
    JScrollPane    scrollInventario = new JScrollPane(tabelaInventario);
    JButton btnAdicionar = new JButton("+ Adicionar");
    JButton btnRemover = new JButton("- Remover");
    JButton btnSalvar = new JButton("Salvar");
    JButton btnNovo = new JButton("+ Novo");
    JButton btnExcluir = new JButton("Excluir");

    public PersonagemView() {
        this.setLayout(new BorderLayout(10,10));
        JPanel centro = new JPanel(new GridLayout(1,2,10,10));
        centro.add(fichaPanel);

        JPanel direitaPanel = new JPanel(new GridLayout(2,1,10,10));
        direitaPanel.add(armaPanel);
        direitaPanel.add(inventarioPanel);
        centro.add(direitaPanel);
        this.add(centro, BorderLayout.CENTER);
        this.add(botoesPanel, BorderLayout.SOUTH);
        this.setBorder(BorderFactory.createEmptyBorder(10,10,10,10));

        inicializarFichaPersonagem();
        inicializarArmaEquipada();
        inicializarInventario();
        inicializarBotoes();
    }
    public void inicializarFichaPersonagem() {
        GridBagConstraints gbc = criarGbc();

        // Título
        adicionarComponente(fichaPanel, lblFichaPersonagem, gbc, 0, 0, 4, 1);

        // Nome e Nível — labels
        adicionarComponente(fichaPanel, lblNome,  gbc, 0, 1, 3, 1);
        adicionarComponente(fichaPanel, lblNivel, gbc, 3, 1, 1, 1);

        // Nome e Nível — campos
        adicionarComponente(fichaPanel, txtNome,  gbc, 0, 2, 3, 1);
        txtNivel.setHorizontalAlignment(JTextField.CENTER);
        adicionarComponente(fichaPanel, txtNivel, gbc, 3, 2, 1, 1);

        // Raça e Classe — labels
        adicionarComponente(fichaPanel, lblRaca,   gbc, 0, 3, 2, 1);
        adicionarComponente(fichaPanel, lblClasse, gbc, 2, 3, 2, 1);

        // Raça e Classe — campos
        adicionarComponente(fichaPanel, cbRaca,   gbc, 0, 4, 2, 1);
        adicionarComponente(fichaPanel, cbClasse, gbc, 2, 4, 2, 1);

        // Dinheiro e Campanha — labels
        adicionarComponente(fichaPanel, lblDinheiro,  gbc, 0, 5, 2, 1);
        adicionarComponente(fichaPanel, lblCampanha,  gbc, 2, 5, 2, 1);

        // Dinheiro e Campanha — campos
        adicionarComponente(fichaPanel, txtDinheiro, gbc, 0, 6, 2, 1);
        adicionarComponente(fichaPanel, cbCampanha,  gbc, 2, 6, 2, 1);

        // Atributos base — título
        adicionarComponente(fichaPanel, lblAtributoBase, gbc, 0, 7, 6, 1);
        // Atributos base — labels e campos (FOR DES CON INT SAB CAR)
        for (int i = 0; i < nomeAtributos.length; i++) {
            JLabel lbl = new JLabel(nomeAtributos[i], SwingConstants.CENTER);
            adicionarComponente(fichaPanel, lbl, gbc, i, 8, 1, 1);

            txtAtributos[i] = new JTextField("10", 3);
            txtAtributos[i].setHorizontalAlignment(JTextField.CENTER);
            adicionarComponente(fichaPanel, txtAtributos[i], gbc, i, 9, 1, 1);
        }

        // Stats de combate — título
        adicionarComponente(fichaPanel, lblStatusCombate, gbc, 0, 10, 6, 1);

        // Stats de combate — labels e campos (VIDA ATAQUE DEFESA)
        for (int i = 0; i < nomeStatus.length; i++) {
            JLabel lbl = new JLabel(nomeStatus[i], SwingConstants.CENTER);
            adicionarComponente(fichaPanel, lbl, gbc, i * 2, 11, 2, 1);

            txtStatus[i] = new JTextField("0", 5);
            txtStatus[i].setHorizontalAlignment(JTextField.CENTER);
            adicionarComponente(fichaPanel, txtStatus[i], gbc, i * 2, 12, 2, 1);
        }

        // HP Atual — label e barra
        adicionarComponente(fichaPanel, lblHpAtual, gbc, 0, 13, 6, 1);

        hpBar.setValue(500);
        hpBar.setStringPainted(true);
        hpBar.setString("250 / 500");
        adicionarComponente(fichaPanel, hpBar, gbc, 0, 14, 6, 1);

        fichaPanel.setBorder(BorderFactory.createTitledBorder("Ficha do Personagem"));
    }
    private void inicializarArmaEquipada() {
        GridBagConstraints gbc = criarGbc();

        adicionarComponente(armaPanel, lblArmaEquipada, gbc, 0, 0, 3, 1);

        adicionarComponente(armaPanel, lblArmaNome, gbc, 0, 1, 3, 1);
        adicionarComponente(armaPanel, txtArmaNome, gbc, 0, 2, 3, 1);

        adicionarComponente(armaPanel, lblArmaDano,    gbc, 0, 3, 1, 1);
        adicionarComponente(armaPanel, lblArmaAlcance, gbc, 1, 3, 1, 1);
        adicionarComponente(armaPanel, lblArmaDurabilidade,  gbc, 2, 3, 1, 1);

        adicionarComponente(armaPanel, txtArmaDano,    gbc, 0, 4, 1, 1);
        adicionarComponente(armaPanel, txtArmaAlcance, gbc, 1, 4, 1, 1);
        adicionarComponente(armaPanel, txtArmaDurabilidade,  gbc, 2, 4, 1, 1);

        //adicionarComponente(armaPanel, lblArmaTipoDado, gbc, 0, 5, 3, 1);??
        adicionarComponente(armaPanel, cbTipoDado,      gbc, 0, 6, 3, 1);

        armaPanel.setBorder(BorderFactory.createTitledBorder("Arma Equipada"));
    }

    // =========================================================================
    // Inicialização — Inventário
    // =========================================================================
    private void inicializarInventario() {
        GridBagConstraints gbc = criarGbc();

        adicionarComponente(inventarioPanel, lblInventario, gbc, 0, 0, 2, 1);

        tabelaInventario.setFillsViewportHeight(true);
        scrollInventario.setPreferredSize(new Dimension(0, 120));
        adicionarComponente(inventarioPanel, scrollInventario, gbc, 0, 1, 2, 1);

        adicionarComponente(inventarioPanel, btnAdicionar, gbc, 0, 2, 1, 1);
        adicionarComponente(inventarioPanel, btnRemover,   gbc, 1, 2, 1, 1);

        inventarioPanel.setBorder(BorderFactory.createTitledBorder("Inventário"));
    }

    // =========================================================================
    // Inicialização — Botões gerais
    // =========================================================================
    private void inicializarBotoes() {
        botoesPanel.add(btnSalvar);
        botoesPanel.add(btnNovo);
        botoesPanel.add(btnExcluir);
    }

    // =========================================================================
    // Helpers
    // =========================================================================

    /** Cria um GridBagConstraints com configuração padrão reutilizável. */
    private GridBagConstraints criarGbc() {
        GridBagConstraints gbc = new GridBagConstraints();
        gbc.insets   = new Insets(4, 4, 4, 4);
        gbc.fill     = GridBagConstraints.HORIZONTAL;
        gbc.weightx  = 1.0;
        gbc.gridwidth = 1;
        return gbc;
    }

    /** Adiciona um componente ao painel com posição e span definidos. */
    private void adicionarComponente(JPanel painel, JComponent comp,GridBagConstraints gbc, int col, int linha, int larguraColunas, int alturaLinhas) {
        gbc.gridx      = col;
        gbc.gridy      = linha;
        gbc.gridwidth  = larguraColunas;
        gbc.gridheight = alturaLinhas;
        painel.add(comp, gbc);
    }

    // =========================================================================
    // Getters — acesso externo para o Controller
    // =========================================================================
    public JTextField  getTxtNome()       { return txtNome; }
    public JTextField  getTxtNivel()      { return txtNivel; }
    public JComboBox<String> getCbRaca()  { return cbRaca; }
    public JComboBox<String> getCbClasse(){ return cbClasse; }
    public JTextField  getTxtDinheiro()   { return txtDinheiro; }
    public JComboBox<String> getCbCampanha() { return cbCampanha; }
    public JTextField[]  getTxtAtributos(){ return txtAtributos; }
    public JTextField[]  getTxtStats()    { return txtStatus; }
    public JProgressBar  getHpBar()       { return hpBar; }

    public JTextField  getTxtArmaNome()   { return txtArmaNome; }
    public JTextField  getTxtArmaDano()   { return txtArmaDano; }
    public JTextField  getTxtArmaAlcance(){ return txtArmaAlcance; }
    public JTextField  getTxtArmaDurabilidade() { return txtArmaDurabilidade; }
    public JComboBox<String> getCbTipoDado() { return cbTipoDado; }

    public JTable   getTabelaInventario()     { return tabelaInventario; }
    public JButton  getBtnAdicionarItem()     { return btnAdicionar; }
    public JButton  getBtnRemoverItem()       { return btnRemover; }

    public JButton  getBtnSalvar()  { return btnSalvar; }
    public JButton  getBtnNovo()    { return btnNovo; }
    public JButton  getBtnExcluir() { return btnExcluir; }
}
