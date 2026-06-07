package com.rpgpoo.Login.controller;

import com.rpgpoo.Campanha.view.CampanhaSelectView;
import com.rpgpoo.Gerenciador.Gerenciador;
import com.rpgpoo.Login.view.LoginView;

import javax.swing.*;

public class LoginController {
    private final LoginView view;
    private final Gerenciador gerenciador;

    public LoginController(LoginView view, Gerenciador gerenciador) {
        this.view = view;
        this.gerenciador = gerenciador;
    }

    public void btnEntrarClick() {
        String usuario = view.getTxtUsuario().getText().trim();
        String senha = new String(view.getTxtSenha().getPassword()).trim();

        if (usuario.isEmpty() || senha.isEmpty()) {
            JOptionPane.showMessageDialog(view, "Preencha todos os campos.", "Atenção", JOptionPane.WARNING_MESSAGE);
            return;
        }

        if (!usuario.equals("admin") || !senha.equals("123")) {
            JOptionPane.showMessageDialog(view, "Usuário e/ou senha incorretos. Tente novamente.", "Erro", JOptionPane.ERROR_MESSAGE);
        } else {
            gerenciador.addPainel(new CampanhaSelectView(gerenciador), "campanhaSelect");
            gerenciador.navegarPara("campanhaSelect", true, "Selecionar Campanha", true);
        }
    }
}
