/* Objetivo : Ler uma idade.
 * Autor    : William Silva (https://github.com/unclWill)
 * Data     : 30/08/2023
 * Material : FP04
 * Slide    : 000
 * Exercício: 01
 */

/* 1. Faça um programa que leia idades informadas pelo usuário enquanto a idade lida for maior ou igual a zero. O programa deve imprimir a maior idade lida.
 */

 using System;

 namespace ContarAlunos
 {
    public class Program{

    public static void Main(string[] args)
    {
        Console.WriteLine("Informar idades");
        RetornaMaiorIdade();
        Console.Write("\nPressione qualquer tecla para finalizar...");
        Console.ReadKey();
    }

    private static void RetornaMaiorIdade()
    {
        int idade, maiorIdade;

        Console.Write("\nDigite uma idade ou 0 para finalizar.\n[>] ");
        idade = Convert.ToInt32(Console.ReadLine());
        maiorIdade = idade;

        for (int i = 0; idade > 0; i++)
        {
            Console.Write("\nDigite uma idade ou 0 para finalizar.\n [>] ");
            idade = Convert.ToInt32(Console.ReadLine());

            if (idade > maiorIdade) 
            {
                maiorIdade = idade;
            }
        }

        Console.WriteLine($"Maior idade digitada {maiorIdade}");
    }

    }
 }



