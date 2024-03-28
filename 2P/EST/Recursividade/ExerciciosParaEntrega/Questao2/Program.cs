/* Autor: William Silva (https://github.com/unclWill)
 * Data : 25/03/2024
 *
 * Questão 2)
 * Faça uma função que receba um vetor de números inteiros por parâmetro e multiplique
 * por -1 todos os elementos negativos desse vetor. A função deve retornar o número de
 * elementos negativos encontrados. Restrição: não utilize comandos de repetição.
 */

using System;

namespace Questao2
{
    public class Program
    {
        public static void Main(string[] args)
        {
            int[] vet = new int[] { -2, 3, -5, 7, -4, 10 };
            Console.WriteLine(RetornaQtdNegativos(vet));
        }

        public static int RetornaQtdNegativos(int[] vet, int i = 0, int qtdNegativos = 0)
        {
            if (i >= vet.Length)
            {
                return qtdNegativos;
            }
            else
            {
                if (vet[i] < 0)
                {
                    vet[i] *= -1;
                    qtdNegativos++;
                }
            }
            return RetornaQtdNegativos(vet, i + 1, qtdNegativos);
        }
    }
}
