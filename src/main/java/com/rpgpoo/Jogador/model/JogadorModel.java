package com.rpgpoo.Jogador.model;

import com.rpgpoo.Personagem.model.PersonagemModel;

import java.util.ArrayList;
import java.util.List;

public class JogadorModel {
    private int id;
    private String nome;
    private String senha;
    private List<PersonagemModel> personagens;

    //region Getters e Setters
    public int  getId() {
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

    public String getSenha() {
        return senha;
    }

    public void setSenha(String senha) {
        this.senha = senha;
    }

    public List<PersonagemModel> getPersonagens() {
        return personagens;
    }

    public void setPersonagens(List<PersonagemModel> personagens) {
        if (personagens != null && !personagens.isEmpty())
            this.personagens = personagens;
    }

    public void setPersonagens(PersonagemModel personagem) {
        if (personagem != null)
            this.personagens.add(personagem);
    }
    //endregion

    //Construtor
    public JogadorModel(String nome, String senha) {
        gerarId();
        this.setNome(nome);
        this.setSenha(senha);
        this.personagens = new ArrayList<>();
    }

    @Override
    public String toString() {
        List<String> personagens = new ArrayList<>();
        this.personagens.forEach(personagem -> personagens.add(personagem.getNome() + ", "));
        return "JogadorModel {" +
                "\n\tid = " + id +
                ",\n\tnome = '" + nome + '\'' +
                ",\n\tsenha = '" + senha + '\'' +
                ",\n\tpersonagens = " + personagens +
                "\n}";
    }

    private void gerarId() {
        this.id = 1;
    }
}
