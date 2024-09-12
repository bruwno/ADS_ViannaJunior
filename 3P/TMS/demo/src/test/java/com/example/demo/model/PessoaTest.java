//package com.example.demo.model;
//
//import org.junit.jupiter.api.Assertions;
//import org.junit.jupiter.api.DisplayName;
//import org.junit.jupiter.api.Test;
//import org.springframework.boot.test.context.SpringBootTest;
//
//@SpringBootTest
//public class PessoaTest {
//   @Test
//   @DisplayName("testando o imc de uma pessoa")
//    public void testaValoresOk() throws Exception {
//        // PASSO 1 - Preparação
//        Pessoa p = new Pessoa("Samuelzim",80, 1.8);
//        double imcEsperado = 24.69;
//
//        // PASSO 2 - Execução
//        double imcObtido = p.imc();
//
//        // PASSO 3 - Validação do teste
//        Assertions.assertEquals(imcEsperado, imcObtido, 0.01);
//    }
//
//    @Test
//    @DisplayName("testando o imc de uma pessoa magra, no limite")
//    public void testaLimiteInferiorMagro() throws Exception {
//        // PASSO 1 - Preparação
//        Pessoa p = new Pessoa("Raphaelzim",41.6, 1.5);
//        double imcEsperado = 18.49;
//
//        // PASSO 2 - Execução
//        double imcObtido = p.imc();
//
//        // PASSO 3 - Validação do teste
//        Assertions.assertEquals(imcEsperado, imcObtido, 0.01);
//    }
//
//    @Test
//    @DisplayName("testando o imc com peso zero")
//    public void testaPesoZero() {
//       Pessoa p = new Pessoa("", 0, 1.5);
//       // double imcEsperado = 18.49;
//
//       try {
//           double imcObtido = p.imc();
//           Assertions.fail("Não deveria executar este método " + imcObtido);
//       } catch (Exception ex) {
//           Assertions.assertTrue(ex.getMessage().contains("peso não pode ser menor que zero"));
//       }
//    }
//
//    @Test
//    @DisplayName("testando o imc com peso negativo")
//    public void testaPesoNegativo() {
//        Pessoa p = new Pessoa("", -50, 1.5);
//        // double imcEsperado = 18.49;
//
//        try {
//            double imcObtido = p.imc();
//            Assertions.fail("Não deveria executar este método " + imcObtido);
//        } catch (Exception ex) {
//            Assertions.assertTrue(ex.getMessage().contains("peso não pode ser menor que zero"));
//        }
//    }
//
//    @Test
//    @DisplayName("testando o imc com altura zero")
//    public void testaAlturaZero() {
//        Pessoa p = new Pessoa("", 50, -1.83);
//        // double imcEsperado = 18.49;
//
//        try {
//            double imcObtido = p.imc();
//            Assertions.fail("Não deveria executar este método " + imcObtido);
//        } catch (Exception ex) {
//            Assertions.assertTrue(ex.getMessage().contains("altura não pode ser menor que zero"));
//        }
//    }
//
//    @Test
//    @DisplayName("testando o imc com altura negativa")
//    public void testaAlturaNegativa() {
//        Pessoa p = new Pessoa("", 50, -1.5);
//        //double imcEsperado = 18.49;
//
//        try {
//            double imcObtido = p.imc();
//            Assertions.fail("Não deveria executar este método " + imcObtido);
//        } catch (Exception ex) {
//            Assertions.assertTrue(ex.getMessage().contains("altura não pode ser menor que zero"));
//        }
//    }
//
//    @Test
//    @DisplayName("testa faixa de uma pessoa magra")
//    public void testeMagro() throws Exception {
//       Pessoa p = new Pessoa("", 41.62, 1.5);
//       String faixaEsperada = "Magro";
//
//       String faixaObtida = p.faixa();
//
//       Assertions.assertEquals(faixaEsperada, faixaObtida);
//    }
//
//    @Test
//    @DisplayName("testa faixa de uma pessoa normal, limite inferior")
//    public void testeNormal() throws Exception {
//        Pessoa p = new Pessoa("", 41.64, 1.5);
//        String faixaEsperada = "Normal";
//
//        String faixaObtida = p.faixa();
//
//        Assertions.assertEquals(faixaEsperada, faixaObtida);
//    }
//}

package com.example.demo.model;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;

@SpringBootTest
public class PessoaTest {

