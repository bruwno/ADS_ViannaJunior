/* Autor: William Silva (https://github.com/unclWill)
 * Data : 10/04/2024
 * 
 * Faça uma função recursiva para calcualar a soma de todos os valores de um vetor de números reais.
 */

using System;

namespace EXC_REC_05
{
    class Program
    {
        static void Main(string[] args)
        {
            double[] vet = new double[] { 0.5, 1.5, 3.0, 3.5, 1.5 };
            CalcularSoma(vet);
        }

        public static void CalcularSoma(double[] vet, double soma = 0.0, int i = 0)
        {
            if (i == vet.Length)
            {
                Console.WriteLine($"Resultado da soma = {soma}");
            }
            else
            {
                soma += vet[i];
                CalcularSoma(vet, soma, i + 1);
            }
        }
    }
}
