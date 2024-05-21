package br.edu.vianna.escola.dao.impl;

import br.edu.vianna.escola.dao.GenericsDAO;
import br.edu.vianna.escola.dao.connection.ConnectionFactory;
import br.edu.vianna.model.Aluno;
import br.edu.vianna.utils.CryptoUtils;
import java.security.NoSuchAlgorithmException;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author William
 */
public class AlunoDAO implements GenericsDAO<Aluno, Integer> {
    private Connection c;

    @Override
    public void inserir(Aluno aluno) throws SQLException, ClassNotFoundException {
        // 4 passos
        // CONECTAR
        c = ConnectionFactory.getConnection();
        // COMANDO SQL
        String sql = "INSERT INTO fpoo.aluno (nome, email, login, senha, matricula, valor_mensalidade) " +
                "VALUES(?, ?, ?, ?, ?, ?);";
        // PREPARAR A EXECUÇÃO
        PreparedStatement pst = c.prepareStatement(sql);
        pst.setString(1, aluno.getNome());
        pst.setString(2, aluno.getEmail());
        pst.setString(3, aluno.getLogin());
        try {
            pst.setString(4, CryptoUtils.md5(aluno.getSenha()));
        } catch (NoSuchAlgorithmException e) {
            throw new SQLException("erro ao gerar a senha");
        }
        pst.setString(5, aluno.getMatricula());
        pst.setDouble(6, aluno.getValorMensalidade());
        // EXECUÇÃO
        pst.execute();
    }

    @Override
    public void alterar(Aluno aluno) throws SQLException, ClassNotFoundException {
        // 4 passos
        // CONECTAR
        c = ConnectionFactory.getConnection();
        // COMANDO SQL
        String sql = "UPDATE fpoo.aluno " +
                "SET nome=?, email=?, login=?, senha=?, matricula=?, valor_mensalidade=? " +
                "WHERE idaluno=?;";
        // PREPARAR A EXECUÇÃO
        PreparedStatement pst = c.prepareStatement(sql);
        pst.setString(1, aluno.getNome());
        pst.setString(2, aluno.getEmail());
        pst.setString(3, aluno.getLogin());
        try {
            pst.setString(4, CryptoUtils.md5(aluno.getSenha()));
        } catch (NoSuchAlgorithmException e) {
            throw new SQLException("Erro ao gerar a senha.");
        }
        pst.setString(5, aluno.getMatricula());
        pst.setDouble(6, aluno.getValorMensalidade());
        pst.setInt(7, aluno.getId());
        // EXECUÇÃO
        pst.execute();
    }

    @Override
    public void apagar(Aluno aluno) throws SQLException, ClassNotFoundException {
        // 4 passos
        // CONECTAR
        c = ConnectionFactory.getConnection();
        // COMANDO SQL
        String sql = "DELETE FROM fpoo.aluno " +
                "WHERE idaluno=?;";
        // PREPARAR A EXECUÇÃO
        PreparedStatement pst = c.prepareStatement(sql);
        pst.setInt(1, aluno.getId());
        // EXECUÇÃO
        pst.execute();
    }

