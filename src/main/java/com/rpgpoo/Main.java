package com.rpgpoo;

import com.rpgpoo.Arma.model.ArmaModel;
import com.rpgpoo.Atributo.model.AtributoModel;
import com.rpgpoo.Campanha.model.CampanhaModel;
import com.rpgpoo.Classe.model.ClasseModel;
import com.rpgpoo.Dado.model.DadoModel;
import com.rpgpoo.Enum.RaridadeEnum;
import com.rpgpoo.Enum.TipoArmaEnum;
import com.rpgpoo.Enum.TipoItemEnum;
import com.rpgpoo.Item.model.ItemModel;
import com.rpgpoo.Jogador.model.JogadorModel;
import com.rpgpoo.Monstro.model.MonstroModel;
import com.rpgpoo.Personagem.model.PersonagemModel;
import com.rpgpoo.Raca.model.RacaModel;

import java.util.ArrayList;
import java.util.List;

public class Main {
    public static void main(String[] args) {
        JogadorModel jogador = new JogadorModel("Pedro", "001");
        System.out.println();
        System.out.println(jogador.toString());

        AtributoModel atributo = new AtributoModel("Força", 10, 2);
        System.out.println(atributo.toString());
        System.out.println();

        RacaModel raca = new RacaModel("Fada", atributo);
        System.out.println(raca.toString());
        System.out.println();

        DadoModel dado = new DadoModel(10, atributo);
        System.out.println(dado.toString());
        System.out.println();

        TipoItemEnum tipoItem = TipoItemEnum.TIPO_1;
        RaridadeEnum raridade = RaridadeEnum.TESTE;
        ArmaModel arma = new ArmaModel("Espadão", tipoItem, 0.3, raridade, 1350.44, 130, 50, 350, dado);
        System.out.println(arma.toString());
        System.out.println();

        TipoArmaEnum tipoArma = TipoArmaEnum.MEDIA_DISTANCIA;
        ClasseModel classe = new ClasseModel("Guerreiro", tipoArma, 2, 3);
        System.out.println(classe.toString());
        System.out.println();

        ItemModel item = new ItemModel("Poção", tipoItem, 0.5, raridade, 1500.99);
        System.out.println(item.toString());
        System.out.println();

        List<ItemModel> itens = new ArrayList<>();
        itens.add(item);
        MonstroModel monstro = new MonstroModel("Boomer", 3, 4, 460, 100, arma, itens);
        System.out.println(monstro.toString());
        System.out.println();

        PersonagemModel personagem = new PersonagemModel("É o Braia", 150, 120, 300, 190, arma, classe, itens, jogador, raca, 5000.00, atributo);
        System.out.println(personagem.toString());
        System.out.println();

        List<PersonagemModel> personagens = new ArrayList<>();
        personagens.add(personagem);
        List<JogadorModel> jogadores = new ArrayList<>();
        jogadores.add(jogador);
        CampanhaModel campanha = new CampanhaModel("D&D", "Dungeons and Dragons", personagens, jogadores, dado, jogador);
        System.out.println(campanha.toString());
    }
}
