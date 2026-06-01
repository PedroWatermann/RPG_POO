package com.rpgpoo.Gerenciador;

import com.rpgpoo.Campanha.view.CampanhaListView;
import com.rpgpoo.Main;

import javax.swing.*;
import javax.swing.plaf.basic.BasicTabbedPaneUI;
import java.awt.*;

public class Gerenciador extends JTabbedPane {
    public void legal() {
        Main main = new Main();

        this.setForeground(main.getPARCHMENT());
        this.setBackground(main.getDARK());

        this.setUI(new BasicTabbedPaneUI() {
            @Override
            protected void paintTabBorder(Graphics g, int tabPlacement, int tabIndex,
                                          int x, int y, int w, int h, boolean isSelected) {
                // remove a borda das abas — deixa vazio pra não desenhar nada
            }

            @Override
            protected void paintTabBackground(Graphics g, int tabPlacement, int tabIndex,
                                              int x, int y, int w, int h, boolean isSelected) {
                Graphics2D g2 = (Graphics2D) g;
                if (isSelected) {
                    g2.setColor(main.getGOLD()); // fundo da aba selecionada
                } else {
                    g2.setColor(main.getDARK()); // fundo das abas inativas
                }
                g2.fillRect(x, y, w, h);
            }

            @Override
            protected void paintFocusIndicator(Graphics g, int tabPlacement, Rectangle[] rects,
                                               int tabIndex, Rectangle iconRect,
                                               Rectangle textRect, boolean isSelected) {
                // remove o retângulo pontilhado de foco
            }

            @Override
            protected int calculateTabHeight(int tabPlacement, int tabIndex, int fontHeight) {
                return 40; // altura das abas
            }
        });

        this.addTab("Campanha", null, new CampanhaListView(), "Informações da Campanha");
        this.addTab("Personagem", null, null, "Informações do Personagem");
        this.addTab("Monstro", null, null, "Informações do Monstro");

        JFrame gerenciadorFrame = new JFrame("RPG POO - Gerenciador");
        gerenciadorFrame.setForeground(main.getPARCHMENT());
        gerenciadorFrame.setBackground(main.getDARK());
        gerenciadorFrame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        gerenciadorFrame.setExtendedState(JFrame.MAXIMIZED_BOTH);
        gerenciadorFrame.setContentPane(this);
        gerenciadorFrame.setLocationRelativeTo(null);
        gerenciadorFrame.setVisible(true);
    }
}
