package com.rpgpoo.Campanha.controller;

import com.rpgpoo.Campanha.view.CampanhaListView;
import com.rpgpoo.Gerenciador.Gerenciador;

public class CampanhaListController {
    private CampanhaListView view;
    private Gerenciador gerenciador;
    public CampanhaListController(CampanhaListView view, Gerenciador gerenciador) {
        this.view = view;
        this.gerenciador = gerenciador;
    }
}
