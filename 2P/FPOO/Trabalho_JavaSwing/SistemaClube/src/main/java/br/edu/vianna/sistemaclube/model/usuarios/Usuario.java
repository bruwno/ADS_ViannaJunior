package br.edu.vianna.sistemaclube.model.usuarios;

import br.edu.vianna.sistemaclube.utils.datahora.FormataData;
import br.edu.vianna.sistemaclube.utils.datahora.FormataDataHora;

import java.time.LocalDate;
import java.time.LocalDateTime;

public abstract class Usuario {
    private int id;
    private String nome;
    private String sobrenome;
    private String cpf;
    private String email;
    private String login;
    private String senha;
    private LocalDate dataNascimento;
    private LocalDateTime dataRegistro;
    private LocalDateTime dataUltimoAcesso;

    public Usuario() {}

    public Usuario(int id, String nome, String sobrenome, String cpf, String email, String login, String senha, String dataNascimento, LocalDateTime dataRegistro) {
        setId(id);
        setNome(nome);
        setSobrenome(sobrenome);
        setCpf(cpf);
        setEmail(email);
        setLogin(login);
        setSenha(senha);
        setDataNascimento(dataNascimento);
        setDataRegistro(dataRegistro);
    }

    public Usuario(int id, String nome, String sobrenome, String cpf, String email, String login, String senha, String dataNascimento, LocalDateTime dataRegistro, LocalDateTime dataUltimoAcesso) {
        setId(id);
        setNome(nome);
        setSobrenome(sobrenome);
        setCpf(cpf);
        setEmail(email);
        setLogin(login);
        setSenha(senha);
        setDataNascimento(dataNascimento);
        setDataRegistro(dataRegistro);
        setDataUltimoAcesso(dataUltimoAcesso);
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        if (nome != null && !nome.isBlank()) {
            this.nome = nome.trim();
        }
    }

    public String getSobrenome() {
        return sobrenome;
    }

    public void setSobrenome(String sobrenome) {
        if (sobrenome != null && !sobrenome.isBlank()) {
            this.sobrenome = sobrenome.trim();
        }
    }

    public String getCpf() {
        return cpf;
    }

    public void setCpf(String cpf) {
        if (cpf != null && !cpf.isBlank() && cpf.length() <= 11) {
            this.cpf = cpf;
        }
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getLogin() {
        return login;
    }

    public void setLogin(String login) {
        this.login = login;
    }

    public String getSenha() {
        return senha;
    }

    public void setSenha(String senha) {
        this.senha = senha;
    }

    public String getDataNascimento() {
        return FormataData.dbFormataDataParaStringBase(dataNascimento);
    }

    public void setDataNascimento(String dataNascimento) {
        if (dataNascimento != null && !dataNascimento.isBlank()) {
            this.dataNascimento = FormataData.formataStringParaData(dataNascimento);
        }
    }

    public String getDataRegistro() {
        return FormataDataHora.dbFormataDataHoraParaStringBase(dataRegistro);
    }

    public void setDataRegistro(LocalDateTime dataRegistro) {
        if (dataRegistro == null) {
            this.dataRegistro = LocalDateTime.now();
        } else {
            this.dataRegistro = dataRegistro;
        }
    }

    public String getDataUltimoAcesso() {
        if (dataUltimoAcesso != null) {
            return FormataDataHora.dbFormataDataHoraParaStringBase(dataUltimoAcesso);
        } else {
            return null;
        }
    }

    public void setDataUltimoAcesso(LocalDateTime dataUltimoAcesso) {
        if (dataUltimoAcesso == null) {
            this.dataUltimoAcesso = LocalDateTime.parse("1970-01-01T00:00:00.000"); // Se a  data de acesso for NULL insere uma data padrão.

        } else {
            this.dataUltimoAcesso = dataUltimoAcesso;
        }
    }
}
