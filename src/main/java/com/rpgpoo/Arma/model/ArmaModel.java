package com.rpgpoo.Arma.model;

import com.rpgpoo.Dado.model.DadoModel;
import com.rpgpoo.Enum.RaridadeEnum;
import com.rpgpoo.Enum.TipoItemEnum;
import com.rpgpoo.Item.model.ItemModel;

public class ArmaModel extends ItemModel {
    private int dano;
    private int alcance;
    private int durabilidade;
    private DadoModel dado;

    public int getDano() { return this.dano; }

    public void setDano(int dano) { this.dano = dano; }

    public int getAlcance() { return this.alcance; }

    public void setAlcance(int alcance) { this.alcance = alcance; }

    public int getDurabilidade() { return this.durabilidade; }

    public void setDurabilidade(int durabilidade) { this.durabilidade = durabilidade; }

    public DadoModel getDado() { return this.dado; }

    public void setDado(DadoModel dado) { this.dado = dado; }

    public ArmaModel(String nome, TipoItemEnum tipoItem, double valorEfeito, RaridadeEnum raridade, double valor, int dano, int alcance, int durabilidade, DadoModel dado) {
        super(nome, tipoItem, valorEfeito, raridade, valor);
        this.setDano(dano);
        this.setAlcance(alcance);
        this.setDurabilidade(durabilidade);
        this.setDado(dado);
    }

    @Override
    public String toString() {
        return "ArmaModel{" +
                "dano=" + dano +
                ", alcance=" + alcance +
                ", durabilidade=" + durabilidade +
                ", dado=" + dado +
                '}';
    }
}
