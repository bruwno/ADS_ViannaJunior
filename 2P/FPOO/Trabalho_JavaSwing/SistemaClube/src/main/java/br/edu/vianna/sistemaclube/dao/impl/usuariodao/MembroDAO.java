package br.edu.vianna.sistemaclube.dao.impl.usuariodao;

import br.edu.vianna.sistemaclube.dao.IGenericDAO;
import br.edu.vianna.sistemaclube.dao.dbconnection.ConnectionFactory;
import br.edu.vianna.sistemaclube.model.associados.ETipoAssociado;
import br.edu.vianna.sistemaclube.model.usuarios.Membro;
import br.edu.vianna.sistemaclube.utils.criptografia.CryptoUtils;
import br.edu.vianna.sistemaclube.utils.datahora.FormataData;
import br.edu.vianna.sistemaclube.utils.datahora.FormataDataHora;

import java.security.NoSuchAlgorithmException;
import java.sql.*;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

public class MembroDAO implements IGenericDAO<Membro, Integer> {
    private Connection c;

    @Override
    public void inserir(Membro membro) throws SQLException, ClassNotFoundException {
        c = ConnectionFactory.getConnection();
        String sql = "INSERT INTO clube.membros\n" +
                "(nome, sobrenome, cpf, email, login, senha, valor_associado, tipo_associado, data_nascimento, data_registro)\n" +
                "VALUES(?, ?, ?, ?, ?, ?, ?, ?, ?, ?);";
        PreparedStatement pst = c.prepareStatement(sql, Statement.RETURN_GENERATED_KEYS);
        pst.setString(1, membro.getNome());
        pst.setString(2, membro.getSobrenome());
        pst.setString(3, membro.getCpf());
        pst.setString(4, membro.getEmail());
        pst.setString(5, membro.getLogin());
        try {
            pst.setString(6, CryptoUtils.criptografar(membro.getSenha()));
        } catch (NoSuchAlgorithmException ex) {
            throw new SQLException("Ocorreu um erro ao tentar inserir a senha.");
        }
        pst.setDouble(7, membro.getValorAssociado());
        pst.setString(8, membro.getTipoAssociado().toString());
        pst.setString(9, membro.getDataNascimento());
        pst.setString(10, membro.getDataRegistro());

        pst.execute();

        try (ResultSet generatedKeys = pst.getGeneratedKeys()) {
            if (generatedKeys.next()) {
                int idGeradoPeloInsert = generatedKeys.getInt(1);
                membro.setId(idGeradoPeloInsert);
            }
        }

        pst.close();
        c.close();
    }

    @Override
    public void alterar(Membro membro) throws SQLException, ClassNotFoundException {
        c = ConnectionFactory.getConnection();
        String sql = "UPDATE clube.membros\n" +
                "SET nome=?, sobrenome=?, cpf=?, email=?, login=?, senha=?, valor_associado=?, tipo_associado=?, data_nascimento=?\n" +
                "WHERE id=?;";
        PreparedStatement pst = c.prepareStatement(sql);
        pst.setString(1, membro.getNome());
        pst.setString(2, membro.getSobrenome());
        pst.setString(3, membro.getCpf());
        pst.setString(4, membro.getEmail());
        pst.setString(5, membro.getLogin());
        try {
            pst.setString(6, CryptoUtils.criptografar(membro.getSenha()));
        } catch (NoSuchAlgorithmException ex) {
            throw new SQLException("Ocorreu um erro ao tentar alterar a senha.");
        }
        pst.setDouble(7, membro.getValorAssociado());
        pst.setString(8, membro.getTipoAssociado().toString());
        pst.setString(9, membro.getDataNascimento());
        pst.setInt(10, membro.getId());

        pst.execute();

        pst.close();
        c.close();
    }

    public void atualizarDataUltimoAcesso(Membro membro) throws SQLException, ClassNotFoundException {
        c = ConnectionFactory.getConnection();
        String sql = "UPDATE clube.membros\n" +
                "SET data_ultimo_acesso=?\n" +
                "WHERE id=?;";
        PreparedStatement pst = c.prepareStatement(sql);
        pst.setString(1, membro.getDataUltimoAcesso());
        pst.setInt(2, membro.getId());
        pst.execute();
    }

    @Override
    public void apagar(Membro membro) throws SQLException, ClassNotFoundException {
        c = ConnectionFactory.getConnection();
        String sql = "DELETE FROM clube.membros\n" +
                "WHERE id=?;";
        PreparedStatement pst = c.prepareStatement(sql);
        pst.setInt(1, membro.getId());
        pst.execute();

        pst.close();
        c.close();
    }

