package com.rpgpoo.Entidade.model;

public class EntidadeModel {
    private int id;
    private String nome;
    private int nivel;
    private int ataque;
    private int vida;
    private int defesa;
    private Arma arma;

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
    public int getNivel() {
        return nivel;
    }
    public void setNivel(int nivel) {
        this.nivel = nivel;
    }
    public int getAtaque() {
        return ataque;
    }
    public void setAtaque(int ataque) {
        this.ataque = ataque;
    }
    public int getVida() {
        return vida;
    }
    public void setVida(int vida) {
        this.vida = vida;
    }
    public int getDefesa() {
        return defesa;
    }
    public void setDefesa(int defesa) {
        this.defesa = defesa;
    }
    public Arma getArma() {
        return this.arma;
    }
    public void setArma(Arma arma) {
        this.arma = arma;
    }

    public int atacar() {
        return this.ataque;
    }

    public int defender() {
        return this.defesa;
    }

    public EntidadeModel() {

    }
}
