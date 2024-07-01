package br.edu.vianna.sistemaclube.dao.impl.usuariodao;

import br.edu.vianna.sistemaclube.dao.IGenericDAO;
import br.edu.vianna.sistemaclube.dao.dbconnection.ConnectionFactory;
import br.edu.vianna.sistemaclube.model.usuarios.Administrador;
import br.edu.vianna.sistemaclube.utils.criptografia.CryptoUtils;
import br.edu.vianna.sistemaclube.utils.datahora.FormataData;
import br.edu.vianna.sistemaclube.utils.datahora.FormataDataHora;

import java.security.NoSuchAlgorithmException;
import java.sql.*;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

public class AdministradorDAO implements IGenericDAO<Administrador, Integer> {
    private Connection c;

    @Override
    public void inserir(Administrador administrador) throws SQLException, ClassNotFoundException {
        c = ConnectionFactory.getConnection();
        String sql = "INSERT INTO clube.administradores\n" +
                "(nome, sobrenome, cpf, email, login, senha, data_nascimento, data_registro)\n" +
                "VALUES(?, ?, ?, ?, ?, ?, ?, ?);";
        PreparedStatement pst = c.prepareStatement(sql, Statement.RETURN_GENERATED_KEYS);
        pst.setString(1, administrador.getNome());
        pst.setString(2, administrador.getSobrenome());
        pst.setString(3, administrador.getCpf());
        pst.setString(4, administrador.getEmail());
        pst.setString(5, administrador.getLogin());
        try {
            pst.setString(6, CryptoUtils.criptografar(administrador.getSenha()));
        } catch (NoSuchAlgorithmException ex) {
            throw new SQLException("Ocorreu um erro ao tentar inserir a senha.");
        }
        if (administrador.getDataNascimento() != null) {
            pst.setString(7, administrador.getDataNascimento());
        } else {
            pst.setNull(7, Types.DATE);
        }
        pst.setString(8, administrador.getDataRegistro());

        pst.execute();

        try (ResultSet generatedKeys = pst.getGeneratedKeys()) {
            if (generatedKeys.next()) {
                int idGeradoPeloInsert = generatedKeys.getInt(1);
                administrador.setId(idGeradoPeloInsert);
            }
        }

        pst.close();
        c.close();
    }

    @Override
    public void alterar(Administrador administrador) throws SQLException, ClassNotFoundException {
        c = ConnectionFactory.getConnection();
        String sql = "UPDATE clube.administradores\n" +
                "SET nome=?, sobrenome=?, cpf=?, email=?, login=?, senha=?, data_nascimento=?\n" +
                "WHERE id=?;";
        PreparedStatement pst = c.prepareStatement(sql);
        pst.setString(1, administrador.getNome());
        pst.setString(2, administrador.getSobrenome());
        pst.setString(3, administrador.getCpf());
        pst.setString(4, administrador.getEmail());
        pst.setString(5, administrador.getLogin());
        try {
            pst.setString(6, CryptoUtils.criptografar(administrador.getSenha()));
        } catch (NoSuchAlgorithmException ex) {
            throw new SQLException("Ocorreu um erro ao tentar alterar a senha.");
        }
        pst.setString(7, administrador.getDataNascimento());
        pst.setInt(8, administrador.getId());

        pst.execute();

        pst.close();
        c.close();
    }

    public void atualizarDataUltimoAcesso(Administrador adm) throws SQLException, ClassNotFoundException {
        c = ConnectionFactory.getConnection();
        String sql = "UPDATE clube.administradores\n" +
                "SET data_ultimo_acesso=?\n" +
                "WHERE id=?;";
        PreparedStatement pst = c.prepareStatement(sql);
        pst.setString(1, adm.getDataUltimoAcesso());
        pst.setInt(2, adm.getId());
        pst.execute();

        pst.close();
        c.close();
    }

    @Override
    public void apagar(Administrador administrador) throws SQLException, ClassNotFoundException {
        c = ConnectionFactory.getConnection();
        String sql = "DELETE FROM clube.administradores\n" +
                "WHERE id=?;";
        PreparedStatement pst = c.prepareStatement(sql);
        pst.setInt(1, administrador.getId());
        pst.execute();

        pst.close();
        c.close();
    }

