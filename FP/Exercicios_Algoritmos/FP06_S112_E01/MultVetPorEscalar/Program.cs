/* Objetivo : Multiplicar os valores de um vetor por um valor escalar.
 * Autor    : William Silva (https://github.com/unclWill)
 * Data     : 11/10/2023
 * Material : FP06 (Vetores)
 * Slide    : 112
 * Exercício: 01
 */

/* 1) Desenvolva um programa que leia um vetor de números reais, 
 * um escalar e imprima o resultado da multiplicação do vetor pelo escalar.
 */

using System;

namespace MultVetPorEscalar
{
    internal class Program
    {
        internal static void Main(string[] args)
        {
            Console.WriteLine("Multiplicar vetor por valor escalar");

            Console.Write("Informe a dimensão do vetor: ");
            int dimVet = Convert.ToInt32(Console.ReadLine());

            double[] vet = new double[dimVet];

            for (int i = 0, j = 1; i < vet.Length; i++, j++)
            {
                Console.Write($"Digite o {j}º valor do vetor: ");
                vet[i] = Convert.ToInt32(Console.ReadLine());
            }

            Console.Write("Digite o valor escalar: ");
            int valEscalar = Convert.ToInt32(Console.ReadLine());

            for (int k = 0; k < vet.Length; k++)
            {
                double resultado = vet[k] * valEscalar;

                Console.WriteLine($"Resultado de {vet[k],2} * {valEscalar,2} = {resultado}");
            }

            Console.Write("\nPressione qualquer tecla para finalizar...");
            Console.ReadKey();
        }
    }
}