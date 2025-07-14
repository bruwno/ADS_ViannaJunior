/* Objetivo : Ler um número inteiro e retornar se ele é perfeito.
 * Autor    : William Silva (https://github.com/unclWill)
 * Data     : 26/09/2023
 * Material : FP0X
 * Slide    : EXRV (Exercícios de Revisão)
 * Exercício: 01
 */

/* Comando:
 * 5) Faça um programa que leia um número inteiro e informe se este é ou não um número perfeito. Um número N é perfeito se a soma de todos os seus divisores p´roprios (divisores exceto o próprio número) é igual a N.
 Exemplo: 6 é número perfeito, pois 6 é divisível por 1, 2 e 3. E 1 + 2 + 3 = 6.
 */

using System;

namespace VerifNumsPerf
{
    public class Program
    {
        public static void Main(string[] args)
        {
            while (true)
            {
                Console.Write("\nDigite um número inteiro para testar ou 0 para encerrar\n" +
                              "[>] ");
                int num = Convert.ToInt32(Console.ReadLine());

                if (num == 0)
                {
                    Console.WriteLine("Leitura interrompida pelo usuário.");
                    break;
                }

                VerificarNumeroPerfeito(num);
            }

            Console.Write("\nPressione qualquer tecla para finalizar...");
            Console.ReadKey();
        }

        private static void VerificarNumeroPerfeito(int num)
        {
            int qtdDvisores = 0;

            for (int i = 1; i < num; i++)
            {
                if (num % i == 0)
                {
                    qtdDvisores += i;
                }
            }

            if (num != 0 && qtdDvisores == num)
            {
                Console.WriteLine($"\n{num} é um número perfeito!", Console.ForegroundColor = ConsoleColor.Green);
                Console.ForegroundColor = ConsoleColor.Gray;
            }
            else
            {
                Console.WriteLine($"\n{num} não é um número perfeito!");
            }
        }
    }
}