/* Autor: William Silva (https://github.com/unclWill)
 * Data : 04/03/2024
 *
 * 6) Faça um procedimento recursivo que receba por parâmetro um vetor vet de
 * números reais e, multiplique por −1 todos os elementos negativos desse vetor.
 */

using System;

namespace EST01_S19_E06
{
    public class Program
    {
        public static void Main(string[] args)
        {
            double[] vet = new double[] { 5, -3, 2, -2 };
            MultiplicaNegativos(vet, 0);
            Console.WriteLine(MultiplicaNegativosV2(vet, 0));
        }

        public static void MultiplicaNegativos(double[] vet, int i = 0)
        {
            if (i < vet.Length)
            {
                if (vet[i] < 0)
                {
                    vet[i] *= -1;
                }
                MultiplicaNegativos(vet, i + 1);
            }
        }

        // Versão com função.
        public static double MultiplicaNegativosV2(double[] vet, int i = 0)
        {
            if (i >= vet.Length)
            {
                return 1;
            }
            else
            {
                if (vet[i] < 0)
                    return vet[i] *= MultiplicaNegativosV2(vet, i + 1);
                else
                    return vet[i] * MultiplicaNegativosV2(vet, i + 1);
            }
        }

    }
}
