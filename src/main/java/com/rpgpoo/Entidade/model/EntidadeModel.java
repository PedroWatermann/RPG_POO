package com.rpgpoo.Entidade.model;

import com.rpgpoo.Arma.model.ArmaModel;
import com.rpgpoo.Campanha.model.CampanhaModel;

import java.util.ArrayList;
import java.util.List;

public abstract class EntidadeModel {
    private int id;
    private String nome;
    private int nivel;
    private int ataque;
    private int vida;
    private int defesa;
    private ArmaModel arma;
    private List<CampanhaModel> campanhas;
    private CampanhaModel campanhaAtual;
    private int dt;

    //region Getters e Setters
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

    public List<CampanhaModel> getCampanhas() {
        return campanhas;
    }

    public CampanhaModel getCampanhaAtual() {
        return campanhaAtual;
    }

    public void setCampanhaAtual(CampanhaModel campanhaAtual) {
        this.campanhaAtual = campanhaAtual;
    }

    public void setCampanhas(List<CampanhaModel> campanhas) {
        if (campanhas != null && !campanhas.isEmpty())
            for (CampanhaModel campanha : campanhas)
                if (!this.getCampanhas().contains(campanha)) {
                    this.campanhas.add(campanha);
                    if (this.getCampanhaAtual() == null)
                        this.setCampanhaAtual(campanha);
                }
    }

    public void setCampanhas(CampanhaModel campanha) {
        if (campanha != null) {
            if (this.getCampanhas() == null) {
                this.campanhas = new ArrayList<>();
                this.campanhas.add(campanha);
            } else {
                if (!this.getCampanhas().contains(campanha)) {
                    this.campanhas.add(campanha);
                }
            }
            if (this.getCampanhaAtual() == null)
                this.setCampanhaAtual(campanha);
        }
    }

    public int getDt() {
        return dt;
    }

    public void setDt(int dt) {
        this.dt = dt;
    }
    //endregion

    //Construtor
    public EntidadeModel(String nome, int nivel, int ataque, int vida, int defesa, ArmaModel arma, int dt) {
        gerarId();
        this.setNome(nome);
        this.setNivel(nivel);
        this.setAtaque(ataque);
        this.setVida(vida);
        this.setDefesa(defesa);
        this.setArma(arma);
        this.setDt(dt);
    }

    public abstract int atacar(int dtAlvo);

    public abstract void defender(int danoRecebido);

    private void gerarId() {
        this.id = 1;
    }
}
