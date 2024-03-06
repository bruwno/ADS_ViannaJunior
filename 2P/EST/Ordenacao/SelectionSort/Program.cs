/* Algoritmo SelectionSort
 *
 * Inserção por Seleção
 * Data: 05/03/2024
 */

using System;

namespace InsertionSort
{
    public class Program
    {
        public static void Main(string[] args)
        {
            double[] vetor = new double[] { 30, 20, 10, 5, 100, 34, 205 };
            SelectionSort(vetor);
            ExibirArrayOrdenado(vetor);
        }

        public static void SelectionSort(double[] vetor)
        {
            for (int i = 0; i < vetor.Length; i++)
            {
                int indMenor = i;
                for (int j = i + 1; j < vetor.Length; j++)
                {
                    if (vetor[j] < vetor[indMenor])
                    {
                        indMenor = j;
                    }
                }
                if (i != indMenor)
                {
                    Troca(vetor, i, indMenor);
                }
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
            Console.WriteLine("ARRAY ORDENADO [SelectionSort]");
            foreach (double num in vetor)
            {
                Console.Write($"{num} ");
            }
        }
    }
}