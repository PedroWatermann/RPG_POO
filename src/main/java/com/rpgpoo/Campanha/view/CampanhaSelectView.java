package com.rpgpoo.Campanha.view;

import com.rpgpoo.Gerenciador.Gerenciador;
import com.rpgpoo.Main;

import javax.swing.*;
import java.awt.*;

public class CampanhaSelectView {
    JFrame mainFrame = new JFrame();
    JPanel mainPanel = new JPanel();
    JButton btnMudarONomeDepois = new JButton() ;

    public void principal() {
        Main main = new Main();

        mainPanel.setBackground(main.getDARK());
        mainPanel.setBorder(BorderFactory.createCompoundBorder(
                BorderFactory.createLineBorder(main.getGOLD(), 1),
                BorderFactory.createEmptyBorder(15, 20, 15, 20)
        ));

        btnMudarONomeDepois = new JButton(" Selecionar Campanha") {
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
        btnMudarONomeDepois.setForeground(main.getPARCHMENT());
        btnMudarONomeDepois.setBackground(new Color(0x24, 0x1E, 0x18));
        btnMudarONomeDepois.setPreferredSize(new Dimension(160, 36));
        btnMudarONomeDepois.setBorder(BorderFactory.createEmptyBorder(6, 20, 6, 20));
        btnMudarONomeDepois.addActionListener(e -> {
            mainFrame.dispose();
            new Gerenciador().legal();
        });

        mainPanel.add(btnMudarONomeDepois);

        mainFrame.setTitle("RPG POO - Seleção de Campanha");
        mainFrame.setLayout(new BorderLayout());
        mainFrame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        mainFrame.add(mainPanel, BorderLayout.CENTER);
        mainFrame.setLocationRelativeTo(null);
        mainFrame.setExtendedState(JFrame.MAXIMIZED_BOTH);
        mainFrame.setVisible(true);
    }
}
