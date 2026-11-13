package br.com.starlog.dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

/**
 * Centraliza a URL de conexão com o banco do almoxarifado.
 */
public class ConexaoFactory {

    private static final String URL = "jdbc:sqlite:almoxarifado.db";

    public static Connection obterConexao() throws SQLException {
        return DriverManager.getConnection(URL);
    }
}
