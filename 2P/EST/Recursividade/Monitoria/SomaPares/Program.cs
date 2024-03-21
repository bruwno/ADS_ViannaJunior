/* Exercício: Faça uma função recursiva que retorne a soma dos elementos pares, existentes em um vetor de inteiros.
 * Data: 18/06/2024
 */

using System;

namespace SomaPares
{
    public class Program
    {
        public static void Main(string[] args)
        {
            int[] vet = new int[] { 0, 1, 1, 1, 11, 9, 2, 0, 100 };
            Console.Write($"Resultado= {SomaPares(0, vet, 0)}");
        }

        public static int SomaPares(int i, int[] vet, int soma)
        {
          if (i >= vet.Length)
            {
                return soma;
            }
            else
            {
                if (vet[i] % 2 == 0) 
                {
                    soma += vet[i];
                }
                return SomaPares(i+1, vet, soma);
            }
        }
    }
}