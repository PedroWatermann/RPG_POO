package com.rpgpoo.Item.view;

import com.rpgpoo.Enum.RaridadeEnum;
import com.rpgpoo.Enum.TipoItemEnum;
import com.rpgpoo.utils.AppColors;
import com.rpgpoo.utils.GenericUtils;
import com.rpgpoo.utils.JButtonCustom;
import org.kordamp.ikonli.fontawesome6.FontAwesomeSolid;
import org.kordamp.ikonli.swing.FontIcon;

import javax.swing.*;
import java.awt.*;

public class ItemAddView extends JFrame {
    JPanel contentPane = new JPanel();

    JLabel lblTitulo = new JLabel();
    JSeparator sepTopo = new JSeparator();

    JLabel lblNome = new JLabel();
    JTextField txtNome = new JTextField();

    JLabel lblTipo = new JLabel();
    JComboBox<TipoItemEnum> cbxTipo = new JComboBox<>();

    JLabel lblRaridade = new JLabel();
    JComboBox<RaridadeEnum> cbxRaridade = new JComboBox<>();

    JLabel lblEfeito = new JLabel();
    JTextField txtEfeito = new JTextField();

    JLabel lblValor = new JLabel();
    JTextField txtValor = new JTextField();

    JSeparator sepBaixo = new JSeparator();

    JButton btnSalvar;
    JButton btnCancelar;

