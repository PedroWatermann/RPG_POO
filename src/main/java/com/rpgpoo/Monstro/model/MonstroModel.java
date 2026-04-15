package com.rpgpoo.Monstro.model;

import com.rpgpoo.Item.model.ItemModel;

import java.util.ArrayList;

public class MonstroModel {
    private ArrayList<ItemModel> loot;

    public ArrayList<ItemModel> getLoot() {
        return this.loot;
    }

    public void setLoot(ArrayList<ItemModel> loot) {
        this.loot = loot;
    }
}
