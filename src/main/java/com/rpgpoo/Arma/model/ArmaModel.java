package com.rpgpoo.Arma.model;

import com.rpgpoo.Item.model.ItemModel;

public class ArmaModel extends ItemModel {
    private int dano;
    private int alcance;
    private int durabilidade;
    private Dado dado;

    public int getDano() { return this.dano; }

    public void setDano(int dano) { this.dano = dano; }

    public int getAlcance() { return this.alcance; }

    public void setAlcance(int alcance) { this.alcance = alcance; }

    public int getDurabilidade() { return this.durabilidade; }

    public void setDurabilidade(int durabilidade) { this.durabilidade = durabilidade; }

    public Dado getDado() { return this.dado; }

    public void setDado(Dado dado) { this.dado = dado; }
}
