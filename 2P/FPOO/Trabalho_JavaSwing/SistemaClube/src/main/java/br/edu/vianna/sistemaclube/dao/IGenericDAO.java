package br.edu.vianna.sistemaclube.dao;

import java.sql.SQLException;
import java.util.List;

public interface IGenericDAO<T, K> {
    public void inserir(T obj) throws SQLException, ClassNotFoundException;

    public void alterar(T obj) throws SQLException, ClassNotFoundException;

    public void apagar(T obj) throws SQLException, ClassNotFoundException;

    public T buscarPorId(K id) throws SQLException, ClassNotFoundException;

    public List<T> buscarTodos() throws SQLException, ClassNotFoundException;

    public int contar() throws SQLException, ClassNotFoundException;
}
