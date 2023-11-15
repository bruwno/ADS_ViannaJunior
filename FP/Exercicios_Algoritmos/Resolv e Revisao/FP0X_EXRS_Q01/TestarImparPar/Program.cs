/* Objetivo : Testar se u número é par ou ímpar.
 * Autor    : William Silva (https://github.com/unclWill)
 * Data     : 24/09/2023
 * Material : FP0X
 * Slide    : EXRS (Exercícios Resolvidos)
 * Exercício: 01
 */

/* Comando:
 * 1) Faça um procedimento que receba por parâmetro um número inteiro e
 * escreva “par” se o número recebido por parâmetro for par. Caso contrário, o
 * procedimento deve escrever “ímpar”. No método principal (Main), leia um número
 * inteiro e passe-o por parâmetro para o procedimento criado.
 */

using System;

namespace TestarImparPar
{
    internal class Program
    {
        internal static void Main(string[] args)
        {
            Console.Write("Digite um número inteiro: ");
            int numero = Convert.ToInt32(Console.ReadLine());
            TestarNumero(numero);

            Console.Write("\nPressione qualquer tecla para finalizar...");
            Console.ReadKey();
        }

        private static void TestarNumero(int num)
        {
            if (num % 2 == 0)
            {
                Console.WriteLine($"O número {num} é PAR.");
            }
            else
            {
                Console.WriteLine($"O número {num} é ÍMPAR.");
            }
        }
    }
}