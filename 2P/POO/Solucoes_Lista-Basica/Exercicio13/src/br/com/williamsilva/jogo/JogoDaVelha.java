package br.com.williamsilva.jogo;

import static br.com.williamsilva.jogo.PossibilidadeDeOcupacao.*;

public class JogoDaVelha {
    private char[][] grade;

    public JogoDaVelha() {
        grade = new char[][]{
                {VAZIO.getOcupacao(), VAZIO.getOcupacao(), VAZIO.getOcupacao()},
                {VAZIO.getOcupacao(), VAZIO.getOcupacao(), VAZIO.getOcupacao()},
                {VAZIO.getOcupacao(), VAZIO.getOcupacao(), VAZIO.getOcupacao()}
        };
    }

    public char[][] getGrade() {
        return grade;
    }

    public void setGrade(char[][] grade) {
        if (grade != null) {
            this.grade = grade;
        }
    }

    public void montarGrade() {
        System.out.println("\tA|\tB|\tC|"); // Imprime a coordenada alfabética.
        for (int i = 0; i < this.grade.length; i++) {
            System.out.print(i + 1 + "| "); // Imprime a coordenada numérica.
            for (int j = 0; j < this.grade[0].length; j++) {
                System.out.print("\t" + this.grade[i][j]); // Imprime a jogada.
            }
            System.out.println();
        }
    }

    public void jogar(int linha, int coluna, Jogador jogador) {
        realizarJogada(linha, coluna, jogador);
    }

    private void realizarJogada(int linha, int coluna, Jogador jogador) {
        for (int i = 0; i < this.grade.length; i++) {
            for (int j = 0; j < this.grade[0].length; j++) {
                if (jogador.getNumJogador() == 1) {
                    grade[linha][coluna] = JOGADOR1.getOcupacao();
                    break;
                } else if (jogador.getNumJogador() == 2) {
                    grade[linha][coluna] = JOGADOR2.getOcupacao();
                    break;
                }
                System.out.println();
            }
        }
        limparTela();
        montarGrade();
    }

    private void verificarEstadoDaGrade() {

    }

    public void limparTela() {
//        try {
//            if (System.getProperty("os.name").contains("Windows"))
//                new ProcessBuilder("cmd.exe", "/c", "cls").inheritIO().start().waitFor();
//            else
//                Runtime.getRuntime().exec("clear");
//        } catch (
//                Exception ex) {
//            System.out.println("Erro ao limpar a tela do console: " + ex.getMessage());
//        }
        System.out.print("\033[H\033[2J");
        System.out.flush();
    }
}
