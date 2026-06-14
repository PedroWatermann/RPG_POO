package com.rpgpoo.Item.view;

import com.rpgpoo.Enum.TipoItemEnum;
import com.rpgpoo.Gerenciador.Gerenciador;
import com.rpgpoo.Item.controller.ItemController;
import com.rpgpoo.utils.*;
import org.kordamp.ikonli.fontawesome6.FontAwesomeSolid;
import org.kordamp.ikonli.swing.FontIcon;

import javax.swing.*;
import javax.swing.table.DefaultTableCellRenderer;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.JTableHeader;
import java.awt.*;

public class ItemView extends JPanel {
    JLabel lblTitulo = new JLabel();
    JSeparator separador = new JSeparator();

    JTextField txtBusca = new JTextField();
    JButton btnBuscar;
    JComboBox<TipoItemEnum> cbxTipoItem = new JComboBox<>();

    JTable tblItens = new JTable();
    JScrollPane scrItens = new JScrollPane();

    JButton btnAdicionar;
    JButton btnEditar;
    JButton btnExcluir;

    public ItemView(Gerenciador gerenciador) {
        ItemController controller = new ItemController(this, gerenciador);

        lblTitulo.setIcon(FontIcon.of(FontAwesomeSolid.LIST_ALT, AppColors.ICON_LG, AppColors.GOLD));
        lblTitulo.setText(" ITENS CADASTRADOS");
        lblTitulo.setFont(new Font("Serif", Font.BOLD, 18));
        lblTitulo.setForeground(AppColors.GOLD);
        lblTitulo.setHorizontalAlignment(SwingConstants.CENTER);

        separador.setForeground(AppColors.GOLD);
        separador.setBackground(AppColors.GOLD);

        txtBusca.setFont(new Font("SansSerif", Font.PLAIN, 12));
        txtBusca.setOpaque(false);
        txtBusca.setForeground(Color.WHITE);
        txtBusca.setBackground(AppColors.DARK3);
        txtBusca.setCaretColor(AppColors.PARCHMENT);
        txtBusca.setBorder(BorderFactory.createLineBorder(AppColors.GOLD));
        txtBusca.setPreferredSize(new Dimension(0, 28));

        btnBuscar = new JButtonCustom(
                "",
                JButtonCustom.Style.SECONDARY,
                FontIcon.of(FontAwesomeSolid.SEARCH, AppColors.ICON_MD1, AppColors.GOLD)
        );
        btnBuscar.setPreferredSize(new Dimension(28, 28));

        cbxTipoItem.setFont(new Font("SansSerif", Font.PLAIN, 12));
        cbxTipoItem.setForeground(Color.WHITE);
        cbxTipoItem.setBackground(AppColors.DARK);
        GenericUtils.estilizarComboBox(cbxTipoItem);
        // Dados ficticios
        cbxTipoItem.addItem(TipoItemEnum.FERRAMENTA);
        cbxTipoItem.addItem(TipoItemEnum.ANEL);
        cbxTipoItem.addItem(TipoItemEnum.BEBIDA);

        Object[][] dadosTemporarios = {
                {FontIcon.of(FontAwesomeSolid.USER_ALT, AppColors.ICON_SM, AppColors.PARCHMENT), "Alemão", "Thorin, o Forte"},
                {FontIcon.of(FontAwesomeSolid.USER_ALT, AppColors.ICON_SM, AppColors.PARCHMENT), "Barela", "Elira Lança Preta"},
                {FontIcon.of(FontAwesomeSolid.USER_ALT, AppColors.ICON_SM, AppColors.PARCHMENT), "Laranjinha", "Thorin, o Forte"},
                {FontIcon.of(FontAwesomeSolid.USER_ALT, AppColors.ICON_SM, AppColors.PARCHMENT), "Sensual", "Thorin, o Forte"},
                {FontIcon.of(FontAwesomeSolid.USER_ALT, AppColors.ICON_SM, AppColors.PARCHMENT), "Pescado", "Thorin, o Forte"},
        };
        tblItens.setModel(new DefaultTableModel(dadosTemporarios, new Object[]{"", "Usuário", "Personagem"}));
        tblItens.setDefaultRenderer(Object.class, new IconTextCellRender());
        tblItens.getColumnModel().getColumn(0).setMaxWidth(30);
        tblItens.setShowVerticalLines(false);
        tblItens.setShowHorizontalLines(false);
        tblItens.setBackground(AppColors.DARK);
        tblItens.setForeground(AppColors.PARCHMENT);
        tblItens.setSelectionBackground(AppColors.CRIMSON);
        tblItens.setFont(new Font("SansSerif", Font.PLAIN, 12));
        tblItens.setRowHeight(28);
        JTableHeader header = tblItens.getTableHeader();
        header.setDefaultRenderer(new DefaultTableCellRenderer() {
            @Override
            public Component getTableCellRendererComponent(JTable table, Object value, boolean isSelected, boolean hasFocus, int row, int column) {
                JLabel lbl = (JLabel) super.getTableCellRendererComponent(table, value, isSelected, hasFocus, row, column);

                lbl.setOpaque(true);
                lbl.setBackground(AppColors.DARK);
                lbl.setForeground(AppColors.GOLD);
                lbl.setFont(new Font("SansSerif", Font.BOLD, 12));
                lbl.setBorder(BorderFactory.createMatteBorder(0, 0, 1, 0, AppColors.GOLD));

                return lbl;
            }
        });

        scrItens.setViewportView(tblItens);
        scrItens.setPreferredSize(new Dimension(0, 150));
        scrItens.getViewport().setBackground(AppColors.DARK);
        scrItens.setBorder(BorderFactory.createLineBorder(AppColors.GOLD, 1));
        scrItens.getVerticalScrollBar().setUI(new DarkScrollBarUI());
        scrItens.getHorizontalScrollBar().setUI(new DarkScrollBarUI());
        scrItens.setVerticalScrollBarPolicy(ScrollPaneConstants.VERTICAL_SCROLLBAR_AS_NEEDED);

        btnAdicionar = new JButtonCustom(
                "Adicionar Item",
                JButtonCustom.Style.PRIMARY,
                FontIcon.of(FontAwesomeSolid.PLUS, AppColors.ICON_SM, AppColors.PARCHMENT)
        );
        btnAdicionar.addActionListener(_ -> controller.btnAdicionarClick());

        btnEditar = new JButtonCustom(
                "Editar Item",
                JButtonCustom.Style.SECONDARY,
                FontIcon.of(FontAwesomeSolid.PENCIL_ALT, AppColors.ICON_SM, AppColors.PARCHMENT)
        );

        btnExcluir = new JButtonCustom(
                "Excluir Item",
                JButtonCustom.Style.DANGER,
                FontIcon.of(FontAwesomeSolid.TRASH_ALT, AppColors.ICON_SM, AppColors.PARCHMENT)
        );

        this.setLayout(new GridBagLayout());
        this.setBackground(AppColors.DARK);
        this.setBorder(BorderFactory.createCompoundBorder(
                BorderFactory.createLineBorder(AppColors.GOLD, 0),
                BorderFactory.createEmptyBorder(15, 20, 15, 20)
        ));

        JPanel pnlBusca = new JPanel(new GridBagLayout());
        pnlBusca.setOpaque(false);

        GridBagConstraints gbcBusca = new GridBagConstraints();

        gbcBusca.gridx = 0;
        gbcBusca.weightx = 1.0;
        gbcBusca.fill = GridBagConstraints.HORIZONTAL;
        gbcBusca.insets = new Insets(0, 0, 0, 5);
        pnlBusca.add(txtBusca, gbcBusca);

        gbcBusca.gridx = 1;
        gbcBusca.weightx = 0;
        gbcBusca.fill = GridBagConstraints.NONE;
        gbcBusca.insets = new Insets(0, 0, 0, 5);
        pnlBusca.add(btnBuscar, gbcBusca);

        GridBagConstraints gbc = new GridBagConstraints();

        // Definições para lblTitulo
        gbc.gridx = 0;
        gbc.gridwidth = 3;
        gbc.weightx = 1.0;
        gbc.fill = GridBagConstraints.HORIZONTAL;
        gbc.insets = new Insets(0, 0, 6, 0);
        this.add(lblTitulo, gbc);

        // Definições para separador
        gbc.gridy = 1;
        this.add(separador, gbc);

        // Definições para pnlBusca
        gbc.gridy = 2;
        gbc.gridwidth = 2;
        gbc.insets = new Insets(0, 0, 6, 5);
        this.add(pnlBusca, gbc);

        // Definições para cbxTipoItem
        gbc.gridx = 2;
        gbc.gridwidth = 1;
        gbc.insets = new Insets(0, 5, 6, 0);
        this.add(cbxTipoItem, gbc);

        // Definições para tblItens/scrItens
        gbc.gridy = 3;
        gbc.gridx = 0;
        gbc.weighty = 1.0;
        gbc.fill = GridBagConstraints.BOTH;
        gbc.insets = new Insets(0, 0, 10, 0);
        gbc.gridwidth = 3;
        this.add(scrItens, gbc);

        // Definições para botões lado a lado
        gbc.weighty = 0.0;
        gbc.gridy = 4;
        gbc.gridwidth = 1;

        // Definições para btnAdicionar
        gbc.insets = new Insets(0, 0, 0, 5);
        this.add(btnAdicionar, gbc);

        // Definições para btnEditar
        gbc.insets = new Insets(0, 5, 0, 5);
        gbc.gridx = 1;
        this.add(btnEditar, gbc);

        // Definições para btnExcluir
        gbc.insets = new Insets(0, 5, 0, 0);
        gbc.gridx = 2;
        this.add(btnExcluir, gbc);
    }
}
