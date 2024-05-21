package br.edu.vianna.escola.dao;

import java.sql.SQLException;
import java.util.List;

/**
 *
 * @author William
 */
public interface GenericsDAO<C, K> {
    public void inserir(C obj) throws SQLException, ClassNotFoundException;

    public void alterar(C obj) throws SQLException, ClassNotFoundException;

    public void apagar(C obj) throws SQLException, ClassNotFoundException;

    public C buscarUm(K id) throws SQLException, ClassNotFoundException;

    public List<C> buscarTodos() throws SQLException, ClassNotFoundException;

    public int count() throws SQLException, ClassNotFoundException;
}