    public void apagar(int id) throws SQLException, ClassNotFoundException {
        c = ConnectionFactory.getConnection();
        String sql = "DELETE FROM clube.administradores\n" +
                "WHERE id=?;";
        PreparedStatement pst = c.prepareStatement(sql);
        pst.setInt(1, id);
        pst.execute();

        pst.close();
        c.close();
    }

    @Override
    public Administrador buscarPorId(Integer id) throws SQLException, ClassNotFoundException {
        c = ConnectionFactory.getConnection();
        String sql = "SELECT id, nome, sobrenome, cpf, email, login, senha, data_nascimento, data_registro, data_ultimo_acesso\n" +
                "FROM clube.administradores\n" +
                "WHERE id=?;";
        PreparedStatement pst = c.prepareStatement(sql);
        pst.setInt(1, id);

        ResultSet rs = pst.executeQuery();
        Administrador adm = null;
        if (rs.next()) {
            adm = new Administrador();
            adm.setId(rs.getInt("id"));
            adm.setNome(rs.getString("nome"));
            adm.setSobrenome(rs.getString("sobrenome"));
            adm.setCpf(rs.getString("cpf"));
            adm.setEmail(rs.getString("email"));
            adm.setLogin(rs.getString("login"));
            adm.setSenha(rs.getString("senha"));
            String dataNascimento = rs.getString("data_nascimento");
            if (dataNascimento != null && !dataNascimento.isBlank()) {
                adm.setDataNascimento(FormataData.dbFormataStringParaDataBase(dataNascimento));
            }

            String dataRegistro = rs.getString("data_registro");
            if (dataRegistro != null && !dataRegistro.isBlank()) {
                adm.setDataRegistro(FormataDataHora.dbFormataStringParaDataHora(dataRegistro));
            }

            String dataUltimoAcesso = rs.getString("data_ultimo_acesso");
            if (dataUltimoAcesso != null && !dataUltimoAcesso.isBlank()) {
                adm.setDataUltimoAcesso(FormataDataHora.dbFormataStringParaDataHora(dataUltimoAcesso));
            }
        }

        liberarRecursos(rs, pst);

        return adm;
    }

    @Override
    public List<Administrador> buscarTodos() throws SQLException, ClassNotFoundException {
        c = ConnectionFactory.getConnection();
        String sql = "SELECT id, nome, sobrenome, cpf, email, login, senha, data_nascimento, data_registro, data_ultimo_acesso\n" +
                "FROM clube.administradores;";
        PreparedStatement pst = c.prepareStatement(sql);
        ResultSet rs = pst.executeQuery();

        List<Administrador> listaAdministradores = retornaListaAdministradores(rs);

        liberarRecursos(rs, pst);

        return listaAdministradores;
    }

    public List<Administrador> buscarPorDataNasc(String dataNasc) throws SQLException, ClassNotFoundException {
        c = ConnectionFactory.getConnection();
        String sql = "SELECT id, nome, sobrenome, cpf, email, login, senha, data_nascimento, data_registro, data_ultimo_acesso\n" +
                "FROM clube.administradores\n" +
                "WHERE data_nascimento=?;";
        PreparedStatement pst = c.prepareStatement(sql);
        pst.setString(1, FormataData.formataDataParaBuscaNaBase(dataNasc));

        ResultSet rs = pst.executeQuery();
        List<Administrador> listaMembros = retornaListaAdministradores(rs);

        liberarRecursos(rs, pst);

        return listaMembros;
    }

