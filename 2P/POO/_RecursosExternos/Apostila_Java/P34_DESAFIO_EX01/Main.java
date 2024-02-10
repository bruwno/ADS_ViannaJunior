/* Objetivo : Exibir o Fibonacci de um número.
 * Autor    : William Silva (https://github.com/unclWill)
 * Data     : 08/01/2024
 * Material : Apostila Java - Alura | Variáveis Primitivas e Controle de Fluxo
 * Slide    : 34
 * Exercício: 01
 * 
 * 1. Faça o exercício da série de Fibonacci usando apenas duas variáveis
 */

public class Main {
    public static void main(String[] args) {
        int valAtual = 1, valAnterior = 0;

        while (valAtual < 100) {
            System.out.println(valAtual);
            valAtual = valAnterior + valAtual;
            valAnterior = valAtual - valAnterior;
        }
        System.out.println(valAtual);
    }
}