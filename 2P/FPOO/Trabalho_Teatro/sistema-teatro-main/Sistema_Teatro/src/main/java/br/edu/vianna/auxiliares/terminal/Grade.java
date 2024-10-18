package br.edu.vianna.auxiliares.terminal;

import br.edu.vianna.modelosteatro.ECores;
import br.edu.vianna.modelosteatro.EOcupacaoAssento;
import br.edu.vianna.modelosteatro.IAssento;

public class Grade {
    public static void montarGradeAssentos(IAssento assentos) {
        int numeroAssento = 1;

        imprimirCabecalhoDaGrade();
        for (int i = 0; i < assentos.retornarAssentos().length; i++) {
            imprimirTabulacao();
            for (int j = 0; j < assentos.retornarAssentos()[0].length; j++) {
                numeroAssento = imprimeNumeroAssento(numeroAssento);
            }
            imprimeQuebraDeLinha();
            for (int j = 0; j < assentos.retornarAssentos()[0].length; j++) {
                if (assentos.retornarAssentos()[i][j].isReservado()) {
                    imprimeSimboloAssentoOcupado();
                } else {
                    imprimeSimboloAssentoDisponivel();
                }
            }
            imprimeQuebraDeLinhaDupla();
        }
    }

    private static void imprimirCabecalhoDaGrade() {
        System.out.println("\t\t||||||||||||||||||||||||||||||||||| PALCO |||||||||||||||||||||||||||||||||");
        System.out.println();
    }

    private static void imprimirTabulacao() {
        System.out.print("\t\t");
    }

    private static int imprimeNumeroAssento(int numeroAssento) {
        System.out.printf("%03d\t\t", numeroAssento);
        numeroAssento++;
        return numeroAssento;
    }

    private static void imprimeSimboloAssentoOcupado() {
        System.out.print(ECores.AMARELO.getCodCor() + "\t\t" + EOcupacaoAssento.OCUPADO.getTipoOcupacao());
        System.out.print(ECores.RESET.getCodCor());
    }

    private static void imprimeSimboloAssentoDisponivel() {
        System.out.print("\t\t" + EOcupacaoAssento.DISPONIVEL.getTipoOcupacao());
    }

    private static void imprimeQuebraDeLinha() {
        System.out.println();
    }

    private static void imprimeQuebraDeLinhaDupla() {
        System.out.println();
        System.out.println();
    }
}
