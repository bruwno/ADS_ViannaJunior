/* Objetivo : Imprimir os números pares entre 1 e 100.
 * Autor    : William Silva (https://github.com/unclWill)
 * Data     : 30/08/2023
 * Material : FP05 (Comandos de Repetição)
 * Slide    : 120
 * Exercício: 03
 */

/* 3. Ler um número inteiro e positivo e verificar se este é ou não um número primo.
 */

using System;

namespace VerifPrimoFor
{
    public class Program
    {
        public static void Main(string[] args)
        {
            Console.WriteLine("Verificar números primos: ");
            LerNumero();
            Console.Write("\nPressione qualquer tecla para finalizar...");
            Console.ReadKey();
        }

        private static void LerNumero()
        {
            Console.Write("\n[i] Digite um número inteiro: ");
            int num = Convert.ToInt32(Console.ReadLine());
            VerificarPrimo(num);
        }

        private static void VerificarPrimo(int num)
        {
            int qtdDivisores = 0;

            for (int i = 1; i <= num; i++)
            {
                if (num % i == 0)
                {
                    qtdDivisores++;
                }
            }

            if (qtdDivisores == 2)
            {
                Console.WriteLine($"\nO número {num} é primo.");
            }
            else
            {
                Console.WriteLine($"\nO número {num} não é primo.");
            }
        }
    }
}