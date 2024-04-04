/*
 * Autor: William Silva (https://gitlab.com/unclWill)
 * Data : 07/03/2024
 *
 * Exercício 11 - Crie uma classe para representar datas.
 */

public class Main {
    public static void main(String[] args) {
        // Data atual do sistema (construtor padrão).
        Data dataAtual = new Data();
        System.out.printf("Data do sistema operacional: %s%n", dataAtual);

        // Data inicializada a partir do construtor.
        Data novaData = new Data(10, 03, 2000);
        System.out.printf("Data definida no construtor: %s%n", novaData);

        // Data inicializada com o construtor padrão e modificada via métodos set de cada campo.
        Data outraData = new Data();
        outraData.setDia(27);
        outraData.setMes(2);
        outraData.setAno(2023);
        System.out.printf("Data definida nos métodos set: %s%n", outraData);
        // Avançando um dia.
        outraData.avancaData();
        System.out.printf("Avançando um dia na data anterior: %s%n", outraData);
    }
}