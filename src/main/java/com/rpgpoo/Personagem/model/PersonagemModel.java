package com.rpgpoo.Personagem.model;

import com.rpgpoo.Campanha.model.CampanhaModel;
import com.rpgpoo.Classe.model.ClasseModel;
import com.rpgpoo.Item.model.ItemModel;
import com.rpgpoo.Jogador.model.JogadorModel;

import java.util.ArrayList;

public class PersonagemModel {
    private ClasseModel classe;
    private ArrayList<ItemModel> itens;
    private JogadorModel jogador;
    private RacaModel raca;
    private double dinheiro;
    private AtributoModel atributo;
    private CampanhaModel campanha;

    public ClasseModel getClasse() {
        return classe;
    }

    public void setClasse(ClasseModel classe) {
        this.classe = classe;
    }

    public ArrayList<ItemModel> getItens() {
        return itens;
    }

    public void setItens(ArrayList<ItemModel> itens) {
        this.itens = itens;
    }

    public JogadorModel getJogador() {
        return jogador;
    }

    public void setJogador(JogadorModel jogador) {
        this.jogador = jogador;
    }

    public RacaModel getRaca() {
        return raca;
    }

    public void setRaca(RacaModel raca) {
        this.raca = raca;
    }

    public double getDinheiro() {
        return dinheiro;
    }

    public void setDinheiro(double dinheiro) {
        this.dinheiro = dinheiro;
    }

    public AtributoModel getAtributo() {
        return atributo;
    }

    public void setAtributo(AtributoModel atributo) {
        this.atributo = atributo;
    }

    public CampanhaModel getCampanha() {
        return campanha;
    }

    public void setCampanha(CampanhaModel campanha) {
        this.campanha = campanha;
    }
}
