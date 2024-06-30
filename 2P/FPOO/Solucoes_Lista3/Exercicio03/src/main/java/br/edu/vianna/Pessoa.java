package br.edu.vianna;

/**
 * @author William Silva
 */

public class Pessoa {
    protected String nome;
    protected String dataNascimento;

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        if (nome != null && !nome.isBlank()) {
            this.nome = nome;
        }
    }

    public String getDataNascimento() {
        return dataNascimento;
    }

    public void setDataNascimento(String dataNascimento) {
        if (dataNascimento != null && !dataNascimento.isBlank()) {
            this.dataNascimento = dataNascimento;
        }
    }

    @Override
    public String toString() {
        return String.format("Nome: <<>%s> Data Nascimento: <<%s>>", nome, dataNascimento);
    }
}