    public ItemAddView() {
        lblTitulo.setIcon(FontIcon.of(FontAwesomeSolid.BOX, AppColors.ICON_LG, AppColors.GOLD));
        lblTitulo.setText(" ADICIONAR ITEM");
        lblTitulo.setFont(new Font(Font.SERIF, Font.BOLD, 18));
        lblTitulo.setForeground(AppColors.GOLD);
        lblTitulo.setHorizontalAlignment(SwingConstants.CENTER);

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

        lblTipo.setFont(new Font(Font.SANS_SERIF, Font.PLAIN, 12));
        lblTipo.setText("Tipo");
        lblTipo.setHorizontalAlignment(SwingConstants.LEFT);
        lblTipo.setForeground(AppColors.PARCHMENT);

        cbxTipo.setFont(new Font("SansSerif", Font.PLAIN, 12));
        cbxTipo.setForeground(Color.WHITE);
        cbxTipo.setBackground(AppColors.DARK);
        GenericUtils.estilizarComboBox(cbxTipo);
        // Dados ficticios
        cbxTipo.addItem(TipoItemEnum.FERRAMENTA);
        cbxTipo.addItem(TipoItemEnum.ANEL);
        cbxTipo.addItem(TipoItemEnum.BEBIDA);

        lblRaridade.setFont(new Font(Font.SANS_SERIF, Font.PLAIN, 12));
        lblRaridade.setText("Raridade");
        lblRaridade.setHorizontalAlignment(SwingConstants.LEFT);
        lblRaridade.setForeground(AppColors.PARCHMENT);

        cbxRaridade.setFont(new Font("SansSerif", Font.PLAIN, 12));
        cbxRaridade.setForeground(Color.WHITE);
        cbxRaridade.setBackground(AppColors.DARK);
        GenericUtils.estilizarComboBox(cbxRaridade);
        // Dados ficticios
        cbxRaridade.addItem(RaridadeEnum.COMUM);
        cbxRaridade.addItem(RaridadeEnum.EPICO);
        cbxRaridade.addItem(RaridadeEnum.RARO);

        lblEfeito.setFont(new Font(Font.SANS_SERIF, Font.PLAIN, 12));
        lblEfeito.setText("Valor do Efeito");
        lblEfeito.setHorizontalAlignment(SwingConstants.LEFT);
        lblEfeito.setForeground(AppColors.PARCHMENT);

        txtEfeito.setFont(new Font(Font.SANS_SERIF, Font.PLAIN, 12));
        txtEfeito.setOpaque(false);
        txtEfeito.setForeground(Color.WHITE);
        txtEfeito.setCaretColor(AppColors.PARCHMENT);
        txtEfeito.setBorder(BorderFactory.createLineBorder(AppColors.GOLD));
        txtEfeito.setPreferredSize(new Dimension(0, 28));

        lblValor.setFont(new Font(Font.SANS_SERIF, Font.PLAIN, 12));
        lblValor.setText("Valor");
        lblValor.setHorizontalAlignment(SwingConstants.LEFT);
        lblValor.setForeground(AppColors.PARCHMENT);

        txtValor.setFont(new Font(Font.SANS_SERIF, Font.PLAIN, 12));
        txtValor.setOpaque(false);
        txtValor.setForeground(Color.WHITE);
        txtValor.setCaretColor(AppColors.PARCHMENT);
        txtValor.setBorder(BorderFactory.createLineBorder(AppColors.GOLD));
        txtValor.setPreferredSize(new Dimension(0, 28));

        sepBaixo.setForeground(AppColors.GOLD);
        sepBaixo.setBackground(AppColors.GOLD);

        btnSalvar = new JButtonCustom(
                "Salvar Item",
                JButtonCustom.Style.PRIMARY,
                FontIcon.of(FontAwesomeSolid.SAVE, AppColors.ICON_SM, AppColors.GOLD)
        );

        btnCancelar = new JButtonCustom(
                "Cancelar",
                JButtonCustom.Style.DANGER,
                FontIcon.of(FontAwesomeSolid.TIMES, AppColors.ICON_SM, AppColors.GOLD)
        );

        // Definições para o painel de conteúdo
        contentPane.setLayout(new GridBagLayout());
        contentPane.setBackground(AppColors.DARK);
        contentPane.setBorder(BorderFactory.createCompoundBorder(
                BorderFactory.createLineBorder(AppColors.GOLD, 0),
                BorderFactory.createEmptyBorder(15, 20, 15, 20)
        ));

        GridBagConstraints gbc = new GridBagConstraints();

        // Definições para lblTitulo
        gbc.gridwidth = 2;
        gbc.gridx = 0;
        gbc.gridy = 0;
        gbc.fill = GridBagConstraints.HORIZONTAL;
        contentPane.add(lblTitulo, gbc);

        // Definições para sepTopo
        gbc.gridy = 1;
        gbc.insets = new Insets(5, 0, 5, 0);
        contentPane.add(sepTopo, gbc);

        // Definições para lblNome
        gbc.gridy = 2;
        gbc.insets = new Insets(5, 0, 0, 0);
        contentPane.add(lblNome, gbc);

        // Definições para txtNome
        gbc.gridy = 3;
        contentPane.add(txtNome, gbc);

        // Definições para lblTipo
        gbc.gridy = 4;
        gbc.gridwidth = 1;
        gbc.insets = new Insets(5, 0, 0, 5);
        contentPane.add(lblTipo, gbc);

        // Definições para lblRaridade
        gbc.gridx = 1;
        gbc.insets = new Insets(5, 5, 0, 0);
        contentPane.add(lblRaridade, gbc);

        // Definições para cbxTipo
        gbc.gridy = 5;
        gbc.gridx = 0;
        gbc.insets = new Insets(0, 0, 5, 5);
        contentPane.add(cbxTipo, gbc);

        // Definições para cbxRaridade
        gbc.gridx = 1;
        gbc.insets = new Insets(0, 5, 5, 0);
        contentPane.add(cbxRaridade, gbc);

        // Definições para lblEfeito
        gbc.gridy = 6;
        gbc.gridx = 0;
        gbc.insets = new Insets(5, 0, 0, 5);
        contentPane.add(lblEfeito, gbc);

        // Definições para lblValor
        gbc.gridx = 1;
        gbc.insets = new Insets(5, 5, 0, 0);
        contentPane.add(lblValor, gbc);

        // Definições para txtEfeito
        gbc.gridy = 7;
        gbc.gridx = 0;
        gbc.insets = new Insets(0, 0, 5, 5);
        contentPane.add(txtEfeito, gbc);

        // Definições para txtValor
        gbc.gridx = 1;
        gbc.insets = new Insets(0, 5, 5, 0);
        contentPane.add(txtValor, gbc);

        // Definições para sepBaixo
        gbc.gridy = 8;
        gbc.gridx = 0;
        gbc.gridwidth = 2;
        gbc.insets = new Insets(5, 0, 5, 0);
        contentPane.add(sepBaixo, gbc);

        // Definições para btnSalvar
        gbc.gridwidth = 1;
        gbc.gridy = 9;
        gbc.insets = new Insets(5, 0, 0, 5);
        contentPane.add(btnSalvar, gbc);

        // Definições para btnCancelar
        gbc.gridx = 1;
        gbc.insets = new Insets(5, 5, 0, 0);
        contentPane.add(btnCancelar, gbc);

        // Definições para a tela
        this.setContentPane(contentPane);
        this.setTitle("Narratus RPG - Adicionar Item");
        this.setDefaultCloseOperation(JFrame.HIDE_ON_CLOSE);
        this.pack();
        this.setLocationRelativeTo(null);
        this.setResizable(false);
    }
}
