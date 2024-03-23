/*
 * Autor: William Silva (https://gitlab.com/unclWill)
 * Data : 21/03/2024
 *
 * Exercício 13 - Escreva um programa completo para jogar o jogo da velha.
 * Para tanto crie uma classe JogoDaVelha:
 * • a classe deve conter como dados privados um array bidimensional 3x3 para
 * representar a grade do jogo
 * • crie uma enumeração para representar as possibilidades de ocupação de uma casa na
 * grade (vazia, jogador 1 ou jogador 2)
 * • o construtor deve inicializar a grade como vazia
 * • forneça um método para exibir a grade
 * • permita dois jogadores humanos
 * • forneça um método para jogar o jogo;
 * • todo movimento deve ocorrer em uma casa vazia;
 * depois de cada movimento, determine se houve uma derrota ou um empate.
 */

import br.com.williamsilva.jogo.Jogador;
import br.com.williamsilva.jogo.JogoDaVelha;
import br.com.williamsilva.jogo.auxiliar.SorteiaPrimeiraJogada;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        exibirCabecalho();

        JogoDaVelha jogo = new JogoDaVelha();
        SorteiaPrimeiraJogada sortear = new SorteiaPrimeiraJogada();

        Jogador j1 = new Jogador();
        j1.setNumJogador(1);
        Jogador j2 = new Jogador();
        j2.setNumJogador(2);

        int primeiroAJogar = sortear.sortearPrimeiraJogada();
        System.out.printf("| PRIMEIRO A JOGAR |%nJogador %d | Símbolo: %c%n%n", primeiroAJogar, j2.getSimbolo());

        iniciarJogo(sc, jogo, j1, j2);
    }

    public static void iniciarJogo(Scanner sc, JogoDaVelha jogo, Jogador j1, Jogador j2) {
        int qtdJogadas = 0;
        jogo.montarGrade();
        while (true) {
            jogo.alternarJogadores(j1);
            System.out.printf("\n[JOGADA] Sua vez jogador %d: ", j1.getNumJogador());
            int[] coordenadas = lerCoordenadasDaJogada(sc);
            int linha = coordenadas[0];
            int coluna = coordenadas[1];
            jogo.jogar(linha, coluna, j1);
            qtdJogadas++;
            jogo.setQtdJogadas(qtdJogadas);
        }
    }

    public static int[] lerCoordenadasDaJogada(Scanner sc) {
        char[] coordenadas = new char[2];
        coordenadas[0] = sc.next().toUpperCase().charAt(0);
        coordenadas[1] = sc.next().toUpperCase().charAt(0);

        int[] coordenadasLinhaColuna = new int[coordenadas.length];
        coordenadasLinhaColuna[0] = converterCoordenada(coordenadas[0]);
        coordenadasLinhaColuna[1] = converterCoordenada(coordenadas[1]);

        return coordenadasLinhaColuna;
    }

    public static int converterCoordenada(char coord) {
        int coordenada = 0;
        if (coord == 'A' || coord == '1') {
            coordenada = 0;
        } else if (coord == 'B' || coord == '2') {
            coordenada = 1;
        } else if (coord == 'C' || coord == '3') {
            coordenada = 2;
        }
        return coordenada;
    }

    public static void exibirCabecalho() {
        System.out.println("\t### JOGO DA VELHA ###");
        //System.out.println("Pressione [1] para começar a jogar!\n");
    }
}