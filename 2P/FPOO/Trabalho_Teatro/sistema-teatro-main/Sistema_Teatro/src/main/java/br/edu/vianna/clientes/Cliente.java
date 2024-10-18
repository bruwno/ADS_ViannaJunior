package br.edu.vianna.clientes;

import br.edu.vianna.eventos.Ingresso;
import br.edu.vianna.utils.datahora.FormataData;

import java.time.LocalDate;
import java.util.ArrayList;

public class Cliente {
    private String nome;
    private String sobrenome;
    private String cpf;
    private String email;
    private String telefone;
    private LocalDate dataNasc;
    private Endereco endereco;

    public Cliente() {
    }

    public Cliente(String nome, String sobrenome, String cpf, String email, String telefone, String dataNasc, Endereco endereco) {
        setNome(nome);
        setSobrenome(sobrenome);
        setCpf(cpf);
        setEmail(email);
        setTelefone(telefone);
        setDataNasc(dataNasc);
        setEndereco(endereco);
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        if (nome != null && !nome.isEmpty()) {
            this.nome = nome;
        }
    }

    public String getSobrenome() {
        return sobrenome;
    }

    public void setSobrenome(String sobrenome) {
        if (sobrenome != null && !sobrenome.isEmpty()) {
            this.sobrenome = sobrenome;
        }
    }

    public String getCpf() {
        return cpf;
    }

    public void setCpf(String cpf) {
        if (cpf != null && !cpf.isEmpty()) {
            this.cpf = cpf;
        }
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        if (email != null && !email.isEmpty()) {
            this.email = email;
        }
    }

    public String getTelefone() {
        return telefone;
    }

    public void setTelefone(String telefone) {
        if (telefone != null && !telefone.isEmpty()) {
            this.telefone = telefone;
        }
    }

    public String getDataNasc() {
        return FormataData.formataDataParaString(dataNasc);
    }

    public void setDataNasc(String dataNasc) {
        if (!dataNasc.isBlank()) {
            this.dataNasc = FormataData.formataStringParaData(dataNasc);
        }
    }

    public Endereco getEndereco() {
        return endereco;
    }

    public void setEndereco(Endereco endereco) {
        if (endereco != null) {
            this.endereco = endereco;
        }
    }

}
