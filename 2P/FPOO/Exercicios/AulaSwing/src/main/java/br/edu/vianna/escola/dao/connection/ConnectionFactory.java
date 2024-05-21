package br.edu.vianna.escola.dao.connection;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

/**
 *
 * @author William
 */
public class ConnectionFactory {
    public static final String URL = "jdbc:mysql://localhost:3306/fpoo";
    public static final String USER = "aluno";
    public static final String PASSWORD = "aluno";
    
        public static Connection getConnection() throws ClassNotFoundException, SQLException {
        try {
            Class.forName("com.mysql.cj.jdbc.Driver");

            return DriverManager.getConnection(URL,USER,PASSWORD);

        } catch (SQLException | ClassNotFoundException e) {
            System.out.println("Driver não encontrado, contate o suporte!");
        }

        return null;
    }

    public static void main(String[] args) {
        try {
            Connection c = getConnection();
            System.out.println("Conectado com sucesso.");
        } catch (ClassNotFoundException | SQLException e) {
            System.out.println("Ocorreu um erro!");
        }
    }
}
