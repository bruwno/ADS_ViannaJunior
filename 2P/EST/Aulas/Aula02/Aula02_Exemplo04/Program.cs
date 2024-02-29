/* Faça um procedimento recursivo que receba um vetor
 * de inteiros e imprima todos os elementos deste vetor.
 */

using System;

namespace Aula02_Exemplo04
{
    public class Program
    {
        public static void Main(string[] args)
        {
            int[] elementos = new int[] { 1, 2, 3, 4, 5 };
            Imprime(elementos);
        }

        public static void Imprime(int[] vetor, int i = 0)
        {
            ImprimirElementos(i, vetor);
        }

        private static void ImprimirElementos(int i, int[] elementos)
        {
            if (i >= elementos.Length)
            {
                Console.WriteLine();
                return;
            }
            Console.Write($"{elementos[i]} ");
            ImprimirElementos(i + 1, elementos);
        }
    }
}

