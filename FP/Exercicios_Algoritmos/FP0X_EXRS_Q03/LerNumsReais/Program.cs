/* Objetivo : Ler números reais enquanto o valor digitado for negativo.
 * Autor    : William Silva (https://github.com/unclWill)
 * Data     : 24/09/2023
 * Material : FP0X
 * Slide    : EXRS (Exercícios Resolvidos)
 * Exercício: 03
 */

/* Comando:
 * 3) Faça uma função que leia números reais informados pelo usuário
 * enquanto o número lido for negativo. Assim que for lido um número não negativo, a
 * função deve retornar o número lido. Note que esta função não recebe parâmetros.
 * No método Main, use a sua função para ler um número real não negativo.
 */

using System;

namespace LerNumsReais
{
    internal class Program
    {
        internal static void Main(string[] args)
        {
            double numero = LerNumero();
            Console.WriteLine($"Número real não negativo digitado: {numero}");

            Console.Write("\nPressione qualquer tecla para finalizar...");
            Console.ReadKey();
        }

        private static double LerNumero()
        {
            Console.Write("Digite um número real: ");
            double num = Convert.ToDouble(Console.ReadLine());

            while (num < 0)
            {
                Console.Write("Digite um número real: ");
                num = Convert.ToDouble(Console.ReadLine());
            }

            return num;
        }
    }
}