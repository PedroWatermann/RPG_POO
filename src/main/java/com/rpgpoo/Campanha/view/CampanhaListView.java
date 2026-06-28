package com.rpgpoo.Campanha.view;

import com.rpgpoo.Campanha.controller.CampanhaListController;
import com.rpgpoo.Gerenciador.Gerenciador;
import com.rpgpoo.utils.*;
import org.kordamp.ikonli.fontawesome6.FontAwesomeSolid;
import org.kordamp.ikonli.swing.FontIcon;

import javax.swing.*;
import javax.swing.plaf.basic.BasicComboBoxUI;
import javax.swing.plaf.basic.BasicComboPopup;
import javax.swing.plaf.basic.ComboPopup;
import javax.swing.table.DefaultTableCellRenderer;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.JTableHeader;
import java.awt.*;

public class CampanhaListView extends JPanel {
    JLabel lblTitulo = new JLabel();

    JLabel lblNome = new JLabel();
    JTextField txtNome = new JTextField();

    JLabel lblDescricao = new JLabel();
    JTextArea txtDescricao = new JTextArea();
    JScrollPane scrDescricao = new JScrollPane();

    JLabel lblMestre = new JLabel();
    JComboBox<String> cbxMestre = new JComboBox<>();

    JLabel lblDadoPadrao = new JLabel();
    JComboBox<String> cbxDadoPadrao = new JComboBox<>();

    JLabel lblJogadores = new JLabel();
    JTable tblJogadores = new JTable();
    JScrollPane scrJogadores = new JScrollPane();

    JButton btnAdicionarJogador;
    JButton btnRemoverJogador;
    JButton btnIniciarCombate;
    JButton btnTrocarCampanha;
    JButton btnEditarCampanha;

