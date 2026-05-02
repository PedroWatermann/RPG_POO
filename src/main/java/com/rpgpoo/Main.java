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

        AtributoModel atributo = new AtributoModel("Força", 10, 2);

        RacaModel raca = new RacaModel("Fada", atributo);

        DadoModel dado = new DadoModel(10, atributo);

        TipoItemEnum tipoItem = TipoItemEnum.TIPO_1;
        RaridadeEnum raridade = RaridadeEnum.TESTE;
        ArmaModel arma = new ArmaModel("Espadão", tipoItem, 0.3, raridade, 1350.44, 130, 50, 350, dado);

        TipoArmaEnum tipoArma = TipoArmaEnum.MEDIA_DISTANCIA;
        ClasseModel classe = new ClasseModel("Guerreiro", tipoArma, 2, 3);

        ItemModel item = new ItemModel("Poção", tipoItem, 0.5, raridade, 1500.99);

        List<ItemModel> itens = new ArrayList<>();
        itens.add(item);
        MonstroModel monstro = new MonstroModel("Boomer", 3, 4, 460, 100, arma, itens);

        PersonagemModel personagem = new PersonagemModel("É o Braia", 150, 120, 300, 190, arma, classe, itens, jogador, raca, 5000.00, atributo);
        jogador.setJogador(personagem);

        List<PersonagemModel> personagens = new ArrayList<>();
        personagens.add(personagem);
        List<JogadorModel> jogadores = new ArrayList<>();
        jogadores.add(jogador);
        CampanhaModel campanha = new CampanhaModel("D&D", "Dungeons and Dragons", personagens, jogadores, dado, jogador);

        personagem.setCampanha(campanha);

        System.out.println(jogador.toString() + "\n");
        System.out.println(atributo.toString() + "\n");
        System.out.println(raca.toString() + "\n");
        System.out.println(dado.toString() + "\n");
        System.out.println(arma.toString() + "\n");
        System.out.println(classe.toString() + "\n");
        System.out.println(item.toString() + "\n");
        System.out.println(monstro.toString() + "\n");
        System.out.println(personagem.toString() + "\n");
        System.out.println(campanha.toString() + "\n");
    }
}
