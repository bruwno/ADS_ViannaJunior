/* Objetivo : Buscar um valor no vetor e iformar a posição do mesmo.
 * Autor    : William Silva (https://github.com/unclWill)
 * Data     : 11/10/2023
 * Material : FP06 (Vetores)
 * Slide    : 113
 * Exercício: 05
 */

/* 5) Faça uma função que receba um vetor de números inteiros e um valor inteiro. 
 * A função deverá procurar este segundo valor neste vetor e retornar seu índice se for encontrado. 
 * Se o elemento não for encontrado, retornar -1.
 */

using System;

namespace BuscarValor
{
    internal class Program
    {
        internal static void Main(string[] args)
        {
            Console.WriteLine("Ler valores");

            int[] vet = new int[10];

            for (int i = 0, j = 1; i < vet.Length; i++, j++)
            {
                Console.Write($"Digite o {j}º valor: ");
                vet[i] = Convert.ToInt32(Console.ReadLine());
            }

            Console.Write("Digite o valor que deseja buscar no vetor: ");
            int valorABuscar = Convert.ToInt32(Console.ReadLine());

            int posic = BuscarValor(vet, valorABuscar);

            if (posic == -1) 
            {
                Console.WriteLine($"Elemento não foi encontrado.");
            }
            else
            {
                Console.WriteLine($"Elemento foi encontrado na posição {posic}");
            }

            Console.Write("\nPressione qualquer tecla para finalizar...");
            Console.ReadKey();
        }

        private static int BuscarValor(int[] vet, int valorDaBusca)
        {
            int posicValor = 0;
            bool valorEncontrado = false;

            for (int i = 0; i < vet.Length; i++) 
            {
                if (vet[i] == valorDaBusca) 
                {
                    posicValor = i;
                    valorEncontrado = true;
                }
            }

            if (valorEncontrado == true)
            {
                return posicValor;
            }
            else
            {
                return -1;
            }
        }
    }
}