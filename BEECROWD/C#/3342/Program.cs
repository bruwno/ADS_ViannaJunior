/* Objetivo: Contar quantas casas brancas e quantas casas pretas um tabuleiro de xadrez com n linhas e colunas possui.
 * Autor   : William Silva (https://github.com/bruwno)
 * Data    : 21/12/2023
 * Tipo    : 1 (INICIANTE)
 * ID      : 3342
 * Nome    : Keanu
 * Link    : https://www.beecrowd.com.br/judge/pt/problems/view/3342
 */

using System;

class URI
{
    public static void Main(string[] args)
    {
        int dimensao = int.Parse(Console.ReadLine());
        int[,] tabuleiro = new int[dimensao, dimensao];
        int casasBrancas = 0, casasPretas = 0;

        for (int i = 0; i < tabuleiro.GetLength(0); i++)
        {
            for (int j = 0; j < tabuleiro.GetLength(1); j++)
            {
                if ((i % 2 == 0) && (j % 2 == 0) || (i % 2 != 0) && (j % 2 != 0))
                {
                    casasBrancas++;
                }
                else
                {
                    casasPretas++;
                }
            }
        }
        Console.WriteLine($"{casasBrancas} casas brancas e {casasPretas} casas pretas");
    }
}