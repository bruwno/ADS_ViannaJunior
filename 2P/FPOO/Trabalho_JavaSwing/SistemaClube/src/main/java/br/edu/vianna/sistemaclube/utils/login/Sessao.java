package br.edu.vianna.sistemaclube.utils.login;

import br.edu.vianna.sistemaclube.model.usuarios.Usuario;

public class Sessao {
    private static Usuario usuarioLogado;

    public static Usuario getUsuarioLogado() {
        return usuarioLogado;
    }

    public static void setUsuarioLogado(Usuario usuario) {
        usuarioLogado = usuario;
    }
}
