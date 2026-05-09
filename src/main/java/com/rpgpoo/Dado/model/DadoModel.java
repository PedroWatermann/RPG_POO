package com.rpgpoo.Dado.model;

import com.rpgpoo.Atributo.model.AtributoModel;

public class DadoModel {
    private int lados;
    private AtributoModel atributo;

    //region Getters e Setters
    public int getLados() {
        return lados;
    }

    public void setLados(int lados) {
        if (lados > 0) {
            this.lados = lados;
        }
    }

    public AtributoModel getAtributo() {
        return atributo;
    }

    public void setAtributo(AtributoModel atributo) {
        this.atributo = atributo;
    }
    //endregion

    //Construtor
    public DadoModel(int lados, AtributoModel atributo) {
        this.setLados(lados);
        this.setAtributo(atributo);
    }

    @Override
    public String toString() {
        return "DadoModel {" +
                "\n\tlados = " + lados +
                ",\n\tatributo = " + atributo.toString() +
                "\n}";
    }

    public int rolarDado() {
        return (int)(Math.random() * this.getLados()) + 1;
    }
}
