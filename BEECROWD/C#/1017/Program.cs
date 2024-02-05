/* Objetivo: Calcular o gasto de combustível com base no tempo de viagem e na velocidade média do automóvel.
 * Autor   : William Silva (https://github.com/unclWill)
 * Data    : 05/02/2024
 * Tipo    : 1 (INICIANTE)
 * ID      : 1017
 * Nome    : Gasto de Combustível
 * Link    : https://www.beecrowd.com.br/judge/pt/problems/view/1017
 */

using System;

class URI
{
    public static void Main(string[] args)
    {
        int tempoGasto = int.Parse(Console.ReadLine());
        int velocidadeMedia = int.Parse(Console.ReadLine());

        double resultado = (tempoGasto * velocidadeMedia) / 12.0;
        Console.WriteLine($"{resultado:N3}");
    }
}