package br.edu.vianna.sistemaclube.model.usuarios;

import br.edu.vianna.sistemaclube.model.instrutores.EEspecializacao;
import br.edu.vianna.sistemaclube.utils.datahora.FormataData;
import br.edu.vianna.sistemaclube.utils.datahora.FormataDataHora;

import java.time.LocalDateTime;

public class Instrutor extends Usuario {
    private double salario;
    private EEspecializacao especializacao;

    public Instrutor() {}

    public Instrutor(double salario, EEspecializacao especializacao) {
        this.salario = salario;
        this.especializacao = especializacao;
    }

    public Instrutor(int id, String nome, String sobrenome, String cpf, String email, String login, String senha, double salario, EEspecializacao especializacao, String dataNascimento, LocalDateTime dataRegistro) {
        super(id, nome, sobrenome, cpf, email, login, senha, dataNascimento, dataRegistro);
        this.salario = salario;
        this.especializacao = especializacao;
    }

    public Instrutor(int id, String nome, String sobrenome, String cpf, String email, String login, String senha, double salario, EEspecializacao especializacao, String dataNascimento, LocalDateTime dataRegistro, LocalDateTime dataUltimoAcesso) {
        super(id, nome, sobrenome, cpf, email, login, senha, dataNascimento, dataRegistro, dataUltimoAcesso);
        this.salario = salario;
        this.especializacao = especializacao;
    }

    public double getSalario() {
        return salario;
    }

    public void setSalario(double salario) {
        if (salario >= 0) {
            this.salario = salario;
        }
    }

    public EEspecializacao getEspecializacao() {
        return especializacao;
    }

    public void setEspecializacao(EEspecializacao especializacao) {
        this.especializacao = especializacao;
    }

    @Override
    public String toString() {
        return String.format("Id: %d\nNome: %s\nSobrenome: %s\nCPF: %s\nEmail: %s\nLogin: %s\nSenha: %s\nSalário: %.2f\nEspecialização: %s\nData nascimento: %s\nData de registro: %s\nÚtimo acesso: %s\n",
                getId(), getNome(), getSobrenome(), getCpf(), getEmail(), getLogin(), getSenha(), getSalario(),
                getEspecializacao(),
                FormataData.formataDataParaExibicao(getDataNascimento()),
                FormataDataHora.formataDataHoraParaExibicaoSemSegundos(getDataRegistro()),
                FormataDataHora.formataDataHoraParaExibicaoSemSegundos(getDataUltimoAcesso()));
    }
}