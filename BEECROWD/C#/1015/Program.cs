/* Objetivo: Calcular a distância entre dois pontos.
 * Autor   : William Silva (https://github.com/unclWill)
 * Data    : 05/02/2024
 * Tipo    : 1 (INICIANTE)
 * ID      : 1015
 * Nome    : Distância Entre Dois Pontos
 * Link    : https://www.beecrowd.com.br/judge/pt/problems/view/1015
 */

using System;

class URI
{
    public static void Main(string[] args)
    {
        string[] p1 = Console.ReadLine().Trim().Split(' ');
        string[] p2 = Console.ReadLine().Trim().Split(' ');

        double x1 = double.Parse(p1[0]);
        double x2 = double.Parse(p2[0]);
        double y1 = double.Parse(p1[1]);
        double y2 = double.Parse(p2[1]);

        Console.WriteLine($"{CalcularDistanciaEntrePontos(x1, x2, y1, y2):N4}");
    }

    private static double CalcularDistanciaEntrePontos(double x1, double x2, double y1, double y2)
    {
        return Math.Sqrt(Math.Pow(x2 - x1, 2) + Math.Pow(y2 - y1, 2));
    }
}
