/* Objetivo: Ler um número, que representa uma senha, e exibir o número que vem depois dele.
 * Autor   : William Silva (https://github.com/unclWill)
 * Data    : 27/09/2023
 * Tipo    : 5 (MATEMÁTICA)
 * ID      : 3104
 * Nome    : Resto 2.0
 * Link    : https://www.beecrowd.com.br/judge/pt/problems/view/3104
 */

/*******************************************************************************
****************************** ESTE PROBLEMA AINDA *****************************
******************************  NÃO FOI RESOLVIDO. *****************************
********************************************************************************/

#include <stdio.h>
#include <string.h>

int resto_divisao(char A[], int B)
{
    int i, tamanho = strlen(A);
    int resto = 0;

    for (i = 0; i < tamanho; i++)
    {
        resto = (resto * 10 + (A[i] - '0')) % B;
    }

    return resto;
}

int main()
{
    char A[100001];
    int B;

    scanf("%s %d", A, &B);

    int resultado = resto_divisao(A, B);
    printf("%d\n", resultado);

    return 0;
}