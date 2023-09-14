/* Objetivo : Imprimir os números pares entre 1 e 100.
 * Autor    : William Silva (https://github.com/unclWill)
 * Data     : 30/08/2023
 * Material : FP05
 * Slide    : 120
 * Exercício: 03
 */

/* 3. Ler um número inteiro e positivo e verificar se este é ou não um número primo.
 */

using System;

namespace VerifPrimo
{
    public class Program
    {
        public static void Main(string[] args)
        {
            Console.WriteLine("Verificar números primos");
            LerNumero();
            Console.Write("\nPressione qualquer tecla para finalizar...");
            Console.ReadKey();
        }

        private static void LerNumero()
        {
            Console.Write("\n[i] Digite um número inteiro: ");
            int numero = Convert.ToInt32(Console.ReadLine());
            VerificarPrimo(numero);
        }

        private static void VerificarPrimo(int num)
        {
            int contador = 1, qtdDivisores = 0;

            do
            {
                if (num % contador == 0)
                {
                    qtdDivisores++;
                }

                contador++;
            } while (contador <= num);


            if (qtdDivisores == 2)
            {
                Console.WriteLine($"\nO número {num} é primo.");
            }
        }
    }
}