package br.edu.vianna.funcionarios;

import br.edu.vianna.utils.datahora.FormataData;
import br.edu.vianna.utils.criptografia.SenhaSegura;

import java.time.LocalDate;

public abstract class Funcionario
{
    private String nome;
    private String email;
    private String senha;
    private LocalDate dataRegistro;
    private SenhaSegura senhaSegura;

    public Funcionario() {
        this.senhaSegura = new SenhaSegura();
    }

    public Funcionario(String nome, String email, String senha) {
        this.senhaSegura = new SenhaSegura();
        setNome(nome);
        setEmail(email);
        setSenha(senha);
        setDataRegistro(FormataData.formataDataParaString(LocalDate.now()));
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        if(nome != null && !nome.isEmpty()){
            this.nome = nome;
        }
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        if(email != null && !email.isEmpty()){
            this.email = email;
        }
    }

    public void setSenha(String senha) {
        if (senha != null && !senha.isEmpty()) {
            this.senha = senhaSegura.criptografarSenha(senha);
        }
    }

    public boolean checarSenha(String senhaDigitada) {
        return senhaSegura.checarSenha(senhaDigitada, this.senha);
    }

    public String getDataRegistro() {
        return FormataData.formataDataParaString(dataRegistro);
    }

    public void setDataRegistro(String dataRegistro) {
        if (dataRegistro != null && !dataRegistro.isBlank()) {
            this.dataRegistro = FormataData.formataStringParaData(dataRegistro);
        } else {
            this.dataRegistro = LocalDate.now();
        }
    }
}
