package br.edu.vianna.escola.dao.impl;

import br.edu.vianna.escola.dao.GenericsDAO;
import br.edu.vianna.escola.dao.connection.ConnectionFactory;
import br.edu.vianna.model.Professor;
import br.edu.vianna.model.escola.Disciplina;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class DisciplinaDAO implements GenericsDAO<Disciplina, Integer> {
    private Connection c;

    @Override
    public void inserir(Disciplina disciplina) throws SQLException, ClassNotFoundException {
        c = ConnectionFactory.getConnection();
        String sql = "INSERT INTO fpoo.disciplina\n" +
                "(nome, carga_horaria, ano, semestre, id_professor)\n" +
                "VALUES(?, ?, ?, ?, ?);";

        PreparedStatement pst = c.prepareStatement(sql);
        pst.setString(1, disciplina.getNome());
        pst.setInt(2, disciplina.getCargaHoraria());
        pst.setInt(3, disciplina.getAno());
        pst.setInt(4, disciplina.getSemestre());
        pst.setInt(5, disciplina.getProfessor().getId());

        pst.execute();
    }

    @Override
    public void alterar(Disciplina disciplina) throws SQLException, ClassNotFoundException {
        c = ConnectionFactory.getConnection();
        String sql = "UPDATE fpoo.disciplina\n" +
                "SET nome=?, carga_horaria=?, ano=?, semestre=?, id_professor=?\n" +
                "WHERE iddisciplina=?;";

        PreparedStatement pst = c.prepareStatement(sql);
        pst.setString(1, disciplina.getNome());
        pst.setInt(2, disciplina.getCargaHoraria());
        pst.setInt(3, disciplina.getAno());
        pst.setInt(4, disciplina.getSemestre());
        pst.setInt(5, disciplina.getProfessor().getId());
        pst.setInt(6, disciplina.getId());

        pst.execute();
    }

    @Override
    public void apagar(Disciplina disciplina) throws SQLException, ClassNotFoundException {
        c = ConnectionFactory.getConnection();
        String sql = "DELETE FROM fpoo.disciplina\n" +
                "WHERE iddisciplina=?;";

        PreparedStatement pst = c.prepareStatement(sql);
        pst.setInt(1, disciplina.getId());

        pst.execute();
    }

    public Disciplina buscarUm(Integer id) throws SQLException, ClassNotFoundException {
        c = ConnectionFactory.getConnection();
        String sql = "SELECT iddisciplina, nome, carga_horaria, ano, semestre, id_professor\n" +
                "FROM fpoo.disciplina\n" +
                "WHERE iddisciplina=?";

        PreparedStatement pst = c.prepareStatement(sql);
        pst.setInt(1, id);

        ResultSet rs = pst.executeQuery();

        Disciplina d = null;
        if (rs.next()) {
            d = new Disciplina();
            d.setId(rs.getInt("iddisciplina"));
            d.setNome(rs.getString("nome"));
            d.setCargaHoraria(rs.getInt("carga_horaria"));
            d.setAno(rs.getInt("ano"));
            d.setSemestre(rs.getInt("semestre"));
            Professor p = new ProfessorDAO().buscarUm(rs.getInt("id_professor"));
            d.setProfessor(p);
        }

        return d;
    }

    @Override
    public List<Disciplina> buscarTodos() throws SQLException, ClassNotFoundException {
        c = ConnectionFactory.getConnection();
        String sql = "SELECT iddisciplina, nome, carga_horaria, ano, semestre, id_professor\n" +
                "FROM fpoo.disciplina";

        PreparedStatement pst = c.prepareStatement(sql);
        ResultSet rs = pst.executeQuery();

        List<Disciplina> listaDisciplinas = new ArrayList<>();
        while (rs.next()) {
            Disciplina d = new Disciplina(
                    rs.getInt("iddisciplina"),
                    rs.getString("nome"),
                    rs.getInt("carga_horaria"),
                    rs.getInt("ano"),
                    rs.getInt("semestre"),
                    new ProfessorDAO().buscarUm(rs.getInt("id_professor")));
            listaDisciplinas.add(d);
        }

        return listaDisciplinas;
    }

    @Override
    public int count() throws SQLException, ClassNotFoundException {
        c = ConnectionFactory.getConnection();
        String sql = "SELECT COUNT(*) qtde\n" +
                "FROM fpoo.disciplina;";

        PreparedStatement pst = c.prepareStatement(sql);
        ResultSet rs = pst.executeQuery();
        rs.next();

        return rs.getInt("qtde");
    }
}