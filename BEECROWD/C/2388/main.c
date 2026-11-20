/* Objetivo: Calcular a distância percorrida em quilômetros.
 * Autor   : William Silva (https://github.com/bruwno)
 * Data    : 20/11/2026
 * Tipo    : 2 (AD-HOC)
 * ID      : 2388
 * Nome    : Tacógrafo
 * Link    : https://judge.beecrowd.com/pt/problems/view/2388
 */

#include <stdio.h>
#include <stdlib.h>

#define COLUMNS 2

int read_line() {
  char buffer[64];
  int value = 0;

  if (fgets(buffer, sizeof(buffer), stdin) != NULL) {
    sscanf(buffer, "%d", &value);
  }

  return value;
}

int **read_line_matrix(int rows, int cols) {
  int **matrix = (int **)malloc(rows * sizeof(int *));

  for (int i = 0; i < rows; i++) {
    matrix[i] = (int *)malloc(cols * sizeof(int));
    for (int j = 0; j < cols; j++) {
      if (scanf("%d", &matrix[i][j]) != 1) {
        puts("Ocorreu um erro ao ler os valores.");
      }
    }
  }

  return matrix;
}

void free_matrix_alloc(int **matrix, int rows) {
  for (int i = 0; i < rows; i++) {
    free(matrix[i]);
  }
  free(matrix);
}

int main() {
  int numberOfTestCases = read_line();
  int **storedValues = read_line_matrix(numberOfTestCases, COLUMNS);

  int avgVel = 0;
  int acc = 0;
  int dist = 0;

  for (int i = 0; i < numberOfTestCases; i++) {
    for (int j = 0; j < COLUMNS; j++) {
      avgVel = storedValues[i][j] * storedValues[i][j + 1];
      acc += avgVel;
    }
    dist = acc;
  }

  printf("%d\n", dist);
  free_matrix_alloc(storedValues, numberOfTestCases);

  return 0;
}

/* SOLUÇÃO:
 * Tenho VELOCIDADE MÉDIA (V) e TEMPO (T) e preciso encontrar a distância
 * percorrida (D) Fórmula da velocidade média -> Vm = D/T Logo, fórmula da
 * distância  -> D = Vm*T
 */
