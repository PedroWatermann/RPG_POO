package com.rpgpoo.Raca.model;

import com.rpgpoo.Atributo.model.AtributoModel;

public class RacaModel {
    private String nome;
    private AtributoModel atributo;

    public String getNome() {
        return nome;
    }
    public void setNome(String nome) {
        this.nome = nome;
    }
    public AtributoModel getAtributo() {
        return atributo;
    }
    public void setAtributo(AtributoModel atributo) {
        this.atributo = atributo;
    }

    public RacaModel(String nome, AtributoModel atributo) {
        this.setNome(nome);
        this.setAtributo(atributo);
    }
    public RacaModel(){
    }

    @Override
    public String toString() {
        return "RacaModel{" +
                "nome='" + nome + '\'' +
                ", atributo=" + atributo.toString() +
                '}';
    }
}
