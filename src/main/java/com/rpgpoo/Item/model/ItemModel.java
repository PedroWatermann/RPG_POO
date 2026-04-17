package com.rpgpoo.Item.model;

import com.rpgpoo.Enum.RaridadeEnum;
import com.rpgpoo.Enum.TipoItemEnum;

public class ItemModel {
    private int id;
    private String nome;
    private TipoItemEnum tipoItem;
    private double valorEfeito;
    private RaridadeEnum raridade;

    public TipoItemEnum getTipoItem() {
        return tipoItem;
    }

    public void setTipoItem(TipoItemEnum tipoItem) {
        this.tipoItem = tipoItem;
    }

    public RaridadeEnum getRaridade() {
        return raridade;
    }

    public void setRaridade(RaridadeEnum raridade) {
        this.raridade = raridade;
    }

    private double valor;

    public int getId() {
        return id;
    }
    public void setId(int id) {
        this.id = id;
    }
    public String getNome() {
        return nome;
    }
    public void setNome(String nome) {
        this.nome = nome;
    }
    public double getValorEfeito() {
        return valorEfeito;
    }
    public void setValorEfeito(double valorEfeito) {
        this.valorEfeito = valorEfeito;
    }
    public double getValor() {
        return valor;
    }
    public void setValor(double valor) {
        this.valor = valor;
    }

    public ItemModel() {

    }
}
