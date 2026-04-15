package com.rpgpoo.Classe.model;

import com.rpgpoo.Enum.TipoArmaEnum;

public class ClasseModel {
    private int id;
    private String nome;
    private TipoArmaEnum tipoArma;
    private int multiplicadorDano;
    private int multiplicadorDefesa;

    public int getId() {
        return this.id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getNome() {
        return this.nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public TipoArmaEnum getTipoArma() {
        return this.tipoArma;
    }

    public void setTipoArma(TipoArmaEnum tipoArma) {
        this.tipoArma = tipoArma;
    }

    public int getMultiplicadorDano() {
        return this.multiplicadorDano;
    }

    public void setMultiplicadorDano(int multiplicador) {
        this.multiplicadorDano = multiplicador;
    }

    public int getMultiplicadorDefesa() {
        return this.multiplicadorDefesa;
    }

    public void setMultiplicadorDefesa(int multiplicador) {
        this.multiplicadorDefesa = multiplicador;
    }
}
