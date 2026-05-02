package com.rpgpoo.Atributo.model;

public class AtributoModel {
    private int id;
    private String nome;
    private int modificador;

    //region Getters e Setters
    public int getId() {
        return id;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public int getModificador() {
        return modificador;
    }

    public void setModificador(int modificador) {
        this.modificador = modificador;
    }
    //endregion

    //Construtor
    public AtributoModel(String nome, int modificador) {
        gerarId();
        this.setNome(nome);
        this.setModificador(modificador);
    }

    @Override
    public String toString() {
        return "AtributoModel {" +
                "\n\tid = " + this.getId() +
                ",\n\tnome = '" + this.getNome() + '\'' +
                ",\n\tmodificador = " + this.getModificador() +
                "\n}";
    }

    private void gerarId() {
        this.id = 1;
    }
}
