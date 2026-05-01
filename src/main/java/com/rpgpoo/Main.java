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

import java.util.List;

public class Main {
    public static void main(String[] args) {
        JogadorModel mestre = new JogadorModel("Lucas", "001");
        JogadorModel jogador1 = new JogadorModel("Pedro", "002");
        JogadorModel jogador2 = new JogadorModel("Raul", "003");
        JogadorModel jogador3 = new JogadorModel("Isabella", "004");
        JogadorModel jogador4 = new JogadorModel("Vinicius", "005");
        JogadorModel jogador5 = new JogadorModel("Gustavo", "006");

        AtributoModel inteligencia = new AtributoModel("Inteligência", 0, 3);
        AtributoModel destreza = new AtributoModel("Destreza", 1, 3);
        AtributoModel constituicao = new AtributoModel("Constituição", 1, 3);
        AtributoModel sabedoria = new AtributoModel("Sabedoria", 0, 3);
        AtributoModel carisma = new AtributoModel("Carisma", -1, 3);
        AtributoModel forca = new AtributoModel("Força", 2, 3);

        RacaModel humano = new RacaModel("Humano", inteligencia);
        RacaModel elfo = new RacaModel("Elfo", destreza);
        RacaModel anao = new RacaModel("Anão", constituicao);
        RacaModel halfling = new RacaModel("Halfling", sabedoria);
        RacaModel tiefling = new RacaModel("Tiefling", carisma);
        RacaModel orc = new RacaModel("Orc", forca);

        DadoModel dadoPadrao = new DadoModel(20, null);

        ArmaModel espadaCurta = new ArmaModel("Espada Curta", TipoItemEnum.ARMA, 0, RaridadeEnum.COMUM, 30.0, 6, 1, 100, dadoPadrao);
        ArmaModel bestaLeve = new ArmaModel("Besta Leve", TipoItemEnum.ARMA, 0, RaridadeEnum.INCOMUM, 45.0, 7, 15, 70, dadoPadrao);
        ArmaModel arcoLongo = new ArmaModel("Arco Longo Élfico", TipoItemEnum.ARMA, 0, RaridadeEnum.INCOMUM, 55.0, 6, 25, 85, dadoPadrao);
        ArmaModel laminaElegante = new ArmaModel("Lâmina Élfica", TipoItemEnum.ARMA, 0, RaridadeEnum.RARO, 80.0, 7, 1, 90, dadoPadrao);
        ArmaModel machadoDeGuerra = new ArmaModel("Machado de Guerra", TipoItemEnum.ARMA, 0, RaridadeEnum.INCOMUM, 50.0, 9, 1, 110, dadoPadrao);
        ArmaModel marteloPesado = new ArmaModel("Martelo Pesado", TipoItemEnum.ARMA, 0, RaridadeEnum.RARO, 75.0, 10, 1, 95, dadoPadrao);
        ArmaModel fundaPrecisa = new ArmaModel("Funda Precisa", TipoItemEnum.ARMA, 0, RaridadeEnum.COMUM, 20.0, 4, 12, 60, dadoPadrao);
        ArmaModel adagaDupla = new ArmaModel("Adagas Duplas", TipoItemEnum.ARMA, 0, RaridadeEnum.INCOMUM, 35.0, 5, 1, 75, dadoPadrao);
        ArmaModel chicoteInfernal = new ArmaModel("Chicote Infernal", TipoItemEnum.ARMA, 0, RaridadeEnum.RARO, 65.0, 6, 8, 80, dadoPadrao);
        ArmaModel espadaLongaDemoniaca = new ArmaModel("Espada Longa Demoníaca", TipoItemEnum.ARMA, 0, RaridadeEnum.EPICO, 120.0, 8, 2, 100, dadoPadrao);
        ArmaModel porreteGrosso = new ArmaModel("Porrete Grosso", TipoItemEnum.ARMA, 0, RaridadeEnum.COMUM, 0, 8, 1, 50, dadoPadrao);
        ArmaModel garraOrc = new ArmaModel("Garras do Orc", TipoItemEnum.ARMA, 0, RaridadeEnum.INCOMUM, 0, 7, 1, 999, dadoPadrao);

        ClasseModel guerreiro = new ClasseModel("Guerreiro", TipoArmaEnum.ESPADA, 2, 2);
        ClasseModel barbaro = new ClasseModel("Bárbaro", TipoArmaEnum.MACHADO, 3, 1);
        ClasseModel arqueiro = new ClasseModel("Arqueiro", TipoArmaEnum.ARCO, 2, 1);
        ClasseModel ladino = new ClasseModel("Ladino", TipoArmaEnum.ADAGA, 2, 1);
        ClasseModel mago = new ClasseModel("Mago", TipoArmaEnum.CAJADO, 3, 0);
        ClasseModel clerigo = new ClasseModel("Clérigo", TipoArmaEnum.MARTELO, 1, 2);
        ClasseModel paladino = new ClasseModel("Paladino", TipoArmaEnum.ESPADA, 2, 2);

        ItemModel pocaoCuraPequena = new ItemModel("Poção de Cura Pequena", TipoItemEnum.POCAO, 15.0, RaridadeEnum.COMUM, 20.0);
        ItemModel pocaoCuraMedia = new ItemModel("Poção de Cura Média", TipoItemEnum.POCAO, 30.0, RaridadeEnum.INCOMUM, 50.0);
        ItemModel pocaoForca = new ItemModel("Poção de Força", TipoItemEnum.POCAO, 5.0, RaridadeEnum.INCOMUM, 45.0);
        ItemModel pocaoDestreza = new ItemModel("Poção de Destreza", TipoItemEnum.POCAO, 5.0, RaridadeEnum.INCOMUM, 45.0);
        ItemModel armaduraCouro = new ItemModel("Armadura de Couro", TipoItemEnum.ARMADURA, 3.0, RaridadeEnum.COMUM, 60.0);
        ItemModel cotaDeMalha = new ItemModel("Cota de Malha", TipoItemEnum.ARMADURA, 6.0, RaridadeEnum.INCOMUM, 150.0);
        ItemModel armaduraPlacas = new ItemModel("Armadura de Placas", TipoItemEnum.ARMADURA, 10.0, RaridadeEnum.RARO, 350.0);
        ItemModel amuletoProtecao = new ItemModel("Amuleto da Proteção", TipoItemEnum.AMULETO, 2.0, RaridadeEnum.INCOMUM, 80.0);
        ItemModel anelForca = new ItemModel("Anel da Força", TipoItemEnum.ANEL, 3.0, RaridadeEnum.RARO, 120.0);
        ItemModel botasVelocidade = new ItemModel("Botas da Velocidade", TipoItemEnum.BOTAS, 2.0, RaridadeEnum.INCOMUM, 95.0);
        ItemModel tocha = new ItemModel("Tocha", TipoItemEnum.FERRAMENTA, 0, RaridadeEnum.COMUM, 2.0);
        ItemModel corda = new ItemModel("Corda (15 metros)", TipoItemEnum.FERRAMENTA, 0, RaridadeEnum.COMUM, 10.0);
        ItemModel kitMedico = new ItemModel("Kit de Primeiros Socorros", TipoItemEnum.FERRAMENTA, 10.0, RaridadeEnum.COMUM, 25.0);
        ItemModel anelOuro = new ItemModel("Anel de Ouro", TipoItemEnum.JOIA, 0, RaridadeEnum.COMUM, 75.0);
        ItemModel colarRubi = new ItemModel("Colar de Prata com Rubi", TipoItemEnum.JOIA, 0, RaridadeEnum.RARO, 250.0);
        ItemModel sacoMoedas = new ItemModel("Saco de Moedas de Prata", TipoItemEnum.TESOURO, 0, RaridadeEnum.COMUM, 150.0);
        ItemModel pergaminhoFogo = new ItemModel("Pergaminho de Bola de Fogo", TipoItemEnum.PERGAMINHO, 40.0, RaridadeEnum.RARO, 120.0);
        ItemModel cristalMagico = new ItemModel("Cristal Mágico", TipoItemEnum.ITEM_QUEST, 25.0, RaridadeEnum.EPICO, 0.0);
        ItemModel livroFeiticos = new ItemModel("Livro de Feitiços Antigo", TipoItemEnum.LIVRO, 0, RaridadeEnum.INCOMUM, 90.0);
        ItemModel elixirVida = new ItemModel("Elixir da Vida", TipoItemEnum.BEBIDA, 50.0, RaridadeEnum.MUITO_RARO, 300.0);

        List<ItemModel> lootOrc = List.of(pocaoCuraPequena, anelOuro, tocha, sacoMoedas);
        MonstroModel orcGuerreiro = new MonstroModel("Orc Guerreiro", 3, 12, 45, 6, porreteGrosso, lootOrc);

        List<ItemModel> itensThorin = List.of(armaduraCouro, pocaoCuraPequena);
        List<ItemModel> itensElira  = List.of(arcoLongo, pocaoDestreza);
        List<ItemModel> itensFinn   = List.of(adagaDupla, kitMedico);
        List<ItemModel> itensZarael = List.of(laminaElegante, pergaminhoFogo);
        List<ItemModel> itensGrom   = List.of(machadoDeGuerra, pocaoForca);
        PersonagemModel thorin = new PersonagemModel("Thorin, o Forte", 3, 14, 50, 8, espadaCurta, guerreiro, itensThorin, jogador1, humano, 85.0, forca);
        PersonagemModel elira = new PersonagemModel("Elira Lança-Prata", 3, 12, 40, 5, arcoLongo, arqueiro, itensElira, jogador2, elfo, 120.0, destreza);
        PersonagemModel finn = new PersonagemModel("Finn Pé-Leve", 2, 11, 35, 4, adagaDupla, ladino, itensFinn, jogador3, halfling, 65.0, destreza);
        PersonagemModel zarael = new PersonagemModel("Zarael Chifre Negro", 4, 10, 32, 3, laminaElegante, mago, itensZarael, jogador4, tiefling, 95.0, inteligencia);
        PersonagemModel grom = new PersonagemModel("Grom Barba de Ferro",  4, 16, 60, 9, machadoDeGuerra, barbaro, itensGrom, jogador5, anao, 45.0, forca);
        jogador1.setPersonagem(thorin);
        jogador2.setPersonagem(elira);
        jogador3.setPersonagem(finn);
        jogador4.setPersonagem(zarael);
        jogador5.setPersonagem(grom);

        List<PersonagemModel> personagens = List.of(thorin, elira, finn, zarael, grom);
        List<JogadorModel> jogadores = List.of(jogador1, jogador2, jogador3, jogador4, jogador5);
        CampanhaModel campanha = new CampanhaModel("D&D", "Dungeons and Dragons", personagens, jogadores, dadoPadrao, mestre);

        thorin.setCampanha(campanha);
        elira.setCampanha(campanha);
        finn.setCampanha(campanha);
        zarael.setCampanha(campanha);
        grom.setCampanha(campanha);
    }
}
