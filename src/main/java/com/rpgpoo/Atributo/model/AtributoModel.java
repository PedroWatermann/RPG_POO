package com.rpgpoo.Atributo.model;

public class AtributoModel {
    private int id;
    private String nome;
    private int modificador;
    private int quantidadeDados;

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
    public int getQuantidadeDados() {
        return quantidadeDados;
    }
    public void setQuantidadeDados(int quantidadeDados) {
        this.quantidadeDados = quantidadeDados;
    }

    public AtributoModel(String nome, int modificador, int quantidadeDados) {
        gerarId();
        this.setNome(nome);
        this.setModificador(modificador);
        this.setQuantidadeDados(quantidadeDados);
    }
    public AtributoModel() {
    }

    @Override
    public String toString() {
        return "AtributoModel{" +
                "id=" + id +
                ", nome='" + nome + '\'' +
                ", modificador=" + modificador +
                ", quantidadeDados=" + quantidadeDados +
                '}';
    }

    private void gerarId() {
        this.id = 1;
    }
}
