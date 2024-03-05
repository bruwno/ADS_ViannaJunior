/* Algoritmo BuubleSort
 *
 * Troca de valores
 * Data: 04/03/2024
 */

using System;

namespace BubbleSort
{
    public class Program
    {
        public static void Main(string[] args)
        {
            double[] vet = new double[] { 1, 2, 5, 4, 10, 9, 8 };
            BubbleSort(vet);

            foreach (var num in vet)
            {
                Console.Write($"{num} ");
            }
        }

        public static void BubbleSort(double[] vetor)
        {
            int fim = vetor.Length - 1, pos = 0;
            bool troca = true;

            while (troca)
            {
                troca = false;
                for (int i = 0; i < fim; i++)
                {
                    if (vetor[i] > vetor[i + 1])
                    {
                        Troca(vetor, i, i + 1);
                        pos = i;
                        troca = true;
                    }
                }
                fim = pos - 1;
            }
        }

        private static void Troca(double[] vetor, int i, int j)
        {
            double aux = vetor[i];
            vetor[i] = vetor[j];
            vetor[j] = aux;
        }
    }
}