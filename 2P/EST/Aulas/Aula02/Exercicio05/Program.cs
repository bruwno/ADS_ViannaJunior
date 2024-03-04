/* Faça uma função recursiva que receba um vetor de interios por parâmetro
 * e retorna a soma dos elementos pertencentes a este vetor.
 */

using System;

namespace Exercicio05
{
    public class Program
    {
        public static void Main(string[] args)
        {
            int[] array = new int[] { 1, 2, 3, 4, 5 };
            Console.WriteLine(RetornaSoma(array, 0, 0));
        }

        public static int RetornaSoma(int[] array, int i, int soma = 0)
        {
            if (i >= array.Length)
            {
                return soma;
                // return 0;
            }
            else
            {
                soma += array[i];
                return RetornaSoma(array, i + 1, soma);
                // return array[i] + RetornaSoma(array, i + 1);
            }
        }
    }
}
