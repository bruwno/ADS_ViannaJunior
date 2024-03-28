/* Método da ordenação de um baralho.
 */

using System;

namespace InsertionSort
{
    public class Program
    {
        public static void Main(string[] args)
        {
            int[] vetor = new int[] { 30, 20, 10, 5, 100, 34, 205 };
            //InsertionSort(vetor);
            SelectionSort(vetor);
            foreach (var num in vetor) {
                Console.Write($"{num} ");
            }
        }

        public static void InsertionSort(int[] vet) 
        {
            int atual, i;

            for (int posUltOrdenado = 0; posUltOrdenado < vet.Length - 1; posUltOrdenado++) 
            {
                atual = vet[posUltOrdenado + 1];
                for (i = posUltOrdenado; i >= 0 && vet[i] > atual; i--)
                {
                    vet[i + 1] = vet[i];
                }
                vet[i + 1] = atual;
            }
        }

        public static void SelectionSort(int[] vet) 
        {
            int indiceMenor, aux;

            for (int i = 0; i < vet.Length - 1; i++) {
                indiceMenor = i;
                for (int j = i + 1; j < vet.Length; j++) 
                {
                    if (vet[j] < vet[indiceMenor])
                    {
                        indiceMenor = j;
                    }
                }
                if (indiceMenor != i) {
                    aux = vet[i];
                    vet[i] = vet[indiceMenor];
                    vet[indiceMenor]= aux;
                }
            }
        }
    }
}
