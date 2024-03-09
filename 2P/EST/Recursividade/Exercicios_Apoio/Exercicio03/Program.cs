/* Autor: William Silva (https://github.com/unclWill)
 * Data : 09/03/2024
 *
 * Exercício 3) Faça uma função recursiva que permita inverter um número inteiro N. Ex: 123 - 321.
 */

using System;

namespace Exercicio03
{
    public class Program
    {
        public static void Main(string[] args)
        {
            Console.Write(InverterNumero(543));
        }

        public static int InverterNumero(int n)
        {
            if (n < 10)
            {
                return n;
            }
            else
            {
                int ultimoDigito = n % 10;
                int numeroSemUltimoDigito = n / 10;
                int numeroInvertido = InverterNumero(numeroSemUltimoDigito);
                return int.Parse(ultimoDigito.ToString() + numeroInvertido.ToString());
            }
        }
    }
}
