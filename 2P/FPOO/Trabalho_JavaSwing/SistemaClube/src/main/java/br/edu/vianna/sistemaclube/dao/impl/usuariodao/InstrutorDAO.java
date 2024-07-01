package br.edu.vianna.sistemaclube.dao.impl.usuariodao;

import br.edu.vianna.sistemaclube.dao.IGenericDAO;
import br.edu.vianna.sistemaclube.dao.dbconnection.ConnectionFactory;
import br.edu.vianna.sistemaclube.model.instrutores.EEspecializacao;
import br.edu.vianna.sistemaclube.model.usuarios.Instrutor;
import br.edu.vianna.sistemaclube.utils.criptografia.CryptoUtils;
import br.edu.vianna.sistemaclube.utils.datahora.FormataData;
import br.edu.vianna.sistemaclube.utils.datahora.FormataDataHora;

import java.security.NoSuchAlgorithmException;
import java.sql.*;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

public class InstrutorDAO implements IGenericDAO<Instrutor, Integer> {
    private Connection c;

    @Override
    public void inserir(Instrutor instrutor) throws SQLException, ClassNotFoundException {
        c = ConnectionFactory.getConnection();
        String sql = "INSERT INTO clube.instrutores\n" +
                "(nome, sobrenome, cpf, email, login, senha, salario, especializacao, data_nascimento, data_registro)\n" +
                "VALUES(?, ?, ?, ?, ?, ?, ?, ?, ?, ?);";
        PreparedStatement pst = c.prepareStatement(sql, Statement.RETURN_GENERATED_KEYS);
        pst.setString(1, instrutor.getNome());
        pst.setString(2, instrutor.getSobrenome());
        pst.setString(3, instrutor.getCpf());
        pst.setString(4, instrutor.getEmail());
        pst.setString(5, instrutor.getLogin());
        try {
            pst.setString(6, CryptoUtils.criptografar(instrutor.getSenha()));
        } catch (NoSuchAlgorithmException ex) {
            throw new SQLException("Ocorreu um erro ao tentar inserir a senha.");
        }
        pst.setDouble(7, instrutor.getSalario());
        pst.setString(8, instrutor.getEspecializacao().toString());
        pst.setString(9, instrutor.getDataNascimento());
        pst.setString(10, instrutor.getDataRegistro());

        pst.execute();

        try (ResultSet generatedKeys = pst.getGeneratedKeys()) {
            if (generatedKeys.next()) {
                int idGeradoPeloInsert = generatedKeys.getInt(1);
                instrutor.setId(idGeradoPeloInsert);
            }
        }

        pst.close();
        c.close();
    }

    @Override
    public void alterar(Instrutor instrutor) throws SQLException, ClassNotFoundException {
        c = ConnectionFactory.getConnection();
        String sql = "UPDATE clube.instrutores\n" +
                "SET nome=?, sobrenome=?, cpf=?, email=?, login=?, senha=?, salario=?, especializacao=?, data_nascimento=?\n" +
                "WHERE id=?;";
        PreparedStatement pst = c.prepareStatement(sql);

        pst.setString(1, instrutor.getNome());
        pst.setString(2, instrutor.getSobrenome());
        pst.setString(3, instrutor.getCpf());
        pst.setString(4, instrutor.getEmail());
        pst.setString(5, instrutor.getNome());
        try {
            pst.setString(6, CryptoUtils.criptografar(instrutor.getSenha()));
        } catch (NoSuchAlgorithmException ex) {
            throw new SQLException("Ocorreu um erro ao tentar alterar a senha.");
        }
        pst.setDouble(7, instrutor.getSalario());
        pst.setString(8, instrutor.getEspecializacao().toString());
        pst.setString(9, instrutor.getDataNascimento());
        pst.setInt(10, instrutor.getId());

        pst.execute();

        pst.close();
        c.close();
    }

    public void atualizarDataUltimoAcesso(Instrutor instrutor) throws SQLException, ClassNotFoundException {
        c = ConnectionFactory.getConnection();
        String sql = "UPDATE clube.instrutores\n" +
                "SET data_ultimo_acesso=?\n" +
                "WHERE id=?;";
        PreparedStatement pst = c.prepareStatement(sql);
        pst.setString(1, instrutor.getDataUltimoAcesso());
        pst.setInt(2, instrutor.getId());
        pst.execute();
    }

    @Override
    public void apagar(Instrutor instrutor) throws SQLException, ClassNotFoundException {
        c = ConnectionFactory.getConnection();
        String sql = "DELETE FROM clube.instrutores\n" +
                "WHERE id=?;";
        PreparedStatement pst = c.prepareStatement(sql);
        pst.setInt(1, instrutor.getId());
        pst.execute();

        pst.close();
        c.close();
    }

    public void apagar(int id) throws SQLException, ClassNotFoundException {
        c = ConnectionFactory.getConnection();
        String sql = "DELETE FROM clube.instrutores\n" +
                "WHERE id=?;";
        PreparedStatement pst = c.prepareStatement(sql);
        pst.setInt(1, id);
        pst.execute();

        pst.close();
        c.close();
    }

