/* Objetivo: Ler dois valores inteiros, A e B, e retornar o resultado da multiplicação entre eles.
 * Autor   : William Silva (https://github.com/bruwno)
 * Data    : 19/11/2026
 * Tipo    : 1 (INICIANTE)
 * ID      : 1004
 * Nome    : Produto Simples
 * Link    : https://judge.beecrowd.com/pt/problems/view/1004
 */

#include <stdio.h>
#include <stdlib.h>

int read_line() {
    char buffer[64];
    int value = 0;

    if (fgets(buffer, sizeof(buffer), stdin) != NULL) {
        sscanf(buffer, "%d", &value);
    }

    return value;
}

int main() {
    int a, b, prod = 0;
    a = read_line();
    b = read_line();

    prod = a * b;
    printf("PROD = %d\n", prod);

    return 0;
}
