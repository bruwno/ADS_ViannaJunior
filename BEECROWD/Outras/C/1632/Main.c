/* Objetivo: Determinar de quantas maneiras uma senha pode ser formada.
 * Autor   : William Silva (https://github.com/unclWill)
 * Data    : 03/02/2024
 * Tipo    : 3 (STRINGS)
 * ID      : 1632
 * Nome    : Variações
 * Link    : https://www.beecrowd.com.br/judge/pt/problems/view/1632
 */

#include <stdio.h>
#include <stdlib.h>
#include <stdbool.h>

bool verificaCaractere(char caractere)
{
    const char conjuntoDeCaracteres[] = "AEIOSaeios";

    for (int i = 0; conjuntoDeCaracteres[i] != '\0'; i++)
    {
        if (caractere == conjuntoDeCaracteres[i])
        {
            return true;
        }
    }
    return false;
}

int retornarQtdPossibilidades(char str[])
{
    int qtdPossib = 1;

    for (int i = 0; str[i] != '\0'; i++)
    {
        char caractere = str[i];
        if (verificaCaractere(caractere))
        {
            qtdPossib *= 3;
        }
        else
        {
            qtdPossib *= 2;
        }
    }
    return qtdPossib;
}

int main()
{
    int resultados[100];
    int t = 0;
    scanf("%d", &t);

    for (int i = 0; i < t; i++)
    {
        char s[17];
        scanf("%s", s);
        resultados[i] = retornarQtdPossibilidades(s);
    }

    for (int i = 0; i < t; ++i)
    {
        printf("%d\n", resultados[i]);
    }

    return 0;
}