/* Objetivo : Ler uma string, que representa um número, e retornar o seu equivalente em numeral ou por extenso.
 * Autor    : William Silva (https://github.com/unclWill)
 * Data     : 24/09/2023
 * Tipo     : 2 (AD-HOC)
 * ID       : 3475
 * Nome     : Conversor
 * Link     : https://www.beecrowd.com.br/judge/pt/problems/view/3475
 */

using System;
using System.Collections.Generic;

public class URI
{
    public static void Main(string[] args)
    {
        string numExtenso = Console.ReadLine().ToLower();

        switch (numExtenso.Length)
        {
            case 1:
                Console.WriteLine(NumeralParaPorExtenso(numExtenso));
                break;
            default:
                Console.WriteLine(PorExtensoParaNumeral(numExtenso));
                break;
        }
    }

    public static string PorExtensoParaNumeral(string num)
    {
        string numero = string.Empty;

        Dictionary<string, int> numsExtenso = new Dictionary<string, int>
        {
            { "zero", 0 },
            { "um", 1 },
            { "dois", 2 },
            { "tres", 3 },
            { "quatro", 4 },
            { "cinco", 5 },
            { "seis", 6 },
            { "sete", 7 },
            { "oito", 8 },
            { "nove", 9 }

        };

        if (numsExtenso.TryGetValue(num, out int numeral))
        {
            numero = numeral.ToString();
        }

        return numero;
    }

    public static string NumeralParaPorExtenso(string num)
    {
        int numeral = int.Parse(num);
        string numero = string.Empty;

        Dictionary<int, string> numerais = new Dictionary<int, string>
        {
            { 0, "zero" },
            { 1, "um" },
            { 2, "dois" },
            { 3, "tres" },
            { 4, "quatro" },
            { 5, "cinco" },
            { 6, "seis" },
            { 7, "sete" },
            { 8, "oito" },
            { 9, "nove" }
        };

        if (numerais.TryGetValue(numeral, out string numPorExtenso))
        {
            numero = numPorExtenso;
        }

        return numero;
    }
}