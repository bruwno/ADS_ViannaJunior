package com.example.demo.model;

import com.example.demo.service.EmailService;
import com.example.demo.service.mock.EmailServiceMock01;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.mockito.Mock;
import org.springframework.boot.test.context.SpringBootTest;

import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.when;

/*
 * Testes utilizando TDD.
 * Primeiro montamos os cenários para posteriormente escrevermos as classes.
 * */

@SpringBootTest
public class FinanciamentoTest {

    @Test
    @DisplayName("Testar o financiamento de 0 reais")
    public void teste001() {
        // Montar o cenário
        Financiamento f = new Financiamento();
        f.setValorFinanciado(0);
        f.setTaxaJuros(5);
        f.setNumeroParcelas(12);
        f.setValorEntrada(1000);

        // double valorEsperado = INFORMAR ERRO!

        // Executar
        try {
            double valorCalculado = f.valorParcela();
            Assertions.fail("Não retornou erro!");
        } catch (Exception ex) {
            Assertions.assertTrue(ex.getMessage().contains("O valor financiado não pode ser zero!"));
        }
    }

    @Test
    @DisplayName("Testar financiamento de 1000 a 1.0% am em 12 parcelas, sem entrada")
    public void teste002() throws Exception {
        // Montar o cenário
        Financiamento f = new Financiamento();
        f.setValorFinanciado(1000);
        f.setTaxaJuros(1);
        f.setNumeroParcelas(12);
        f.setValorEntrada(0);

        double valorEsperado = 93.34;

        // Executar

        double valorCalculado = f.valorParcela();
        Assertions.assertEquals(valorEsperado, valorCalculado);
    }

    @Test
    @DisplayName("Teste de integração com o Gmail, impedir que o email seja enviado")
    public void testeIntegracao001() throws Exception {
        Financiamento f = new Financiamento();
        f.setValorFinanciado(1000);
        f.setTaxaJuros(1);
        f.setNumeroParcelas(12);
        f.setValorEntrada(0);
        f.setEmail(new EmailServiceMock01());

        f.fecharFinanciamento("william@bruno.com", "William Silva");
        Assertions.assertTrue(true);
    }

    @Test
    @DisplayName("Teste de integração com o Gmail, impedir que o email seja enviado")
    public void testeIntegracao002() throws Exception {
        Financiamento f = new Financiamento();
        f.setValorFinanciado(1000);
        f.setTaxaJuros(1);
        f.setNumeroParcelas(12);
        f.setValorEntrada(0);
        f.setEmail(new EmailServiceMock01());

        try {
            f.fecharFinanciamento("ze@ze.com", "Zezin das Couves");
            Assertions.fail("Falhou!"); // Deveria passar, mas está dando erro.
        } catch (Exception ex) {
            Assertions.assertEquals("538 - Destinatário inválido!", ex.getMessage());
        }
    }

    @Test
    @DisplayName("Teste de integração com Mockito")
    public void testeIntegracao003() throws Exception {
        Financiamento f = new Financiamento();
        f.setValorFinanciado(1000);
        f.setTaxaJuros(1);
        f.setNumeroParcelas(12);
        f.setValorEntrada(0);

        EmailService em = mock(EmailService.class);//Criando um elemento falso

        when(em.sendEmail("ze@ze.com", "Confirmação dos dados do Financiamento", "Parabéns, Sr(a) Zezin das Coves, o seu financeamento no valor de R$1000 foi aprovado Serão 12 parcelas de RS 93.34");

                em.sendEmail("","",""));// De acordo com os parametros gera comportamentos diferentes

        f.setEmail(em);

        try{
            f.fecharFinanciamento("ze@ze.com","Zezin das Coves");
            Assertions.fail("Falhou!");
        }catch (Exception e){
            Assertions.assertEquals("538 - Destinatario Inválido!" , e.getMessage());
        }
    }
}
