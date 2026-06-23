package com.rpgpoo;

import com.rpgpoo.Atributo.model.AtributoModel;
import com.rpgpoo.Gerenciador.Gerenciador;
import com.rpgpoo.Jogador.model.JogadorModel;
import com.rpgpoo.Monstro.model.MonstroModel;
import com.rpgpoo.Personagem.model.PersonagemModel;
import com.rpgpoo.utils.JpaUtil;
import jakarta.persistence.EntityManager;

import java.util.logging.Level;
import java.util.logging.Logger;

public class Main {
    static void main() {
        try (EntityManager em = JpaUtil.getEntityManager()) {
            em.getTransaction().begin();

            JogadorModel jogador = new JogadorModel("Barela", "senha123");
            AtributoModel atributoForca = new AtributoModel("Força", 4);

            PersonagemModel personagem = new PersonagemModel(
                    "Thorin, o Forte", 1, 10, 100, 5,
                    null, null, null, jogador, null, 50.0, atributoForca, 12
            );

            jogador.adicionarPersonagem(personagem); // sincroniza os dois lados

            em.persist(jogador);        // cascateia e persiste o personagem junto
            em.persist(atributoForca);  // esse precisa ser persistido manualmente (não tem cascade vindo de ninguém)

            MonstroModel goblin = new MonstroModel("Goblin Saqueador", 1, 3, 7, 12, null, null, null, 10);
            em.persist(goblin);

            em.getTransaction().commit();
        } catch (Exception ex) {
            Logger.getLogger(Main.class.getName()).log(Level.SEVERE, ex.getMessage(), ex);
        } finally {
            new Gerenciador();
        }
    }
}
