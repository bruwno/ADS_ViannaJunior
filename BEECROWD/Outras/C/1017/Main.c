/* Objetivo: Calcular o gasto de combustível com base no tempo de viagem e na velocidade média do automóvel.
 * Autor   : William Silva (https://github.com/unclWill)
 * Data    : 05/02/2024
 * Tipo    : 1 (INICIANTE)
 * ID      : 1017
 * Nome    : Gasto de Combustível
 * Link    : https://www.beecrowd.com.br/judge/pt/problems/view/1017
 */

#include <stdio.h>
#include <stdlib.h>

int main()
{
    int tempoGasto = 0;
    int velocidadeMedia = 0;
    scanf("%d", &tempoGasto);
    scanf("%d", &velocidadeMedia);

    double resultado = (tempoGasto * velocidadeMedia) / 12.0;
    printf("%.3f\n", resultado);

    return 0;
}