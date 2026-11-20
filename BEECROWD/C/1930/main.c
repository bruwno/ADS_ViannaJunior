/* Objetivo: Calcular quantidade de tomadas disponíveis.
 * Autor   : William Silva (https://github.com/bruwno)
 * Data    : 20/11/2026
 * Tipo    : 1 (INICIANTE)
 * ID      : 1930
 * Nome    : Tomadas
 * Link    : https://judge.beecrowd.com/pt/problems/view/1930
 */

#include <stdio.h>
#include <stdlib.h>

#define ARRAY_SIZE 4

int *read_line() {
  int *values = malloc(ARRAY_SIZE * sizeof(int));

  if (values == NULL) {
    puts("Erro ao tentar alocar memória.");
    return NULL;
  }

  for (int i = 0; i < ARRAY_SIZE; i++) {
    // A função scanf ingnora automaticamente espaços em branco e quebras de linha
    // e retorna 1 se a leitura for realizada com sucesso. O operador & indica a scanf
    // o endereço onde cada valor deve ser salvo na memória. Sendo que cada posição no array
    // aponta para um endereço, alocado inicialmente pela função malloc.
    if (scanf("%d", &values[i]) != 1) {
      free(values);
      return NULL;
    }
  }

  return values;
}

int main() {
    int *storedValues = read_line();
    int result = 0;

    if (storedValues != NULL) {
        int acc = 0;
        for (int i = 0; i < ARRAY_SIZE; i++) {
            acc += storedValues[i];
        }

        result = acc - (ARRAY_SIZE - 1);
        free(storedValues);
    }

    printf("%d\n", result);

    return 0;
}

/*
 * SOLUÇÃO:
 * Para cada valor do array, tomadas=(t1-1)+(t2-1)+(t3-1)+t4
 * Por exemplo, para a entrada: 6 6 6 6
 * tomadas = (6-1)+(6-1)+(6-1)+(6) -> 5+5+5+6=21
 */
