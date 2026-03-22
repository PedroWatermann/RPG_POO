package com.rpgpoo;

import com.formdev.flatlaf.FlatDarkLaf;
import com.rpgpoo.views.MainFrame;

import javax.swing.*;

public class Main {
    public static void main(String[] args) {
        SwingUtilities.invokeLater(() -> {
            FlatDarkLaf.setup();

            System.out.println("LookAndFeel: " + UIManager.getLookAndFeel().getName());

            MainFrame mainFrame = new MainFrame();
            mainFrame.iniciar();
        });
    }
}
