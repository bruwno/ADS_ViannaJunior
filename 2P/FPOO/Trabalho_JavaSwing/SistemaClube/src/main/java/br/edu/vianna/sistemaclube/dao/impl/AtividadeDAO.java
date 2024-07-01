package br.edu.vianna.sistemaclube.dao.impl;

import br.edu.vianna.sistemaclube.dao.IGenericDAO;
import br.edu.vianna.sistemaclube.dao.dbconnection.ConnectionFactory;
import br.edu.vianna.sistemaclube.model.atividades.Atividade;
import br.edu.vianna.sistemaclube.model.atividades.ETipoAtividades;
import br.edu.vianna.sistemaclube.utils.datahora.FormataData;
import br.edu.vianna.sistemaclube.utils.datahora.FormataHora;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class AtividadeDAO implements IGenericDAO<Atividade, Integer> {
    private Connection c;

    @Override
    public void inserir(Atividade atividade) throws SQLException, ClassNotFoundException {
        c = ConnectionFactory.getConnection();
        String sql = "INSERT INTO clube.atividades\n" +
                "(nome, tipo_atividade, descricao, data_atividade, hora_atividade, id_instrutor)\n" +
                "VALUES(?, ?, ?, ?, ?, ?);";
        PreparedStatement pst = c.prepareStatement(sql, Statement.RETURN_GENERATED_KEYS);
        pst.setString(1, atividade.getNome());
        pst.setString(2, atividade.getTipoAtividade().toString());
        pst.setString(3, atividade.getDescricao());
        pst.setString(4, atividade.getDataAtividade());
        pst.setString(5, atividade.getHoraAtividade());
        pst.setInt(6, atividade.getIdInstrutor());

        pst.execute();

        try (ResultSet generatedKeys = pst.getGeneratedKeys()) {
            if (generatedKeys.next()) {
                int idGeradoPeloInsert = generatedKeys.getInt(1);
                atividade.setId(idGeradoPeloInsert);
            }
        }

        pst.close();
        c.close();
    }

    @Override
    public void alterar(Atividade atividade) throws SQLException, ClassNotFoundException {
        c = ConnectionFactory.getConnection();
        String sql = "UPDATE clube.atividades\n" +
                "SET nome=?, tipo_atividade=?, descricao=?, data_atividade=?, hora_atividade=?, id_instrutor=?\n" +
                "WHERE id=?;";
        PreparedStatement pst = c.prepareStatement(sql);
        pst.setString(1, atividade.getNome());
        pst.setString(2, atividade.getTipoAtividade().toString());
        pst.setString(3, atividade.getDescricao());
        pst.setString(4, atividade.getDataAtividade());
        pst.setString(5, atividade.getHoraAtividade());
        pst.setInt(6, atividade.getIdInstrutor());
        pst.setInt(7, atividade.getId());

        pst.execute();

        pst.close();
        c.close();
    }

    @Override
    public void apagar(Atividade atividade) throws SQLException, ClassNotFoundException {
        c = ConnectionFactory.getConnection();
        String sql = "DELETE FROM clube.atividades\n" +
                "WHERE id=?;";
        PreparedStatement pst = c.prepareStatement(sql);
        pst.setInt(1, atividade.getId());
        pst.execute();
    }

    public void apagar(int id) throws SQLException, ClassNotFoundException {
        c = ConnectionFactory.getConnection();
        String sql = "DELETE FROM clube.atividades\n" +
                "WHERE id=?;";
        PreparedStatement pst = c.prepareStatement(sql);
        pst.setInt(1, id);
        pst.execute();

        pst.close();
        c.close();
    }

    @Override
    public Atividade buscarPorId(Integer id) throws SQLException, ClassNotFoundException {
        c = ConnectionFactory.getConnection();
        String sql = "SELECT id, nome, tipo_atividade, descricao, data_atividade, hora_atividade, id_instrutor\n" +
                "FROM clube.atividades\n" +
                "WHERE id=?;";
        PreparedStatement pst = c.prepareStatement(sql);
        pst.setInt(1, id);

        ResultSet rs = pst.executeQuery();
        Atividade atividade = null;
        if (rs.next()) {
            atividade = new Atividade();
            atividade.setId(rs.getInt("id"));
            atividade.setNome(rs.getString("nome"));
            atividade.setTipoAtividade(ETipoAtividades.valueOf(rs.getString("tipo_atividade")));
            atividade.setDescricao(rs.getString("descricao"));
            String dataAtividade = rs.getString("data_atividade");
            if (dataAtividade != null && !dataAtividade.isBlank()) {
                atividade.setDataAtividade(FormataData.dbFormataStringParaDataBase(dataAtividade));
            }

            String horaAtividade = rs.getString("hora_atividade");
            if (horaAtividade != null && !horaAtividade.isBlank()) {
                atividade.setHoraAtividade(FormataHora.dbFormataHoraParaString(horaAtividade));
            }
            atividade.setIdInstrutor(rs.getInt("id_instrutor"));
        }

        liberarRecursos(rs, pst);

        return atividade;
    }

    @Override
    public List<Atividade> buscarTodos() throws SQLException, ClassNotFoundException {
        c = ConnectionFactory.getConnection();
        String sql = "SELECT id, nome, tipo_atividade, descricao, data_atividade, hora_atividade, id_instrutor\n" +
                "FROM clube.atividades;";
        PreparedStatement pst = c.prepareStatement(sql);
        ResultSet rs = pst.executeQuery();

        List<Atividade> listaDeAtividades = new ArrayList<>();
        while(rs.next()) {
            String dataAtividade = rs.getString("data_atividade");
            String dtAtv = null;
            if (dataAtividade != null && !dataAtividade.isBlank()) {
                dtAtv = FormataData.dbFormataStringParaDataBase(dataAtividade);
            }

            String horaAtividade = rs.getString("hora_atividade");
            String hrAtv = null;
            if (horaAtividade != null && !horaAtividade.isBlank()) {
                hrAtv = FormataHora.dbFormataHoraParaString(horaAtividade);
            }

            Atividade atividade = new Atividade(
                    rs.getInt("id"),
                    rs.getString("nome"),
                    ETipoAtividades.valueOf(rs.getString("tipo_atividade")),
                    rs.getString("descricao"),
                    dtAtv,
                    hrAtv,
                    rs.getInt("id_instrutor")
            );
            listaDeAtividades.add(atividade);
        }

        return listaDeAtividades;
    }

    public List<Atividade> buscarPorNome(String nome) throws SQLException, ClassNotFoundException {
        c = ConnectionFactory.getConnection();
        String sql = "SELECT id, nome, tipo_atividade, descricao, data_atividade, hora_atividade, id_instrutor\n" +
                "FROM clube.atividades\n" +
                "WHERE nome LIKE ?;";
        PreparedStatement pst = c.prepareStatement(sql);
        pst.setString(1, "%" + nome + "%");

        ResultSet rs = pst.executeQuery();
        List<Atividade> listaDeAtividades = retornaListaAtividades(rs);

        liberarRecursos(rs, pst);

        return listaDeAtividades;
    }

    public Atividade buscarUmPorNome(String nome) throws SQLException, ClassNotFoundException {
        c = ConnectionFactory.getConnection();
        String sql = "SELECT id, nome, tipo_atividade, descricao, data_atividade, hora_atividade, id_instrutor\n" +
                "FROM clube.atividades\n" +
                "WHERE nome LIKE ?;";
        PreparedStatement pst = c.prepareStatement(sql);
        pst.setString(1, "%" + nome + "%");

        ResultSet rs = pst.executeQuery();
        Atividade atividade = null;
        if (rs.next()) {
            atividade = new Atividade();
            atividade.setId(rs.getInt("id"));
            atividade.setNome(rs.getString("nome"));
            atividade.setTipoAtividade(ETipoAtividades.valueOf(rs.getString("tipo_atividade")));
            atividade.setDescricao(rs.getString("descricao"));
            String dataAtividade = rs.getString("data_atividade");
            if (dataAtividade != null && !dataAtividade.isBlank()) {
                atividade.setDataAtividade(FormataData.dbFormataStringParaDataBase(dataAtividade));
            }

            String horaAtividade = rs.getString("hora_atividade");
            if (horaAtividade != null && !horaAtividade.isBlank()) {
                atividade.setHoraAtividade(FormataHora.dbFormataHoraParaString(horaAtividade));
            }
            atividade.setIdInstrutor(rs.getInt("id_instrutor"));
        }

        liberarRecursos(rs, pst);

        return atividade;
    }

    public List<Atividade> buscarPorTipo(ETipoAtividades tipoAtividade) throws SQLException, ClassNotFoundException {
        c = ConnectionFactory.getConnection();
        String sql = "SELECT id, nome, tipo_atividade, descricao, data_atividade, hora_atividade, id_instrutor\n" +
                "FROM clube.atividades\n" +
                "WHERE tipo_atividade=?;";
        PreparedStatement pst = c.prepareStatement(sql);
        pst.setString(1, tipoAtividade.toString());

        ResultSet rs = pst.executeQuery();
        List<Atividade> listaDeAtividades = retornaListaAtividades(rs);

        liberarRecursos(rs, pst);

        return listaDeAtividades;
    }

    public List<Atividade> buscarPorData(String dataDaAtividade) throws SQLException, ClassNotFoundException {
        c = ConnectionFactory.getConnection();
        String sql = "SELECT id, nome, tipo_atividade, descricao, data_atividade, hora_atividade, id_instrutor\n" +
                "FROM clube.atividades\n" +
                "WHERE data_atividade=?;";
        PreparedStatement pst = c.prepareStatement(sql);
        pst.setString(1, FormataData.formataDataParaBuscaNaBase(dataDaAtividade));

        ResultSet rs = pst.executeQuery();
        List<Atividade> listaDeAtividades = retornaListaAtividades(rs);

        liberarRecursos(rs, pst);

        return listaDeAtividades;
    }

    private static List<Atividade> retornaListaAtividades(ResultSet rs) throws SQLException {
        List<Atividade> listaDeAtividades = new ArrayList<>();
        while(rs.next()) {
            String dataAtividade = rs.getString("data_atividade");
            String dtAtv = null;
            if (dataAtividade != null && !dataAtividade.isBlank()) {
                dtAtv = FormataData.dbFormataStringParaDataBase(dataAtividade);
            }

            String horaAtividade = rs.getString("hora_atividade");
            String hrAtv = null;
            if (horaAtividade != null && !horaAtividade.isBlank()) {
                hrAtv = FormataHora.dbFormataHoraParaString(horaAtividade);
            }

            Atividade atividade = new Atividade(
                    rs.getInt("id"),
                    rs.getString("nome"),
                    ETipoAtividades.valueOf(rs.getString("tipo_atividade")),
                    rs.getString("descricao"),
                    dtAtv,
                    hrAtv,
                    rs.getInt("id_instrutor")
            );

            listaDeAtividades.add(atividade);
        }

        return listaDeAtividades;
    }

    @Override
    public int contar() throws SQLException, ClassNotFoundException {
        c = ConnectionFactory.getConnection();
        String sql = "SELECT COUNT(*) quantidade\n" +
                "FROM clube.atividades;";
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
