package com.rpgpoo.Campanha.view;

import com.rpgpoo.Main;

import javax.swing.*;

public class CampanhaListView extends JPanel {
    public CampanhaListView() {
        Main main = new Main();

        this.setForeground(main.getPARCHMENT());
        this.setBackground(main.getDARK());
    }
}
