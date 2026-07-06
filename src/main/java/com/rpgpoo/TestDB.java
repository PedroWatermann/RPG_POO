package com.rpgpoo;

import com.rpgpoo.Item.model.ItemModel;
import com.rpgpoo.Arma.model.ArmaModel;
import com.rpgpoo.utils.JpaUtil;
import jakarta.persistence.EntityManager;
import java.util.List;

public class TestDB {
    public static void main(String[] args) {
        try (EntityManager em = JpaUtil.getEntityManager()) {
            List<ItemModel> itens = em.createQuery("SELECT i FROM ItemModel i", ItemModel.class).getResultList();
            System.out.println("Itens in DB: " + itens.size());
            for (ItemModel i : itens) {
                System.out.println("- " + i.getNome() + " (Tipo: " + i.getTipoItem() + ")");
            }

            List<ArmaModel> armas = em.createQuery("SELECT a FROM ArmaModel a", ArmaModel.class).getResultList();
            System.out.println("\nArmas in DB: " + armas.size());
            for (ArmaModel a : armas) {
                System.out.println("- " + a.getNome());
            }
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            JpaUtil.close();
        }
    }
}
