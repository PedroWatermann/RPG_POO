package com.rpgpoo.Monstro.model;

import com.rpgpoo.Arma.model.ArmaModel;
import com.rpgpoo.Entidade.model.EntidadeModel;
import com.rpgpoo.Item.model.ItemModel;
import com.rpgpoo.Raca.model.RacaModel;
import jakarta.persistence.*;

import java.util.List;

@Entity
@Table(name = "monstro")
public class MonstroModel extends EntidadeModel {
    @ManyToMany
    @JoinTable(
            name = "monstro_loot",
            joinColumns = @JoinColumn(name = "monstro_id"),
            inverseJoinColumns = @JoinColumn(name = "item_id")
    )
    private List<ItemModel> loot;

    @ManyToOne
    @JoinColumn(name = "raca_id")
    private RacaModel raca;

    //region Getters e Setters
    public List<ItemModel> getLoot() {
        return this.loot;
    }

    public void setLoot(List<ItemModel> loot) {
        if (loot != null && !loot.isEmpty())
            this.loot = loot;
    }

    public void setLoot(ItemModel itemLoot) {
        if (this.loot != null)
            this.loot.add(itemLoot);
    }

    public RacaModel getRaca() {
        return raca;
    }

    public void setRaca(RacaModel raca) {
        this.raca = raca;
    }
    //endregion

    //Construtor
    protected MonstroModel() {}

    public MonstroModel(String nome, int nivel, int ataque, int vida, int defesa, ArmaModel arma, List<ItemModel> loot, RacaModel raca, int dt) {
        super(nome, nivel, ataque, vida, defesa, arma, dt);
        this.loot = loot;
        this.raca = raca;
    }

    @Override
    public int atacar(int dtAlvo) {
        int sorte = this.getCampanhaAtual() != null ? this.getCampanhaAtual().getDado().rolarDado() : -1;
        if (sorte > dtAlvo)
            return this.getAtaque();
        return 0;
    }

    @Override
    public void defender(int danoRecebido) {
        int reducao = this.getDefesa();
        int danoFinal = Math.max(danoRecebido - reducao, 0);
        this.setVida(this.getVida() - danoFinal);
    }
}