    public CampanhaListView(Gerenciador gerenciador) {
        CampanhaListController campanhaSelectController = new CampanhaListController(this, gerenciador);

        UIManager.put("PopupMenu.border", BorderFactory.createLineBorder(AppColors.GOLD, 1));
        UIManager.put("List.background", AppColors.DARK);
        UIManager.put("List.foreground", AppColors.PARCHMENT);
        UIManager.put("List.selectionBackground", AppColors.CRIMSON);
        UIManager.put("List.selectionForeground", AppColors.PARCHMENT);

        lblTitulo.setIcon(FontIcon.of(FontAwesomeSolid.MAP, AppColors.ICON_LG, AppColors.GOLD));
        lblTitulo.setText(" DETALHES DA CAMPANHA");
        lblTitulo.setFont(new Font(Font.SERIF, Font.BOLD, 18));
        lblTitulo.setForeground(AppColors.GOLD);
        lblTitulo.setHorizontalAlignment(SwingConstants.CENTER);

        JSeparator sepTopo = new JSeparator();
        sepTopo.setForeground(AppColors.GOLD);
        sepTopo.setBackground(AppColors.GOLD);

        lblNome.setFont(new Font(Font.SANS_SERIF, Font.PLAIN, 12));
        lblNome.setText("Nome");
        lblNome.setHorizontalAlignment(SwingConstants.LEFT);
        lblNome.setForeground(AppColors.PARCHMENT);

        txtNome.setFont(new Font(Font.SANS_SERIF, Font.PLAIN, 12));
        txtNome.setOpaque(false);
        txtNome.setForeground(Color.WHITE);
        txtNome.setCaretColor(AppColors.PARCHMENT);
        txtNome.setBorder(BorderFactory.createLineBorder(AppColors.GOLD));
        txtNome.setPreferredSize(new Dimension(0, 28));

        lblDescricao.setFont(new Font(Font.SANS_SERIF, Font.PLAIN, 12));
        lblDescricao.setText("Descrição");
        lblDescricao.setHorizontalAlignment(SwingConstants.LEFT);
        lblDescricao.setForeground(AppColors.PARCHMENT);

        txtDescricao.setFont(new Font(Font.SANS_SERIF, Font.PLAIN, 12));
        txtDescricao.setOpaque(false);
        txtDescricao.setForeground(Color.WHITE);
        txtDescricao.setCaretColor(AppColors.PARCHMENT);
        txtDescricao.setBorder(BorderFactory.createLineBorder(AppColors.PARCHMENT));
        txtDescricao.setLineWrap(true);
        txtDescricao.setWrapStyleWord(true);
        txtDescricao.setBorder(BorderFactory.createLineBorder(AppColors.PARCHMENT, 0));

        scrDescricao.setViewportView(txtDescricao);
        scrDescricao.setPreferredSize(new Dimension(0, 150));
        scrDescricao.setMinimumSize(new Dimension(28, 150));
        scrDescricao.setMaximumSize(new Dimension(Integer.MAX_VALUE, 150));
        scrDescricao.getViewport().setBackground(AppColors.DARK);
        scrDescricao.setBorder(BorderFactory.createLineBorder(AppColors.GOLD, 1));
        scrDescricao.getVerticalScrollBar().setUI(new DarkScrollBarUI());
        scrDescricao.getHorizontalScrollBar().setUI(new DarkScrollBarUI());
        scrDescricao.setVerticalScrollBarPolicy(ScrollPaneConstants.VERTICAL_SCROLLBAR_AS_NEEDED);

        lblMestre.setFont(new Font(Font.SANS_SERIF, Font.PLAIN, 12));
        lblMestre.setText("Mestre");
        lblMestre.setHorizontalAlignment(SwingConstants.LEFT);
        lblMestre.setForeground(AppColors.PARCHMENT);

        cbxMestre.setFont(new Font(Font.SANS_SERIF, Font.PLAIN, 12));
        cbxMestre.setForeground(Color.WHITE);
        cbxMestre.setBackground(AppColors.DARK);
        GenericUtils.estilizarComboBox(cbxMestre);
        // Dados ficticios
        cbxMestre.addItem("Alemão");
        cbxMestre.addItem("Barela");
        cbxMestre.addItem("Laranjinha");

        lblDadoPadrao.setFont(new Font(Font.SANS_SERIF, Font.PLAIN, 12));
        lblDadoPadrao.setText("Dado padrão");
        lblDadoPadrao.setHorizontalAlignment(SwingConstants.LEFT);
        lblDadoPadrao.setForeground(AppColors.PARCHMENT);

        cbxDadoPadrao.setFont(new Font(Font.SANS_SERIF, Font.PLAIN, 12));
        cbxDadoPadrao.setOpaque(false);
        cbxDadoPadrao.setForeground(Color.WHITE);
        cbxDadoPadrao.setBackground(AppColors.DARK);
        GenericUtils.estilizarComboBox(cbxDadoPadrao);
        // Dados ficticios
        cbxDadoPadrao.addItem("D4");
        cbxDadoPadrao.addItem("D6");
        cbxDadoPadrao.addItem("D8");
        cbxDadoPadrao.addItem("D10");
        cbxDadoPadrao.addItem("D12");
        cbxDadoPadrao.addItem("D20");
        cbxDadoPadrao.addItem("D100");

        JSeparator sepEsquerda = new JSeparator();
        sepEsquerda.setForeground(AppColors.GOLD);
        sepEsquerda.setBackground(AppColors.GOLD);

        lblJogadores.setFont(new Font(Font.SANS_SERIF, Font.PLAIN, 12));
        lblJogadores.setText("Jogadores");
        lblJogadores.setHorizontalAlignment(SwingConstants.LEFT);
        lblJogadores.setForeground(AppColors.PARCHMENT);

        JSeparator sepDireita = new JSeparator();
        sepDireita.setForeground(AppColors.GOLD);
        sepDireita.setBackground(AppColors.GOLD);

        Object[][] dadosTemporarios = {
                {FontIcon.of(FontAwesomeSolid.USER_ALT, AppColors.ICON_SM, AppColors.PARCHMENT), "Alemão", "Thorin, o Forte"},
                {FontIcon.of(FontAwesomeSolid.USER_ALT, AppColors.ICON_SM, AppColors.PARCHMENT), "Barela", "Elira Lança Preta"},
                {FontIcon.of(FontAwesomeSolid.USER_ALT, AppColors.ICON_SM, AppColors.PARCHMENT), "Laranjinha", "Thorin, o Forte"},
                {FontIcon.of(FontAwesomeSolid.USER_ALT, AppColors.ICON_SM, AppColors.PARCHMENT), "Sensual", "Thorin, o Forte"},
                {FontIcon.of(FontAwesomeSolid.USER_ALT, AppColors.ICON_SM, AppColors.PARCHMENT), "Pescado", "Thorin, o Forte"},
        };
        tblJogadores.setModel(new DefaultTableModel(dadosTemporarios, new Object[]{"", "Usuário", "Personagem"}));
        tblJogadores.setDefaultRenderer(Object.class, new IconTextCellRender());
        tblJogadores.getColumnModel().getColumn(0).setMaxWidth(30);
        tblJogadores.setShowVerticalLines(false);
        tblJogadores.setShowHorizontalLines(false);
        tblJogadores.setBackground(AppColors.DARK);
        tblJogadores.setForeground(AppColors.PARCHMENT);
        tblJogadores.setSelectionBackground(AppColors.CRIMSON);
        tblJogadores.setFont(new Font(Font.SANS_SERIF, Font.PLAIN, 12));
        tblJogadores.setRowHeight(28);
        JTableHeader header = tblJogadores.getTableHeader();
        header.setDefaultRenderer(new DefaultTableCellRenderer() {
            @Override
            public Component getTableCellRendererComponent(JTable table, Object value, boolean isSelected, boolean hasFocus, int row, int column) {
                JLabel lbl = (JLabel) super.getTableCellRendererComponent(table, value, isSelected, hasFocus, row, column);

                lbl.setOpaque(true);
                lbl.setBackground(AppColors.DARK);
                lbl.setForeground(AppColors.GOLD);
                lbl.setFont(new Font(Font.SANS_SERIF, Font.BOLD, 12));
                lbl.setBorder(BorderFactory.createMatteBorder(0, 0, 1, 0, AppColors.GOLD));

                return lbl;
            }
        });

        scrJogadores.setViewportView(tblJogadores);
        scrJogadores.setPreferredSize(new Dimension(0, 150));
        scrJogadores.getViewport().setBackground(AppColors.DARK);
        scrJogadores.setBorder(BorderFactory.createLineBorder(AppColors.GOLD, 1));
        scrJogadores.getVerticalScrollBar().setUI(new DarkScrollBarUI());
        scrJogadores.getHorizontalScrollBar().setUI(new DarkScrollBarUI());
        scrJogadores.setVerticalScrollBarPolicy(ScrollPaneConstants.VERTICAL_SCROLLBAR_AS_NEEDED);

        btnAdicionarJogador = new JButtonCustom(
                "Adicionar Jogador",
                JButtonCustom.Style.SECONDARY,
                FontIcon.of(FontAwesomeSolid.USER_PLUS, AppColors.ICON_SM, AppColors.PARCHMENT)
        );

        btnRemoverJogador = new JButtonCustom(
                "Remover Jogador",
                JButtonCustom.Style.DANGER,
                FontIcon.of(FontAwesomeSolid.USER_MINUS, AppColors.ICON_SM, AppColors.PARCHMENT)
        );

        btnIniciarCombate = new JButtonCustom(
                "Iniciar Combate",
                FontIcon.of(FontAwesomeSolid.SHIELD_ALT, 12, AppColors.PARCHMENT)
        );

        btnTrocarCampanha = new JButtonCustom(
                "Trocar Campanha",
                JButtonCustom.Style.SECONDARY,
                FontIcon.of(FontAwesomeSolid.SYNC_ALT, 12, AppColors.PARCHMENT)
        );

        btnEditarCampanha = new JButtonCustom(
                "Editar Campanha",
                JButtonCustom.Style.SECONDARY,
                FontIcon.of(FontAwesomeSolid.PEN, 12, AppColors.PARCHMENT)
        );

        this.setLayout(new GridBagLayout());
        this.setBackground(AppColors.DARK);
        this.setBorder(BorderFactory.createCompoundBorder(
                BorderFactory.createLineBorder(AppColors.GOLD, 0),
                BorderFactory.createEmptyBorder(15, 20, 15, 20)
        ));

        GridBagConstraints gbc = new GridBagConstraints();
        gbc.gridx = 0;
        gbc.gridwidth = 2;
        gbc.fill = GridBagConstraints.HORIZONTAL;
        gbc.insets = new Insets(0, 0, 6, 0);

        // Definições para lblTitulo
        gbc.gridy = 0;
        gbc.weightx = 1.0;
        this.add(lblTitulo, gbc);

        // Definições para sepTopo
        gbc.gridy = 1;
        this.add(sepTopo, gbc);

        // Definições para lblNome
        gbc.gridy = 2;
        this.add(lblNome, gbc);

        // Definições para txtNome
        gbc.gridy = 3;
        this.add(txtNome, gbc);

        // Definições para lblDescricao
        gbc.gridy = 4;
        this.add(lblDescricao, gbc);

        // Definições para txtDescricao/scrDescricao
        gbc.gridy = 5;
        gbc.fill = GridBagConstraints.HORIZONTAL;
        gbc.weightx = 1.0;
        gbc.weighty = 0;
        this.add(scrDescricao, gbc);

        // Definições para lblMestre
        gbc.gridy = 6;
        gbc.gridx = 0;
        gbc.gridwidth = 1;
        gbc.weightx = 0.5;
        gbc.insets = new Insets(6, 0, 0, 5);
        this.add(lblMestre, gbc);

        // Definições para lblDadoPadrao
        gbc.gridx = 1;
        gbc.insets = new Insets(6, 5, 0, 0);
        this.add(lblDadoPadrao, gbc);

        // Definições para cbxMestre
        gbc.gridy = 7;
        gbc.gridx = 0;
        gbc.insets = new Insets(0, 0, 0, 5);
        this.add(cbxMestre, gbc);

        // Definições para cbxMestre
        gbc.gridx = 1;
        gbc.insets = new Insets(0, 5, 0, 0);
        this.add(cbxDadoPadrao, gbc);

        // Definições para pnlJogadores
        JPanel pnlJogadores = new JPanel(new GridBagLayout());
        pnlJogadores.setOpaque(false);

        GridBagConstraints g = new GridBagConstraints();
        g.gridy = 0;
        g.fill = GridBagConstraints.HORIZONTAL;

        // sepEsquerda — coluna 0, estica
        g.gridx = 0;
        g.gridwidth = 1;
        g.weightx = 1.0;
        pnlJogadores.add(sepEsquerda, g);

        // lblJogadores — coluna 1, tamanho natural
        g.gridx = 1;
        g.weightx = 0.0;
        g.fill = GridBagConstraints.NONE;
        g.anchor = GridBagConstraints.CENTER;
        g.insets = new Insets(0, 8, 0, 8);
        pnlJogadores.add(lblJogadores, g);

        // sepDireita — coluna 2, estica
        g.gridx = 2;
        g.weightx = 1.0;
        g.fill = GridBagConstraints.HORIZONTAL;
        g.insets = new Insets(0, 0, 0, 0);
        pnlJogadores.add(sepDireita, g);

        // Adiciona o painel no layout principal
        gbc.gridy = 8;
        gbc.gridx = 0;
        gbc.gridwidth = 2;
        gbc.weightx = 1.0;
        gbc.insets = new Insets(15, 0, 0, 0);
        this.add(pnlJogadores, gbc);

        // Definições para scrJogadores
        gbc.gridy = 9;
        gbc.weighty = 1.0;
        gbc.fill = GridBagConstraints.BOTH;
        this.add(scrJogadores, gbc);

        // Definições para botões lado a lado
        gbc.gridy = 10;
        gbc.weighty = 0;
        gbc.fill = GridBagConstraints.HORIZONTAL;

        // Definições para btnAdicionarJogador
        gbc.gridx = 0;
        gbc.gridwidth = 1;
        gbc.insets = new Insets(10, 0, 5, 5);
        this.add(btnAdicionarJogador, gbc);

        // Definições para btnRemoverJogador
        gbc.gridx = 1;
        gbc.insets = new Insets(10, 5, 5, 0);
        this.add(btnRemoverJogador, gbc);

        // Definições para btnIniciarCombate
        gbc.gridy = 11;
        gbc.gridx = 0;
        gbc.gridwidth = 2;
        gbc.insets = new Insets(5, 0, 5, 0);
        this.add(btnIniciarCombate, gbc);

        JPanel pnlBotoesCampanha = new JPanel(new GridBagLayout());
        pnlBotoesCampanha.setOpaque(false);

        // Definições para btnTrocarCampanha
        gbc.gridy = 12;
        gbc.gridwidth = 1;
        gbc.weightx = 0.5;
        gbc.insets = new Insets(5, 0, 0, 5);
        gbc.anchor = GridBagConstraints.WEST;
        this.add(btnTrocarCampanha, gbc);

        // Definições para btnEditarCampanha
        gbc.gridx = 1;
        gbc.insets = new Insets(5, 5, 0, 0);
        gbc.anchor = GridBagConstraints.EAST;
        this.add(btnEditarCampanha, gbc);
    }

