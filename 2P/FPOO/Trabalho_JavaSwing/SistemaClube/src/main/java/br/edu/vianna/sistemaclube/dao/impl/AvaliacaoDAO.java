package br.edu.vianna.sistemaclube.dao.impl;

import br.edu.vianna.sistemaclube.dao.IGenericDAO;
import br.edu.vianna.sistemaclube.dao.dbconnection.ConnectionFactory;
import br.edu.vianna.sistemaclube.model.associados.ETipoAssociado;
import br.edu.vianna.sistemaclube.model.atividades.Atividade;
import br.edu.vianna.sistemaclube.model.atividades.ETipoAtividades;
import br.edu.vianna.sistemaclube.model.avaliacoes.Avaliacao;
import br.edu.vianna.sistemaclube.model.instrutores.EEspecializacao;
import br.edu.vianna.sistemaclube.model.usuarios.Instrutor;
import br.edu.vianna.sistemaclube.model.usuarios.Membro;
import br.edu.vianna.sistemaclube.utils.datahora.FormataData;
import br.edu.vianna.sistemaclube.utils.datahora.FormataDataHora;
import br.edu.vianna.sistemaclube.utils.datahora.FormataHora;

import java.sql.*;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

public class AvaliacaoDAO implements IGenericDAO<Avaliacao, Integer> {
    private Connection c;

    @Override
    public void inserir(Avaliacao avaliacao) throws SQLException, ClassNotFoundException {
        c = ConnectionFactory.getConnection();
        String sql = "INSERT INTO clube.avaliacoes\n" +
                "(id_membro, id_atividade, id_instrutor, nota, descricao, presente, data_hora_avaliacao)\n" +
                "VALUES(?, ?, ?, ?, ?, ?, ?);";
        PreparedStatement pst = c.prepareStatement(sql, Statement.RETURN_GENERATED_KEYS);
        pst.setInt(1, avaliacao.getMembro().getId());
        pst.setInt(2, avaliacao.getAtividade().getId());
        pst.setInt(3, avaliacao.getInstrutor().getId());
        pst.setInt(4, avaliacao.getNota());
        pst.setString(5, avaliacao.getComentarioAvaliador());
        pst.setBoolean(6, avaliacao.isPresente());
        pst.setString(7, avaliacao.getDataHoraAvaliacao());

        pst.execute();

        try (ResultSet generatedKeys = pst.getGeneratedKeys()) {
            if (generatedKeys.next()) {
                int idGeradoPeloInsert = generatedKeys.getInt(1);
                avaliacao.setId(idGeradoPeloInsert);
            }
        }

        pst.close();
        c.close();
    }

    @Override
    public void alterar(Avaliacao avaliacao) throws SQLException, ClassNotFoundException {
        c = ConnectionFactory.getConnection();
        String sql = "UPDATE clube.avaliacoes\n" +
                "SET id_membro=?, id_atividade=?, id_instrutor=?, nota=?, descricao=?, presente=?, data_hora_avaliacao=?\n" +
                "WHERE id=?;";
        PreparedStatement pst = c.prepareStatement(sql);
        pst.setInt(1, avaliacao.getMembro().getId());
        pst.setInt(2, avaliacao.getAtividade().getId());
        pst.setInt(3, avaliacao.getInstrutor().getId());
        pst.setInt(4, avaliacao.getNota());
        pst.setString(5, avaliacao.getComentarioAvaliador());
        pst.setBoolean(6, avaliacao.isPresente());
        pst.setString(7, avaliacao.getDataHoraAvaliacao());
        pst.setInt(8, avaliacao.getId());

        pst.execute();

        pst.close();
        c.close();
    }

    @Override
    public void apagar(Avaliacao avaliacao) throws SQLException, ClassNotFoundException {
        c = ConnectionFactory.getConnection();
        String sql = "DELETE FROM clube.avaliacoes\n" +
                "WHERE id=?;";
        PreparedStatement pst = c.prepareStatement(sql);
        pst.setInt(1, avaliacao.getId());
        pst.execute();

        pst.close();
        c.close();
    }

    @Override
    public Avaliacao buscarPorId(Integer id) throws SQLException, ClassNotFoundException {
        c = ConnectionFactory.getConnection();
        String sql = "SELECT a.*, m.*, at.*, i.*\n" +
                "FROM clube.avaliacoes AS a\n" +
                "INNER JOIN clube.membros AS m ON a.id_membro = m.id\n" +
                "INNER JOIN clube.atividades AS at ON a.id_atividade = at.id\n" +
                "INNER JOIN clube.instrutores AS i ON a.id_instrutor = i.id\n" +
                "WHERE a.id=?;";
        PreparedStatement pst = c.prepareStatement(sql);
        pst.setInt(1, id);

        ResultSet rs = pst.executeQuery();
        Avaliacao avaliacao = getAvaliacaoComJoin(rs);

        liberarRecursos(rs, pst);

        return avaliacao;
    }

