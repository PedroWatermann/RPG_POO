package com.rpgpoo.Dado.model;

import com.rpgpoo.Atributo.model.AtributoModel;
import jakarta.persistence.*;

@Entity
@Table(name = "dado")
public class DadoModel {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    @Column(nullable = false)
    private int lados;

    @ManyToOne
    @JoinColumn(name = "atributo_id")
    private AtributoModel atributo;

    protected DadoModel() {}

    public DadoModel(int lados, AtributoModel atributo) {
        this.setLados(lados);
        this.setAtributo(atributo);
    }

    //region Getters e Setters
    public int getId() { return id; }

    public int getLados() { return lados; }
    public void setLados(int lados) {
        if (lados > 0) {
            this.lados = lados;
        }
    }

    public AtributoModel getAtributo() { return atributo; }
    public void setAtributo(AtributoModel atributo) { this.atributo = atributo; }
    //endregion

    public int rolarDado() {
        return (int) (Math.random() * this.getLados()) + 1;
    }
}