package com.rpgpoo.Monstro.model;

import com.rpgpoo.Arma.model.ArmaModel;
import com.rpgpoo.Entidade.model.EntidadeModel;
import com.rpgpoo.Item.model.ItemModel;

import java.util.ArrayList;
import java.util.List;

public class MonstroModel extends EntidadeModel {
    private List<ItemModel> loot;

    //region Getters e Setters
    public List<ItemModel> getLoot() {
        return this.loot;
    }

    public void setLoot(List<ItemModel> loot) {
        if (loot != null && !loot.isEmpty())
            this.loot = loot;
    }

    public void setItemLoot(ItemModel itemLoot) {
        if (this.loot != null)
            this.loot.add(itemLoot);
    }
    //endregion

    //Construtor
    public MonstroModel(String nome, int nivel, int ataque, int vida, int defesa, ArmaModel arma, List<ItemModel> loot) {
        super(nome, nivel, ataque, vida, defesa, arma);
        this.loot = loot;
    }

    @Override
    public int atacar() {
        //Representa a aleatoriedade do sucesso que o monstro pode ter ao atacar
        int sorte = this.getArma().getDado().rolarDado();
        return this.getAtaque() + sorte;
    }

    @Override
    public int defender() {
        return this.getDefesa();
    }

    @Override
    public String toString() {
        List<String> loot = new ArrayList<>();
        this.loot.forEach(item -> loot.add(item.getNome() + ", "));

        return "MonstroModel {" +
                "\n\tloot = " + loot +
                "\n}";
    }
}
