
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
        string[] tempoJogo = Console.ReadLine().Split(' ');
        int horaInicial = 0, minInicial = 0, horaFinal = 0, minFinal = 0;

        horaInicial = int.Parse(tempoJogo[0]);
        minInicial = int.Parse(tempoJogo[1]);
        horaFinal = int.Parse(tempoJogo[2]);
        minFinal = int.Parse(tempoJogo[3]);

        // DIVIDIR A HORA INICIAL PELA HORA FINAL
        if (horaInicial <= horaFinal)
        {
            while (horaInicial < 24)
            {
                horaInicial += 3600;
            }
        }


        // Convertendo de horas e minutos para segundos.
        int tempoTotalEmSegundosH = (horaFinal - horaInicial) * 3600;
        int tempoTotalEmSegundosM = (minFinal - minInicial) * 60;

        if (tempoTotalEmSegundosH < 0)
        {
            tempoTotalEmSegundosH *= -1 * 24;
        }
        if (tempoTotalEmSegundosM < 0)
        {
            tempoTotalEmSegundosM *= -1 * 60;
        }

        int horasTotais = tempoTotalEmSegundosH + tempoTotalEmSegundosM;

        // DEBUG
        System.Console.WriteLine(horasTotais);

        // Convertendo de segundos para horas e minutos.
        int horas = horasTotais / 3600;
        int tempoRestante = horasTotais % 3600;
        int minutos = tempoRestante / 60;

        Console.WriteLine($"O JOGO DUROU {horas} HORA(S) E {minutos} MINUTO(S)");
    }
}