/* Objetivo: Ler um valor double e retornar o cálculo da área correspondente utilizando a fórmula a = 3.14159 * r².
 * Autor   : William Silva (https://github.com/bruwno)
 * Data    : 19/11/2026
 * Tipo    : 1 (INICIANTE)
 * ID      : 1002
 * Nome    : Área do Círculo
 * Link    : https://judge.beecrowd.com/pt/problems/view/1002
 */

#include <math.h>
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
    const double PI = 3.14159;
    double r, area = 0.0;

    r = read_line();
    area = PI * pow(r, 2); // Necessário usar o parâmetro -lm para compilar com o gcc.

    printf("A=%.4f\n", area);

    return 0;
}