    public Administrador buscarPorCpf(String cpf) throws SQLException, ClassNotFoundException {
        c = ConnectionFactory.getConnection();
        String sql = "SELECT id, nome, sobrenome, cpf, email, login, senha, data_nascimento, data_registro, data_ultimo_acesso\n" +
                "FROM clube.administradores\n" +
                "WHERE cpf=?;";
        PreparedStatement pst = c.prepareStatement(sql);
        pst.setString(1, cpf);

        ResultSet rs = pst.executeQuery();
        Administrador adm = null;
        if (rs.next()) {
            adm = new Administrador();
            adm.setId(rs.getInt("id"));
            adm.setNome(rs.getString("nome"));
            adm.setSobrenome(rs.getString("sobrenome"));
            adm.setCpf(rs.getString("cpf"));
            adm.setEmail(rs.getString("email"));
            adm.setLogin(rs.getString("login"));
            adm.setSenha(rs.getString("senha"));
            String dataNascimento = rs.getString("data_nascimento");
            if (dataNascimento != null && !dataNascimento.isBlank()) {
                adm.setDataNascimento(FormataData.dbFormataStringParaDataBase(dataNascimento));
            }

            String dataRegistro = rs.getString("data_registro");
            if (dataRegistro != null && !dataRegistro.isBlank()) {
                adm.setDataRegistro(FormataDataHora.dbFormataStringParaDataHora(dataRegistro));
            }

            String dataUltimoAcesso = rs.getString("data_ultimo_acesso");
            if (dataUltimoAcesso != null && !dataUltimoAcesso.isBlank()) {
                adm.setDataUltimoAcesso(FormataDataHora.dbFormataStringParaDataHora(dataUltimoAcesso));
            }
        }

        liberarRecursos(rs, pst);

        return adm;
    }

    public List<Administrador> buscarPorNome(String nome) throws SQLException, ClassNotFoundException {
        c = ConnectionFactory.getConnection();
        String sql = "SELECT id, nome, sobrenome, cpf, email, login, senha, data_nascimento, data_registro, data_ultimo_acesso\n" +
                "FROM clube.administradores\n" +
                "WHERE nome=?;";
        PreparedStatement pst = c.prepareStatement(sql);
        pst.setString(1, nome);

        ResultSet rs = pst.executeQuery();
        List<Administrador> listaAdministradores = retornaListaAdministradores(rs);

        liberarRecursos(rs, pst);

        return listaAdministradores;
    }

    private static List<Administrador> retornaListaAdministradores(ResultSet rs) throws SQLException {
        List<Administrador> listaAdministradores = new ArrayList<>();
        while (rs.next()) {
            String dataNascimento = rs.getString("data_nascimento");
            String dtNasc = null;
            if (dataNascimento != null && !dataNascimento.isBlank()) {
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

            Administrador adm = new Administrador(
                    rs.getInt("id"),
                    rs.getString("nome"),
                    rs.getString("sobrenome"),
                    rs.getString("cpf"),
                    rs.getString("email"),
                    rs.getString("login"),
                    rs.getString("senha"),
                    dtNasc,
                    dtReg,
                    dtUltAcess);

            listaAdministradores.add(adm);
        }

        return listaAdministradores;
    }

    public Administrador buscarPorLoginSenha(String login, String senha) throws SQLException, ClassNotFoundException {
        c = ConnectionFactory.getConnection();
        String sql = "SELECT id, nome, sobrenome, cpf, email, login, senha, data_nascimento, data_registro\n" +
                "FROM clube.administradores\n" +
                "WHERE login=? AND senha=?;";
        PreparedStatement pst = c.prepareStatement(sql);
        pst.setString(1, login);
        try {
            pst.setString(2, CryptoUtils.criptografar(senha));
        } catch (NoSuchAlgorithmException e) {
            throw new SQLException("Erro na Criptografia");
        }

        ResultSet rs = pst.executeQuery();

        Administrador adm = null;
        if (rs.next()) {
            adm = new Administrador();
            adm.setId(rs.getInt("id"));
            adm.setNome(rs.getString("nome"));
            adm.setSobrenome(rs.getString("sobrenome"));
            adm.setCpf(rs.getString("cpf"));
            adm.setEmail(rs.getString("email"));
            adm.setLogin(rs.getString("login"));
            adm.setSenha(rs.getString("senha"));
            String dataNascimento = rs.getString("data_nascimento");
            if (dataNascimento != null && !dataNascimento.isBlank()) {
                adm.setDataNascimento(FormataData.dbFormataStringParaDataBase(dataNascimento));
            }

            String dataRegistro = rs.getString("data_registro");
            if (dataRegistro != null && !dataRegistro.isBlank()) {
                adm.setDataRegistro(FormataDataHora.dbFormataStringParaDataHora(dataRegistro));
            }
        }

        liberarRecursos(rs, pst);

        return adm;
    }

    @Override
    public int contar() throws SQLException, ClassNotFoundException {
        c = ConnectionFactory.getConnection();
        String sql = "SELECT COUNT(*) quantidade\n" +
                "FROM clube.administradores;";
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