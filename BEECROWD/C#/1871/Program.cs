/*
 * Objetivo: Somar valores e, se existirem, remover os zeros dos resultados.
 * Autor   : William Silva (https://github.com/bruwno)
 * Data    : 31/01/2024
 * Tipo    : 3 (STRINGS)
 * ID      : 1871
 * Nome    : Zero vale Zero
 * Link    : https://www.beecrowd.com.br/judge/pt/problems/view/1871
 */

using System;
using System.Collections.Generic;

class URI
{
    public static void Main(string[] args)
    {
        List<string> armazenaSomas = new List<string>();

        while (true)
        {
            int soma = 0, i = 0;

            string[] entrada = Console.ReadLine().Trim().Split(' ');

            if (entrada[i].Equals("0") && entrada[i + 1].Equals("0"))
            {
                break;
            }
            else
            {
                soma = int.Parse(entrada[i]) + int.Parse(entrada[i + 1]);
                armazenaSomas.Add(soma.ToString());
            }
            i++;
        }
        RemoverZeros(armazenaSomas);
    }

    private static void RemoverZeros(List<string> valores)
    {
        string novoValor = string.Empty;

        foreach (string valor in valores)
        {
            if (valor.Contains("0"))
            {
                novoValor = valor.Replace("0", "");
                Console.WriteLine(novoValor);
            }
            else
            {
                novoValor = valor;
                Console.WriteLine(novoValor);
            }
        }
    }
}