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
        public static void Main()
        {
            Console.WriteLine("Verificar números primos");
            ObterNumero();
            Console.Write("\nPressione qualquer tecla para finalizar...");
            Console.ReadKey();
        }

        private static void ObterNumero()
        {
            Console.Write("[i] Digite um número: ");
            int numero = Convert.ToInt32(Console.ReadLine());
            VerificarPrimo(numero);
        }

        private static void VerificarPrimo(int num)
        {
            if ((num % 1 == 0) && (num % num == 0))
            {
                Console.WriteLine($"{num} é primo.");
            }
        }
    }
 }