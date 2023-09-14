/* Objetivo : Exibir o antecessor e o sucessor de um número inteiro aleatório.
 * Autor    : William Silva (https://github.com/unclWill)
 * Data     : 15/08/2023
 * Material : FP02
 * Slide    : 48
 * Exercício: 04
 */

/* Comando:
 * 4. Faça um programa que leia um número inteiro
 * e imprima o seu antecessor e sucessor.
 */

using System;

namespace ImpAntESucessor
{
    public class Program
    {
        public static void Main(string[] args)
        {
            Console.WriteLine("");
            ExibirAntecessorESucessor();
            Console.Write("\nPressione qualquer tecla para finalizar...");
            Console.ReadKey();
        }

        private static void ExibirAntecessorESucessor()
        {
            Console.Write("Digite um número inteiro: ");
            int numero = Convert.ToInt32(Console.ReadLine());
            Console.WriteLine($"O antecessor de {numero} é [{numero - 1}] e seu sucessor é [{numero + 1}]");
        }
    }
}


