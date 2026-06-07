package com.rpgpoo.Login.view;

import javax.swing.*;
import java.awt.*;

import com.rpgpoo.Gerenciador.Gerenciador;
import com.rpgpoo.Login.controller.LoginController;
import com.rpgpoo.utils.AppColors;
import com.rpgpoo.utils.JButtonCustom;
import org.kordamp.ikonli.swing.FontIcon;
import org.kordamp.ikonli.fontawesome6.FontAwesomeSolid;

public class LoginView extends JPanel {
    JLabel lblTitulo = new JLabel();
    JLabel lblUsuario = new JLabel();
    JTextField txtUsuario = new JTextField();
    JLabel lblSenha = new JLabel();
    JPasswordField txtSenha = new JPasswordField();
    JButton btnEntrar;

    public LoginView(Gerenciador gerenciador) {
        lblTitulo.setFont(new Font("Serif", Font.BOLD, 18));
        lblTitulo.setIcon(FontIcon.of(FontAwesomeSolid.USER_SHIELD, AppColors.ICON_LG, AppColors.GOLD));
        lblTitulo.setText(" ACESSO AO SISTEMA");
        lblTitulo.setForeground(AppColors.GOLD);
        lblTitulo.setHorizontalAlignment(SwingConstants.CENTER);

        JSeparator sepTopo = new JSeparator();
        sepTopo.setForeground(AppColors.GOLD);
        sepTopo.setBackground(AppColors.GOLD);

        lblUsuario.setFont(new Font("SansSerif", Font.PLAIN, 12));
        lblUsuario.setText("Usuário:");
        lblUsuario.setForeground(AppColors.PARCHMENT);

        txtUsuario.setFont(new Font("SansSerif", Font.PLAIN, 12));
        txtUsuario.setOpaque(false);
        txtUsuario.setForeground(Color.WHITE);
        txtUsuario.setCaretColor(AppColors.PARCHMENT);
        txtUsuario.setBorder(BorderFactory.createLineBorder(AppColors.PARCHMENT));
        txtUsuario.setPreferredSize(new Dimension(220, 28));

        lblSenha.setFont(new Font("SansSerif", Font.PLAIN, 12));
        lblSenha.setText("Senha:");
        lblSenha.setForeground(AppColors.PARCHMENT);

        txtSenha.setFont(new Font("SansSerif", Font.PLAIN, 12));
        txtSenha.setOpaque(false);
        txtSenha.setForeground(Color.WHITE);
        txtSenha.setCaretColor(AppColors.PARCHMENT);
        txtSenha.setBorder(BorderFactory.createLineBorder(AppColors.PARCHMENT));
        txtSenha.setPreferredSize(new Dimension(220, 28));

        JSeparator sepBaixo = new JSeparator();
        sepBaixo.setForeground(AppColors.GOLD);
        sepBaixo.setBackground(AppColors.GOLD);

        btnEntrar = new JButtonCustom("Entrar", FontIcon.of(FontAwesomeSolid.SIGN_IN_ALT, AppColors.ICON_SM, AppColors.PARCHMENT));

        this.setLayout(new GridBagLayout());
        this.setBackground(AppColors.DARK);
        this.setBorder(BorderFactory.createCompoundBorder(
                BorderFactory.createLineBorder(AppColors.GOLD, 2),
                BorderFactory.createEmptyBorder(15, 20, 15, 20)
        ));

        GridBagConstraints bag = new GridBagConstraints();
        bag.insets = new Insets(4, 4, 4, 4);
        bag.fill = GridBagConstraints.HORIZONTAL;

        bag.gridx = 0;
        bag.gridy = 0;
        bag.gridwidth = 2;
        this.add(lblTitulo, bag);

        bag.gridy = 1;
        this.add(sepTopo, bag);

        bag.gridy = 2;
        bag.gridwidth = 1;
        bag.fill = GridBagConstraints.NONE;
        bag.anchor = GridBagConstraints.WEST;
        this.add(lblUsuario, bag);

        bag.gridx = 1; bag.gridy = 2;
        bag.fill = GridBagConstraints.HORIZONTAL;
        bag.weightx = 1.0;
        this.add(txtUsuario, bag);

        bag.gridx = 0; bag.gridy = 3;
        bag.fill = GridBagConstraints.NONE;
        bag.weightx = 0;
        this.add(lblSenha, bag);

        bag.gridx = 1; bag.gridy = 3;
        bag.fill = GridBagConstraints.HORIZONTAL;
        bag.weightx = 1.0;
        this.add(txtSenha, bag);

        bag.gridx = 0; bag.gridy = 4;
        bag.gridwidth = 2;
        bag.weightx = 0;
        this.add(sepBaixo, bag);

        bag.gridy = 5;
        bag.fill = GridBagConstraints.NONE;
        bag.anchor = GridBagConstraints.CENTER;
        this.add(btnEntrar, bag);

        LoginController loginController = new LoginController(this, gerenciador);
        btnEntrar.addActionListener(_ -> loginController.btnEntrarClick());
    }

    public JTextField getTxtUsuario() {
        return txtUsuario;
    }

    public JPasswordField getTxtSenha() {
        return txtSenha;
    }
}
