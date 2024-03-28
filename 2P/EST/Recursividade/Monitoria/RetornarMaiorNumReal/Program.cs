/* Data: 21/03/2024
 -> Faça uma função recursiva que retorne o maior número existente em um vetor de números reais.
 */

using System;

namespace RetornarMaiorNumReal
{
    public class Program
    {
        public static void Main(string[] args) 
        {
            double[] vet = new double[] { 4.5, 9.9, 10.1, 3.14, 99.7, 75.2 };
            Console.WriteLine(RetornaMaiorReal(vet));
        }

        public static double RetornaMaiorReal(double[] vet, double maior = 0, int i = 0)
        {
            if (i >= vet.Length) 
            {
                return maior;
            }
            else
            {
                if (vet[i] > maior) 
                {
                    maior = vet[i];
                }
                return RetornaMaiorReal(vet, maior, i + 1);
            }
        }
    }
}