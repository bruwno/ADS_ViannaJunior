package br.edu.vianna.utils.criptografia;

import org.jasypt.util.password.StrongPasswordEncryptor;

public class SenhaSegura {
    private StrongPasswordEncryptor strongPassword;

    public SenhaSegura() {
        this.strongPassword = new StrongPasswordEncryptor();
    }

    public String criptografarSenha(String senha) {
        return strongPassword.encryptPassword(senha);
    }

    public boolean checarSenha(String senhaDigitada, String senhaArmazenada) {
        return strongPassword.checkPassword(senhaDigitada, senhaArmazenada);
    }
}
