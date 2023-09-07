/* Objetivo : Ler 10 valores e armazenar na mesma variável.
 * Autor    : William Silva (https://github.com/unclWill)
 * Data     : 05/08/2023
 * Material : FP05
 * Slide    : 126
 * Exercício: 02
 */

/* 2. Escreva um algoritmo que leia 10 valores (usando a mesma variável) e 
 * encontre o maior e o menor deles. Mostre o resultado.
 */

using System;

namespace LeValores
{
    public class Program
    {
        public static void Main(string[] args)
        {
            Console.WriteLine("Ler valores");
            LerValor();
            Console.Write("\nPressione qualquer tecla para finalizar...");
            Console.ReadKey();
        }

        private static void LerValor()
        {
            int menor = 0, maior = 0;

            for (int i = 1; i < 11; i++)
            {
                Console.Write($"\n[i] Digite o {i}º valor: ");
                int valor = Convert.ToInt32(Console.ReadLine());

                if (menor == 0)
                {
                    menor = valor;
                }

                if (valor < menor)
                {
                    menor = valor;
                }
                else if (valor > maior)
                {
                    maior = valor;
                }

            }
            Console.WriteLine($"[>] Menor valor: {menor}\n" +
                              $"[>] Maior valor: {maior}");
        }
    }
}