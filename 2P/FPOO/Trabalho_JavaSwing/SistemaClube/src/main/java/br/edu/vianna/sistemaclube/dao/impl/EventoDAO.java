package br.edu.vianna.sistemaclube.dao.impl;

import br.edu.vianna.sistemaclube.dao.IGenericDAO;
import br.edu.vianna.sistemaclube.dao.dbconnection.ConnectionFactory;
import br.edu.vianna.sistemaclube.model.eventos.Evento;
import br.edu.vianna.sistemaclube.utils.datahora.FormataData;
import br.edu.vianna.sistemaclube.utils.datahora.FormataHora;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class EventoDAO implements IGenericDAO<Evento, Integer>  {
    private Connection c;

    @Override
    public void inserir(Evento evento) throws SQLException, ClassNotFoundException {
        c = ConnectionFactory.getConnection();
        String sql = "INSERT INTO clube.eventos\n" +
                "(nome, descricao, data_evento, hora_evento, id_instrutor)\n" +
                "VALUES(?, ?, ?, ?, ?);";
        PreparedStatement pst = c.prepareStatement(sql, Statement.RETURN_GENERATED_KEYS);
        pst.setString(1, evento.getNome());
        pst.setString(2, evento.getDescricao());
        pst.setString(3, evento.getDataEvento());
        pst.setString(4, evento.getHoraEvento());
        pst.setInt(5, evento.getIdInstrutor());

        pst.execute();

        try (ResultSet generatedKeys = pst.getGeneratedKeys()) {
            if (generatedKeys.next()) {
                int idGeradoPeloInsert = generatedKeys.getInt(1);
                evento.setId(idGeradoPeloInsert);
            }
        }

        pst.close();
        c.close();
    }

    @Override
    public void alterar(Evento evento) throws SQLException, ClassNotFoundException {
        c = ConnectionFactory.getConnection();
        String sql = "UPDATE clube.eventos\n" +
                "SET nome=?, descricao=?, data_evento=?, hora_evento=?, id_instrutor=?\n" +
                "WHERE id=?;";
        PreparedStatement pst = c.prepareStatement(sql);
        pst.setString(1, evento.getNome());
        pst.setString(2, evento.getDescricao());
        pst.setString(3, evento.getDataEvento());
        pst.setString(4, evento.getHoraEvento());
        pst.setInt(5, evento.getIdInstrutor());
        pst.setInt(6, evento.getId());

        pst.execute();

        pst.close();
        c.close();
    }

    @Override
    public void apagar(Evento evento) throws SQLException, ClassNotFoundException {
        c = ConnectionFactory.getConnection();
        String sql = "DELETE FROM clube.eventos\n" +
                "WHERE id=?;";
        PreparedStatement pst = c.prepareStatement(sql);
        pst.setInt(1, evento.getId());
        pst.execute();

        pst.close();
        c.close();
    }

    public void apagar(int id) throws SQLException, ClassNotFoundException {
        c = ConnectionFactory.getConnection();
        String sql = "DELETE FROM clube.eventos\n" +
                "WHERE id=?;";
        PreparedStatement pst = c.prepareStatement(sql);
        pst.setInt(1, id);
        pst.execute();

        pst.close();
        c.close();
    }

    @Override
    public Evento buscarPorId(Integer id) throws SQLException, ClassNotFoundException {
        c = ConnectionFactory.getConnection();
        String sql = "SELECT id, nome, descricao, data_evento, hora_evento, id_instrutor\n" +
                "FROM clube.eventos\n" +
                "WHERE id=?;";
        PreparedStatement pst = c.prepareStatement(sql);
        pst.setInt(1, id);

        ResultSet rs = pst.executeQuery();
        Evento evento = null;
        if (rs.next()) {
            evento = new Evento();
            evento.setId(rs.getInt("id"));
            evento.setNome(rs.getString("nome"));
            evento.setDescricao(rs.getString("descricao"));
            String dataEvento = rs.getString("data_evento");
            if (dataEvento != null && !dataEvento.isBlank()) {
                evento.setDataEvento(FormataData.dbFormataStringParaDataBase(dataEvento));
            }
            String horaEvento = rs.getString("hora_evento");
            if (horaEvento != null && !horaEvento.isBlank()) {
                evento.setHoraEvento(FormataHora.dbFormataHoraParaString(horaEvento));
            }
            evento.setIdInstrutor(rs.getInt("id_instrutor"));
        }

        liberarRecursos(rs, pst);

        return evento;
    }

    @Override
    public List<Evento> buscarTodos() throws SQLException, ClassNotFoundException {
        c = ConnectionFactory.getConnection();
        String sql = "SELECT id, nome, descricao, data_evento, hora_evento, id_instrutor\n" +
                "FROM clube.eventos;";
        PreparedStatement pst = c.prepareStatement(sql);
        ResultSet rs = pst.executeQuery();

        List<Evento> listaDeEventos = retornaListaEventos(rs);

        liberarRecursos(rs, pst);

        return listaDeEventos;
    }

    public List<Evento> buscarPorNome(String nome) throws SQLException, ClassNotFoundException {
        c = ConnectionFactory.getConnection();
        String sql = "SELECT id, nome, descricao, data_evento, hora_evento, id_instrutor\n" +
                "FROM clube.eventos\n" +
                "WHERE nome LIKE ?;";
        PreparedStatement pst = c.prepareStatement(sql);
        pst.setString(1, "%"  + nome + "%");

        ResultSet rs = pst.executeQuery();
        List<Evento> listaDeEventos = retornaListaEventos(rs);

        liberarRecursos(rs, pst);

        return listaDeEventos;
    }

    public List<Evento> buscarPorData(String dataDoEvento) throws SQLException, ClassNotFoundException {
        c = ConnectionFactory.getConnection();
        String sql = "SELECT id, nome, descricao, data_evento, hora_evento, id_instrutor\n" +
                "FROM clube.eventos\n" +
                "WHERE data_evento=?;";
        PreparedStatement pst = c.prepareStatement(sql);
        pst.setString(1, FormataData.formataDataParaBuscaNaBase(dataDoEvento));

        ResultSet rs = pst.executeQuery();
        List<Evento> listaDeEventos = retornaListaEventos(rs);

        return listaDeEventos;
    }

    public List<Evento> buscarPorHorario(String horarioDoEvento) throws SQLException, ClassNotFoundException {
        c = ConnectionFactory.getConnection();
        String sql = "SELECT id, nome, descricao, data_evento, hora_evento, id_instrutor\n" +
                "FROM clube.eventos\n" +
                "WHERE hora_evento=?;";
        PreparedStatement pst = c.prepareStatement(sql);
        pst.setString(1, FormataHora.formataHoraParaBuscaNaBase(horarioDoEvento));

        ResultSet rs = pst.executeQuery();
        List<Evento> listaDeEventos = retornaListaEventos(rs);

        liberarRecursos(rs, pst);

        return listaDeEventos;
    }

    private static List<Evento> retornaListaEventos(ResultSet rs) throws SQLException {
        List<Evento> listaDeEventos = new ArrayList<>();
        while(rs.next()) {
            String dataEvento = rs.getString("data_evento");
            String dtEvt = null;
            if (dataEvento != null && !dataEvento.isBlank()) {
                dtEvt = FormataData.dbFormataStringParaDataBase(dataEvento);
            }

            String horaEvento = rs.getString("hora_evento");
            String hrEvt = null;
            if (horaEvento != null && !horaEvento.isBlank()) {
                hrEvt = FormataHora.dbFormataHoraParaString(horaEvento);
            }

            Evento evento = new Evento(
                    rs.getInt("id"),
                    rs.getString("nome"),
                    rs.getString("descricao"),
                    dtEvt,
                    hrEvt,
                    rs.getInt("id_instrutor")
            );

            listaDeEventos.add(evento);
        }

        return listaDeEventos;
    }

    @Override
    public int contar() throws SQLException, ClassNotFoundException {
        c = ConnectionFactory.getConnection();
        String sql = "SELECT COUNT(*) quantidade\n" +
                "FROM clube.eventos;";
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
