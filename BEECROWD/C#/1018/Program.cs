/* Objetivo: Determinar a quantidade de notas necessárias para formar um valor.
 * Autor   : William Silva (https://github.com/bruwno)
 * Data    : 05/02/2024
 * Tipo    : 1 (INICIANTE)
 * ID      : 1018
 * Nome    : Cédulas
 * Link    : https://www.beecrowd.com.br/judge/pt/problems/view/1018
 */

using System;

class URI
{
    const int Nota100 = 100, Nota50 = 50, Nota20 = 20, Nota10 = 10, Nota5 = 5, Nota2 = 2, Nota1 = 1;

    public static void Main(string[] args)
    {
        int valor = int.Parse(Console.ReadLine());
        int valorOriginal = valor;

        int[] notas = { Nota100, Nota50, Nota20, Nota10, Nota5, Nota2, Nota1 };
        int[] qtdNotas = new int[notas.Length];

        for (int i = 0; i < notas.Length; i++)
        {
            qtdNotas[i] = valor / notas[i];
            valor %= notas[i];
        }

        Console.WriteLine($"{valorOriginal}");

        for (int i = 0; i < notas.Length; i++)
        {
            Console.WriteLine($"{qtdNotas[i]} nota(s) de R$ {notas[i]},00");
        }
    }
}