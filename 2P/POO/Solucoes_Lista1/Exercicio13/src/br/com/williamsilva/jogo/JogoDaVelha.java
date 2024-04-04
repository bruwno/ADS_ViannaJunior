package br.com.williamsilva.jogo;

import br.com.williamsilva.jogo.auxiliar.CorTexto;

import static br.com.williamsilva.jogo.Jogada.*;

public class JogoDaVelha {
    private char[][] grade;
    private int[] coordenadas;
    private Jogador jogador;
    private int contadorJogadas;

    public JogoDaVelha() {
        grade = new char[][]{
                {VAZIO.getSimbolo(), VAZIO.getSimbolo(), VAZIO.getSimbolo()},
                {VAZIO.getSimbolo(), VAZIO.getSimbolo(), VAZIO.getSimbolo()},
                {VAZIO.getSimbolo(), VAZIO.getSimbolo(), VAZIO.getSimbolo()}
        };
        this.coordenadas = new int[2];
    }

    // Métodos acessores.
    public void setJogador(Jogador jogador) {
        if (jogador != null) {
            this.jogador = jogador;
        }
    }

    public void setContadorJogadas(int contadorJogadas) {
        if (contadorJogadas >= 0) {
            this.contadorJogadas = contadorJogadas;
        }
    }

    // Métodos da classe.
    public boolean validarCoordenadas(int[] coordenadas) {
        if (coordenadas.length != 2) {
            return false;
        }

        if (impedirSobrescritaDeJogada(coordenadas)) {
            return false;
        }

        int lin = coordenadas[0];
        int col = coordenadas[1];

        return lin >= 0 && lin <= 2 && col >= 0 && col <= 2;
    }

    public void montarGrade() {
        System.out.println(CorTexto.AZUL.getCodCor() + "\tA\tB\tC" + CorTexto.RESET.getCodCor()); // Imprime a coordenada alfabética.
        for (int i = 0; i < this.grade.length; i++) {
            System.out.print(CorTexto.VERDE.getCodCor() + (i + 1) + CorTexto.RESET.getCodCor()); // Imprime a coordenada numérica.
            for (int j = 0; j < this.grade[0].length; j++) {
                System.out.print("\t" + this.grade[i][j]);
            }
            System.out.println();
        }
    }

    public void jogar(int[] coordenadas, Jogador jogador) {
        if (validarCoordenadas(coordenadas)) {
            this.coordenadas = coordenadas;
            setJogador(jogador);
            registrarJogadaNaGrade();
        }
    }

    private boolean impedirSobrescritaDeJogada(int[] coordenadas) {
        int lin = coordenadas[0];
        int col = coordenadas[1];
        return grade[lin][col] != VAZIO.getSimbolo();
    }

    private void registrarJogadaNaGrade() {
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

    private char retornaSimboloPosicao(int lin, int col) {
        return this.grade[lin][col];
    }

    private boolean vitoriaNaDiagonalPrincipal() {
        char simbolo = retornaSimboloPosicao(0,0);
        if (simbolo == VAZIO.getSimbolo()) {
            return false;
        }

        for (int i = 0; i < this.grade.length; i++) {
            if (this.grade[i][i] != simbolo) {
                return false;
            }
        }

        return true;
    }

    private boolean vitoriaNaDiagonalSecundaria() {
        char simbolo = retornaSimboloPosicao(0,2);
        if (simbolo == VAZIO.getSimbolo()) {
            return false;
        }

        for (int i = 0; i < this.grade.length; i++) {
            if (this.grade[i][this.grade.length - 1 - i] != simbolo) {
                return false;
            }
        }

        return true;
    }

    private boolean vitoriaNaHorizontal() {
        for (int i = 0; i < this.grade.length; i++) {
            char simbolo = retornaSimboloPosicao(i, 0);
            if (simbolo != VAZIO.getSimbolo() && simbolo == retornaSimboloPosicao(i, 1) && simbolo == retornaSimboloPosicao(i, 2)) {
                return true;
            }
        }
        return false;
    }

    private boolean vitoriaNaVertical() {
        for (int i = 0; i < this.grade[0].length; i++) {
            char simbolo = retornaSimboloPosicao(0, i);
            if (simbolo != VAZIO.getSimbolo() && simbolo == retornaSimboloPosicao(1, i) && simbolo == retornaSimboloPosicao(2, i)) {
                return true;
            }
        }
        return false;
    }

    public boolean verificarEstadoDaGrade() {
        // Só varre a grade se tiverem acontecido 4 ou mais jogadas.
        if (otimizacaoDeVarredura(this.contadorJogadas)) {
            return verificarCondicoesDeVitoria();
        }
        return false;
    }

    private boolean verificarCondicoesDeVitoria() {
        return (vitoriaNaHorizontal() || vitoriaNaVertical() || vitoriaNaDiagonalPrincipal() || vitoriaNaDiagonalSecundaria());
    }

    public boolean verificarEmpate() {
        for (char[] chars : this.grade) {
            for (int j = 0; j < this.grade[0].length; j++) {
                if (chars[j] == VAZIO.getSimbolo()) {
                    return false;
                }
            }
        }
        return true;
    }

    private boolean otimizacaoDeVarredura(int qtdJogadas) {
        return qtdJogadas >= 4;
    }
}
