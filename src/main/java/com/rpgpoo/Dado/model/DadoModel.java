package com.rpgpoo.Dado.model;

import com.rpgpoo.Atributo.model.AtributoModel;

public class DadoModel {
    private int lados;
    private AtributoModel atributo;

    public int getLados() {
        return lados;
    }
    public void setLados(int lados) {
        this.lados = lados;
    }
    public AtributoModel getAtributo() {
        return atributo;
    }
    public void setAtributo(AtributoModel atributo) {
        this.atributo = atributo;
    }

    public DadoModel(int lados, AtributoModel atributo) {
        this.setLados(lados);
        this.setAtributo(atributo);
    }
    public DadoModel() {
    }

    @Override
    public String toString() {
        return "DadoModel{" +
                "lados=" + lados +
                ", atributo=" + atributo.toString() +
                '}';
    }

    public void rolarDado(){

    }

}
