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

import br.com.williamsilva.jogo.Jogada;
import br.com.williamsilva.jogo.Jogador;
import br.com.williamsilva.jogo.JogoDaVelha;
import br.com.williamsilva.jogo.auxiliar.SorteiaPrimeiraJogada;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        JogoDaVelha jogo = new JogoDaVelha();
        Jogador j1, j2;
        j1 = new Jogador();
        j1.setNumJogador(1);
        j1.setSimbolo(Jogada.JOGADOR1);

        j2 = new Jogador();
        j2.setNumJogador(2);
        j2.setSimbolo(Jogada.JOGADOR2);

        exibirCabecalho();
        iniciarJogo(sc, jogo, sortearPrimeiroAJogar(j1, j2));
    }

    public static Jogador sortearPrimeiroAJogar(Jogador j1, Jogador j2) {
        SorteiaPrimeiraJogada sortear = new SorteiaPrimeiraJogada();
        int primeiroAJogar = sortear.sortearPrimeiraJogada();
        System.out.printf("| PRIMEIRO A JOGAR: Jogador %d | Símbolo: %c%n%n", primeiroAJogar, definirSimbolo(primeiroAJogar));
        return (primeiroAJogar == 1) ? j1 : j2;
    }

    public static void iniciarJogo(Scanner sc, JogoDaVelha jogo, Jogador j) {
        int contaJogadas = 0;
        jogo.montarGrade();

        while (true) {
            exibeDadosDaJogada(j);

            int[] coordenadas = lerCoordenadasDaJogada(sc);
            if (verificaSobrescritaDeJogada(sc, coordenadas, jogo, j)) {
                jogo.jogar(coordenadas, j);
            }
            verificaSeExisteVencedor(jogo, j);

            ++contaJogadas;
            defineDadosDoJogadorAtual(jogo, j, contaJogadas);
        }
    }

    public static void verificaSeExisteVencedor(JogoDaVelha jogo, Jogador j) {
        if (jogo.verificarEstadoDaGrade()) {
            System.out.printf("| FIM DE JOGO | Vitória do Jogador %d!", j.getNumJogador());
            System.exit(-1);
        } else if (jogo.verificaEmpate()) {
            System.out.println("|FIM DE JOGO | Empate!");
            System.exit(-1);
        }
    }

    public static void exibeDadosDaJogada(Jogador j) {
        System.out.printf("\n| JOGADOR %d (%c) | Sua vez: ", j.getNumJogador(), j.getSimbolo());
    }

    public static void defineDadosDoJogadorAtual(JogoDaVelha jogo, Jogador j, int contaJogadas) {
        jogo.setQtdJogadas(contaJogadas);
        j.setNumJogador(alternarJogadores(j));
        j.setSimbolo(alternarSimbolo(j));
    }

    public static int alternarJogadores(Jogador j) {
        return (j.getNumJogador() == 1) ? 2 : 1;
    }

    public static Jogada alternarSimbolo(Jogador j) {
        return (j.getSimbolo() == Jogada.JOGADOR1.getSimbolo()) ? Jogada.JOGADOR2 : Jogada.JOGADOR1;
    }

    public static char definirSimbolo(int primeiroAJogar) {
        return (primeiroAJogar == 1) ? Jogada.JOGADOR1.getSimbolo() : Jogada.JOGADOR2.getSimbolo();
    }

    public static boolean verificaSobrescritaDeJogada(Scanner sc, int[] coordenadas, JogoDaVelha jogo, Jogador j) {
        while (jogo.impedirSobrescritaDeJogada(coordenadas)) {
            System.out.print("| JOGADA INVÁLIDA | Esta posição já está ocupada, escolha outra: ");
            coordenadas = lerCoordenadasDaJogada(sc);

            if (!jogo.impedirSobrescritaDeJogada(coordenadas)) {
                jogo.jogar(coordenadas, j);
                return false;
            }
        }
        return true;
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
        System.out.println("\t\t### JOGO DA VELHA ###");
    }

    public static int escolherOpcNoMenu() {
        Scanner sc = new Scanner(System.in);
        int opcDigitada = 0;

        exibirCabecalho();
        System.out.println("[1] JOGAR" + "\n[2] SAIR");

        while (opcDigitada != 1) {
            System.out.print("|>| ");
            opcDigitada = sc.nextInt();
        }

        return opcDigitada;
    }
}