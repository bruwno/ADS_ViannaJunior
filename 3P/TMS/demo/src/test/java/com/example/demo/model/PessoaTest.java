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


