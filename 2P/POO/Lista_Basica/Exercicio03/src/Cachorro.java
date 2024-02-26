/*
 * Objetivo: Imprimir informações sobre cachorros.
 * Autor   : William Silva (https://gitlab.com/unclWill)
 * Data    : 26/02/2024
 *
 * 2) Crie uma classe chamada "Cachorro" que represente um cachorro. Esta classe deve
 * ter os seguintes atributos: nome (String), idade (int) e raça (String). Em seguida, crie
 * um programa principal que instancia objetos da classe "Cachorro" e exibe algumas
* informações sobre eles.
 */

public class Cachorro {
    private String nome;
    private int idade;

    private String raca;

    public Cachorro() {}

    public Cachorro(String nome, int idade, String raca) {
        this.nome = nome;
        this.idade = idade;
        this.raca = raca;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        if (nome != null && !nome.isBlank()) {
            this.nome = nome;
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

    public String getRaca() {
        return raca;
    }

    public void setRaca(String raca) {
        if (raca != null && !raca.isBlank()) {
            this.raca = raca;
        }
    }

    public String exibeInformacoes() {
        return ("Nome: " + getNome() + "\nIdade: " + getIdade() + "\nRaça: " + getRaca());
    }
}
