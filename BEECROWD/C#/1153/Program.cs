/* Objetivo: Calcular o fatorial de um valor N.
 * Autor   : William Silva (https://github.com/bruwno)
 * Data    : 16/10/2023
 * Tipo    : 1 (INICIANTE)
 * ID      : 1153
 * Nome    : Fatorial Simples
 * Link    : https://www.beecrowd.com.br/judge/pt/problems/view/1153
 */

using System;

class URI
{
    static void Main(string[] args)
    {
        int n = int.Parse(Console.ReadLine());

        Console.WriteLine(CalcularFatorial(n));
    }

    private static int CalcularFatorial(int n)
    {
        int fat = 1;

        for (int i = n; i > 1; i--)
        {
            fat *= i;
        }

        return fat;
    }
}