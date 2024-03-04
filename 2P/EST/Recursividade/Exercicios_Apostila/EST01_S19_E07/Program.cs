/* Autor: William Silva (https://github.com/unclWill)
 * Data : 04/03/2024
 *
 * 6) Faça um procedimento recursivo que receba por parâmetro um vetor vet de
 * números reais e, multiplique por −1 todos os elementos negativos desse vetor.
 */

using System;

namespace EST01_S19_E07
{
    public class Program
    {
        public static void Main(string[] args)
        {
            Console.WriteLine(Somar(-5));
        }

        public static int Somar(int n)
        {
            if (n == 0)
            {
                return 0;
            }
            else
            {
                if (n < 0)
                {
                    return n + Somar(n + 1);
                }
                else
                {
                    return n + Somar(n - 1);
                }
            }
        }
    }
}