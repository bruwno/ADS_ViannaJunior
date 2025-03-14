/* Objetivo: Calcular a média ponderada sobre 3 notas.
 * Autor   : William Silva (https://github.com/bruwno)
 * Data    : 20/09/2023
 * Tipo    : 1 (INICIANTE)
 * ID      : 1006
 * Nome    : Média 2
 * Link    : https://www.beecrowd.com.br/judge/pt/problems/view/1006
 */

using System;

class URI
{
    static void Main(string[] args)
    {
        double a = double.Parse(Console.ReadLine());
        double b = double.Parse(Console.ReadLine());
        double c = double.Parse(Console.ReadLine());

        double media = ((2.0 * a) + (3.0 * b) + (5.0 * c)) / 10.0;

        Console.WriteLine("MEDIA = {0}", media.ToString("F1"));
    }
}

