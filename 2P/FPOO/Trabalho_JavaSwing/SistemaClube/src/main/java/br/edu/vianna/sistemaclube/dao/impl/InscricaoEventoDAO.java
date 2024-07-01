package br.edu.vianna.sistemaclube.dao.impl;

import br.edu.vianna.sistemaclube.dao.IGenericDAO;
import br.edu.vianna.sistemaclube.dao.dbconnection.ConnectionFactory;
import br.edu.vianna.sistemaclube.dao.impl.usuariodao.MembroDAO;
import br.edu.vianna.sistemaclube.model.eventos.Evento;
import br.edu.vianna.sistemaclube.model.inscricoes.InscricaoEvento;
import br.edu.vianna.sistemaclube.model.usuarios.Membro;
import br.edu.vianna.sistemaclube.utils.datahora.FormataData;
import br.edu.vianna.sistemaclube.utils.datahora.FormataHora;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class InscricaoEventoDAO implements IGenericDAO<InscricaoEvento, Integer> {
    private Connection c;

    @Override
    public void inserir(InscricaoEvento inscricaoEvento) throws SQLException, ClassNotFoundException {
        c = ConnectionFactory.getConnection();
        String sql = "INSERT INTO clube.inscricoes_eventos\n" +
                "(id_membro, id_evento, data_inscricao, hora_inscricao)\n" +
                "VALUES(?, ?, ?, ?);";
        PreparedStatement pst = c.prepareStatement(sql, Statement.RETURN_GENERATED_KEYS);
        pst.setInt(1, inscricaoEvento.getMembro().getId());
        pst.setInt(2, inscricaoEvento.getEvento().getId());
        pst.setString(3, inscricaoEvento.getDataInscricao());
        pst.setString(4, inscricaoEvento.getHoraInscricao());

        pst.execute();

        try (ResultSet generatedKeys = pst.getGeneratedKeys()) {
            if (generatedKeys.next()) {
                int idGeradoPeloInsert = generatedKeys.getInt(1);
                inscricaoEvento.setId(idGeradoPeloInsert);
            }
        }
    }

    @Override
    public void alterar(InscricaoEvento inscricaoEvento) throws SQLException, ClassNotFoundException {
        c = ConnectionFactory.getConnection();
        String sql = "UPDATE clube.inscricoes_eventos\n" +
                "SET id_membro=?, id_evento=?, data_inscricao=?, hora_inscricao=?\n" +
                "WHERE id=?;";
        PreparedStatement pst = c.prepareStatement(sql);
        pst.setInt(1, inscricaoEvento.getMembro().getId());
        pst.setInt(2, inscricaoEvento.getEvento().getId());
        pst.setString(3, inscricaoEvento.getDataInscricao());
        pst.setString(4, inscricaoEvento.getHoraInscricao());
        pst.setInt(5, inscricaoEvento.getId());

        pst.execute();
    }

    @Override
    public void apagar(InscricaoEvento inscricaoEvento) throws SQLException, ClassNotFoundException {
        c = ConnectionFactory.getConnection();
        String sql = "DELETE FROM clube.inscricoes_eventos\n" +
                "WHERE id=?;";
        PreparedStatement pst = c.prepareStatement(sql);
        pst.setInt(1, inscricaoEvento.getId());

        pst.execute();
    }

    @Override
    public InscricaoEvento buscarPorId(Integer id) throws SQLException, ClassNotFoundException {
        c = ConnectionFactory.getConnection();
        String sql = "SELECT id, id_membro, id_evento, data_inscricao, hora_inscricao\n" +
                "FROM clube.inscricoes_eventos\n" +
                "WHERE id=?;";
        PreparedStatement pst = c.prepareStatement(sql);
        pst.setInt(1, id);

        ResultSet rs = pst.executeQuery();
        InscricaoEvento inscricaoEvento = null;
        if (rs.next()) {
            inscricaoEvento = new InscricaoEvento();
            inscricaoEvento.setId(rs.getInt("id"));

            Membro membro = new MembroDAO().buscarPorId(rs.getInt("id_membro"));
            inscricaoEvento.setMembro(membro);

            int idEvento = rs.getInt("id_evento");
            Evento evento = (idEvento != 0) ? new EventoDAO().buscarPorId(idEvento) : null;
            inscricaoEvento.setEvento(evento);

            String dataInscricao = rs.getString("data_inscricao");
            if (dataInscricao != null && !dataInscricao.isBlank()) {
                inscricaoEvento.setDataInscricao(FormataData.dbFormataStringParaDataBase(dataInscricao));
            }
            String horaInscricao = rs.getString("hora_inscricao");
            if (horaInscricao != null && !horaInscricao.isBlank()) {
                inscricaoEvento.setHoraInscricao(FormataHora.dbFormataHoraParaString(horaInscricao));
            }
        }

        return inscricaoEvento;
    }

    @Override
    public List<InscricaoEvento> buscarTodos() throws SQLException, ClassNotFoundException {
        c = ConnectionFactory.getConnection();
        String sql = "SELECT id, id_membro, id_evento, data_inscricao, hora_inscricao\n" +
                "FROM clube.inscricoes_eventos;";
        PreparedStatement pst = c.prepareStatement(sql);
        ResultSet rs = pst.executeQuery();

        List<InscricaoEvento> listaDeInscricoes = retornaListaInscricoes(rs);

        return listaDeInscricoes;
    }

    public List<InscricaoEvento> buscarTodosPorIdMembro(int id) throws SQLException, ClassNotFoundException {
        c = ConnectionFactory.getConnection();
        String sql = "SELECT id, id_membro, id_evento, data_inscricao, hora_inscricao\n" +
                "FROM clube.inscricoes_eventos\n" +
                "WHERE id_membro=?;";
        PreparedStatement pst = c.prepareStatement(sql);
        pst.setInt(1, id);

        ResultSet rs = pst.executeQuery();
        List<InscricaoEvento> listaDeInscricoes = retornaListaInscricoes(rs);

        return listaDeInscricoes;
    }

    public List<InscricaoEvento> buscarPorData(String dataDaInscricao) throws SQLException, ClassNotFoundException {
        c = ConnectionFactory.getConnection();
        String sql = "SELECT id, id_membro, id_evento, data_inscricao, hora_inscricao\n" +
                "FROM clube.inscricoes_eventos\n" +
                "WHERE data_inscricao=?;";
        PreparedStatement pst = c.prepareStatement(sql);
        pst.setString(1, FormataData.formataDataParaBuscaNaBase(dataDaInscricao));

        ResultSet rs = pst.executeQuery();
        List<InscricaoEvento> listaDeInscricoes = retornaListaInscricoes(rs);

        return listaDeInscricoes;
    }

    public List<InscricaoEvento> buscarPorNomeDoMembro(String nomeMembro) throws SQLException, ClassNotFoundException {
        c = ConnectionFactory.getConnection();
        String sql = "SELECT ins.id, ins.id_membro, ins.id_evento, ins.data_inscricao, ins.hora_inscricao\n" +
                "FROM clube.inscricoes_eventos AS ins\n" +
                "INNER JOIN membros AS m ON ins.id_membro = m.id\n" +
                "WHERE m.nome=?;";
        PreparedStatement pst = c.prepareStatement(sql);
        pst.setString(1, nomeMembro);

        ResultSet rs = pst.executeQuery();
        List<InscricaoEvento> listaDeInscricoes = retornaListaInscricoes(rs);

        return listaDeInscricoes;
    }

    private static List<InscricaoEvento> retornaListaInscricoes(ResultSet rs) throws SQLException, ClassNotFoundException {
        List<InscricaoEvento> listaDeInscricoes = new ArrayList<>();
        while(rs.next()) {
            Membro membro = new MembroDAO().buscarPorId(rs.getInt("id_membro"));
            int idEvento = rs.getInt("id_evento");
            Evento evento = (idEvento != 0) ? new EventoDAO().buscarPorId(idEvento) : null;
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

            InscricaoEvento inscricaoEvento = new InscricaoEvento(
                    rs.getInt("id"),
                    membro,
                    evento,
                    dtInsc,
                    hrIns
            );

            listaDeInscricoes.add(inscricaoEvento);
        }
        return listaDeInscricoes;
    }

    @Override
    public int contar() throws SQLException, ClassNotFoundException {
        c = ConnectionFactory.getConnection();
        String sql = "SELECT COUNT(*) quantidade\n" +
                "FROM clube.inscricoes_eventos;";
        PreparedStatement pst = c.prepareStatement(sql);
        ResultSet rs = pst.executeQuery();
        rs.next();

        return rs.getInt("quantidade");
    }
}

