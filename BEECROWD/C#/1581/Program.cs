/* Objetivo: Definir o qual idioma deve ser falado em uma conversa entre pessoas de diferentes nacionalidades.
 * Autor   : William Silva (https://github.com/bruwno)
 * Data    : 02/02/2024
 * Tipo    : 3 (STRINGS)
 * ID      : 1581
 * Nome    : Conversa Internacional
 * Link    : https://www.beecrowd.com.br/judge/pt/problems/view/1581
 */

using System;
using System.Collections.Generic;

class URI
{
    public static void Main(string[] args)
    {
        List<String> resultados = new List<String>();

        int n = int.Parse(Console.ReadLine());
        for (int i = 0; i < n; i++)
        {
            int k = int.Parse(Console.ReadLine());
            string[] conversas = new string[k];
            for (int j = 0; j < k; j++)
            {
                conversas[j] = Console.ReadLine();
            }
            resultados.Add(DeterminarIdiomaDaConversa(conversas));
        }

        foreach (string resultado in resultados)
        {
            Console.WriteLine(resultado);
        }
    }

    private static string DeterminarIdiomaDaConversa(string[] idiomasFalados)
    {
        string determinarIdioma = string.Empty;
        string idiomaBase = string.Empty;
        int qtdIdiomasIguais = 0, qtdIdiomasDiferentes = 0;

        for (int i = 0; i < idiomasFalados.Length; i++)
        {
            idiomaBase = idiomasFalados[0];

            if (idiomaBase.Equals(idiomasFalados[i]))
            {
                qtdIdiomasIguais++;
            }
            else
            {
                qtdIdiomasDiferentes++;
            }
        }

        if (qtdIdiomasDiferentes >= 1)
        {
            determinarIdioma = "ingles";
        }
        else
        {
            determinarIdioma = idiomaBase;
        }

        return determinarIdioma;
    }
}