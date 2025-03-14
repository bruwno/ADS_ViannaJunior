/* Objetivo: Converter uma entrada de idade em dias para anos, meses e dias.
 * Autor   : William Silva (https://github.com/bruwno)
 * Data    : 07/02/2024
 * Tipo    : 1 (INICIANTE)
 * ID      : 1020
 * Nome    : Idade em Dias
 * Link    : https://www.beecrowd.com.br/judge/pt/problems/view/1020
 */

using System;

class URI
{
    public static void Main(string[] args)
    {
        int idadeEmDias = int.Parse(Console.ReadLine());
        ConversorDeIdade(idadeEmDias);
    }

    private static void ConversorDeIdade(int idadeEmDias)
    {
        int diasRestantes, anos, meses, dias;
        anos = idadeEmDias / 365;
        diasRestantes = idadeEmDias % 365;
        meses = diasRestantes / 30;
        dias = diasRestantes % 30;
        Console.WriteLine($"{anos} ano(s)\n{meses} mes(es)\n{dias} dia(s)");
    }
}