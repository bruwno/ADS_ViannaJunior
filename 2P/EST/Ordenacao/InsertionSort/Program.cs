/* Algoritmo InsertionSort
 *
 * Inserção Direta
 * Data: 05/03/2024
 */

using System;

namespace InsertionSort
{
    public class Program
    {
        public static void Main(string[] args)
        {
            double[] vet = new double[] { 200, 199, 156, 101, 98, 75, 68, 60, 50, 45, 30, 29, 13, 9, 8, 3, 1 }; // Pior caso.
            InsertionSort(vet);
            ExibirDadosDoArray(vet);
        }

        public static void InsertionSort(double[] vetor)
        {
            for (int i = 1; i < vetor.Length; i++)
            {
                double chave = vetor[i];
                int j = i - 1;
                while (j >= 0 && chave < vetor[j])
                {
                    vetor[j + 1] = vetor[j];
                    j--;
                }
                vetor[j + 1] = chave;
            }
        }

        private static void ExibirDadosDoArray(double[] vet)
        {
            Console.WriteLine("ARRAY ORDENADO [InsertionSort]");
            foreach (double num in vet)
            {
                Console.Write($"{num} ");
            }
        }
    }
}
