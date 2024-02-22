/* Objetivo: Converter uma entrada de tempo em segundos para horas, minutos e segundos.
 * Autor   : William Silva (https://github.com/unclWill)
 * Data    : 07/02/2024
 * Tipo    : 1 (INICIANTE)
 * ID      : 1019
 * Nome    : Conversão de Tempo
 * Link    : https://www.beecrowd.com.br/judge/pt/problems/view/1019
 */

#include <stdio.h>
#include <stdlib.h>

void converterTempo(int tempoEmSegundos)
{
    int tempoRestante, horas, minutos, segundos;
    horas = tempoEmSegundos / 3600;
    tempoRestante = tempoEmSegundos % 3600;
    minutos = tempoRestante / 60;
    segundos = tempoRestante % 60;
    printf("%d:%d:%d\n", horas, minutos, segundos);
}

int main()
{
    int tempoEmSegundos = 0;
    scanf("%d", &tempoEmSegundos);
    converterTempo(tempoEmSegundos);
    return 0;
}