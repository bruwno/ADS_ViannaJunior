package br.com.williamsilva.utils;

public class FormatarInformacaoCarro {
    public String formatarInformacao(String texto, String valor) {
        return String.format("\t%s: %s%n", texto, valor);
    }
}
