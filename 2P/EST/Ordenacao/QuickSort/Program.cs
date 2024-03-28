using System;

namespace QuickSort
{
    public class Program
    {
        public static void Main(string[] args)
        {
            double[] vetor = new double[] { 50, 10, 20, 70, 80, 1, 80 };
            Quicksort(vetor);
            ExibirElementosDoVetor(vetor);

            Console.ReadKey();
        }

        public static void Quicksort(double[] vetor)
        {
            Quicksort(vetor, 0, vetor.Length - 1);
        }

        public static void Quicksort(double[] vetor, int inicio, int fim)
        {
            // Condição de parada.
            if (inicio >= fim)
            {
                return;
            }

            int indiceMenor = fim, indiceMaior = inicio;
            var pivo = indiceMenor;

            do
            {
                while (indiceMaior < fim && vetor[indiceMaior] <= vetor[pivo])
                {
                    indiceMaior++;
                }

                while (indiceMenor > inicio && vetor[indiceMenor] > vetor[pivo])
                {
                    indiceMenor--;
                }

                if (indiceMaior < indiceMenor)
                {
                    Troca(vetor, indiceMaior, indiceMenor);
                }
            } while (indiceMenor > indiceMaior);

            Troca(vetor, indiceMenor, pivo);

            Quicksort(vetor, inicio, pivo - 1);
            Quicksort(vetor, pivo + 1, fim);
        }

        public static void Troca(double[] vetor, int i, int j)
        {
            double aux = vetor[i];
            vetor[i] = vetor[j];
            vetor[j] = aux;
        }

        private static void ExibirElementosDoVetor(double[] vetor)
        {
            foreach (var e in vetor)
            {
                Console.Write($"{e} ");
            }
        }
    }
}