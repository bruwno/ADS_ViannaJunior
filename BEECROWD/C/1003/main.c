/* Objetivo: Ler dois valores inteiros, A e B, e retornar o resultado da soma entre eles.
 * Autor   : William Silva (https://github.com/bruwno)
 * Data    : 19/11/2026
 * Tipo    : 1 (INICIANTE)
 * ID      : 1003
 * Nome    : Soma Simples
 * Link    : https://judge.beecrowd.com/pt/problems/view/1003
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
    int a, b, sum = 0;
    a = read_line();
    b = read_line();

    sum = a + b;
    printf("SOMA = %d\n", sum);

    return 0;
}
