package com.rpgpoo.Entidade.model;

import com.rpgpoo.Arma.model.ArmaModel;

public abstract class EntidadeModel {
    private int id;
    private String nome;
    private int nivel;
    private int ataque;
    private int vida;
    private int defesa;
    private ArmaModel arma;

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
    public ArmaModel getArma() {
        return this.arma;
    }
    public void setArma(ArmaModel arma) {
        this.arma = arma;
    }

    public abstract int atacar();

    public abstract int defender();

    public EntidadeModel(String nome, int nivel, int ataque, int vida, int defesa, ArmaModel arma) {
        gerarId();
        this.setNome(nome);
        this.setNivel(nivel);
        this.setAtaque(ataque);
        this.setVida(vida);
        this.setDefesa(defesa);
        this.setArma(arma);
    }

    private void gerarId() {
        this.id = 1;
    }
}
