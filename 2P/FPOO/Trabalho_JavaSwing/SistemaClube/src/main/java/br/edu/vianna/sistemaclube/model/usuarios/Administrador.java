package br.edu.vianna.sistemaclube.model.usuarios;

import br.edu.vianna.sistemaclube.utils.datahora.FormataData;
import br.edu.vianna.sistemaclube.utils.datahora.FormataDataHora;

import java.time.LocalDateTime;

public class Administrador extends Usuario {
    public Administrador() {}

    public Administrador(int id, String nome, String sobrenome, String cpf, String email, String login, String senha, String dataNascimento, LocalDateTime dataRegistro, LocalDateTime dataUltimoAcesso) {
        super(id, nome, sobrenome, cpf, email, login, senha, dataNascimento, dataRegistro, dataUltimoAcesso);
    }

    public Administrador(int id, String nome, String sobrenome, String cpf, String email, String login, String senha, String dataNascimento, LocalDateTime dataRegistro) {
        super(id, nome, sobrenome, cpf, email, login, senha, dataNascimento, dataRegistro);
    }

    @Override
    public String toString() {
        return String.format("Id: %d\nNome: %s\nSobrenome: %s\nCPF: %s\nEmail: %s\nLogin: %s\nSenha: %s\nData nascimento: %s\nData de registro: %s\nÚtimo acesso: %s\n",
                getId(), getNome(), getSobrenome(), getCpf(), getEmail(), getLogin(), getSenha(),
                FormataData.formataDataParaExibicao(getDataNascimento()),
                FormataDataHora.formataDataHoraParaExibicaoSemSegundos(getDataRegistro()),
                FormataDataHora.formataDataHoraParaExibicaoSemSegundos(getDataUltimoAcesso()));
    }
}
