/* Objetivo: Determinar de quantas maneiras uma senha pode ser formada.
 * Autor   : William Silva (https://github.com/bruwno)
 * Data    : 03/02/2024
 * Tipo    : 3 (STRINGS)
 * ID      : 1632
 * Nome    : Variações
 * Link    : https://www.beecrowd.com.br/judge/pt/problems/view/1632
 */

using System;
using System.Collections.Generic;

class URI
{
    public static void Main(string[] args)
    {
        List<int> resultados = new List<int>();
        int t = int.Parse(Console.ReadLine());

        for (int i = 0; i < t; i++)
        {
            string s = Console.ReadLine();
            resultados.Add(RetornarQtdPossibilidades(s));
        }

        foreach (int resultado in resultados)
        {
            Console.WriteLine(resultado);
        }
    }

    private static int RetornarQtdPossibilidades(string str)
    {
        int qtdPissib = 1;

        for (int i = 0; i < str.Length; i++)
        {
            char caractere = str[i];
            if (VerificarCaractere(caractere))
            {
                qtdPissib *= 3;
            }
            else
            {
                qtdPissib *= 2;
            }
        }
        return qtdPissib;
    }

    private static bool VerificarCaractere(char caractere)
    {
        const string conjuntoDeCaracteres = "AEIOSaeios";

        for (int i = 0; i < conjuntoDeCaracteres.Length; i++)
        {
            if (caractere == conjuntoDeCaracteres[i])
            {
                return true;
            }
        }
        return false;
    }
}