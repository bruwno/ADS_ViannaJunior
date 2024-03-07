using System;

namespace BubbleSort
{
    public class Program
    {
        public static void Main(string[] args)
        {
            int[] vetor = new int[] { 8, 5, 7, 100, 65 };
            BubbleSort(vetor);
            foreach (var num in vetor) 
            {
                Console.Write($"{num} ");
            }
        }

        public static void BubbleSort(int[] vet)
        {
            int aux = 0;
            bool houveTroca = true;

            do {
                houveTroca = false;

                for (int i =0; i < vet.Length - 1; i++)
                {
                    if (vet[i] > vet[i + 1])
                    {
                        aux = vet[i];
                        vet [i] = vet[i + 1];
                        vet[i + 1] = aux;
                        houveTroca = true;
                    }
                }

            } while (houveTroca);
        }
    }
}