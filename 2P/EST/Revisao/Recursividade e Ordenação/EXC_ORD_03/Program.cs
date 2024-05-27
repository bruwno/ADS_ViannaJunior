/* Autor: William Silva (https://github.com/unclWill)
 * Data : 09/04/2024
 * 
 * Crie 3 procedimentos que ordenem um vetor de números reais, com positivos e negativos mesclados, 
 * e retornem o tempo que cada algoritmo levou para realizar o processamento, o vetor deve ser o mesmo para os 3 casos.
 */

using System;
using System.Diagnostics;

namespace EXC_ORD_03
{
    class Program
    {
        static void Main(string[] args)
        {
            Stopwatch stopwatch = new Stopwatch();
            Random random = new Random();

            double[] vet = new double[100000]; // -500.1, 467.9, 5.7, -345.7, -0.00579, -2345.8, 1001.0, 29.032, -2345678, 0.1, 230.7, -235.9, 1234763.8, 0.45, 198746.938, 1, 919.092 

            for (int i = 0; i < vet.Length; i++)
            {
                vet[i] = random.NextDouble();
            }

            //Console.WriteLine("VETOR DESORDENADO");
            //ImprimeVetor(vet);

            Console.WriteLine($"\n\nBUBBLESORT | Tempo decorrido: {BubbleSort(vet, stopwatch)} ms");
            //ImprimeVetor(vet);

            Console.WriteLine($"\n\nINSERTIONSORT | Tempo decorrido: {InsertionSort(vet, stopwatch)} ms");
            //ImprimeVetor(vet);

            Console.WriteLine($"\n\nSELECTIONSORT | Tempo decorrido: {SelectionSort(vet, stopwatch)} ms");
            //ImprimeVetor(vet);
        }

        public static long BubbleSort(double[] vet, Stopwatch stw)
        {
            stw.Restart();

            for (int i = vet.Length - 1; i >= 0; i--)
            {
                for (int j = 0; j < i; j++)
                {
                    if (vet[j] > vet[j + 1])
                    {
                        Troca(vet, j, j + 1);
                    }
                }
            }

            stw.Stop();
            return stw.ElapsedMilliseconds;
        }

        public static long InsertionSort(double[] vet, Stopwatch stw)
        {
            stw.Restart();

            for (int i = 1; i < vet.Length; i++)
            {
                double chave = vet[i];
                int j;
                for (j = i - 1; j >= 0 && chave < vet[j]; j--)
                {
                    Troca(vet, j, j + 1);
                }
                vet[j + 1] = chave;
            }

            stw.Stop();
            return stw.ElapsedMilliseconds;
        }

        public static long SelectionSort(double[] vet, Stopwatch stw)
        {
            stw.Restart();

            for (int i = 0; i < vet.Length - 1; i++)
            {
                int indiceMenor = i;
                for (int j = i + 1; j < vet.Length; j++)
                {
                    if (vet[j] < vet[indiceMenor])
                    {
                        indiceMenor = j;
                    }
                }

                if (i != indiceMenor)
                {
                    Troca(vet, i, indiceMenor);
                }
            }

            stw.Stop();
            return stw.ElapsedMilliseconds;
        }

        public static void Troca(double[] vet, int i, int j)
        {
            double aux = vet[i];
            vet[i] = vet[j];
            vet[j] = aux;
        }

        private static void ImprimeVetor(double[] vet)
        {
            foreach (double v in vet)
            {
                Console.Write($"{v} | ");
            }
        }
    }
}