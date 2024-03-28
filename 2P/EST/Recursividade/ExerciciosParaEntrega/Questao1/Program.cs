/* Autor: William Silva (https://github.com/unclWill)
 * Data : 25/03/2024
 *
 * Questão 1)
 * Faça um procedimento que receba um número n inteiro e positivo. O procedimento deve
 * imprimir todos os números do intervalo entre 0 e n que são divisíveis por 2 e por 3
 * (simultaneamente). Restrição: não utilize comandos de repetição.
 */

using System;

namespace Questao1
{
    public class Program
    {
        public static void Main(string[] args)
        {
            ImprimirDivisiveis(40);
        }

        public static void ImprimirDivisiveis(int n)
        {
            if (n == 0)
            {
                return;
            }
            else
            {
                ImprimirDivisiveis(n - 1);
                if (n % 2 == 0 && n % 3 == 0)
                {
                    Console.Write($"{n} ");
                }
            }
        }
    }
}
