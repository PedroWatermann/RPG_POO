package com.rpgpoo.services;

public class ExemploService {
    public boolean validarNome(String nome) {
        return !(nome == null || nome.trim().isEmpty());
    }
}
