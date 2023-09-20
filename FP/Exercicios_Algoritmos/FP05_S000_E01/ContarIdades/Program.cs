
/* Objetivo : Ler idades e retornar o maior valor lido.
 * Autor    : William Silva (https://github.com/unclWill)
 * Data     : 20/09/2023
 * Material : FP05
 * Slide    : 000
 * Exercício: 01
 */

/* 1. Faça um programa que leia idades informadas pelo usuário enquanto a idade lida for maior ou igual a zero. 
 * O programa deve imprimir a maior idade lida.
 */

using System;

namespace ContarIdades
{
    public class Program
    {
        public static void Main(string[] args)
        {
            Console.WriteLine("Ler idades\n");
            Console.Write("Digite uma idade: ");
            int idade = Convert.ToInt32(Console.ReadLine());

            int maiorIdade = RetornarMaiorIdade(idade);
            Console.WriteLine($"\nA maior idade digitada foi {maiorIdade}");

            Console.Write("\nPressione qualquer tecla para finalizar...");
            Console.ReadKey();
        }

        private static int RetornarMaiorIdade(int idade)
        {
            int maiorIdade = idade;

            for (int i = 0; idade > 0; i++)
            {
                Console.WriteLine("(i) Para interromper a leitura digite 0");
                Console.Write("Digite uma idade: ");
                idade = Convert.ToInt32(Console.ReadLine());

                if (idade < 0)
                {
                    // Operador unário '-' inverte o valor da variável lida.
                    idade *= -1;
                    Console.WriteLine("O sinal de negativo foi desconsiderado.");
                }

                if (idade > maiorIdade)
                {
                    maiorIdade = idade;
                }
            }

            return maiorIdade;
        }
    }
}