/* Objetivo : Ler 10 valores e armazenar na mesma variável.
 * Autor    : William Silva (https://github.com/unclWill)
 * Data     : 06/09/2023
 * Material : FP05 (Comandos de Repetição)
 * Slide    : 126
 * Exercício: 02
 */

/* 2) Escreva um algoritmo que leia 10 valores (usando a mesma variável) e 
 * encontre o maior e o menor deles. Mostre o resultado.
 */

using System;

namespace LeValores
{
    public class Program
    {
        public static void Main(string[] args)
        {
            Console.WriteLine("Ler valores e exibir menor e maior");
            LerValor();
            Console.Write("\nPressione qualquer tecla para finalizar...");
            Console.ReadKey();
        }

        private static void LerValor()
        {
            Console.Write($"\nDigite o 1º valor: ");
            int valor = Convert.ToInt32(Console.ReadLine());
            int cont = 2, menor = valor, maior = valor;

            while (cont <= 10)
            {
                Console.Write($"\nDigite o {cont}º valor: ");
                valor = Convert.ToInt32(Console.ReadLine());

                if (valor < menor)
                {
                    menor = valor;
                }
                else if (valor > maior)
                {
                    maior = valor;
                }

                cont++;
            }

            Console.WriteLine($"\n[>] Menor valor: {menor}" +
                              $"\n[>] Maior valor: {maior}");
        }
    }
}