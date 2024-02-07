/* Objetivo: Converter uma entrada de tempo em segundos para horas, minutos e segundos.
 * Autor   : William Silva (https://github.com/unclWill)
 * Data    : 07/02/2024
 * Tipo    : 1 (INICIANTE)
 * ID      : 1019
 * Nome    : Conversão de Tempo
 * Link    : https://www.beecrowd.com.br/judge/pt/problems/view/1019
 */

using System;

class URI
{
    public static void Main(string[] args)
    {
        int tempoEmSegundos = int.Parse(Console.ReadLine());
        ConversorDeTempo(tempoEmSegundos);
    }

    private static void ConversorDeTempo(int tempoEmSegundos)
    {
        int tempoRestante, horas, minutos, segundos;
        horas = tempoEmSegundos / 3600;
        tempoRestante = tempoEmSegundos % 3600;
        minutos = tempoRestante / 60;
        segundos = tempoRestante % 60;

        Console.WriteLine($"{horas}:{minutos}:{segundos}");
    }
}