    public List<Avaliacao> buscarTodosPorIdMembro(int id) throws SQLException, ClassNotFoundException {
        c = ConnectionFactory.getConnection();
        String sql = "SELECT a.*, m.*, at.*, i.*\n" +
                "FROM clube.avaliacoes AS a\n" +
                "INNER JOIN clube.membros AS m ON a.id_membro = m.id\n" +
                "INNER JOIN clube.atividades AS at ON a.id_atividade = at.id\n" +
                "INNER JOIN clube.instrutores AS i ON a.id_instrutor = i.id\n" +
                "WHERE a.id_membro=?;";

        PreparedStatement pst = c.prepareStatement(sql);
        pst.setInt(1, id);

        ResultSet rs = pst.executeQuery();
        List<Avaliacao> listaDeAvaliacoes = retornaListaAvaliacoes(rs);

        liberarRecursos(rs, pst);

        return listaDeAvaliacoes;
    }

    public List<Avaliacao> buscarPorNome(String nomeMembro) throws SQLException, ClassNotFoundException {
        c = ConnectionFactory.getConnection();
        String sql = "SELECT a.*, m.*, at.*, i.*\n" +
                "FROM clube.avaliacoes AS a\n" +
                "INNER JOIN clube.membros AS m ON a.id_membro = m.id\n" +
                "INNER JOIN clube.atividades AS at ON a.id_atividade = at.id\n" +
                "INNER JOIN clube.instrutores AS i ON a.id_instrutor = i.id\n" +
                "WHERE m.nome LIKE ? OR m.sobrenome LIKE ?;";

        PreparedStatement pst = c.prepareStatement(sql);
        pst.setString(1, "%" + nomeMembro + "%");
        pst.setString(2, "%" + nomeMembro + "%");

        ResultSet rs = pst.executeQuery();
        List<Avaliacao> listaDeAvaliacoes = retornaListaAvaliacoes(rs);

        liberarRecursos(rs, pst);

        return listaDeAvaliacoes;
    }

    @Override
    public List<Avaliacao> buscarTodos() throws SQLException, ClassNotFoundException {
        c = ConnectionFactory.getConnection();
        String sql = "SELECT a.*, m.*, at.*, i.*\n" +
                "FROM clube.avaliacoes AS a\n" +
                "INNER JOIN clube.membros AS m ON a.id_membro = m.id\n" +
                "INNER JOIN clube.atividades AS at ON a.id_atividade = at.id\n" +
                "INNER JOIN clube.instrutores AS i ON a.id_instrutor = i.id;";

        PreparedStatement pst = c.prepareStatement(sql);
        ResultSet rs = pst.executeQuery();

        List<Avaliacao> listaDeAvaliacoes = retornaListaAvaliacoes(rs);

        liberarRecursos(rs, pst);

        return listaDeAvaliacoes;
    }

