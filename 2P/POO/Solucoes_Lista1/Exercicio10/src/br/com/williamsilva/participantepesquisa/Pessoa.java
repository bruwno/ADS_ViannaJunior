package br.com.williamsilva.participantepesquisa;

import java.util.ArrayList;

public class Pessoa {
    private Generos sexo;
    private CoresOlhos corDosOlhos;
    private CoresCabelos corDosCabelos;
    private double altura;
    private int idade;
    private ArrayList<Pessoa> listaDePessoas;

    public Pessoa() {
        this.sexo = Generos.MASCULINO;
        this.corDosOlhos = CoresOlhos.AZUIS;
        this.corDosCabelos = CoresCabelos.LOUROS;
        this.altura = 0.0;
        this.idade = 0;
        listaDePessoas = new ArrayList<>();
    }

    public Pessoa(Generos sexo, CoresOlhos corDosOlhos, CoresCabelos corDosCabelos, double altura, int idade) {
        this.sexo = sexo;
        this.corDosOlhos = corDosOlhos;
        this.corDosCabelos = corDosCabelos;
        this.altura = altura;
        this.idade = idade;
        listaDePessoas = new ArrayList<>();
    }

    public Generos getSexo() {
        return sexo;
    }

    public void setSexo(Generos sexo) {
        if (sexo != null) {
            this.sexo = sexo;
        }
    }

    public CoresOlhos getCorDosOlhos() {
        return corDosOlhos;
    }

    public void setCorDosOlhos(CoresOlhos corDosOlhos) {
        if (corDosOlhos != null) {
            this.corDosOlhos = corDosOlhos;
        }
    }

    public CoresCabelos getCorDosCabelos() {
        return corDosCabelos;
    }

    public void setCorDosCabelos(CoresCabelos corDosCabelos) {
        if (corDosCabelos != null) {
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
