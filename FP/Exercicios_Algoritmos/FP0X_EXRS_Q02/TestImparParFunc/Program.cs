/* Objetivo : Testar se u n[umero é par ou ímpar usando uma função.
 * Autor    : William Silva (https://github.com/unclWill)
 * Data     : 24/09/2023
 * Material : FP0X
 * Slide    : EXRS (Exercícios Resolvidos)
 * Exercício: 02
 */

/* Comando:
 * 2) Faça uma função que receba por parâmetro um número inteiro e
 * retorne “par” se o número recebido por parâmetro for par. Caso contrário, a função
 * deve retornar “ímpar”. No método principal (Main), leia um número inteiro e passe-o por parâmetro para a função criada, imprimindo em seguida o seu retorno.
 */

using System;

namespace TestImparParFunc
{
    internal class Program
    {
        internal static void Main(string[] args)
        {
            Console.Write("\nDigite um número inteiro: ");
            int numero = Convert.ToInt32(Console.ReadLine());

            Console.WriteLine($"O número {numero} é {TestarNumero(numero)}");

            Console.Write("\nPressione qualquer tecla para finalizar...");
            Console.ReadKey();
        }

        internal static string TestarNumero(int num)
        {
            if (num % 2 == 0)
            {
                return "par.";
            }
            else
            {
                return "ímpar.";
            }
        }
    }
}