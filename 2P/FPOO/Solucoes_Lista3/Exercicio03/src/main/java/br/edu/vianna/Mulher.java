package br.edu.vianna;

public class Mulher extends PessoaIMC {

    public Mulher() {}

    public Mulher(String nome, String dataNascimento, double peso, double altura) {
        this.nome = nome;
        this.dataNascimento = dataNascimento;
        this.peso = peso;
        this.altura = altura;
    }

    @Override
    public String resultIMC() {
        double imc = calculaIMC();

        if (imc < 19) {
            return String.format("IMC %.2f: Abaixo do peso ideal ", imc);
        } else if (imc >= 19 && imc <= 25.8) {
            return String.format("IMC %.2f: Peso ideal", imc);
        } else {
            return String.format("IMC %.2f: Acima do peso ideal", imc);
        }
    }
}
