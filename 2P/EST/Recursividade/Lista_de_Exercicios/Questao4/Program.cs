using System;

namespace Questao4
{
    public class Program
    {
        public static void Main(string[] args)
        {
            int[] vet = new int[] { 2, 1, 3, 0, 5, 4 };
            Console.WriteLine($"Para ordernar este vetor foi necessário realizar {RetornaQtdTrocas(vet)} troca(s).");
        }



        public static int RetornaQtdTrocas(int[] vet)
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
                    }
                }
            }
            return contaTrocas;
        }
    }
}