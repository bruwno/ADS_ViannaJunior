/* Objetivo: Calcular a distância percorrida por dois veículos se movendo a velocidades diferentes.
 * Autor   : William Silva (https://github.com/bruwno)
 * Data    : 31/01/2024
 * Tipo    : 1 (INICIANTE)
 * ID      : 1016
 * Nome    : Distância
 * Link    : https://www.beecrowd.com.br/judge/pt/problems/view/1016
 */

using System;

class URI
{
    public static void Main(string[] args)
    {
        int distancia = int.Parse(Console.ReadLine());
        int tempo = distancia * 2;
        Console.WriteLine($"{tempo} minutos");
    }
}