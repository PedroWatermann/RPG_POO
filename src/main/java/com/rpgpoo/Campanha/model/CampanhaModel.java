package com.rpgpoo.Campanha.model;

import com.rpgpoo.Dado.model.DadoModel;
import com.rpgpoo.Jogador.model.JogadorModel;
import com.rpgpoo.Personagem.model.PersonagemModel;

import java.util.List;

public class CampanhaModel {
    private int id;
    private String nome;
    private String descricao;
    private List<PersonagemModel> personagens;
    private List<JogadorModel> jogadores;
    private DadoModel dado;
    private JogadorModel mestre;

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

    public String getDescricao() {
        return descricao;
    }

    public void setDescricao(String descricao) {
        this.descricao = descricao;
    }

    public List<PersonagemModel> getPersonagens() {
        return personagens;
    }

    public void setPersonagens(List<PersonagemModel> personagens) {
        this.personagens = personagens;
    }

    public List<JogadorModel> getJogadores() {
        return jogadores;
    }

    public void setJogadores(List<JogadorModel> jogadores) {
        if (jogadores != null && !jogadores.isEmpty())
            this.jogadores = jogadores;
    }

    public void setJogadores(JogadorModel jogador) {
        if (jogador != null)
            this.jogadores.add(jogador);
    }

    public DadoModel getDado() {
        return this.dado;
    }

    public void setDado(DadoModel dado) {
        this.dado = dado;
    }

    public JogadorModel getMestre() {
        return mestre;
    }

    public void setMestre(JogadorModel mestre) {
        this.mestre = mestre;
    }
    //endregion

    //Construtor
    public CampanhaModel(String nome, String descricao, List<PersonagemModel> personagens, List<JogadorModel> jogadores, DadoModel dado, JogadorModel mestre) {
        gerarId();
        this.setNome(nome);
        this.setDescricao(descricao);
        this.setPersonagens(personagens);
        this.setJogadores(jogadores);
        this.setDado(dado);
        this.setMestre(mestre);
    }

    @Override
    public String toString() {
        return "CampanhaModel {" +
                "\n\tid = " + id +
                ",\n\tnome = '" + nome + '\'' +
                ",\n\tdescricao = '" + descricao + '\'' +
                ",\n\tpersonagens = " + personagens +
                ",\n\tjogadores = " + jogadores +
                ",\n\tdado = " + dado +
                ",\n\tmestre = " + mestre +
                "\n}";
    }

    private void gerarId() {
        this.id = 1;
    }
}
