
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
        int horaInicial = 0, minInicial = 0, horaFinal = 0, minFinal = 0;
        int horas = 0, minutos = 0, minutosTmp = 0;
        int tempoTotalEmSegundos = 0, tempoTotalEmSegundosH = 0, tempoTotalEmSegundosM = 0;

        string[] tempoJogo = Console.ReadLine()!.Split(' ');

        horaInicial = int.Parse(tempoJogo[0]);
        minInicial = int.Parse(tempoJogo[1]);
        horaFinal = int.Parse(tempoJogo[2]);
        minFinal = int.Parse(tempoJogo[3]);

        if (horaInicial == horaFinal)
        {
            minutosTmp = (minFinal - minInicial) * 60;

            if (horaInicial == horaFinal && minInicial == minFinal)
            {
                tempoTotalEmSegundos = (24 * 3600) + minutosTmp;
            }

            else if (horaInicial == horaFinal && minFinal < minInicial)
            {
                tempoTotalEmSegundos = (24 * 3600) + minutosTmp;
            }

            else
            {
                tempoTotalEmSegundos = ((horaInicial - horaFinal) * 3600) + minutosTmp;
            }
        }

        else if (horaFinal < horaInicial)
        {
            minutosTmp = (minFinal - minInicial) * 60;
            tempoTotalEmSegundos = ((24 - horaInicial + horaFinal) * 3600) + minutosTmp;
        }

        else
        {
            if (horaInicial > horaFinal)
            {
                int tmp = horaInicial;
                horaInicial = horaFinal;
                horaFinal = tmp;
            }

            tempoTotalEmSegundosH = (horaFinal - horaInicial) * 3600;
            tempoTotalEmSegundosM = (minFinal - minInicial) * 60;

            tempoTotalEmSegundos = tempoTotalEmSegundosH + tempoTotalEmSegundosM;

            if (tempoTotalEmSegundos < 0)
            {
                tempoTotalEmSegundos = tempoTotalEmSegundos * -1;
            }
        }

        horas = tempoTotalEmSegundos / 3600;
        int tempoRestante = tempoTotalEmSegundos % 3600;
        minutos = tempoRestante / 60;

        Console.WriteLine($"O JOGO DUROU {horas} HORA(S) E {minutos} MINUTO(S)");
    }
}