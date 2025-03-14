/*
 * Objetivo: Verificar quem vence a batalha dos cinco exércitos de acordo com a quantidade de tropas.
 * Autor   : William Silva (https://github.com/bruwno)
 * Data    : 31/01/2024
 * Tipo    : 1 (INICIANTE)
 * ID      : 3147
 * Nome    : A Batalha dos Cinco Exércitos
 * Link    : https://www.beecrowd.com.br/judge/pt/problems/view/3147
 */

using System;

class URI
{
    public static void Main(string[] args)
    {
        string[] entrada = Console.ReadLine().Trim().Split(' ');
        int[] exercitos = Array.ConvertAll(entrada, int.Parse);

        int exercitosBem = RetornarQtdExercitosDoBem(exercitos[0], exercitos[1], exercitos[2], exercitos[5]);
        int exercitosMal = RetornarQtdExercitosDoMal(exercitos[3], exercitos[4]);

        if (exercitosBem >= exercitosMal)
        {
            Console.WriteLine("Middle-earth is safe.");
        }
        else
        {
            Console.WriteLine("Sauron has returned.");
        }
    }

    private static int RetornarQtdExercitosDoBem(int h, int e, int a, int x)
    {
        int resultado = h + e + a + x;
        return resultado;
    }

    private static int RetornarQtdExercitosDoMal(int o, int w)
    {
        int resultado = o + w;
        return resultado;
    }
}