    public void apagar(int id) throws SQLException, ClassNotFoundException {
        c = ConnectionFactory.getConnection();
        String sql = "DELETE FROM clube.membros\n" +
                "WHERE id=?;";
        PreparedStatement pst = c.prepareStatement(sql);
        pst.setInt(1, id);
        pst.execute();

        pst.close();
        c.close();
    }

    @Override
    public Membro buscarPorId(Integer id) throws SQLException, ClassNotFoundException {
        c = ConnectionFactory.getConnection();
        String sql = "SELECT id, nome, sobrenome, cpf, email, login, senha, valor_associado, tipo_associado, data_nascimento, data_registro, data_ultimo_acesso\n" +
                "FROM clube.membros\n" +
                "WHERE id=?;";
        PreparedStatement pst = c.prepareStatement(sql);
        pst.setInt(1, id);

        ResultSet rs = pst.executeQuery();
        Membro membro = null;
        if (rs.next()) {
            membro = new Membro();
            membro.setId(rs.getInt("id"));
            membro.setNome(rs.getString("nome"));
            membro.setSobrenome(rs.getString("sobrenome"));
            membro.setCpf(rs.getString("cpf"));
            membro.setEmail(rs.getString("email"));
            membro.setLogin(rs.getString("login"));
            membro.setSenha(rs.getString("senha"));
            membro.setValorAssociado(rs.getDouble("valor_associado"));
            membro.setTipoAssociado(ETipoAssociado.valueOf(rs.getString("tipo_associado")));
            String dataNascimento = rs.getString("data_nascimento");
            if (dataNascimento != null && !dataNascimento.isBlank())
            {
                membro.setDataNascimento(FormataData.dbFormataStringParaDataBase(dataNascimento));
            }

            String dataRegistro = rs.getString("data_registro");
            if (dataRegistro != null && !dataRegistro.isBlank()) {
                membro.setDataRegistro(FormataDataHora.dbFormataStringParaDataHora(dataRegistro));
            }

            String dataUltimoAcesso = rs.getString("data_ultimo_acesso");
            if (dataUltimoAcesso != null && !dataUltimoAcesso.isBlank()) {
                membro.setDataUltimoAcesso(FormataDataHora.dbFormataStringParaDataHora(dataUltimoAcesso));
            }
        }

        liberarRecursos(rs, pst);

        return membro;
    }

    @Override
    public List<Membro> buscarTodos() throws SQLException, ClassNotFoundException {
        c = ConnectionFactory.getConnection();
        String sql = "SELECT id, nome, sobrenome, cpf, email, login, senha, valor_associado, tipo_associado, data_nascimento, data_registro, data_ultimo_acesso\n" +
                "FROM clube.membros;";
        PreparedStatement pst = c.prepareStatement(sql);
        ResultSet rs = pst.executeQuery();

        List<Membro> listaMembros = retornaListaMembros(rs);

        liberarRecursos(rs, pst);

        return listaMembros;
    }

    public Membro buscarPorCpf(String cpf) throws SQLException, ClassNotFoundException {
        c = ConnectionFactory.getConnection();
        String sql = "SELECT id, nome, sobrenome, cpf, email, login, senha, valor_associado, tipo_associado, data_nascimento, data_registro, data_ultimo_acesso\n" +
                "FROM clube.membros\n" +
                "WHERE cpf=?;";
        PreparedStatement pst = c.prepareStatement(sql);
        pst.setString(1, cpf);

        ResultSet rs = pst.executeQuery();
        Membro membro = null;
        if (rs.next()) {
            membro = new Membro();
            membro.setId(rs.getInt("id"));
            membro.setNome(rs.getString("nome"));
            membro.setSobrenome(rs.getString("sobrenome"));
            membro.setCpf(rs.getString("cpf"));
            membro.setEmail(rs.getString("email"));
            membro.setLogin(rs.getString("login"));
            membro.setSenha(rs.getString("senha"));
            membro.setValorAssociado(rs.getDouble("valor_associado"));
            membro.setTipoAssociado(ETipoAssociado.valueOf(rs.getString("tipo_associado")));
            String dataNascimento = rs.getString("data_nascimento");
            if (dataNascimento != null && !dataNascimento.isBlank())
            {
                membro.setDataNascimento(FormataData.dbFormataStringParaDataBase(dataNascimento));
            }

            String dataRegistro = rs.getString("data_registro");
            if (dataRegistro != null && !dataRegistro.isBlank()) {
                membro.setDataRegistro(FormataDataHora.dbFormataStringParaDataHora(dataRegistro));
            }

            String dataUltimoAcesso = rs.getString("data_ultimo_acesso");
            if (dataUltimoAcesso != null && !dataUltimoAcesso.isBlank()) {
                membro.setDataUltimoAcesso(FormataDataHora.dbFormataStringParaDataHora(dataUltimoAcesso));
            }
        }

        liberarRecursos(rs, pst);

        return membro;
    }

