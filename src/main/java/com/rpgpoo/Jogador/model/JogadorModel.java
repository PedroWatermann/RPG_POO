package com.rpgpoo.Jogador.model;

public class JogadorModel {
    private int id;
    private String nome;
    private String senha;

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

    public JogadorModel(String nome, String senha) {
        gerarId();
        this.setNome(nome);
        this.setSenha(senha);
    }

    public JogadorModel() {

    }

    private void gerarId() {
        this.id = 1;
    }

    @Override
    public String toString() {
        return "JogadorModel{" +
                "id=" + id +
                ", nome='" + nome + '\'' +
                ", senha='" + senha + '\'' +
                '}';
    }
}
