package br.com.williamsilva.jogo;

import br.com.williamsilva.jogo.auxiliar.TextoEmCores;

import static br.com.williamsilva.jogo.Jogada.*;

public class JogoDaVelha {
    private char[][] grade;
    private Jogador jogador;
    private int qtdJogadas;

    public JogoDaVelha() {
        grade = new char[][]{
                {VAZIO.getSimbolo(), VAZIO.getSimbolo(), VAZIO.getSimbolo()},
                {VAZIO.getSimbolo(), VAZIO.getSimbolo(), VAZIO.getSimbolo()},
                {VAZIO.getSimbolo(), VAZIO.getSimbolo(), VAZIO.getSimbolo()}
        };
        this.jogador = new Jogador();
    }

    public char[][] getGrade() {
        return grade;
    }

    public void setQtdJogadas(int qtdJogadas) {
        this.qtdJogadas = qtdJogadas;
    }

    // Métodos da classe.
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

    public void jogar(int[] coordenadas, Jogador jogador) {
        registrarJogadaNaGrade(coordenadas, jogador);
        //verificarEstadoDaGrade();
    }

    public boolean impedirSobrescritaDeJogada(int[] coordenadas) {
        int lin = coordenadas[0];
        int col = coordenadas[1];
        return grade[lin][col] != VAZIO.getSimbolo();
    }

    private char verificaSimboloPosicao(int lin, int col) {
        return this.grade[lin][col];
    }

    private void registrarJogadaNaGrade(int[] coordenadas, Jogador jogador) {
        int lin = coordenadas[0];
        int col = coordenadas[1];
        int numJogador = jogador.getNumJogador();

        if (numJogador == 1) {
            grade[lin][col] = JOGADOR1.getSimbolo();
        } else if (numJogador == 2) {
            grade[lin][col] = JOGADOR2.getSimbolo();
        }

        montarGrade();
    }

    private boolean vitoriaNaDiagonalPrincipal() {
        char simboloPosicao = verificaSimboloPosicao(0,0);
        if (simboloPosicao == VAZIO.getSimbolo()) {
            return false;
        }

        for (int i = 0; i < this.grade.length; i++) {
            if (this.grade[i][i] != simboloPosicao) {
                return false;
            }
        }

        return true;
    }

    private boolean vitoriaNaDiagonalSecundaria() {
        char simboloPosicao = verificaSimboloPosicao(0,2);
        if (simboloPosicao == VAZIO.getSimbolo()) {
            return false;
        }

        for (int i = 0; i < this.grade.length; i++) {
            if (this.grade[i][this.grade.length - 1 - i] != simboloPosicao) {
                return false;
            }
        }

        return true;
    }

    private boolean vitoriaNaHorizontal() {
        for (int i = 0; i < this.grade.length; i++) {
            char simbolo = verificaSimboloPosicao(i, 0);
            if (simbolo != VAZIO.getSimbolo() && simbolo == verificaSimboloPosicao(i, 1) && simbolo == verificaSimboloPosicao(i, 2)) {
                return true;
            }
        }
        return false;
    }

    private boolean vitoriaNaVertical() {
        for (int i = 0; i < this.grade[0].length; i++) {
            char simbolo = verificaSimboloPosicao(0, i);
            if (simbolo != VAZIO.getSimbolo() && simbolo == verificaSimboloPosicao(1, i) && simbolo == verificaSimboloPosicao(2, i)) {
                return true;
            }
        }
        return false;
    }

    public boolean verificaEmpate() {
        int qtdCamposVazios = 0;
        for (int i = 0; i < this.grade.length; i++) {
            for (int j = 0; j < this.grade[0].length; j++) {
                if (this.grade[i][j] == VAZIO.getSimbolo()) {
                    qtdCamposVazios++;
                }
            }
        }
        return qtdCamposVazios == 1;
    }

    public boolean verificarEstadoDaGrade() {
        // Só varre a grade se tiverem acontecido 4 ou mais jogadas.
        if (otimizacaoDeVarredura(this.qtdJogadas)) {
            return verificarCondicoesDeVitoria();
        }
        return false;
    }

    private boolean verificarCondicoesDeVitoria() {
        return (vitoriaNaHorizontal() || vitoriaNaVertical() || vitoriaNaDiagonalPrincipal() || vitoriaNaDiagonalSecundaria());
    }

    private boolean otimizacaoDeVarredura(int qtdJogadas) {
        return qtdJogadas >= 4;
    }
}
