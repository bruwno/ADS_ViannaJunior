/* Autor: William Silva (https://github.com/unclWill)
 * Data : 09/11/2024
 *
 * Exercício 4) Faça uma função recursiva que permita somar os elementos de um vetor de inteiros.
 */

using System;

namespace Exercicio04
{
    public class Program
    {
        public static void Main(string[] args)
        {
            int[] vetor = new int[] { 1, 1, 2 };
            Console.WriteLine(SomarVetor(vetor, 0));
        }

        public static int SomarVetor(int[] vetor, int i)
        {
            if (i >= vetor.Length)
            {
                return 0;
            }
            else
            {
                return vetor[i] + SomarVetor(vetor, i + 1);
            }
        }
    }
}