/*
 * Objetivo : Imprimir o valor de x.
 * Autor    : William Silva (https://github.com/unclWill)
 * Data     : 29/12/2023
 * Material : Apostila Java - Alura | Variáveis Primitivas e Controle de Fluxo
 * Slide    : 34
 * Exercício: 08
 */

/*
 * 8. (Opcional) Imprima a seguinte tabela usando fors encadeados:
 * 1
 * 2 4
 * 3 6 9
 * 4 8 12 16
 * n n*2 n*3 .... n*n
 */

public class Main {
    public static void main(String[] args) {
        for (int i = 1; i <= 5; i++) {
            for (int j = 1; j <= i; j++) {
                System.out.printf("%d ", i * j);
            }
            System.out.println();
        }
    }
}