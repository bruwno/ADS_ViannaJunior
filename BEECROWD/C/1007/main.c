/* Objetivo: Ler quatro valores e retornar a diferença entre eles a partir da fórmula DIFERENCA = (A*B-C*D).
 * Autor   : William Silva (https://github.com/bruwno)
 * Data    : 20/11/2026
 * Tipo    : 1 (INICIANTE)
 * ID      : 1007
 * Nome    : Diferença
 * Link    : https://judge.beecrowd.com/pt/problems/view/1007
 */

#include <stdio.h>
#include <stdlib.h>

#define ARRAY_SIZE 4

int read_line() {
    char buffer[64];
    int value = 0;

    if (fgets(buffer, sizeof(buffer), stdin) != NULL) {
        sscanf(buffer, "%d", &value);
    }

    return value;
}

int main() {
    int result = 0;
    int values[ARRAY_SIZE];

    for (int i = 0; i < ARRAY_SIZE; i++) {
        values[i] = read_line();
    }

    result = (values[0] * values[1]) - (values[2] * values[3]);
    printf("DIFERENCA = %d\n", result);

    return 0;
}
