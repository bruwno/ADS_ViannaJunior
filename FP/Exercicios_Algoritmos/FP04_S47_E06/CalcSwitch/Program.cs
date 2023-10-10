/* Objetivo : Efetuar operação aritmética entre dois valores.
 * Autor    : William Silva (https://github.com/unclWill)
 * Data     : 23/08/2023
 * Material : FP04 (Estruturas Condicionais)
 * Slide    : 47
 * Exercício: 06
 */

/* Comando:
 * 6) Fazer um algoritmo para ler dois números e um dos símbolos das operações: +, -, * e /. 
 * Imprimir o resultado da operação efetuada sobre os números lidos.
 */

using System;

namespace CalcSwitch
{
    public class Program
    {
        public static void Main()
        {
            Console.WriteLine("Calcular");
            ObterValores();
            Console.Write("\nPressione qualquer tecla para finalizar...");
            Console.ReadKey();
        }

        private static void ObterValores()
        {
            Console.Write("\n[i] Digite o primeiro número: ");
            double num1 = Convert.ToDouble(Console.ReadLine());
            Console.Write("\n[i] Digite o segundo número : ");
            double num2 = Convert.ToDouble(Console.ReadLine());
            Console.Write("\n[i] Digite uma operação (+)(-)(*)(/): ");
            char operacao = Convert.ToChar(Console.ReadLine());

            Calcular(num1, num2, operacao);
        }

        private static void Calcular(double num1, double num2, char op)
        {
            double result = 0.0;

            switch (op)
            {
                case '+':
                    result = num1 + num2;
                    break;
                case '-':
                    result = num1 - num2;
                    break;
                case '*':
                    result = num1 * num2;
                    break;
                case '/':
                    result = num1 / num2;
                    break;
                default:
                    Console.WriteLine("\n[!] Operação inválida!");
                    return;
            }

            Console.WriteLine($"\nResultado da operação {num1} {op} {num2} = {result}");
        }
    }
}
