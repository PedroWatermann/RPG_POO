package com.rpgpoo;

import com.rpgpoo.Atributo.model.AtributoModel;
import com.rpgpoo.Gerenciador.Gerenciador;
import com.rpgpoo.Jogador.model.JogadorModel;
import com.rpgpoo.Monstro.model.MonstroModel;
import com.rpgpoo.Personagem.model.PersonagemModel;
import com.rpgpoo.utils.JpaUtil;
import jakarta.persistence.EntityManager;

public class Main {
    static void main() {
        EntityManager em = JpaUtil.getEntityManager();
        em.getTransaction().begin();

        JogadorModel jogador = new JogadorModel("Barela", "senha123");
        em.persist(jogador);

        AtributoModel atributoForca = new AtributoModel("Força", 4);
        em.persist(atributoForca);

        PersonagemModel personagem = new PersonagemModel(
                "Thorin, o Forte", 1, 10, 100, 5,
                null, null, null, jogador, null, 50.0, atributoForca, 12
        );
        em.persist(personagem);

        MonstroModel goblin = new MonstroModel("Goblin Saqueador", 1, 3, 7, 12, null, null, null, 10);
        em.persist(goblin);

        em.getTransaction().commit();
        em.close();

        // new Gerenciador();
    }
}
