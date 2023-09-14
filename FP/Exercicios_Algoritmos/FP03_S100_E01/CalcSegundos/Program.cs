/* Objetivo : Converter segundos para h, m e s.
 * Autor    : William Silva (https://github.com/unclWill)
 * Data     : 19/08/2023
 * Material : FP03
 * Slide    : 100
 * Exercício: 01
 */

/* Comando:
 * 1) Faça um procedimento que receba por parâmetro o tempo de duração de um experimento expresso
 * em segundos e imprima na tela esse mesmo tempo em horas, minutos e segundos.
 */

using System;

namespace CalcSegundos
{
    public class Program
    {
        public static void Main(string[] args)
        {
            Console.WriteLine("Converter tempo em segundos\n");
            ObterDados();
            Console.Write("\nPressione qualquer tecla para finalizar...");
            Console.ReadKey();
        }

        private static void ObterDados()
        {
            Console.Write("[i] Digite o tempo em segundos: ");
            int tempoEmSegundos = Convert.ToInt32(Console.ReadLine());

            ConverterTempo(tempoEmSegundos);
        }

        private static void ConverterTempo(int tempoEmSeg)
        {
            int tempoRestante, horas, minutos, segundos;
            horas = tempoEmSeg / 3600;
            tempoRestante = tempoEmSeg % 3600;
            minutos = tempoRestante / 60;
            segundos = tempoRestante % 60;

            Console.WriteLine($"\nO experimento de {tempoEmSeg} segundos durou o total de {horas}h {minutos}m {segundos}s ");
        }
    }
}