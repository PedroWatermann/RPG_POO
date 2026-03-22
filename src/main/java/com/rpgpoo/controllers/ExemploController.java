package com.rpgpoo.controllers;

import com.rpgpoo.models.ExemploModel;
import com.rpgpoo.repositories.ExemploRepository;
import com.rpgpoo.services.ExemploService;

public class ExemploController {
    private final ExemploService _exemploService = new ExemploService();
    private final ExemploRepository _exemploRepository = new ExemploRepository();

    public String salvarExemplo(ExemploModel exemploModel) {
        String nome = exemploModel.getNome();

        return _exemploService.validarNome(nome)
                ? _exemploRepository.create(exemploModel)
                : "Erro ao salvar: O campo { nome } não deve estar vazio!";
    }
}
