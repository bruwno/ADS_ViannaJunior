/* Objetivo : Ler idades e retornar o maior valor lido.
 * Autor    : William Silva (https://github.com/unclWill)
 * Data     : 20/09/2023
 * Material : FP05 (Comandos de Repetição)
 * Slide    : 000
 * Exercício: 01/V2
 */

/* 1. Faça um programa que leia idades informadas pelo usuário enquanto a idade lida for maior ou igual a zero. 
 * O programa deve imprimir a maior idade lida.
 */

using System;

namespace ContarIdadesV2
{
    public class Program
    {
        public static void Main(string[] args)
        {
            Console.WriteLine("Ler idades\n");
            LerIdade();
            Console.Write("Pressione qualquer tecla para finalizar...");
            Console.ReadKey();
        }

        private static void LerIdade()
        {
            int idade = 0, maiorIdade = 0;

            Console.WriteLine("Para finalizar a leitura digite -1");

            for (int i = 0; idade >= 0; i++)
            {
                Console.Write("Digite uma idade: ");
                idade = Convert.ToInt32(Console.ReadLine());

                if (idade == -1 || idade < -1)
                {
                    Console.WriteLine("Leitura interrompida.");
                }
                else
                {
                    if (idade > maiorIdade)
                    {
                        maiorIdade = idade;
                    }
                }
            }

            Console.WriteLine($"A maior idade digitada foi {maiorIdade}");
        }
    }
}
