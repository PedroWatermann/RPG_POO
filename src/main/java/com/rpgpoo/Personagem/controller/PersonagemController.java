package com.rpgpoo.Personagem.controller;

import com.rpgpoo.Gerenciador.Gerenciador;
import com.rpgpoo.Personagem.view.PersonagemView;

public class PersonagemController {
    private PersonagemView view;
    private Gerenciador gerenciador;

    public PersonagemController(PersonagemView view, Gerenciador gerenciador) {
        this.view = view;
        this.gerenciador = gerenciador;
    }

    public void btnAdicionarInventarioClick() {
        System.out.println("Adicionando Inventario");
    }
}
