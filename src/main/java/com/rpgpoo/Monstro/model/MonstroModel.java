package com.rpgpoo.Monstro.model;

import com.rpgpoo.Arma.model.ArmaModel;
import com.rpgpoo.Entidade.model.EntidadeModel;
import com.rpgpoo.Item.model.ItemModel;

import java.util.List;

public class MonstroModel extends EntidadeModel {
    private List<ItemModel> loot;

    public List<ItemModel> getLoot() {
        return this.loot;
    }

    public void setLoot(List<ItemModel> loot) {
        this.loot = loot;
    }

    public MonstroModel(String nome, int nivel, int ataque, int vida, int defesa, ArmaModel arma, List<ItemModel> loot) {
        super(nome, nivel, ataque, vida, defesa, arma);
        this.loot = loot;
    }

    @Override
    public int atacar() {
        return 0;
    }

    @Override
    public int defender() {
        return 0;
    }

    @Override
    public String toString() {
        return "MonstroModel{" +
                "loot=" + loot +
                '}';
    }
}