    @Test
    @DisplayName("Testando o imc de uma pessoa")
    public void teste_valores_OK() throws Exception {
        //1° Passo - Preparação:
        Pessoa p = new Pessoa("",80,1.8);
        double imcEsperado = 24.69;

        //2° Passo - Execução:
        double imcObitido = p.imc();

        //3° Passo - Validação do teste:
        Assertions.assertEquals(imcEsperado,imcObitido,0.01);//delta pega duas casas decimais


    }

    @Test
    @DisplayName("Testando o imc com uma pessoa magra, no limite")
    public void teste_limite_inferior_magro() throws Exception {
        //1° Passo - Preparação:
        Pessoa p = new Pessoa("",41.6,1.5);
        double imcEsperado = 18.49;

        //2° Passo - Execução:
        double imcObitido = p.imc();

        //3° Passo - Validação do teste:
        Assertions.assertEquals(imcEsperado,imcObitido,0.01);
    }

    @Test
    @DisplayName("Testando o imc com o peso zerado")
    public void teste_peso_zero(){
        //1° Passo - Preparação:
        Pessoa p = new Pessoa("",0,1.5);
        //double imcEsperado = 18.49;

        //2° Passo - Execução:
        try {
            double imcObitido = p.imc();
            Assertions.fail("Não deveria executar o método " + imcObitido);

        } catch (Exception e) {
            Assertions.assertTrue(e.getMessage().contains("Peso não pode ser menor que zero"));
        }


        //3° Passo - Validação do teste:
        //Assertions.assertEquals(imcEsperado,imcObitido,0.01);
    }

    @Test
    @DisplayName("Testando o imc com o peso negativo")
    public void teste1(){
        //1° Passo - Preparação:
        Pessoa p = new Pessoa("",-60,1.5);
        //double imcEsperado = 18.49;

        //2° Passo - Execução:
        try {
            double imcObitido = p.imc();
            Assertions.fail("Não deveria executar o método " + imcObitido);

        } catch (Exception e) {
            Assertions.assertTrue(e.getMessage().contains("Peso não pode ser menor que zero"));
        }


        //3° Passo - Validação do teste:
        //Assertions.assertEquals(imcEsperado,imcObitido,0.01);
    }

    @Test
    @DisplayName("Testando o imc com o altura zerada")
    public void teste2(){
        //1° Passo - Preparação:
        Pessoa p = new Pessoa("",60,0);
        //double imcEsperado = 18.49;

        //2° Passo - Execução:
        try {
            double imcObitido = p.imc();
            Assertions.fail("Não deveria executar o método " + imcObitido);

        } catch (Exception e) {
            Assertions.assertTrue(e.getMessage().contains("altura não pode ser menor que zero"));
        }


        //3° Passo - Validação do teste:
        //Assertions.assertEquals(imcEsperado,imcObitido,0.01);
    }

    @Test
    @DisplayName("Testando o imc com o altura negativo")
    public void teste3(){
        //1° Passo - Preparação:
        Pessoa p = new Pessoa("",60,-1.5);
        //double imcEsperado = 18.49;

        //2° Passo - Execução:
        try {
            double imcObitido = p.imc();
            Assertions.fail("Não deveria executar o método " + imcObitido);

        } catch (Exception e) {
            Assertions.assertTrue(e.getMessage().contains("altura não pode ser menor que zero"));
        }


        //3° Passo - Validação do teste:
        //Assertions.assertEquals(imcEsperado,imcObitido,0.01);
    }

    @Test
    @DisplayName("Testando o imc com a faixa magro")
    public void teste_magro() throws Exception{
        //1° Passo - Preparação:
        Pessoa p = new Pessoa("",41.6,1.5);
        String esperado = "magro";

        //2° Passo - Execução:
        String resultado = p.faixa();

        //3° Passo - Validação do teste:
        Assertions.assertEquals(esperado,resultado);
    }

    @Test
    @DisplayName("Testando o imc de uma pessoa magra, limite inferior")
    public void teste_magro_limite_inferior() throws Exception{
        //1° Passo - Preparação:
        Pessoa p = new Pessoa("",41.62,1.5);
        String esperado = "magro";

        //2° Passo - Execução:
        String resultado = p.faixa();


        //3° Passo - Validação do teste:
        Assertions.assertEquals(esperado,resultado);
    }

    @Test
    @DisplayName("Testando o imc de uma pessoa normal, limite inferior")
    public void teste_normal_limite_inferior() throws Exception{
        //1° Passo - Preparação:
        Pessoa p = new Pessoa("",41.64,1.5);
        String esperado = "normal";

        //2° Passo - Execução:
        String resultado = p.faixa();


        //3° Passo - Validação do teste:
        Assertions.assertEquals(esperado,resultado);
    }
}