    @Override
    public Instrutor buscarPorId(Integer id) throws SQLException, ClassNotFoundException {
        c = ConnectionFactory.getConnection();
        String sql = "SELECT id, nome, sobrenome, cpf, email, login, senha, salario, especializacao, data_nascimento, data_registro, data_ultimo_acesso\n" +
                "FROM clube.instrutores\n" +
                "WHERE id=?";
        PreparedStatement pst = c.prepareStatement(sql);
        pst.setInt(1, id);

        ResultSet rs = pst.executeQuery();
        Instrutor instrutor = null;
        if (rs.next()) {
            instrutor = new Instrutor();
            instrutor.setId(rs.getInt("id"));
            instrutor.setNome(rs.getString("nome"));
            instrutor.setSobrenome(rs.getString("sobrenome"));
            instrutor.setCpf(rs.getString("cpf"));
            instrutor.setEmail(rs.getString("email"));
            instrutor.setLogin(rs.getString("login"));
            instrutor.setSenha(rs.getString("senha"));
            instrutor.setSalario(rs.getDouble("salario"));
            instrutor.setEspecializacao(EEspecializacao.valueOf(rs.getString("especializacao")));
            String dataNascimento = rs.getString("data_nascimento");
            if (dataNascimento != null && !dataNascimento.isBlank())
            {
                instrutor.setDataNascimento(FormataData.dbFormataStringParaDataBase(dataNascimento));
            }

            String dataRegistro = rs.getString("data_registro");
            if (dataRegistro != null && !dataRegistro.isBlank()) {
                instrutor.setDataRegistro(FormataDataHora.dbFormataStringParaDataHora(dataRegistro));
            }

            String dataUltimoAcesso = rs.getString("data_ultimo_acesso");
            if (dataUltimoAcesso != null && !dataUltimoAcesso.isBlank()) {
                instrutor.setDataUltimoAcesso(FormataDataHora.dbFormataStringParaDataHora(dataUltimoAcesso));
            }
        }

        liberarRecursos(rs, pst);

        return instrutor;
    }

    @Override
    public List<Instrutor> buscarTodos() throws SQLException, ClassNotFoundException {
        c = ConnectionFactory.getConnection();
        String sql = "SELECT id, nome, sobrenome, cpf, email, login, senha, salario, especializacao, data_nascimento, data_registro, data_ultimo_acesso\n" +
                "FROM clube.instrutores;";
        PreparedStatement pst = c.prepareStatement(sql);
        ResultSet rs = pst.executeQuery();

        List<Instrutor> listaInstrutores = retornaListaInstrutores(rs);

        liberarRecursos(rs, pst);

        return listaInstrutores;
    }

    public Instrutor buscarPorCpf(String cpf) throws SQLException, ClassNotFoundException {
        c = ConnectionFactory.getConnection();
        String sql = "SELECT id, nome, sobrenome, cpf, email, login, senha, salario, especializacao, data_nascimento, data_registro, data_ultimo_acesso\n" +
                "FROM clube.instrutores\n" +
                "WHERE cpf=?";
        PreparedStatement pst = c.prepareStatement(sql);
        pst.setString(1, cpf);

        ResultSet rs = pst.executeQuery();
        Instrutor instrutor = null;
        if (rs.next()) {
            instrutor = new Instrutor();
            instrutor.setId(rs.getInt("id"));
            instrutor.setNome(rs.getString("nome"));
            instrutor.setSobrenome(rs.getString("sobrenome"));
            instrutor.setCpf(rs.getString("cpf"));
            instrutor.setEmail(rs.getString("email"));
            instrutor.setLogin(rs.getString("login"));
            instrutor.setSenha(rs.getString("senha"));
            instrutor.setSalario(rs.getDouble("salario"));
            instrutor.setEspecializacao(EEspecializacao.valueOf(rs.getString("especializacao")));
            String dataNascimento = rs.getString("data_nascimento");
            if (dataNascimento != null && !dataNascimento.isBlank())
            {
                instrutor.setDataNascimento(FormataData.dbFormataStringParaDataBase(dataNascimento));
            }

            String dataRegistro = rs.getString("data_registro");
            if (dataRegistro != null && !dataRegistro.isBlank()) {
                instrutor.setDataRegistro(FormataDataHora.dbFormataStringParaDataHora(dataRegistro));
            }

            String dataUltimoAcesso = rs.getString("data_ultimo_acesso");
            if (dataUltimoAcesso != null && !dataUltimoAcesso.isBlank()) {
                instrutor.setDataUltimoAcesso(FormataDataHora.dbFormataStringParaDataHora(dataUltimoAcesso));
            }
        }

        liberarRecursos(rs, pst);

        return instrutor;
    }

    public List<Instrutor> buscarPorDataNasc(String dataNasc) throws SQLException, ClassNotFoundException {
        c = ConnectionFactory.getConnection();
        String sql = "SELECT id, nome, sobrenome, cpf, email, login, senha, salario, especializacao, data_nascimento, data_registro, data_ultimo_acesso\n" +
                "FROM clube.instrutores\n" +
                "WHERE data_nascimento=?;";
        PreparedStatement pst = c.prepareStatement(sql);
        pst.setString(1, FormataData.formataDataParaBuscaNaBase(dataNasc));

        ResultSet rs = pst.executeQuery();
        List<Instrutor> listaInstrutores = retornaListaInstrutores(rs);

        liberarRecursos(rs, pst);

        return listaInstrutores;
    }

