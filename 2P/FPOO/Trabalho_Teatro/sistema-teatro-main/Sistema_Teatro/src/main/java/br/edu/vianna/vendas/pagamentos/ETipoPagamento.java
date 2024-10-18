package br.edu.vianna.vendas.pagamentos;

import java.util.Arrays;
import java.util.List;

public enum ETipoPagamento {
    DINHEIRO("1 - Dinheiro"),
    CREDITO("2 - Crédito"),
    DEBITO("3 - Débito"),
    PIX("4 - Pix");

    private final String tipoPagamento;

    ETipoPagamento(String tipoPagamento){
        this.tipoPagamento = tipoPagamento;
    }

    public String getTipoPagamento(){
        return tipoPagamento;
    }

    public static List <ETipoPagamento> getTiposPagamento(){
        return Arrays.asList(ETipoPagamento.values());
    }
}