    private static List<Avaliacao> retornaListaAvaliacoes(ResultSet rs) throws SQLException, ClassNotFoundException {
        List<Avaliacao> listaDeAvaliacoes = new ArrayList<>();
        while (rs.next()) {
            String dataHoraAvaliacao = rs.getString("a.data_hora_avaliacao");
            LocalDateTime dtAvl = null;
            if (dataHoraAvaliacao != null && !dataHoraAvaliacao.isBlank()) {
                dtAvl = FormataDataHora.dbFormataStringParaDataHora(dataHoraAvaliacao);
            }

            String dataNascimentoMembro = rs.getString("m.data_nascimento");
            String dtNascMembro = null;
            if (dataNascimentoMembro != null && !dataNascimentoMembro.isBlank())
            {
                dtNascMembro = (FormataData.dbFormataStringParaDataBase(dataNascimentoMembro));
            }

            String dataRegistroMembro = rs.getString("m.data_registro");
            LocalDateTime dataRegMembro = null;
            if (dataRegistroMembro != null && !dataRegistroMembro.isBlank()) {
                dataRegMembro = FormataDataHora.dbFormataStringParaDataHora(dataRegistroMembro);
            }

            String dataUltimoAcessoMembro = rs.getString("m.data_ultimo_acesso");
            LocalDateTime dataUltAcessoMembro = null;
            if (dataUltimoAcessoMembro != null && !dataUltimoAcessoMembro.isBlank()) {
                dataUltAcessoMembro = FormataDataHora.dbFormataStringParaDataHora(dataUltimoAcessoMembro);
            }

            String dataNascimentoInstrutor = rs.getString("i.data_nascimento");
            String dtNascInstrutor = rs.getString("data_nascimento");
            if (dataNascimentoInstrutor != null && !dataNascimentoInstrutor.isBlank())
            {
                dtNascInstrutor = FormataData.dbFormataStringParaDataBase(dataNascimentoInstrutor);
            }

            String dataRegistroInstrutor = rs.getString("i.data_registro");
            LocalDateTime dataRegInstrutor = null;
            if (dataRegistroInstrutor != null && !dataRegistroInstrutor.isBlank()) {
                dataRegInstrutor = FormataDataHora.dbFormataStringParaDataHora(dataRegistroInstrutor);
            }

            String dataUltimoAcessoInstrutor = rs.getString("i.data_ultimo_acesso");
            LocalDateTime dataUltAcessoInstrutor = null;
            if (dataUltimoAcessoInstrutor != null && !dataUltimoAcessoInstrutor.isBlank()) {
                dataUltAcessoInstrutor = FormataDataHora.dbFormataStringParaDataHora(dataUltimoAcessoInstrutor);
            }

            String dataAtividade = rs.getString("at.data_atividade");
            String dtAtv = null;
            if (dataAtividade != null && !dataAtividade.isBlank()) {
                dtAtv = FormataData.dbFormataStringParaDataBase(dataAtividade);
            }

            String horaAtividade = rs.getString("at.hora_atividade");
            String hrAtv = null;
            if (horaAtividade != null && !horaAtividade.isBlank()) {
                hrAtv = FormataHora.dbFormataHoraParaString(horaAtividade);
            }

            Membro membro = new Membro(
                    rs.getInt("m.id"),
                    rs.getString("m.nome"),
                    rs.getString("m.sobrenome"),
                    rs.getString("m.cpf"),
                    rs.getString("m.email"),
                    rs.getString("m.login"),
                    rs.getString("m.senha"),
                    rs.getDouble("m.valor_associado"),
                    ETipoAssociado.valueOf(rs.getString("m.tipo_associado")),
                    dtNascMembro,
                    dataRegMembro,
                    dataUltAcessoMembro
            );

            Atividade atividade = new Atividade(
                    rs.getInt("at.id"),
                    rs.getString("at.nome"),
                    ETipoAtividades.valueOf(rs.getString("at.tipo_atividade")),
                    rs.getString("at.descricao"),
                    dtAtv,
                    hrAtv,
                    rs.getInt("at.id_instrutor")
            );

            Instrutor instrutor = new Instrutor(
                    rs.getInt("i.id"),
                    rs.getString("i.nome"),
                    rs.getString("i.sobrenome"),
                    rs.getString("i.cpf"),
                    rs.getString("i.email"),
                    rs.getString("i.login"),
                    rs.getString("i.senha"),
                    rs.getDouble("i.salario"),
                    EEspecializacao.valueOf(rs.getString("i.especializacao")),
                    dtNascInstrutor,
                    dataRegInstrutor,
                    dataUltAcessoInstrutor
            );

            Avaliacao avaliacao = new Avaliacao(
                    rs.getInt("a.id"),
                    membro,
                    atividade,
                    instrutor,
                    rs.getInt("a.nota"),
                    rs.getString("a.descricao"),
                    rs.getBoolean("a.presente"),
                    dtAvl
            );

            listaDeAvaliacoes.add(avaliacao);
        }

        return listaDeAvaliacoes;
    }

    @Override
    public int contar() throws SQLException, ClassNotFoundException {
        c = ConnectionFactory.getConnection();
        String sql = "SELECT COUNT(*) quantidade\n" +
                "FROM clube.avaliacoes;";
        PreparedStatement pst = c.prepareStatement(sql);
        ResultSet rs = pst.executeQuery();
        rs.next();

        liberarRecursos(rs, pst);

        return rs.getInt("quantidade");
    }

