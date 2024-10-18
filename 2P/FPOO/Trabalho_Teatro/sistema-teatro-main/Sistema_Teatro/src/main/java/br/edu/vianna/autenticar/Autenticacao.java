package br.edu.vianna.autenticar;

import br.edu.vianna.funcionarios.Funcionario;

import java.util.HashMap;
import java.util.Map;

public class Autenticacao {
    private HashMap<String, Funcionario> funcionariosCadastrados;

    public Autenticacao() {
        this.funcionariosCadastrados = new HashMap<>();
    }

    public Map<String, Funcionario> getFuncionariosCadastrados() {
        return funcionariosCadastrados;
    }

    public boolean cadastraFuncionario(Funcionario funcionario) {
        if (!funcionario.getEmail().isEmpty() && !funcionariosCadastrados.containsKey(funcionario.getEmail())) {
            funcionariosCadastrados.put(funcionario.getEmail(), funcionario);
            return true;
        }
        return false;
    }

    public Funcionario autenticar(String email, String senha) {
        Funcionario func = funcionariosCadastrados.get(email);
        return (func != null && func.checarSenha(senha) ? func : null);
    }
}