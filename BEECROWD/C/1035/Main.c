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
    int A, B, C, D;
    char readLine[100];

    fgets(readLine, sizeof(readLine), stdin);
    sscanf(readLine,
           "%d"
           "%d"
           "%d"
           "%d",
           &A, &B, &C, &D);

    int somaAB = A + B;
    int somaCD = C + D;

    if ((B > C) && (D > A) && (somaCD > somaAB) && (C > 0 && D > 0) && (ehPar(A)))
    {
        printf("Valores aceitos\n");
    }
    else
    {
        printf("Valores nao aceitos\n");
    }

    return 0;
}