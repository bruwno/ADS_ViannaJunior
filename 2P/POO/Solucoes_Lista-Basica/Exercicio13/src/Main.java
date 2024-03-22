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

public class Main {
    public static void main(String[] args) {
        exibirCabecalho();

        JogoDaVelha jogo = new JogoDaVelha();
        SorteiaPrimeiraJogada sortear = new SorteiaPrimeiraJogada();

        System.out.println("| PRIMEIRO A JOGAR | Jogador " + sortear.sortearPrimeiraJogada());

        Jogador j1 = new Jogador();
        j1.setNumJogador(1);
        jogo.jogar(0,0, j1);

        Jogador j2 = new Jogador();
        j2.setNumJogador(2);
        jogo.jogar(1,1, j2);
    }

    public static void exibirCabecalho() {
        System.out.println("||| JOGO DA VELHA |||");
        System.out.println("Pressione [1] para começar a jogar!\n");
    }

}