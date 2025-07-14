/* Objetivo : Calcular a sequência de Fibonacci para um valor N.
 * Autor    : William Silva (https://github.com/unclWill)
 * Data     : 10/09/2023
 * Material : FP05 (Comandos de Repetição)
 * Slide    : 127
 * Exercício: 09
 */

/* Comando:
 * 9) Fazer um programa para calcular e mostrar os N primeiros termos da série de Fibonacci.
 * O número N é fornecido pelo usuário. A série de Fibonacci é gerada da seguinte forma:
 * f1 = f2 = 1;
 * f3 = f1 + f2 = 2;
 * f4 = f2 + f3 = 3;....
 * O primeiro e segundo termos valem 1 e os seguintes são calculados somando os dois termos anteriores
 */

using System;

namespace Fibonacci
{
    public class Program
    {
        public static void Main(string[] args)
        {
            Console.WriteLine("Calcular termos da sequência de Fibonacci");
            LerValor();
            Console.Write("\n\nPressione qualquer tecla para finalizar...");
            Console.ReadKey();
        }

        private static void LerValor()
        {
            Console.Write("[i] Digite um valor para calcular a sequência: ");
            int valor = Convert.ToInt32(Console.ReadLine());
            // Iterativo
            CalcularFibonacci(valor);

            // Recursivo
            Console.WriteLine($"\n Número de Fibonacci na {valor}ª posição = " + Fibonacci(valor));
        }

        // Retorna os N primeiros fib, de acordo com a quantidade informada pelo usuário.
        private static void CalcularFibonacci(int n)
        {
            int antePenultVal = 0, penultVal = 0, valAtual = 1;

            Console.WriteLine($"\nExibindo os {n} primeiros números da sequência de Fibonacci: ");

            if (n == 0 || n == 1)
            {
                Console.WriteLine(n);
            }

            for (int i = 2; i <= n + 1; i++)
            {
                antePenultVal = penultVal;
                penultVal = valAtual;
                valAtual = antePenultVal + penultVal;

                Console.Write($"{valAtual}, ");
            }
        }

        // Retorna o número de fibonacci na posição inserida pela usuário.
        private static int Fibonacci(int fib)
        {
            if (fib == 0 || fib == 1)
            {
                return fib;
            }
            return Fibonacci(fib - 1) + Fibonacci(fib - 2);
        }
    }
}