    @Override
    public Aluno buscarUm(Integer id) throws SQLException, ClassNotFoundException {
        // 5 passos
        // CONECTAR
        c = ConnectionFactory.getConnection();
        // COMANDO SQL
        String sql = "SELECT idaluno, nome, email, login, senha, data_ultimo_acesso, matricula, valor_mensalidade " +
                "FROM fpoo.aluno " +
                "WHERE idaluno=?;";
        // PREPARAR A EXECUÇÃO
        PreparedStatement pst = c.prepareStatement(sql);

        pst.setInt(1, id);
        // EXECUÇÃO
        ResultSet rs = pst.executeQuery();
        // PREENCHER O OBJETO
        Aluno a = null;
        if (rs.next()) {
            a = new Aluno();
            a.setId(rs.getInt("idaluno"));
            a.setNome(rs.getString("nome"));
            a.setEmail(rs.getString("email"));
            a.setLogin(rs.getString("login"));
            a.setSenha(rs.getString("senha"));
            String dt = rs.getString("data_ultimo_acesso");
            //2024-05-01 22:00:00.000
            if (dt != null && !dt.isEmpty() && !dt.isBlank()) {
                LocalDateTime dt1 = LocalDateTime.parse(dt, DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm"));
                a.setDataUltimoAcesso(dt1);
            }
            a.setMatricula(rs.getString("matricula"));
            a.setValorMensalidade(rs.getDouble("valor_mensalidade"));
        }

        return a;
    }

    public Aluno buscarAlunoByLoginAndSenha(String login, String senha) throws SQLException, ClassNotFoundException {
        c = ConnectionFactory.getConnection();
        String sql = "SELECT idaluno, nome, email, login, senha, data_ultimo_acesso, matricula, valor_mensalidade " +
                "FROM fpoo.aluno " +
                "WHERE login=? and senha=?;";
        // PREPARAR A EXECUÇÃO
        PreparedStatement pst = c.prepareStatement(sql);

        pst.setString(1, login);
        try {
            pst.setString(2, CryptoUtils.md5(senha));
        } catch (NoSuchAlgorithmException e) {
            throw new SQLException("Erro na Criptografia");
        }
        // EXECUÇÃO
        ResultSet rs = pst.executeQuery();
        // PREENCHER O OBJETO
        Aluno a = null;
        if (rs.next()) {
            a = new Aluno();
            a.setId(rs.getInt("idaluno"));
            a.setNome(rs.getString("nome"));
            a.setEmail(rs.getString("email"));
            a.setLogin(rs.getString("login"));
            a.setSenha(rs.getString("senha"));
            String dt = rs.getString("data_ultimo_acesso");
            //2024-05-01 22:00:00.000
            if (dt != null && !dt.isEmpty() && !dt.isBlank()) {
                LocalDateTime dt1 = LocalDateTime.parse(dt,
                        DateTimeFormatter.ofPattern("YYYY-mm-dd HH:MM"));
                a.setDataUltimoAcesso(dt1);
            }
            a.setMatricula(rs.getString("matricula"));
            a.setValorMensalidade(rs.getDouble("valor_mensalidade"));
        }

        return a;
    }

    @Override
    public List<Aluno> buscarTodos() throws SQLException, ClassNotFoundException {
        // 5 passos
        // CONECTAR
        c = ConnectionFactory.getConnection();
        // COMANDO
        String sql = "SELECT idaluno, nome, email, login, senha, data_ultimo_acesso, matricula, valor_mensalidade " +
                "FROM fpoo.aluno\n";
        // PRFEPARAR A EXECUÇÃO
        PreparedStatement pst = c.prepareStatement(sql);
        // EXECUÇÃO
        ResultSet rs = pst.executeQuery();
        // PREENCHER O OBJETO
        List<Aluno> listaAlunos = new ArrayList<>();
        while (rs.next()) {
            String dt = rs.getString("data_ultimo_acesso");
            LocalDateTime dt1 = null;
            if (dt != null && !dt.isEmpty() && !dt.isBlank()) {
                dt1 = LocalDateTime.parse(dt, DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm"));
            }
            Aluno a = new Aluno(
                    rs.getInt("idaluno"),
                    rs.getString("nome"),
                    rs.getString("email"),
                    rs.getString("login"),
                    rs.getString("senha"),
                    dt1,
                    rs.getString("matricula"),
                    rs.getDouble("valor_mensalidade"));
            listaAlunos.add(a);
        }

        return listaAlunos;
    }

    @Override
    public int count() throws SQLException, ClassNotFoundException {
        // 5 passos
        // CONECTAR
        c = ConnectionFactory.getConnection();
        // COMANDO SQL
        String sql = "SELECT COUNT(*) qtde\n" +
                "FROM fpoo.aluno;";
        // PREPARAR A EXECUÇÃO
        PreparedStatement pst = c.prepareStatement(sql);
        // EXECUÇÃO
        ResultSet rs = pst.executeQuery();
        // PREENCHER O OBJETO
        rs.next();

        return rs.getInt("qtde");
    }
}
