package com.rpgpoo.Item.model;

import com.rpgpoo.Enum.RaridadeEnum;
import com.rpgpoo.Enum.TipoItemEnum;

public class ItemModel {
    private int id;
    private String nome;
    private TipoItemEnum tipoItem;
    private double valorEfeito;
    private RaridadeEnum raridade;
    private double valor;

    //region Getter e Setters
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
    //endregion

    //Construtor
    public ItemModel(String nome, TipoItemEnum tipoItem, double valorEfeito, RaridadeEnum raridade, double valor) {
        gerarId();
        this.nome = nome;
        this.tipoItem = tipoItem;
        this.valorEfeito = valorEfeito;
        this.raridade = raridade;
        this.valor = valor;
    }

    private void gerarId() {
        this.id = 1;
    }
}
