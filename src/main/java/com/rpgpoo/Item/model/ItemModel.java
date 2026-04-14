package com.rpgpoo.Item.model;

public class ItemModel {
    private int id;
    private String nome;
    private enum tipoItem {item1, item2};
    private double valorEfeito;
    private enum raridade {raridade1, raridade2};
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
