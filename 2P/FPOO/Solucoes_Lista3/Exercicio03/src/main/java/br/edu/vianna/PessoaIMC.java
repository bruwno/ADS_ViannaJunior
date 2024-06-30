package br.edu.vianna;

public abstract class PessoaIMC extends Pessoa {
    protected double peso;
    protected double altura;

    public double calculaIMC() {
        return peso / (altura * altura);
    }

    public abstract String resultIMC();

    public double getPeso() {
        return peso;
    }

    public void setPeso(double peso) {
        this.peso = peso;
    }

    public double getAltura() {
        return altura;
    }

    public void setAltura(double altura) {
        this.altura = altura;
    }

    @Override
    public String toString() {
        return String.format("Nome: <<>%s> Data de Nascimento: <<%s>> Peso: <<%.2f>> Altura: <<%.2f>>", nome, dataNascimento, peso, altura);
    }
}
