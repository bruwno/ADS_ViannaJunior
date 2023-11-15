/* Objetivo : Determinar quanto tempo um intervalo em segundos representa.
 * Autor    : William Silva (https://github.com/unclWill)
 * Data     : 16/08/2023
 * Material : FP02 (E/S de dados)
 * Slide    : 48
 * Exercício: 06
 */

/* Comando:
 * 6. Construa um programa para ler um intervalo
 * de tempo em segundos, converter para
 * horas, minutos e segundos e imprimir o resultado.
 */

using System;

namespace ConversorDeTempo
{
    public class Program
    {
        public static void Main(string[] args)
        {
            Console.WriteLine("Converter segundos\n");
            ObterDados();
            Console.Write("\nPressione qualquer tecla para finalizar...");
            Console.ReadKey();
        }

        private static void ObterDados()
        {
            Console.Write("[i] Informe o intervalo de tempo em segundos: ");
            int tempoEmSegundos = Convert.ToInt32(Console.ReadLine());
            ConverterSegundos(tempoEmSegundos);
        }

        private static void ConverterSegundos(int tempoEmSegundos)
        {
            int tempoRestante, horas, minutos, segundos;
            horas = tempoEmSegundos / 3600;
            tempoRestante = tempoEmSegundos % 3600;
            minutos = tempoRestante / 60;
            segundos = tempoRestante % 60;

            Console.WriteLine($"\n[>] {tempoEmSegundos} segundos são: {horas}h {minutos}m {segundos}s");
        }
    }
}