    public List<Membro> buscarPorNome(String nomeMembro) throws SQLException, ClassNotFoundException {
        c = ConnectionFactory.getConnection();
        String sql = "SELECT id, nome, sobrenome, cpf, email, login, senha, valor_associado, tipo_associado, data_nascimento, data_registro, data_ultimo_acesso\n" +
                "FROM clube.membros\n" +
                "WHERE nome LIKE ? OR sobrenome LIKE ?;";
        PreparedStatement pst = c.prepareStatement(sql);
        pst.setString(1, "%" + nomeMembro + "%");
        pst.setString(2, "%" + nomeMembro + "%");

        ResultSet rs = pst.executeQuery();
        List<Membro> listaMembros = retornaListaMembros(rs);

        liberarRecursos(rs, pst);

        return listaMembros;
    }

    public List<Membro> buscarPorDataNasc(String dataNasc) throws SQLException, ClassNotFoundException {
        c = ConnectionFactory.getConnection();
        String sql = "SELECT id, nome, sobrenome, cpf, email, login, senha, valor_associado, tipo_associado, data_nascimento, data_registro, data_ultimo_acesso\n" +
                "FROM clube.membros\n" +
                "WHERE data_nascimento=?;";
        PreparedStatement pst = c.prepareStatement(sql);
        pst.setString(1, FormataData.formataDataParaBuscaNaBase(dataNasc));

        ResultSet rs = pst.executeQuery();
        List<Membro> listaMembros = retornaListaMembros(rs);

        liberarRecursos(rs, pst);

        return listaMembros;
    }

    private static List<Membro> retornaListaMembros(ResultSet rs) throws SQLException {
        List<Membro> listaMembros = new ArrayList<>();
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

            Membro membro = new Membro(
                    rs.getInt("id"),
                    rs.getString("nome"),
                    rs.getString("sobrenome"),
                    rs.getString("cpf"),
                    rs.getString("email"),
                    rs.getString("login"),
                    rs.getString("senha"),
                    rs.getDouble("valor_associado"),
                    ETipoAssociado.valueOf(rs.getString("tipo_associado")),
                    dtNasc,
                    dtReg,
                    dtUltAcess);

            listaMembros.add(membro);
        }

        return listaMembros;
    }

    public Membro buscarPorLoginSenha(String login, String senha) throws SQLException, ClassNotFoundException {
        c = ConnectionFactory.getConnection();
        String sql = "SELECT id, nome, sobrenome, cpf, email, login, senha, valor_associado, tipo_associado, data_nascimento, data_registro\n" +
                "FROM clube.membros\n" +
                "WHERE login=? AND senha=?;";
        PreparedStatement pst = c.prepareStatement(sql);
        pst.setString(1, login);
        try {
            pst.setString(2, CryptoUtils.criptografar(senha));
        } catch (NoSuchAlgorithmException e) {
            throw new SQLException("Erro na Criptografia");
        }

        ResultSet rs = pst.executeQuery();

        Membro membro = null;
        if (rs.next()) {
            membro = new Membro();
            membro.setId(rs.getInt("id"));
            membro.setNome(rs.getString("nome"));
            membro.setSobrenome(rs.getString("sobrenome"));
            membro.setCpf(rs.getString("cpf"));
            membro.setEmail(rs.getString("email"));
            membro.setLogin(rs.getString("login"));
            membro.setSenha(rs.getString("senha"));
            membro.setValorAssociado(rs.getDouble("valor_associado"));
            membro.setTipoAssociado(ETipoAssociado.valueOf(rs.getString("tipo_associado")));
            String dataNascimento = rs.getString("data_nascimento");
            if (dataNascimento != null && !dataNascimento.isBlank())
            {
                membro.setDataNascimento(FormataData.dbFormataStringParaDataBase(dataNascimento));
            }

            String dataRegistro = rs.getString("data_registro");
            if (dataRegistro != null && !dataRegistro.isBlank()) {
                membro.setDataRegistro(FormataDataHora.dbFormataStringParaDataHora(dataRegistro));
            }
        }

        liberarRecursos(rs, pst);

        return membro;
    }

    @Override
    public int contar() throws SQLException, ClassNotFoundException {
        c = ConnectionFactory.getConnection();
        String sql = "SELECT COUNT(*) quantidade\n" +
                "FROM clube.membros;";
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
