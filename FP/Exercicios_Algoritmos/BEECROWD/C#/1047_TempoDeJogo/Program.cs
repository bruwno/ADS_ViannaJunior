
/* Objetivo : Calcular a duração de um jogo.
 * Autor    : William Silva (https://github.com/unclWill)
 * Data     : 25/09/2023
 * Tipo     : 1 (INICIANTE)
 * ID       : 1047
 * Nome     : Tempo de Jogo com Minutos
 * Link     : https://www.beecrowd.com.br/judge/pt/problems/view/1047
 */

using System;

class URI
{
    static void Main(string[] args)
    {
        string[] tempoDeJogo = Console.ReadLine().Trim().Split(' ');
        CalcularTempoDeJogo(tempoDeJogo);
    }

    private static void CalcularTempoDeJogo(string[] tempoDeJogo)
    {
        int tempoTotalEmSegundos = 0;

        int horaInicial = int.Parse(tempoDeJogo[0]);
        int minInicial = int.Parse(tempoDeJogo[1]);
        int horaFinal = int.Parse(tempoDeJogo[2]);
        int minFinal = int.Parse(tempoDeJogo[3]);

        int minutos = (minFinal - minInicial) * 60;

        if (horaInicial == horaFinal)
        {
            tempoTotalEmSegundos = HoraInicialIgualHoraFinal(horaInicial, horaFinal, minInicial, minFinal, minutos);
        }

        else if (horaFinal < horaInicial)
        {
            tempoTotalEmSegundos = HoraFinalMenorQueHoraInicial(horaInicial, horaFinal, minInicial, minFinal, minutos);
        }

        else
        {
            tempoTotalEmSegundos = HoraFinalMaiorQueHoraInicial(horaInicial, horaFinal, minInicial, minFinal, minutos);
        }

        ConverterSegundosParaHoras(tempoTotalEmSegundos);
    }

    private static int HoraInicialIgualHoraFinal(int horaInicial, int horaFinal, int minInicial, int minFinal, int minutos)
    {
        int tempoEmSegundos = 0;

        if (minInicial == minFinal)
        {
            return tempoEmSegundos = (24 * 3600) + minutos;
        }

        else if (minFinal < minInicial)
        {
            return tempoEmSegundos = (24 * 3600) + minutos;
        }

        else
        {
            return tempoEmSegundos = ((horaInicial - horaFinal) * 3600) + minutos;
        }
    }

    private static int HoraFinalMenorQueHoraInicial(int horaInicial, int horaFinal, int minInicial, int minFinal, int minutos)
    {
        int tempoEmSegundos = 0;
        return tempoEmSegundos = ((24 - horaInicial + horaFinal) * 3600) + minutos;
    }

    private static int HoraFinalMaiorQueHoraInicial(int horaInicial, int horaFinal, int minInicial, int minFinal, int minutos)
    {
        int tempoEmSegundos = ((horaFinal - horaInicial) * 3600) + minutos;

        if (tempoEmSegundos < 0)
        {
            return tempoEmSegundos *= -1;
        }

        return tempoEmSegundos;
    }

    private static void ConverterSegundosParaHoras(int tempoEmSegundos)
    {
        int horas = tempoEmSegundos / 3600;
        int tempoRestante = tempoEmSegundos % 3600;
        int minutos = tempoRestante / 60;

        Console.WriteLine($"O JOGO DUROU {horas} HORA(S) E {minutos} MINUTO(S)");
    }
}