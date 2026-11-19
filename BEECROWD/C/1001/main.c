/* Objetivo: Ler dois valores inteiros A e B e retornar o resultado da soma armazenado em X.
 * Autor   : William Silva (https://github.com/bruwno)
 * Data    : 19/11/2026
 * Tipo    : 1 (INICIANTE)
 * ID      : 1001
 * Nome    : Extremamente Básico
 * Link    : https://judge.beecrowd.com/pt/problems/view/1001
 */

#include <stdio.h>
#include <stdlib.h>

int read_line() {
    char buffer[64];
    int num = 0;

    // Lê os caracteres de entrada e os guarda em buffer.
    if (fgets(buffer, sizeof(buffer), stdin) != NULL) {
        // Lê a string na memória em vez de ler direto do teclado.
        sscanf(buffer, "%d", &num);
    }

    return num;
}

int main() {
    int a, b, x = 0;
    a = read_line();
    b = read_line();
    x = a + b;
    printf("X = %d\n", x);

    return 0;
}
