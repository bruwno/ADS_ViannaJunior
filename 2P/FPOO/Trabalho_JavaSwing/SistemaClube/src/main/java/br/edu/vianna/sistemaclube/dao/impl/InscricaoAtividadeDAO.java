package br.edu.vianna.sistemaclube.dao.impl;

import br.edu.vianna.sistemaclube.dao.IGenericDAO;
import br.edu.vianna.sistemaclube.dao.dbconnection.ConnectionFactory;
import br.edu.vianna.sistemaclube.dao.impl.usuariodao.MembroDAO;
import br.edu.vianna.sistemaclube.model.atividades.Atividade;
import br.edu.vianna.sistemaclube.model.atividades.ETipoAtividades;
import br.edu.vianna.sistemaclube.model.inscricoes.InscricaoAtividade;
import br.edu.vianna.sistemaclube.model.usuarios.Membro;
import br.edu.vianna.sistemaclube.utils.datahora.FormataData;
import br.edu.vianna.sistemaclube.utils.datahora.FormataHora;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class InscricaoAtividadeDAO implements IGenericDAO<InscricaoAtividade, Integer> {
    private Connection c;

    @Override
    public void inserir(InscricaoAtividade inscricaoAtividade) throws SQLException, ClassNotFoundException {
        c = ConnectionFactory.getConnection();
        String sql = "INSERT INTO clube.inscricoes_atividades\n" +
                "(id_membro, id_atividade, data_inscricao, hora_inscricao, atividade_avaliada)\n" +
                "VALUES(?, ?, ?, ?, ?);";
        PreparedStatement pst = c.prepareStatement(sql, Statement.RETURN_GENERATED_KEYS);
        pst.setInt(1, inscricaoAtividade.getMembro().getId());
        pst.setInt(2, inscricaoAtividade.getAtividade().getId());
        pst.setString(3, inscricaoAtividade.getDataInscricao());
        pst.setString(4, inscricaoAtividade.getHoraInscricao());
        pst.setBoolean(5, inscricaoAtividade.isAtividadeAvaliada());

        pst.execute();

        try (ResultSet generatedKeys = pst.getGeneratedKeys()) {
            if (generatedKeys.next()) {
                int idGeradoPeloInsert = generatedKeys.getInt(1);
                inscricaoAtividade.setId(idGeradoPeloInsert);
            }
        }

        pst.close();
        c.close();
    }

    @Override
    public void alterar(InscricaoAtividade inscricaoAtividade) throws SQLException, ClassNotFoundException {
        c = ConnectionFactory.getConnection();
        String sql = "UPDATE clube.inscricoes_atividades\n" +
                "SET id_membro=?, id_atividade=?, data_inscricao=?, hora_inscricao=?, atividade_avaliada=?\n" +
                "WHERE id=?;";
        PreparedStatement pst = c.prepareStatement(sql);
        pst.setInt(1, inscricaoAtividade.getMembro().getId());
        pst.setInt(2, inscricaoAtividade.getAtividade().getId());
        pst.setString(3, inscricaoAtividade.getDataInscricao());
        pst.setString(4, inscricaoAtividade.getHoraInscricao());
        pst.setBoolean(5, inscricaoAtividade.isAtividadeAvaliada());
        pst.setInt(6, inscricaoAtividade.getId());

        pst.execute();

        pst.close();
        c.close();
    }

    @Override
    public void apagar(InscricaoAtividade inscricaoEvento) throws SQLException, ClassNotFoundException {
        c = ConnectionFactory.getConnection();
        String sql = "DELETE FROM clube.inscricoes_atividades\n" +
                "WHERE id=?;";
        PreparedStatement pst = c.prepareStatement(sql);
        pst.setInt(1, inscricaoEvento.getId());

        pst.execute();
    }

    public void apagar(int id) throws SQLException, ClassNotFoundException {
        c = ConnectionFactory.getConnection();
        String sql = "DELETE FROM clube.inscricoes_atividades\n" +
                "WHERE id=?;";
        PreparedStatement pst = c.prepareStatement(sql);
        pst.setInt(1, id);

        pst.execute();
    }

    @Override
    public InscricaoAtividade buscarPorId(Integer id) throws SQLException, ClassNotFoundException {
        c = ConnectionFactory.getConnection();
        String sql = "SELECT id, id_membro, id_atividade, data_inscricao, hora_inscricao, atividade_avaliada\n" +
                "FROM clube.inscricoes_atividades\n" +
                "WHERE id=?;";
        PreparedStatement pst = c.prepareStatement(sql);
        pst.setInt(1, id);

        ResultSet rs = pst.executeQuery();
        InscricaoAtividade inscricaoAtividade = null;
        if (rs.next()) {
            inscricaoAtividade = new InscricaoAtividade();
            inscricaoAtividade.setId(rs.getInt("id"));

            Membro membro = new MembroDAO().buscarPorId(rs.getInt("id_membro"));
            inscricaoAtividade.setMembro(membro);

            int idAtividade = rs.getInt("id_atividade");
            Atividade atividade = (idAtividade != 0) ? new AtividadeDAO().buscarPorId(idAtividade) : null;
            inscricaoAtividade.setAtividade(atividade);

            String dataInscricao = rs.getString("data_inscricao");
            if (dataInscricao != null && !dataInscricao.isBlank()) {
                inscricaoAtividade.setDataInscricao(FormataData.dbFormataStringParaDataBase(dataInscricao));
            }
            String horaInscricao = rs.getString("hora_inscricao");
            if (horaInscricao != null && !horaInscricao.isBlank()) {
                inscricaoAtividade.setHoraInscricao(FormataHora.dbFormataHoraParaString(horaInscricao));
            }

            inscricaoAtividade.setAtividadeAvaliada(rs.getBoolean("atividade_avaliada"));
        }

        liberarRecursos(rs, pst);

        return inscricaoAtividade;
    }

    @Override
    public List<InscricaoAtividade> buscarTodos() throws SQLException, ClassNotFoundException {
        c = ConnectionFactory.getConnection();
        String sql = "SELECT id, id_membro, id_atividade, data_inscricao, hora_inscricao, atividade_avaliada\n" +
                "FROM clube.inscricoes_atividades;";
        PreparedStatement pst = c.prepareStatement(sql);
        ResultSet rs = pst.executeQuery();

        List<InscricaoAtividade> listaDeInscricoes = retornaListaInscricoes(rs);

        liberarRecursos(rs, pst);

        return listaDeInscricoes;
    }

    public List<InscricaoAtividade> buscarTodosPorIdMembro(int id) throws SQLException, ClassNotFoundException {
        c = ConnectionFactory.getConnection();
        String sql = "SELECT id, id_membro, id_atividade, data_inscricao, hora_inscricao, atividade_avaliada\n" +
                "FROM clube.inscricoes_atividades\n" +
                "WHERE id_membro=?;";
        PreparedStatement pst = c.prepareStatement(sql);
        pst.setInt(1, id);

        ResultSet rs = pst.executeQuery();
        List<InscricaoAtividade> listaDeInscricoes = retornaListaInscricoes(rs);

        liberarRecursos(rs, pst);

        return listaDeInscricoes;
    }

    public List<InscricaoAtividade> buscarPorData(String dataDaInscricao) throws SQLException, ClassNotFoundException {
        c = ConnectionFactory.getConnection();
        String sql = "SELECT id, id_membro, id_atividade, data_inscricao, hora_inscricao, atividade_avaliada\n" +
                "FROM clube.inscricoes_atividades\n" +
                "WHERE data_inscricao=?;";
        PreparedStatement pst = c.prepareStatement(sql);
        pst.setString(1, FormataData.formataDataParaBuscaNaBase(dataDaInscricao));

        ResultSet rs = pst.executeQuery();
        List<InscricaoAtividade> listaDeInscricoes = retornaListaInscricoes(rs);

        liberarRecursos(rs, pst);

        return listaDeInscricoes;
    }

    public List<InscricaoAtividade> buscarPorTipo(ETipoAtividades tipoAtividade) throws SQLException, ClassNotFoundException {
        c = ConnectionFactory.getConnection();
        String sql = "SELECT ia.id, ia.id_membro, ia.id_atividade, ia.data_inscricao, ia.hora_inscricao, ia.atividade_avaliada\n" +
                "FROM clube.inscricoes_atividades AS ia\n" +
                "INNER JOIN atividades AS a ON ia.id_atividade = a.id\n" +
                "WHERE a.tipo_atividade=?;";
        PreparedStatement pst = c.prepareStatement(sql);
        pst.setString(1, tipoAtividade.toString());

        ResultSet rs = pst.executeQuery();
        List<InscricaoAtividade> listaDeInscricoes = retornaListaInscricoes(rs);

        liberarRecursos(rs, pst);

        return listaDeInscricoes;
    }

    public List<InscricaoAtividade> buscarPorNomeDoMembro(String nomeMembro) throws SQLException, ClassNotFoundException {
        c = ConnectionFactory.getConnection();
        String sql = "SELECT ins.id, ins.id_membro, ins.id_atividade, ins.data_inscricao, ins.hora_inscricao, ins.atividade_avaliada, m.nome\n" +
                "FROM clube.inscricoes_atividades AS ins\n" +
                "INNER JOIN membros AS m ON ins.id_membro = m.id\n" +
                "WHERE m.nome LIKE ?;";
        PreparedStatement pst = c.prepareStatement(sql);
        pst.setString(1, "%" + nomeMembro + "%");

        ResultSet rs = pst.executeQuery();
        List<InscricaoAtividade> listaDeInscricoes = retornaListaInscricoes(rs);

        liberarRecursos(rs, pst);

        return listaDeInscricoes;
    }

    public List<InscricaoAtividade> buscarPorNomeAtividade(String nomeAtividade) throws SQLException, ClassNotFoundException {
        c = ConnectionFactory.getConnection();
        String sql = "SELECT ins.id, ins.id_membro, ins.id_atividade, ins.data_inscricao, ins.hora_inscricao, ins.atividade_avaliada\n" +
                "FROM clube.inscricoes_atividades AS ins\n" +
                "INNER JOIN atividades AS a ON ins.id_atividade = a.id\n" +
                "WHERE a.nome LIKE ?;";
        PreparedStatement pst = c.prepareStatement(sql);
        pst.setString(1, "%" + nomeAtividade + "%");

        ResultSet rs = pst.executeQuery();
        List<InscricaoAtividade> listaDeInscricoes = retornaListaInscricoes(rs);

        liberarRecursos(rs, pst);

        return listaDeInscricoes;
    }

    private List<InscricaoAtividade> retornaListaInscricoes(ResultSet rs) throws SQLException, ClassNotFoundException {
        List<InscricaoAtividade> listaDeInscricoes = new ArrayList<>();
        while(rs.next()) {
            Membro membro = new MembroDAO().buscarPorId(rs.getInt("id_membro"));
            int idAtividade = rs.getInt("id_atividade");
            Atividade atividade = (idAtividade != 0) ? new AtividadeDAO().buscarPorId(idAtividade) : null;
            String dataInscricao = rs.getString("data_inscricao");
            String dtInsc = null;
            if (dataInscricao != null && !dataInscricao.isBlank()) {
                dtInsc = FormataData.dbFormataStringParaDataBase(dataInscricao);
            }
            String horaInscricao = rs.getString("hora_inscricao");
            String hrIns = null;
            if (horaInscricao != null && !horaInscricao.isBlank()) {
                hrIns = FormataHora.dbFormataHoraParaString(horaInscricao);
            }
            boolean atividadeAvaliada = rs.getBoolean("atividade_avaliada");

            InscricaoAtividade inscricaoAtividade = new InscricaoAtividade(
                    rs.getInt("id"),
                    membro,
                    atividade,
                    dtInsc,
                    hrIns,
                    atividadeAvaliada
            );

            listaDeInscricoes.add(inscricaoAtividade);
        }

        return listaDeInscricoes;
    }

    public List<InscricaoAtividade> retornarAtividadesAindaNaoAvaliadas() throws SQLException, ClassNotFoundException {
        c = ConnectionFactory.getConnection();
        String sql = "SELECT id, id_membro, id_atividade, data_inscricao, hora_inscricao, atividade_avaliada\n" +
                "FROM clube.inscricoes_atividades\n" +
                "WHERE atividade_avaliada=0;";
        PreparedStatement pst = c.prepareStatement(sql);

        ResultSet rs = pst.executeQuery();
        List<InscricaoAtividade> listaDeInscricoes = retornaListaInscricoes(rs);

        liberarRecursos(rs, pst);

        return listaDeInscricoes;
    }

    public void atualizarEstadoAvaliacao(int id, boolean estado) throws SQLException, ClassNotFoundException {
        c = ConnectionFactory.getConnection();
        String sql = "UPDATE clube.inscricoes_atividades\n" +
                "SET atividade_avaliada=?\n" +
                "WHERE id=?;";
        PreparedStatement pst = c.prepareStatement(sql);
        pst.setBoolean(1, estado);
        pst.setInt(2, id);

        pst.execute();

        pst.close();
        c.close();
    }

    @Override
    public int contar() throws SQLException, ClassNotFoundException {
        c = ConnectionFactory.getConnection();
        String sql = "SELECT COUNT(*) quantidade\n" +
                "FROM clube.inscricoes_atividades;";
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
