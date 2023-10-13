/* Objetivo : Buscar um valor no vetor e imprimir quantas vezes ele aparece.
 * Autor    : William Silva (https://github.com/unclWill)
 * Data     : 11/10/2023
 * Material : FP06 (Vetores)
 * Slide    : 112
 * Exercício: 04
 */

/* 4) Faça um programa que leia um vetor de 15 posições (reais) e depois um valor a ser procurado no vetor. 
 * Imprima se o valor foi ou não encontrado e a quantidade de vezes que o valor está presente no vetor.
 */

using System;

namespace BuscarValNoVet
{
    internal class Program
    {
        internal static void Main(string[] args)
        {
            double[] vet = new double[15];

            Console.WriteLine("Ler 15 valores");

            for (int i = 0, j = 1; i < vet.Length; i++, j++)
            {
                Console.Write($"Digite o {j}º valor: ");
                vet[i] = Convert.ToDouble(Console.ReadLine());
            }

            Console.Write("Informe o valor que deseja buscar no vetor: ");
            double valorABuscar = Convert.ToDouble(Console.ReadLine());

            BuscarValor(vet, valorABuscar);

            Console.Write("\nPressione qualquer tecla para finalizar...");
            Console.ReadKey();
        }

        private static void BuscarValor(double[] vet, double valorDaBusca)
        {
            int qtdOcorrencias = 0;

            for (int i = 0; i < vet.Length; i++)
            {
                if (vet[i] == valorDaBusca)
                {
                    qtdOcorrencias++;
                }
            }

            switch (qtdOcorrencias)
            {
                case 0:
                    Console.WriteLine($"\nO valor {valorDaBusca} não foi encontrado no vetor.");
                    break;
                case 1:
                    Console.WriteLine($"\nO valor {valorDaBusca} foi encontrado {qtdOcorrencias} vez no vetor.");
                    break;
                default:
                    Console.WriteLine($"\nO valor {valorDaBusca} foi encontrado {qtdOcorrencias} vezes no vetor.");
                    break;
            }
        }
    }
}