    private static Avaliacao getAvaliacaoComJoin(ResultSet rs) throws SQLException {
        Avaliacao avaliacao = null;
        if (rs.next()) {
            String dataHoraAvaliacao = rs.getString("a.data_hora_avaliacao");
            LocalDateTime dtAvl = null;
            if (dataHoraAvaliacao != null && !dataHoraAvaliacao.isBlank()) {
                dtAvl = FormataDataHora.dbFormataStringParaDataHora(dataHoraAvaliacao);
            }

            String dataNascimentoMembro = rs.getString("m.data_nascimento");
            String dtNascMembro = null;
            if (dataNascimentoMembro != null && !dataNascimentoMembro.isBlank())
            {
                dtNascMembro = (FormataData.dbFormataStringParaDataBase(dataNascimentoMembro));
            }

            String dataRegistroMembro = rs.getString("m.data_registro");
            LocalDateTime dataRegMembro = null;
            if (dataRegistroMembro != null && !dataRegistroMembro.isBlank()) {
                dataRegMembro = FormataDataHora.dbFormataStringParaDataHora(dataRegistroMembro);
            }

            String dataUltimoAcessoMembro = rs.getString("m.data_ultimo_acesso");
            LocalDateTime dataUltAcessoMembro = null;
            if (dataUltimoAcessoMembro != null && !dataUltimoAcessoMembro.isBlank()) {
                dataUltAcessoMembro = FormataDataHora.dbFormataStringParaDataHora(dataUltimoAcessoMembro);
            }

            String dataNascimentoInstrutor = rs.getString("i.data_nascimento");
            String dtNascInstrutor = rs.getString("data_nascimento");
            if (dataNascimentoInstrutor != null && !dataNascimentoInstrutor.isBlank())
            {
                dtNascInstrutor = FormataData.dbFormataStringParaDataBase(dataNascimentoInstrutor);
            }

            String dataRegistroInstrutor = rs.getString("i.data_registro");
            LocalDateTime dataRegInstrutor = null;
            if (dataRegistroInstrutor != null && !dataRegistroInstrutor.isBlank()) {
                dataRegInstrutor = FormataDataHora.dbFormataStringParaDataHora(dataRegistroInstrutor);
            }

            String dataUltimoAcessoInstrutor = rs.getString("i.data_ultimo_acesso");
            LocalDateTime dataUltAcessoInstrutor = null;
            if (dataUltimoAcessoInstrutor != null && !dataUltimoAcessoInstrutor.isBlank()) {
                dataUltAcessoInstrutor = FormataDataHora.dbFormataStringParaDataHora(dataUltimoAcessoInstrutor);
            }

            String dataAtividade = rs.getString("at.data_atividade");
            String dtAtv = null;
            if (dataAtividade != null && !dataAtividade.isBlank()) {
                dtAtv = FormataData.dbFormataStringParaDataBase(dataAtividade);
            }

            String horaAtividade = rs.getString("at.hora_atividade");
            String hrAtv = null;
            if (horaAtividade != null && !horaAtividade.isBlank()) {
                hrAtv = FormataHora.dbFormataHoraParaString(horaAtividade);
            }

            Membro membro = new Membro(
                    rs.getInt("m.id"),
                    rs.getString("m.nome"),
                    rs.getString("m.sobrenome"),
                    rs.getString("m.cpf"),
                    rs.getString("m.email"),
                    rs.getString("m.login"),
                    rs.getString("m.senha"),
                    rs.getDouble("m.valor_associado"),
                    ETipoAssociado.valueOf(rs.getString("m.tipo_associado")),
                    dtNascMembro,
                    dataRegMembro,
                    dataUltAcessoMembro
            );

            Atividade atividade = new Atividade(
                    rs.getInt("at.id"),
                    rs.getString("at.nome"),
                    ETipoAtividades.valueOf(rs.getString("at.tipo_atividade")),
                    rs.getString("at.descricao"),
                    dtAtv,
                    hrAtv,
                    rs.getInt("at.id_instrutor")
            );

            Instrutor instrutor = new Instrutor(
                    rs.getInt("i.id"),
                    rs.getString("i.nome"),
                    rs.getString("i.sobrenome"),
                    rs.getString("i.cpf"),
                    rs.getString("i.email"),
                    rs.getString("i.login"),
                    rs.getString("i.senha"),
                    rs.getDouble("i.salario"),
                    EEspecializacao.valueOf(rs.getString("i.especializacao")),
                    dtNascInstrutor,
                    dataRegInstrutor,
                    dataUltAcessoInstrutor
            );

            avaliacao = new Avaliacao(
                    rs.getInt("a.id"),
                    membro,
                    atividade,
                    instrutor,
                    rs.getInt("a.nota"),
                    rs.getString("a.descricao"),
                    rs.getBoolean("a.presente"),
                    dtAvl
            );
        }
        return avaliacao;
    }


    private void liberarRecursos(ResultSet rs, PreparedStatement pst) throws SQLException {
        rs.close();
        pst.close();
        c.close();
    }
}