    static void estilizarComboBox(JComboBox<?> cbx) {
        cbx.setBackground(AppColors.DARK);
        cbx.setForeground(AppColors.PARCHMENT);
        cbx.setFont(new Font("SansSerif", Font.PLAIN, 12));
        cbx.setBorder(BorderFactory.createLineBorder(AppColors.GOLD, 1));

        cbx.setUI(new BasicComboBoxUI() {
            @Override
            protected JButton createArrowButton() {
                JButton btn = new JButton("▾");
                btn.setBackground(AppColors.DARK);
                btn.setForeground(AppColors.PARCHMENT);
                btn.setBorder(BorderFactory.createEmptyBorder(0, 4, 0, 4));
                btn.setFocusPainted(false);
                btn.setContentAreaFilled(false);
                return btn;
            }

            @Override
            protected ComboPopup createPopup() {
                BasicComboPopup popup = (BasicComboPopup) super.createPopup();
                popup.setBorder(BorderFactory.createLineBorder(AppColors.GOLD, 1));
                popup.getList().setBackground(AppColors.DARK3);
                popup.getList().setForeground(AppColors.PARCHMENT);
                popup.getList().setSelectionBackground(AppColors.CRIMSON);
                popup.getList().setSelectionForeground(AppColors.PARCHMENT);
                return popup;
            }
        });
    }
}
