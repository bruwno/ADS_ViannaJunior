/* Objetivo : Exibir a faixa etária com base na idade informada.
 * Autor    : William Silva (https://github.com/unclWill)
 * Data     : 29/08/2023
 * Material : FP04 (Estruturas Condicionais)
 * Slide    : 47
 * Exercício: 07
 */

/* Comando:
 * 7) Desenvolver um algoritmo para ler o valor inteiro da idade de uma pessoa e imprimir
 * uma das mensagens: se idade < 13: Criança, se 13 ≤ idade < 20: Adolescente, se 20 ≤ idade < 60: Adulto e se idade ≥ 60: Idoso.
 */

using System;

namespace LerIdade
{
    public class Program
    {
        public static void Main(string[] args)
        {
            Console.WriteLine("Determinar faixa etária");
            ExibirFaixaEtaria();
            Console.Write("\nPressione qualquer tecla para finalizar...");
            Console.ReadKey();
        }

        private static void ExibirFaixaEtaria()
        {
            int idade = LerIdade();

            if (idade < 13)
            {
                Console.WriteLine("\nCriança.");
            }
            else if (idade > 13 && idade < 20)
            {
                Console.WriteLine("\nAdolescente.");
            }
            else if (idade > 20 && idade < 60)
            {
                Console.WriteLine("\nAdulto.");
            }
            else
            {
                Console.WriteLine("\nIdoso.");
            }
        }

        private static int LerIdade()
        {
            Console.Write("\n[i] Digite a sua idade: ");
            int idade = Convert.ToInt32(Console.ReadLine());
            return idade;
        }
    }
}