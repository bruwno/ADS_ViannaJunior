package com.example.demo.model;

import com.example.demo.service.EmailService;
import com.example.demo.service.Mock.EmailServiceMock01;
import com.example.demo.service.Mock.EmailServiceMock02;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Assumptions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.mockito.Mock;
import org.springframework.boot.test.context.SpringBootTest;

import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.when;

@SpringBootTest
public class FinanciamentoTest {

    @Test
    @DisplayName("Testar financiamento de zero(0) reais")
    public void teste001(){
      //Montar Cenário
      Financiamento f = new Financiamento();
      f.setValorFinanciado(0);
      f.setTaxaJuros(0);
      f.setNumeroParcelas(12);
      f.setValorEntrada(1000);

      //double valorEsperado = informar erro

        //Executar
        try {
            double valorCalculado = f.valorParcela();
            Assertions.fail("não retornou erro!!");
        }catch(Exception e){
            Assertions.assertTrue(e.getMessage().contains("valor financiado não pode ser 0"));
        }
    }

    @Test
    @DisplayName("Testar financiamento de zero(0) reais")
    public void teste002() throws Exception {
        //Montar Cenário
        Financiamento f = new Financiamento();
        f.setValorFinanciado(1000);
        f.setTaxaJuros(1);
        f.setNumeroParcelas(12);
        f.setValorEntrada(0);

        double valorEsperado = 93.34;

        //Executar
            double valorCalculado = f.valorParcela();
            Assertions.assertEquals(valorEsperado,valorCalculado);

    }

    @Test
    @DisplayName("Testar de integração com o Gmail, impedir que o email seja enviado")
    public void testeIntegracao001() throws Exception {
        Financiamento f = new Financiamento();
        f.setValorFinanciado(1000);
        f.setTaxaJuros(1);
        f.setNumeroParcelas(12);
        f.setValorEntrada(0);
        f.setEm(new EmailServiceMock01());

       f.fecharFinanciamento("samuel@email.com","Samuel Costa");
       Assertions.assertTrue(true);
    }

    @Test
    @DisplayName("Teste de integração de erro de destinatário errado")
    public void testeIntegracao002() throws Exception {
        Financiamento f = new Financiamento();
        f.setValorFinanciado(1000);
        f.setTaxaJuros(1);
        f.setNumeroParcelas(12);
        f.setValorEntrada(0);
        f.setEm(new EmailServiceMock02());

        try{
            f.fecharFinanciamento("ze@ze.com","Zezin das Coves");
            Assertions.fail("Falhou!");
        }catch (Exception e){
            Assertions.assertEquals("538 - Destinatario Inválido!" , e.getMessage());
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

//        when(em.sendEmail("ze@ze.com",
//                "Confirmação dos dados do Financiamento",
//                "Parabéns, Sr(a) Zezin das Coves, o seu financeamento no valor de R$1000 foi aprovado"
//                        "Serão 12 parcelas de RS 93.34"),

        em.sendEmail("","",""));// De acordo com os parametros gera comportamentos diferentes

        f.setEm(em);

        try{
            f.fecharFinanciamento("ze@ze.com","Zezin das Coves");
            Assertions.fail("Falhou!");
        }catch (Exception e){
            Assertions.assertEquals("538 - Destinatario Inválido!" , e.getMessage());
        }
    }
}
