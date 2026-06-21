package com.rpgpoo.Campanha.controller;

import com.rpgpoo.Campanha.view.CampanhaCreateView;
import com.rpgpoo.Campanha.view.CampanhaSelectView;
import com.rpgpoo.Gerenciador.Gerenciador;

public class CampanhaCreateController {
    private final CampanhaCreateView view;
    private final Gerenciador gerenciador;

    public CampanhaCreateController(CampanhaCreateView view, Gerenciador gerenciador) {
        this.view = view;
        this.gerenciador = gerenciador;
        // TODO: implementar listeners de salvamento e validação do formulário
    }
}
