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
            double[] vetor = new double[] { 100, 2, 50, 4, 10, 9, 8 };
            BubbleSort(vetor);
            ExibirArrayOrdenado(vetor);
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

        private static void ExibirArrayOrdenado(double[] vetor)
        {
            Console.WriteLine("ARRAY ORDENADO [BubbleSort]");
            foreach (double num in vetor)
            {
                Console.Write($"{num} ");
            }
        }
    }
}