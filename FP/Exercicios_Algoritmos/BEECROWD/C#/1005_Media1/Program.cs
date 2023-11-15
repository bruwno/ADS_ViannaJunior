/* Objetivo : Calcular a média ponderada sobre 2 notas.
 * Autor    : William Silva (https://github.com/unclWill)
 * Data     : 20/09/2023
 * Tipo     : 1 (INICIANTE)
 * ID       : 1005
 * Nome     : Média 1
 * Link     : https://www.beecrowd.com.br/judge/pt/problems/view/1005
 */

using System;

class URI
{
    static void Main(string[] args)
    {
        double a = double.Parse(Console.ReadLine());
        double b = double.Parse(Console.ReadLine());

        double media = ((3.5 * a) + (7.5 * b)) / 11.0;

        Console.WriteLine("MEDIA = {0}", media.ToString("F5"));
    }
}