    public List<Instrutor> buscarPorNome(String nome) throws SQLException, ClassNotFoundException {
        c = ConnectionFactory.getConnection();
        String sql = "SELECT id, nome, sobrenome, cpf, email, login, senha, salario, especializacao, data_nascimento, data_registro, data_ultimo_acesso\n" +
                "FROM clube.instrutores\n" +
                "WHERE nome=?;";
        PreparedStatement pst = c.prepareStatement(sql);
        pst.setString(1, nome);

        ResultSet rs = pst.executeQuery();
        List<Instrutor> listaInstrutores = retornaListaInstrutores(rs);

        liberarRecursos(rs, pst);

        return listaInstrutores;
    }

    private static List<Instrutor> retornaListaInstrutores(ResultSet rs) throws SQLException {
        List<Instrutor> listaInstrutores = new ArrayList<>();
        while (rs.next()) {
            String dataNascimento = rs.getString("data_nascimento");
            String dtNasc = null;
            if (dataNascimento != null && !dataNascimento.isBlank())
            {
                dtNasc = FormataData.dbFormataStringParaDataBase(dataNascimento);
            }

            String dataRegistro = rs.getString("data_registro");
            LocalDateTime dtReg = null;
            if (dataRegistro != null && !dataRegistro.isBlank()) {
                dtReg = FormataDataHora.dbFormataStringParaDataHora(dataRegistro);
            }

            String dataUltimoAcesso = rs.getString("data_ultimo_acesso");
            LocalDateTime dtUltAcess = null;
            if (dataUltimoAcesso != null && !dataUltimoAcesso.isBlank()) {
                dtUltAcess = FormataDataHora.dbFormataStringParaDataHora(dataUltimoAcesso);
            }

            Instrutor instrutor = new Instrutor(
                    rs.getInt("id"),
                    rs.getString("nome"),
                    rs.getString("sobrenome"),
                    rs.getString("cpf"),
                    rs.getString("email"),
                    rs.getString("login"),
                    rs.getString("senha"),
                    rs.getDouble("salario"),
                    EEspecializacao.valueOf(rs.getString("especializacao")),
                    dtNasc,
                    dtReg,
                    dtUltAcess);

            listaInstrutores.add(instrutor);
        }
        if (listaInstrutores.isEmpty()) {
            return null;
        } else {
            return listaInstrutores;
        }
    }

    public Instrutor buscarPorLoginSenha(String login, String senha) throws SQLException, ClassNotFoundException {
        c = ConnectionFactory.getConnection();
        String sql = "SELECT id, nome, sobrenome, cpf, email, login, senha, salario, especializacao, data_nascimento, data_registro\n" +
                "FROM clube.instrutores\n" +
                "WHERE login=? AND senha=?;";
        PreparedStatement pst = c.prepareStatement(sql);
        pst.setString(1, login);
        try {
            pst.setString(2, CryptoUtils.criptografar(senha));
        } catch (NoSuchAlgorithmException e) {
            throw new SQLException("Erro na Criptografia");
        }

        ResultSet rs = pst.executeQuery();

        Instrutor instrutor = null;
        if (rs.next()) {
            instrutor = new Instrutor();
            instrutor.setId(rs.getInt("id"));
            instrutor.setNome(rs.getString("nome"));
            instrutor.setSobrenome(rs.getString("sobrenome"));
            instrutor.setCpf(rs.getString("cpf"));
            instrutor.setEmail(rs.getString("email"));
            instrutor.setLogin(rs.getString("login"));
            instrutor.setSenha(rs.getString("senha"));
            instrutor.setSalario(rs.getDouble("salario"));
            instrutor.setEspecializacao(EEspecializacao.valueOf(rs.getString("especializacao")));
            String dataNascimento = rs.getString("data_nascimento");
            if (dataNascimento != null && !dataNascimento.isBlank())
            {
                instrutor.setDataNascimento(FormataData.dbFormataStringParaDataBase(dataNascimento));
            }

            String dataRegistro = rs.getString("data_registro");
            if (dataRegistro != null && !dataRegistro.isBlank()) {
                instrutor.setDataRegistro(FormataDataHora.dbFormataStringParaDataHora(dataRegistro));
            }
        }

        liberarRecursos(rs, pst);

        return instrutor;
    }

    @Override
    public int contar() throws SQLException, ClassNotFoundException {
        c = ConnectionFactory.getConnection();
        String sql = "SELECT COUNT(*) quantidade\n" +
                "FROM clube.instrutores;";
        PreparedStatement pst = c.prepareStatement(sql);
        ResultSet rs = pst.executeQuery();
        rs.next();

        liberarRecursos(rs, pst);

        return rs.getInt("quantidade");
    }

    private void liberarRecursos(ResultSet rs, PreparedStatement pst) throws SQLException {
        rs.close();
        pst.close();
        c.close();
    }
}
