/* Objetivo: Ler valores, realizar avaliações lógicas e determinar se é válido ou não.
 * Autor   : William Silva (https://github.com/unclWill)
 * Data    : 22/02/2024
 * Tipo    : 1 (INICIANTE)
 * ID      : 1035
 * Nome    : Teste de Seleção 1
 * Link    : https://www.beecrowd.com.br/judge/pt/problems/view/1035
 */

#include <stdio.h>
#include <stdbool.h>

bool ehPar(int num)
{
    return num % 2 == 0;
}

int main()
{
    int a, b, c, d;
    char readLine[100];

    fgets(readLine, sizeof(readLine), stdin);
    sscanf(readLine,
           "%d"
           "%d"
           "%d"
           "%d",
           &a, &b, &c, &d);

    int somaAB = a + b;
    int somaCD = c + d;

    if ((b > c) && (d > a) && (somaCD > somaAB) && (c > 0 && d > 0) && (ehPar(a)))
    {
        printf("Valores aceitos\n");
    }
    else
    {
        printf("Valores nao aceitos\n");
    }

    return 0;
}