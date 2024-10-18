package br.edu.vianna.auxiliares.terminal;

public class AuxiliaImpressao {
    public static void centralizarTexto(String texto, int largura) {
        int espacosEsquerda = (largura - texto.length()) / 2;
        int espacosDireita = largura - texto.length() - espacosEsquerda;
        String resultado = " ".repeat(espacosEsquerda) + texto + " ".repeat(espacosDireita);
        System.out.println(resultado);
    }

    public static void decorarImpressao(String caractere, int qtd) {
        System.out.println(caractere.repeat(qtd));
    }
}
