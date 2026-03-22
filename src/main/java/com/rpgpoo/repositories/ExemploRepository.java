package com.rpgpoo.repositories;

import com.rpgpoo.models.ExemploModel;

public class ExemploRepository {
    public String create(ExemploModel exemploModel) {
        System.out.println("Salvando Exemplo: " + exemploModel.toString());
        return exemploModel.getNome();
    }
}
