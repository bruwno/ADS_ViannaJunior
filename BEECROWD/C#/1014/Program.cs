/* Objetivo: Calcular o consumo médio de um automóvel.
 * Autor   : William Silva (https://github.com/unclWill)
 * Data    : 29/09/2023
 * Tipo    : 1 (INICIANTE)
 * ID      : 1014
 * Nome    : Consumo
 * Link    : https://www.beecrowd.com.br/judge/pt/problems/view/1014
 */

using System;
class URI
{
    static void Main(string[] args)
    {
        int kilometros = int.Parse(Console.ReadLine());
        double combustivelGasto = double.Parse(Console.ReadLine());

        double gastoMedio = kilometros / combustivelGasto;

        Console.WriteLine($"{gastoMedio:F3} km/l");
    }
}
