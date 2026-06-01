package com.rpgpoo.Login.view;

import javax.swing.*;
import java.awt.*;

import com.rpgpoo.Campanha.view.CampanhaSelectView;
import com.rpgpoo.Main;
import org.kordamp.ikonli.fontawesome5.FontAwesomeRegular;
import org.kordamp.ikonli.swing.FontIcon;
import org.kordamp.ikonli.fontawesome5.FontAwesomeSolid;

public class LoginView {
    JPanel mainPanel = new JPanel();
    JLabel lblTitulo = new JLabel();
    JLabel lblUsuario = new JLabel();
    JTextField txtUsuario = new JTextField();
    JLabel lblSenha = new JLabel();
    JPasswordField txtSenha = new JPasswordField();
    JButton btnEntrar = new JButton();
    JFrame mainFrame = new JFrame();

    public void principal() {
        Main main = new Main();

        lblTitulo.setIcon(FontIcon.of(FontAwesomeRegular.USER, 16, main.getGOLD()));
        lblTitulo.setText(" ACESSO AO SISTEMA");
        lblTitulo.setFont(lblTitulo.getFont().deriveFont(Font.BOLD, 16));
        lblTitulo.setForeground(main.getGOLD());
        lblTitulo.setHorizontalAlignment(SwingConstants.CENTER);

        JSeparator sepTopo = new JSeparator();
        sepTopo.setForeground(main.getGOLD());
        sepTopo.setBackground(main.getGOLD());

        JSeparator sepBaixo = new JSeparator();
        sepBaixo.setForeground(main.getGOLD());
        sepBaixo.setBackground(main.getGOLD());

        lblUsuario.setText("Usuário:");
        lblUsuario.setForeground(main.getPARCHMENT());

        txtUsuario.setOpaque(false);
        txtUsuario.setForeground(Color.WHITE);
        txtUsuario.setCaretColor(main.getPARCHMENT());
        txtUsuario.setBorder(BorderFactory.createLineBorder(main.getPARCHMENT()));
        txtUsuario.setPreferredSize(new Dimension(220, 28));

        lblSenha.setText("Senha:");
        lblSenha.setForeground(main.getPARCHMENT());

        txtSenha.setOpaque(false);
        txtSenha.setForeground(Color.WHITE);
        txtSenha.setCaretColor(main.getPARCHMENT());
        txtSenha.setBorder(BorderFactory.createLineBorder(main.getPARCHMENT()));
        txtSenha.setPreferredSize(new Dimension(220, 28));

        // Botão entrar - arredondado com padding
        btnEntrar = new JButton(" Entrar") {
            @Override
            protected void paintComponent(Graphics g) {
                Graphics2D g2 = (Graphics2D) g.create();
                g2.setRenderingHint(RenderingHints.KEY_ANTIALIASING, RenderingHints.VALUE_ANTIALIAS_ON);
                g2.setColor(getBackground());
                g2.fillRoundRect(0, 0, getWidth(), getHeight(), 20, 20);
                g2.dispose();
                super.paintComponent(g);
            }

            @Override
            protected void paintBorder(Graphics g) {
                Graphics2D g2 = (Graphics2D) g.create();
                g2.setRenderingHint(RenderingHints.KEY_ANTIALIASING, RenderingHints.VALUE_ANTIALIAS_ON);
                g2.setColor(main.getGOLD());
                g2.drawRoundRect(0, 0, getWidth() - 1, getHeight() - 1, 20, 20);
                g2.dispose();
            }
        };
        btnEntrar.setIcon(FontIcon.of(FontAwesomeSolid.SIGN_IN_ALT, 16, main.getPARCHMENT()));
        btnEntrar.setContentAreaFilled(false);
        btnEntrar.setFocusPainted(false);
        btnEntrar.setOpaque(false);
        btnEntrar.setForeground(main.getPARCHMENT());
        btnEntrar.setBackground(new Color(0x24, 0x1E, 0x18));
        btnEntrar.setPreferredSize(new Dimension(160, 36));
        btnEntrar.setBorder(BorderFactory.createEmptyBorder(6, 20, 6, 20));
        btnEntrar.addActionListener(e -> {
            String usuario = txtUsuario.getText().trim();
            String senha   = new String(txtSenha.getPassword()).trim();

            if (usuario.isEmpty() || senha.isEmpty()) {
                JOptionPane.showMessageDialog(mainFrame, "Preencha todos os campos.", "Atenção", JOptionPane.WARNING_MESSAGE);
                return;
            }

            if (!usuario.equals("admin") || !senha.equals("123")) {
                JOptionPane.showMessageDialog(mainFrame, "Usuário e/ou senha incorretos. Tente novamente.", "Atenção", JOptionPane.ERROR_MESSAGE);
            } else {
                mainFrame.dispose();
                new CampanhaSelectView().principal();
            }
        });

        // Layout principal com GridBagLayout
        mainPanel.setLayout(new GridBagLayout());
        mainPanel.setBackground(main.getDARK());
        mainPanel.setBorder(BorderFactory.createCompoundBorder(
                BorderFactory.createLineBorder(main.getGOLD(), 2),
                BorderFactory.createEmptyBorder(15, 20, 15, 20)
        ));

        GridBagConstraints bag = new GridBagConstraints();
        bag.insets = new Insets(4, 4, 4, 4);
        bag.fill = GridBagConstraints.HORIZONTAL;

        bag.gridx = 0; bag.gridy = 0;
        bag.gridwidth = 2;
        mainPanel.add(lblTitulo, bag);

        bag.gridy = 1;
        mainPanel.add(sepTopo, bag);

        bag.gridy = 2; bag.gridwidth = 1;
        bag.fill = GridBagConstraints.NONE;
        bag.anchor = GridBagConstraints.WEST;
        mainPanel.add(lblUsuario, bag);

        bag.gridx = 1; bag.gridy = 2;
        bag.fill = GridBagConstraints.HORIZONTAL;
        bag.weightx = 1.0;
        mainPanel.add(txtUsuario, bag);

        bag.gridx = 0; bag.gridy = 3;
        bag.fill = GridBagConstraints.NONE;
        bag.weightx = 0;
        mainPanel.add(lblSenha, bag);

        bag.gridx = 1; bag.gridy = 3;
        bag.fill = GridBagConstraints.HORIZONTAL;
        bag.weightx = 1.0;
        mainPanel.add(txtSenha, bag);

        bag.gridx = 0; bag.gridy = 4;
        bag.gridwidth = 2;
        bag.weightx = 0;
        mainPanel.add(sepBaixo, bag);

        bag.gridy = 5;
        bag.fill = GridBagConstraints.NONE;
        bag.anchor = GridBagConstraints.CENTER;
        mainPanel.add(btnEntrar, bag);

        mainFrame.setTitle("RPG POO - Login");
        mainFrame.setResizable(false);
        mainFrame.setLayout(new BorderLayout());
        mainFrame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        mainFrame.add(mainPanel, BorderLayout.CENTER);
        mainFrame.pack();
        mainFrame.setLocationRelativeTo(null);
        mainFrame.setVisible(true);
    }
}