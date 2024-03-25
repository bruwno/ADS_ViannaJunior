using System;

namespace Questao4
{
    public class Program
    {
        public static void Main(string[] args)
        {
            int[] vet = new int[] { 2, 1, 3, 0 };

            Console.WriteLine(BubbleSort(vet));
            foreach (int num in vet)
            {
                Console.Write($"{num} ");
            }
        }



        public static int BubbleSort(int[] vet)
        {
            int aux = 0;
            int contaTrocas = 0;

            for (int i = vet.Length - 1; i >= 0; i--)
            {
                for (int j = 0; j < i; j++)
                {
                    if (vet[j] > vet[j + 1])
                    {
                        aux = vet[j];
                        vet[j] = vet[j + 1];
                        vet[j + 1] = aux;
                        contaTrocas++;
                        Console.WriteLine($"[TROCA REALIZADA] {vet[j]} --> {vet[j + 1]}");
                    }
                }
            }
            return contaTrocas;
        }
    }
}