package com.rpgpoo.Campanha.view;

import com.rpgpoo.Campanha.controller.CampanhaCreateController;
import com.rpgpoo.Campanha.controller.CampanhaListController;
import com.rpgpoo.Gerenciador.Gerenciador;
import com.rpgpoo.utils.AppColors;
import com.rpgpoo.utils.DarkScrollBarUI;
import com.rpgpoo.utils.IconTextCellRender;
import com.rpgpoo.utils.JButtonCustom;
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

public class CampanhaCreateView extends JPanel { // true = modal
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

    public CampanhaCreateView(Gerenciador gerenciador) {
        CampanhaCreateController campanhaCreateController = new CampanhaCreateController(this, gerenciador);

        UIManager.put("PopupMenu.border", BorderFactory.createLineBorder(AppColors.GOLD, 1));
        UIManager.put("List.background", AppColors.DARK);
        UIManager.put("List.foreground", AppColors.PARCHMENT);
        UIManager.put("List.selectionBackground", AppColors.CRIMSON);
        UIManager.put("List.selectionForeground", AppColors.PARCHMENT);

        lblTitulo.setIcon(FontIcon.of(FontAwesomeSolid.MAP, AppColors.ICON_LG, AppColors.GOLD));
        lblTitulo.setText(" DETALHES DA CAMPANHA");
        lblTitulo.setFont(new Font("Serif", Font.BOLD, 18));
        lblTitulo.setForeground(AppColors.GOLD);
        lblTitulo.setHorizontalAlignment(SwingConstants.CENTER);

        JSeparator sepTopo = new JSeparator();
        sepTopo.setForeground(AppColors.GOLD);
        sepTopo.setBackground(AppColors.GOLD);

        lblNome.setFont(new Font("SansSerif", Font.PLAIN, 12));
        lblNome.setText("Nome");
        lblNome.setHorizontalAlignment(SwingConstants.LEFT);
        lblNome.setForeground(AppColors.PARCHMENT);

        txtNome.setFont(new Font("SansSerif", Font.PLAIN, 12));
        txtNome.setOpaque(false);
        txtNome.setForeground(Color.WHITE);
        txtNome.setCaretColor(AppColors.PARCHMENT);
        txtNome.setBorder(BorderFactory.createLineBorder(AppColors.GOLD));
        txtNome.setPreferredSize(new Dimension(0, 28));

        lblDescricao.setFont(new Font("SansSerif", Font.PLAIN, 12));
        lblDescricao.setText("Descrição");
        lblDescricao.setHorizontalAlignment(SwingConstants.LEFT);
        lblDescricao.setForeground(AppColors.PARCHMENT);

        txtDescricao.setFont(new Font("SansSerif", Font.PLAIN, 12));
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

        lblMestre.setFont(new Font("SansSerif", Font.PLAIN, 12));
        lblMestre.setText("Mestre");
        lblMestre.setHorizontalAlignment(SwingConstants.LEFT);
        lblMestre.setForeground(AppColors.PARCHMENT);

        cbxMestre.setFont(new Font("SansSerif", Font.PLAIN, 12));
        cbxMestre.setForeground(Color.WHITE);
        cbxMestre.setBackground(AppColors.DARK);
        CampanhaListView.estilizarComboBox(cbxMestre);
        // Dados ficticios
        cbxMestre.addItem("Alemão");
        cbxMestre.addItem("Barela");
        cbxMestre.addItem("Laranjinha");

        lblDadoPadrao.setFont(new Font("SansSerif", Font.PLAIN, 12));
        lblDadoPadrao.setText("Dado padrão");
        lblDadoPadrao.setHorizontalAlignment(SwingConstants.LEFT);
        lblDadoPadrao.setForeground(AppColors.PARCHMENT);

        cbxDadoPadrao.setFont(new Font("SansSerif", Font.PLAIN, 12));
        cbxDadoPadrao.setOpaque(false);
        cbxDadoPadrao.setForeground(Color.WHITE);
        cbxDadoPadrao.setBackground(AppColors.DARK);
        CampanhaListView.estilizarComboBox(cbxDadoPadrao);

        // Dados ficticios
        cbxDadoPadrao.addItem("D4");
        cbxDadoPadrao.addItem("D6");
        cbxDadoPadrao.addItem("D8");
        cbxDadoPadrao.addItem("D10");
        cbxDadoPadrao.addItem("D12");
        cbxDadoPadrao.addItem("D20");
        cbxDadoPadrao.addItem("D100");


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

        this.setBorder(BorderFactory.createLineBorder(AppColors.GOLD, 1));

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

    }
}
