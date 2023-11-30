/* Objetivo : Calcular volume de uma esfera.
 * Autor    : William Silva (https://github.com/unclWill)
 * Data     : 26/09/2023
 * Tipo     : 1 (INICIANTE)
 * ID       : 1011
 * Nome     : Esfera
 * Link     : https://www.beecrowd.com.br/judge/pt/problems/view/1011
 */

using System;
class URI
{
    static void Main(string[] args)
    {
        double raio = double.Parse(Console.ReadLine());

        double volume = (4.0 / 3.0) * 3.14159 * Math.Pow(raio, 3.0);

        Console.WriteLine($"VOLUME = {volume:F3}");
    }
}