package com.rpgpoo.Item.controller;

import com.rpgpoo.Campanha.view.CampanhaSelectView;
import com.rpgpoo.Gerenciador.Gerenciador;
import com.rpgpoo.Item.view.ItemAddView;
import com.rpgpoo.Item.view.ItemView;

public class ItemController {
    private final ItemView view;
    private final Gerenciador gerenciador;

    public ItemController(ItemView view, Gerenciador gerenciador) {
        this.view = view;
        this.gerenciador = gerenciador;
    }

    public void btnAdicionarClick() {
        new ItemAddView().setVisible(true);
    }
}
