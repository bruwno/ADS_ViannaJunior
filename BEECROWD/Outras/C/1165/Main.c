/* Objetivo: Verificar se um número é primo.
 * Autor   : William Silva (https://github.com/unclWill)
 * Data    : 04/02/2024
 * Tipo    : 1 (INICIANTE)
 * ID      : 1165
 * Nome    : Número Primo
 * Link    : https://www.beecrowd.com.br/judge/pt/problems/view/1165
 */

#include <stdio.h>
#include <stdlib.h>
#include <stdbool.h>

bool ehPrimo(int num)
{
    if (num <= 1)
    {
        return false;
    }

    if (num == 2 || num == 3)
    {
        return true;
    }

    if (num % 2 == 0 || num % 3 == 0)
    {
        return false;
    }

    for (int i = 5; i * i <= num; i += 6)
    {
        if (num % i == 0 || num % (i + 2) == 0)
        {
            return false;
        }
    }

    return true;
}

int main()
{
    int n = 0;
    scanf("%d", &n);
    int numeros[n];

    for (int i = 0; i < n; i++)
    {
        int num = 0;
        scanf("%d", &num);
        numeros[i] = num;
    }

    for (int i = 0; i < n; i++)
    {
        if (ehPrimo(numeros[i]))
        {
            printf("%d eh primo\n", numeros[i]);
        }
        else
        {
            printf("%d nao eh primo\n", numeros[i]);
        }
    }

    return 0;
}