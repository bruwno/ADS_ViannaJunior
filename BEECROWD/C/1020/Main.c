/* Objetivo: Converter uma entrada de idade em dias para anos, meses e dias.
 * Autor   : William Silva (https://github.com/bruwno)
 * Data    : 07/02/2024
 * Tipo    : 1 (INICIANTE)
 * ID      : 1020
 * Nome    : Idade em Dias
 * Link    : https://www.beecrowd.com.br/judge/pt/problems/view/1020
 */

#include <stdio.h>

void converterIdade(int idadeEmDias)
{
    int diasRestantes, anos, meses, dias;
    anos = idadeEmDias / 365;
    diasRestantes = idadeEmDias % 365;
    meses = diasRestantes / 30;
    dias = diasRestantes % 30;
    printf("%d ano(s)\n%d mes(es)\n%d dia(s)\n", anos, meses, dias);
}

int main()
{
    int idadeEmDias = 0;
    scanf("%d", &idadeEmDias);
    converterIdade(idadeEmDias);
    return 0;
}