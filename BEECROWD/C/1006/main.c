/* Objetivo: Ler três valores float, A, B e C, e retornar a média ponderada.
 * Autor   : William Silva (https://github.com/bruwno)
 * Data    : 19/11/2026
 * Tipo    : 1 (INICIANTE)
 * ID      : 1006
 * Nome    : Média 2
 * Link    : https://judge.beecrowd.com/pt/problems/view/1006
 */

#include <stdio.h>
#include <stdlib.h>

double read_line() {
    char buffer[64];
    double value = 0.0;

    if (fgets(buffer, sizeof(buffer), stdin) != NULL) {
        sscanf(buffer, "%lf", &value);
    }

    return value;
}

int main() {
    const int WEIGHT_A = 2;
    const int WEIGHT_B = 3;
    const int WEIGHT_C = 5;
    double a, b, c, avg = 0;

    a = read_line();
    b = read_line();
    c = read_line();

    avg = ((a * WEIGHT_A) + (b * WEIGHT_B) + (c * WEIGHT_C)) / (WEIGHT_A + WEIGHT_B + WEIGHT_C);
    printf("MEDIA = %.1f\n", avg);

    return 0;
}
