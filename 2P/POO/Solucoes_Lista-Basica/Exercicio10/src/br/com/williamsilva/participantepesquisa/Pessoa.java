package br.com.williamsilva.participantepesquisa;

import java.util.ArrayList;

public class Pessoa {
    private Character sexo;
    private String corDosOlhos;
    private String corDosCabelos;
    private double altura;
    private int idade;
    private ArrayList<Pessoa> listaDePessoas;

    public Pessoa() {
        this.sexo = ' ';
        this.corDosOlhos = "";
        this.corDosCabelos = "";
        this.altura = 0.0;
        this.idade = 0;
        listaDePessoas = new ArrayList<>();
    }

    public Pessoa(char sexo, String corDosOlhos, String corDosCabelos, double altura, int idade) {
        this.sexo = sexo;
        this.corDosOlhos = corDosOlhos;
        this.corDosCabelos = corDosCabelos;
        this.altura = altura;
        this.idade = idade;
        listaDePessoas = new ArrayList<>();
    }

    public char getSexo() {
        return sexo;
    }

    public void setSexo(Character sexo) {
        if (!sexo.equals(' ')) {
            this.sexo = sexo;
        }
    }

    public String getCorDosOlhos() {
        return corDosOlhos;
    }

    public void setCorDosOlhos(String corDosOlhos) {
        if (!corDosOlhos.isBlank()) {
            this.corDosOlhos = corDosOlhos;
        }
    }

    public String getCorDosCabelos() {
        return corDosCabelos;
    }

    public void setCorDosCabelos(String corDosCabelos) {
        if (!corDosCabelos.isBlank()) {
            this.corDosCabelos = corDosCabelos;
        }
    }

    public double getAltura() {
        return altura;
    }

    public void setAltura(double altura) {
        if (altura > 0.0) {
            this.altura = altura;
        }
    }

    public int getIdade() {
        return idade;
    }

    public void setIdade(int idade) {
        if (idade > 0) {
            this.idade = idade;
        }
    }

    public ArrayList<Pessoa> getListaDePessoas() {
        return listaDePessoas;
    }

    public void addPessoa(Pessoa pessoa) {
        listaDePessoas.add(pessoa);
    }


}
