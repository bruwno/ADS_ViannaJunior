package com.example.demo.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class Pessoa {

    private String nome;
    private double peso,altura;

    public double imc() throws Exception {
        if(peso <= 0){
            throw new Exception("Peso não pode ser menor que zero");
        }
        if(altura <= 0){
            throw new Exception("altura não pode ser menor que zero");
        }

        return peso / Math.pow(altura,2);
    }

    public String faixa() throws Exception {
        double fx = imc();
        if(fx <= 18.5){
            return "magro";
        } else if (fx <= 24.99) {
            return "normal";
        } else if (fx <= 29.99) {
            return "Pré-Obesidade";
        } else if (fx <= 34.99) {
            return "Obesidade Grau I";
        } else if (fx <= 39.99) {
            return  "Obesidade Grau II";
        } else {
            return  "Obesidade Grau III";
        }
    }
}

