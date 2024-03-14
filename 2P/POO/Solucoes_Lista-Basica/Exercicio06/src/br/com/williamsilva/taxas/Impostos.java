package br.com.williamsilva.taxas;

public class Impostos {
    public static double aplicaImpostoIPI(double valor) {
        return (valor > 0) ? valor * 0.20 : 0;
    }

    public static double aplicaDescontoIsencaoImpostoIPI(double valor) {
        double valorComIsencao = valor * 0.10;
        return (valor > 0) ? valorComIsencao : 0;
    }

    public static double aplicaImpostoDeImportacao(double valor) {
        return valor * 0.30;
    }
}
