package br.edu.vianna;

public class Homem extends PessoaIMC {

    public Homem() {}

    public Homem(String nome, String dataNascimento, double peso, double altura) {
        super.nome = nome;
        super.dataNascimento = dataNascimento;
        super.peso = peso;
        super.altura = altura;
    }

    @Override
    public String resultIMC() {
        double imc = calculaIMC();

        if (imc < 20.7) {
            return String.format("IMC %.2f: Abixo do peso ideal", imc);
        } else if (imc >= 20.7 && imc <= 26.4) {
            return String.format("IMC %.2f: Peso ideal", imc);
        } else {
            return String.format("IMC %.2f: Acima do peso ideal", imc);
        }
    }
}