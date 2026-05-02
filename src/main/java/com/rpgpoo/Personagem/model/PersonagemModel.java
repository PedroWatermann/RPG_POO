package com.rpgpoo.Personagem.model;

import com.rpgpoo.Arma.model.ArmaModel;
import com.rpgpoo.Atributo.model.AtributoModel;
import com.rpgpoo.Campanha.model.CampanhaModel;
import com.rpgpoo.Classe.model.ClasseModel;
import com.rpgpoo.Dado.model.DadoModel;
import com.rpgpoo.Entidade.model.EntidadeModel;
import com.rpgpoo.Item.model.ItemModel;
import com.rpgpoo.Jogador.model.JogadorModel;
import com.rpgpoo.Raca.model.RacaModel;

import java.util.ArrayList;
import java.util.List;

public class PersonagemModel extends EntidadeModel {
    private ClasseModel classe;
    private List<ItemModel> itens;
    private JogadorModel jogador;
    private RacaModel raca;
    private double dinheiro;
    private AtributoModel atributo;
    private List<CampanhaModel> campanha;

    public ClasseModel getClasse() {
        return classe;
    }

    public void setClasse(ClasseModel classe) {
        this.classe = classe;
    }

    public List<ItemModel> getItens() {
        return itens;
    }

    public void setItens(List<ItemModel> itens) {
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

    public List<CampanhaModel> getCampanha() {
        return campanha;
    }

    public void setCampanha(List<CampanhaModel> campanha) {
        this.campanha = campanha;
    }

    public PersonagemModel(String nome, int nivel, int ataque, int vida, int defesa, ArmaModel arma, ClasseModel classe, List<ItemModel> itens, JogadorModel jogador, RacaModel raca, double dinheiro, AtributoModel atributo) {
        super(nome, nivel, ataque, vida, defesa, arma);
        this.setClasse(classe);
        this.setItens(itens);
        this.setJogador(jogador);
        this.setRaca(raca);
        this.setDinheiro(dinheiro);
        this.setAtributo(atributo);
        this.campanha = new ArrayList<CampanhaModel>();
    }

    @Override
    public int atacar() {
        return 0;
    }

    @Override
    public int defender() {
        return 0;
    }

    @Override
    public String toString() {
        return "PersonagemModel{" +
                "classe=" + classe +
                ", itens=" + itens +
                ", jogador=" + jogador +
                ", raca=" + raca +
                ", dinheiro=" + dinheiro +
                ", atributo=" + atributo +
                ", campanha=" + campanha +
                '}';
    }
}
