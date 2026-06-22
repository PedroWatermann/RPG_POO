package com.rpgpoo.Jogador.model;

import com.rpgpoo.Personagem.model.PersonagemModel;
import jakarta.persistence.*;

import java.util.ArrayList;
import java.util.List;

@Entity
@Table(name = "jogador")
public class JogadorModel {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    @Column(nullable = false, unique = true)
    private String nome;

    @Column(nullable = false)
    private String senha;

    @OneToMany(mappedBy = "jogador", cascade = CascadeType.ALL)
    private List<PersonagemModel> personagens = new ArrayList<>();

    //region Getters e Setters
    public int  getId() {
        return id;
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

    public void adicionarPersonagem(PersonagemModel personagem) {
        if (personagem != null) {
            personagens.add(personagem);
            personagem.setJogador(this);
        }
    }
    //endregion

    protected JogadorModel() {}

    public JogadorModel(String nome, String senha) {
        this.setNome(nome);
        this.setSenha(senha);
        this.personagens = new ArrayList<>();
    }
}
