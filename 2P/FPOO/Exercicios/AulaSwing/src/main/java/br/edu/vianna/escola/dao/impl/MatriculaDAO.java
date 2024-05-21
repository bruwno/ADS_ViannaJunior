package br.edu.vianna.escola.dao.impl;

import br.edu.vianna.escola.dao.GenericsDAO;
import br.edu.vianna.escola.dao.connection.ConnectionFactory;
import br.edu.vianna.model.Aluno;
import br.edu.vianna.model.escola.Disciplina;
import br.edu.vianna.model.escola.Matricula;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class MatriculaDAO implements GenericsDAO<Matricula, Integer> {
    private Connection c;

    @Override
    public void inserir(Matricula matricula) throws SQLException, ClassNotFoundException {
        c = ConnectionFactory.getConnection();
        String sql = "INSERT INTO fpoo.matricula\n" +
                "(id_aluno, id_disciplina, nota, numeroFaltas)\n" +
                "VALUES(?, ?, ?, ?);";

        PreparedStatement pst = c.prepareStatement(sql);
        pst.setInt(1, matricula.getAluno().getId());
        pst.setInt(2, matricula.getDisciplina().getId());
        pst.setDouble(3, matricula.getNota());
        pst.setInt(4, matricula.getNumeroFaltas());

        pst.execute();
    }

    @Override
    public void alterar(Matricula matricula) throws SQLException, ClassNotFoundException {
        c = ConnectionFactory.getConnection();
        String sql = "UPDATE fpoo.matricula\n" +
                "SET nota=?, numeroFaltas=?\n" +
                "WHERE id_aluno=? AND id_disciplina=?;";

        PreparedStatement pst = c.prepareStatement(sql);
        pst.setDouble(1, matricula.getNota());
        pst.setInt(2, matricula.getNumeroFaltas());
        pst.setInt(3, matricula.getAluno().getId());
        pst.setInt(4, matricula.getDisciplina().getId());

        pst.execute();
    }

    @Override
    public void apagar(Matricula matricula) throws SQLException, ClassNotFoundException {
        c = ConnectionFactory.getConnection();
        String sql = "DELETE FROM fpoo.matricula\n" +
                "WHERE id_aluno=? AND id_disciplina=?;";

        PreparedStatement pst = c.prepareStatement(sql);
        pst.setInt(1, matricula.getAluno().getId());
        pst.setInt(2, matricula.getDisciplina().getId());

        pst.execute();
    }

    @Override
    public Matricula buscarUm(Integer id) throws SQLException, ClassNotFoundException {
        c = ConnectionFactory.getConnection();
        String sql = "SELECT id_aluno, id_disciplina, nota, numeroFaltas\n" +
                "FROM fpoo.matricula\n" +
                "WHERE id_aluno=?;";

        PreparedStatement pst = c.prepareStatement(sql);
        pst.setInt(1, id);

        ResultSet rs = pst.executeQuery();

        Matricula m = null;
        if (rs.next()) {
            m = new Matricula();
            Aluno a = new AlunoDAO().buscarUm(rs.getInt("idaluno"));
            m.setAluno(a);
            Disciplina d = new DisciplinaDAO().buscarUm(rs.getInt("iddisciplina"));
            m.setDisciplina(d);
            m.setNota(rs.getDouble("nota"));
            m.setNumeroFaltas(rs.getInt("numeroFaltas"));
        }

        return m;
    }

    @Override
    public List<Matricula> buscarTodos() throws SQLException, ClassNotFoundException {
        c = ConnectionFactory.getConnection();
        String sql = "SELECT id_aluno, id_disciplina, nota, numeroFaltas\n" +
                "FROM fpoo.matricula;";

        PreparedStatement pst = c.prepareStatement(sql);
        ResultSet rs = pst.executeQuery();

        List<Matricula> listaMatriculas = new ArrayList<>();
        while (rs.next()) {
            Matricula m = new Matricula(
                    new AlunoDAO().buscarUm(rs.getInt("idaluno")),
                    new DisciplinaDAO().buscarUm(rs.getInt("iddisciplina")),
                    rs.getDouble("nota"),
                    rs.getInt("numeroFaltas"));
            listaMatriculas.add(m);
        }

        return listaMatriculas;
    }

    @Override
    public int count() throws SQLException, ClassNotFoundException {
        c = ConnectionFactory.getConnection();
        String sql = "SELECT COUNT(*) qtde\n" +
                "FROM fpoo.matricula;";

        PreparedStatement pst = c.prepareStatement(sql);
        ResultSet rs = pst.executeQuery();
        rs.next();

        return rs.getInt("qtde");
    }
}