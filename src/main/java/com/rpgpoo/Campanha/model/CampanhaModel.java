package com.rpgpoo.Campanha.model;

import com.rpgpoo.Jogador.model.JogadorModel;

import java.util.ArrayList;

public class CampanhaModel {
    private int id;
    private String nome;
    private String descricao;
    private ArrayList<Personagem> personagens;
    private ArrayList<JogadorModel> jogadores;
    private int dado;
    private JogadorModel mestre;

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

    public String getDescricao() {
        return descricao;
    }

    public void setDescricao(String descricao) {
        this.descricao = descricao;
    }

    public ArrayList<Personagem> getPersonagens() {
        return personagens;
    }

    public void setPersonagens(ArrayList<Personagem> personagens) {
        this.personagens = personagens;
    }

    public ArrayList<JogadorModel> getJogadores() {
        return jogadores;
    }

    public void setJogadores(ArrayList<JogadorModel> jogadores) {
        this.jogadores = jogadores;
    }

    public int getDado() {
        return dado;
    }

    public void setDado(int dado) {
        this.dado = dado;
    }

    public JogadorModel getMestre() {
        return mestre;
    }

    public void setMestre(JogadorModel mestre) {
        this.mestre = mestre;
    }
}
