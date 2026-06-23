package com.rpgpoo.Entidade.model;

import com.rpgpoo.Arma.model.ArmaModel;
import com.rpgpoo.Campanha.model.CampanhaModel;
import jakarta.persistence.*;

import java.util.ArrayList;
import java.util.List;

@Entity
@Inheritance(strategy = InheritanceType.JOINED)
@Table(name = "entidade")
public abstract class EntidadeModel {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    @Column(nullable = false)
    private String nome;

    @Column(nullable = false)
    private int nivel;

    @Column(nullable = false)
    private int ataque;

    @Column(nullable = false)
    private int vida;

    @Column(nullable = false)
    private int defesa;

    @Column(nullable = false)
    private int dt;

    @ManyToOne
    @JoinColumn(name = "arma_id")
    private ArmaModel arma;

    // Deixar transiente para não gerar inconsistência nos dados. Validar se é possível remover
    @Transient
    private List<CampanhaModel> campanhas;

    @ManyToOne
    @JoinColumn(name = "campanha_atual_id")
    private CampanhaModel campanhaAtual;

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

    public int getNivel() {
        return nivel;
    }

    public void setNivel(int nivel) {
        if (nivel < 0) throw new IllegalArgumentException("Nível não pode ser negativo");
        this.nivel = nivel;
    }

    public int getAtaque() {
        return ataque;
    }

    public void setAtaque(int ataque) {
        if (ataque < 0) throw new IllegalArgumentException("Ataque não pode ser negativo");
        this.ataque = ataque;
    }

    public int getVida() {
        return vida;
    }

    public void setVida(int vida) {
        if (vida < 0) throw new IllegalArgumentException("Vida não pode ser negativa");
        this.vida = vida;
    }

    public int getDefesa() {
        return defesa;
    }

    public void setDefesa(int defesa) {
        if (defesa < 0) throw new IllegalArgumentException("Defesa não pode ser negativa");
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
        if (dt < 0) throw new IllegalArgumentException("DT não pode ser negativo");
        this.dt = dt;
    }
    //endregion

    //Construtor
    protected EntidadeModel() {}

    public EntidadeModel(String nome, int nivel, int ataque, int vida, int defesa, ArmaModel arma, int dt) {
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
}
