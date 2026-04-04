package com.rpgpoo.repositories;

import com.rpgpoo.database.DataBaseConnection;
import com.rpgpoo.models.ExemploModel;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

public class ExemploRepository {
    public String create(ExemploModel exemploModel) {
        System.out.println("Salvando Exemplo: " + exemploModel.toString());

        String sql = "INSERT INTO tbExemplos (nome) VALUES (?)";

        try (Connection conn = DataBaseConnection.getConnection(); PreparedStatement stmt = conn.prepareStatement(sql)) {
            stmt.setString(1, exemploModel.getNome());
            stmt.executeUpdate();

            return exemploModel.getNome();
        } catch (SQLException e) {
            return "Erro ao salvar no banco: " + e.getMessage();
        }
    }
}
