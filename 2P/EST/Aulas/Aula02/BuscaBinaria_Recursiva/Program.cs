using System;

namespace BuscaBinaria_Recursiva
{
    public class Program
    {
        public static void Main(string[] args)
        {
            int[] v = new int[] { 1, 2, 5, 10, 20, 25, 27, 30, 49, 51, 52, 57, 60, 68, 70, 71, 72, 89, 95, 96, 99, 101 };
            int posicaoNoVetor = BuscaBinaria(v, 5);
            Console.WriteLine($"Posição do valor X = {posicaoNoVetor}");
        }

        public static int BuscaBinaria(int[] v, int chave)
        {
            return BuscaBin(v, 0, v.Length - 1, chave);
        }

        private static int BuscaBin(int[] v, int inicio, int fim, int x)
        {
            int meio = (inicio + fim) / 2; // Ponto médio.
            if (v[meio] == x)
                return meio;

            if (inicio == fim)
                return -1;

            if (v[meio] > x) // Busca na primeira metade.
            {
                return BuscaBin(v, inicio, meio - 1, x);
            }
            else // Busca na segunda metade.
            {
                return BuscaBin(v, meio + 1, fim, x);
            }
        }
    }
}