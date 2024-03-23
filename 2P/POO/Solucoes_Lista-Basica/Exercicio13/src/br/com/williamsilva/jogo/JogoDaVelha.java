package br.com.williamsilva.jogo;

import br.com.williamsilva.jogo.auxiliar.TextoEmCores;

import static br.com.williamsilva.jogo.PossibilidadeDeOcupacao.*;

public class JogoDaVelha {
    private char[][] grade;
    private int qtdJogadas;

    public JogoDaVelha() {
        grade = new char[][]{
                {VAZIO.getSimbolo(), VAZIO.getSimbolo(), VAZIO.getSimbolo()},
                {VAZIO.getSimbolo(), VAZIO.getSimbolo(), VAZIO.getSimbolo()},
                {VAZIO.getSimbolo(), VAZIO.getSimbolo(), VAZIO.getSimbolo()}
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

    public void setQtdJogadas(int qtdJogadas) {
        this.qtdJogadas = qtdJogadas;
    }

    public void montarGrade() {
        System.out.println(TextoEmCores.AZUL + "\tA\tB\tC" + TextoEmCores.RESET); // Imprime a coordenada alfabética.
        for (int i = 0; i < this.grade.length; i++) {
            System.out.print(TextoEmCores.VERDE + (i + 1) + TextoEmCores.RESET); // Imprime a coordenada numérica.
            for (int j = 0; j < this.grade[0].length; j++) {
                System.out.print("\t" + this.grade[i][j]); // Imprime a jogada.
            }
            System.out.println();
        }
    }

    public void jogar(int linha, int coluna, Jogador jogador) {
        jogador.setNumJogador(alternarJogadores(jogador));
        registrarJogadaNaGrade(linha, coluna, jogador);
    }

    private int alternarJogadores(Jogador jogador) {
        int numJogador = 0;
        if (jogador.getNumJogador() == 1) {
            numJogador = 2;
        } else if (jogador.getNumJogador() == 2) {
            numJogador = 1;
        }
        return numJogador;
    }

    private void registrarJogadaNaGrade(int linha, int coluna, Jogador jogador) {
        for (int i = 0; i < this.grade.length; i++) {
            for (int j = 0; j < this.grade[0].length; j++) {
                if (jogador.getNumJogador() == 1) {
                    grade[linha][coluna] = JOGADOR1.getSimbolo();
                    break;
                } else if (jogador.getNumJogador() == 2) {
                    grade[linha][coluna] = JOGADOR2.getSimbolo();
                    break;
                }
                System.out.println();
            }
        }
        montarGrade();
        verificarEstadoDaGrade();
    }

    private void condicoesDeVitoria(char[][] grade) {
        if (diagonalPrincipal(grade)) {
            System.out.println("Fim de jogo! [Vitória]");
        } else if (diagonalSecundaria(grade)) {
            System.out.println("Fim de jogo! [Vitória]");
        }
    }

    private boolean diagonalPrincipal(char[][] grade) {
        int ij = 0;
        for (int i = 0; i < grade.length; i++) {
            for (int j = 0; j < grade[0].length; j++) {
                if (i == j) {
                    if ((grade[i][j] == 'X' && grade[i][j] != 'O') || (grade[i][j] == 'O' && grade[i][j] != 'X')) {
                        ij++;
                    }
                }
            }
        }
        System.out.println("DP-" + ij);
        return ij == 3;
    }

    private boolean diagonalSecundaria(char[][] grade) {
        int ij = 0;
        for (int i = 0; i < grade.length; i++) {
            for (int j = 0; j < grade[0].length; j++) {
                if (j == grade.length - 1 - i) {
                    if ((grade[i][j] == 'X' && grade[i][j] != 'O') || (grade[i][j] == 'O' && grade[i][j] != 'X')) {
                        ij++;
                    }
                }
            }
        }
        System.out.println("DS-" + ij);
        return ij == 3;
    }

    private void verificarEstadoDaGrade() {
        // Só varre a grade se tiverem acontecido 4 ou mais jogadas.
        if (otimizacoes(this.qtdJogadas)) {
            condicoesDeVitoria(grade);
        }
    }

    public boolean otimizacoes(int qtdJogadas) {
        if (qtdJogadas >= 3) {
            return true;
        }
        return false;
    }
}
