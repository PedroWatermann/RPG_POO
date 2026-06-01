package com.rpgpoo;

import com.rpgpoo.Login.view.LoginView;

import java.awt.*;

public class Main {
    Color DARK = new Color(0x1A, 0x14, 0x10);
    Color DARK3 = new Color(0x24, 0x1E, 0x18);
    Color GOLD = new Color(0xC9, 0xA8, 0x4C);
    Color CRIMSON = new Color(0x7B, 0x1C, 0x2E);
    Color PARCHMENT = new Color(0xF0, 0xE6, 0xC8);

    public static void main(String[] args) {
        LoginView login = new LoginView();
        login.principal();
    }

    public Color getDARK() {
        return DARK;
    }

    public Color getDARK3() {
        return DARK3;
    }

    public Color getGOLD() {
        return GOLD;
    }

    public Color getCRIMSON() {
        return CRIMSON;
    }

    public Color getPARCHMENT() {
        return PARCHMENT;
    }
}
