
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

        /*/ DIVIDIR A HORA INICIAL PELA HORA FINAL
        if (horaInicial != 0 && horaInicial <= horaFinal)
        {
            while (horaInicial < 24)
            {
                horaInicial += 3600;
            }
        }*/


        #region FUNCIONANDO
        // Convertendo de horas e minutos para segundos. #FUNCIONANDO
        int tempoTotalEmSegundosH = (horaFinal - horaInicial) * 3600;
        int tempoTotalEmSegundosM = (minFinal - minInicial) * 60;
        #endregion

        #region FUNCIONANDO
        int tempoTotalEmSegundos = tempoTotalEmSegundosH + tempoTotalEmSegundosM;

        if (tempoTotalEmSegundos < 0)
        {
            tempoTotalEmSegundos = tempoTotalEmSegundos * -1;
        }
        #endregion

        // DEBUG
        System.Console.WriteLine(tempoTotalEmSegundos);

        #region FUNCIONANDO
        // Convertendo de segundos para horas e minutos.
        int horas = tempoTotalEmSegundos / 3600;
        int tempoRestante = tempoTotalEmSegundos % 3600;
        int minutos = tempoRestante / 60;

        Console.WriteLine($"O JOGO DUROU {horas} HORA(S) E {minutos} MINUTO(S)");
        #endregion
    }
}