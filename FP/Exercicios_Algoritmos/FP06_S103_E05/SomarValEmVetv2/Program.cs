/* Objetivo : Somar os valores de dois vetores.
 * Autor    : William Silva (https://github.com/unclWill)
 * Data     : 10/10/2023
 * Material : FP06 (Vetores)
 * Slide    : 103
 * Exercício: 05
 */

/* 5) Refaça o exercício anterior criando um procedimento para efetuar a leitura dos vetores e um
 * segundo procedimento que imprimirá a soma dos vetores.
 */

using System;

namespace SomarValEmVetorv2
{
    internal class Program
    {
        const int dim = 10;

        internal static void Main(string[] args)
        {
            int i, j;
            int[] vet1 = new int[dim];
            int[] vet2 = new int[dim];

            Console.WriteLine("Digite 20 valores inteiros");

            for (i = 0, j = 1; i < vet1.Length; i++, j++)
            {
                Console.Write($"\nDigite o {j}º valor do primeiro vetor: ", Console.ForegroundColor = ConsoleColor.Green);
                vet1[i] = int.Parse(Console.ReadLine());

                Console.Write($"\nDigite o {j}º valor do segundo vetor : ", Console.ForegroundColor = ConsoleColor.Blue);
                vet2[i] = int.Parse(Console.ReadLine());
            }

            Somar(vet1, vet2);

            Console.Write("\nPressione qualquer tecla para finalizar...", Console.ForegroundColor = ConsoleColor.Gray);
            Console.ReadKey();
        }

        private static void Somar(int[] vet1, int[] vet2)
        {
            int resultado = 0;

            for (int i = 0; i < vet1.Length; i++)
            {
                resultado = vet1[i] + vet2[i];
                Console.WriteLine($"Resultado de {vet1[i],4} + {vet2[i],4} = {resultado,4}", Console.ForegroundColor = ConsoleColor.Gray);
            }
        }
    }
}
