/* Objetivo: Ler dois valores float, A e B, e retornar a média ponderada.
 * Autor   : William Silva (https://github.com/bruwno)
 * Data    : 19/11/2026
 * Tipo    : 1 (INICIANTE)
 * ID      : 1005
 * Nome    : Média 1
 * Link    : https://judge.beecrowd.com/pt/problems/view/1005
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
    const double WEIGHT_A = 3.5;
    const double WEIGHT_B = 7.5;
    double a, b, avg = 0;
    a = read_line();
    b = read_line();

    avg = ((a * WEIGHT_A) + (b * WEIGHT_B)) / (WEIGHT_A + WEIGHT_B);
    printf("MEDIA = %.5f\n", avg);

    return 0;
}
