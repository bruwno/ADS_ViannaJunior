package br.edu.vianna.sistemaclube.dao.dbconnection;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class ConnectionFactory {
    public static final String URL = "jdbc:mysql://localhost:3306/clube";
    public static final String USER = "aluno";
    public static final String PASSWORD = "aluno";

    public static Connection getConnection() throws ClassNotFoundException, SQLException {
        try {
            Class.forName("com.mysql.cj.jdbc.Driver");
            return DriverManager.getConnection(URL, USER, PASSWORD);
        } catch (ClassNotFoundException e) {
            System.out.println("Driver não encontrado, contate o suporte!");
        } catch (SQLException e) {
            System.out.println("Falha ao tentar conectar à base de dados, contate o suporte!");
        }

        return null;
    }
}
