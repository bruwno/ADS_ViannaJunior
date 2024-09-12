package com.example.demo.model;

import com.example.demo.service.EmailService;
import com.example.demo.service.mock.EmailServiceMock01;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.math.BigDecimal;
import java.math.RoundingMode;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class Financiamento {
    private double valorFinanciado;
    private double taxaJuros;
    private double numeroParcelas;
    private double valorEntrada;
    private EmailService email;

    public double valorParcela() throws Exception {
        if (valorFinanciado == 0) {
            throw new Exception("O valor financiado não pode ser zero!");
        }

        double montante = valorFinanciado * (1 + (taxaJuros * numeroParcelas) / 100);
        double parcela = montante / numeroParcelas;

//        String valor = new DecimalFormat("#0.00").format(parcela);
//        double nParcela = Double.parseDouble(valor);
//        return (nParcela);

        return new BigDecimal(parcela).setScale(2, RoundingMode.UP).doubleValue();
    }

//    public void fecharFinanciamento(String email, String nome) throws Exception {
//        new EmailService().senEmail(email, "Confirmaçãp dos dados do financiamento",
//                "Parabéns, Sr(a) " + nome + ", o seu financiamento no valor de " +
//                        "R$" + valorFinanciado + " foi aprovado.\n" +
//                        "Serão " + numeroParcelas + " parcelas de R$ " + valorParcela());
//
//    }

    public void fecharFinanciamento(String email, String nome) throws Exception {
        String corpo = String.format("Parabéns, Srº/Srª %s, o seu financiamento no valor de R$ %.2f foi aprovado.\n" +
                "Serão %.2f parcelas de R$ %.2f", nome, valorFinanciado, numeroParcelas, valorParcela());

        new EmailServiceMock01().sendEmail(email, "Confirmaçãp dos dados do financiamento", corpo);
    }
}
