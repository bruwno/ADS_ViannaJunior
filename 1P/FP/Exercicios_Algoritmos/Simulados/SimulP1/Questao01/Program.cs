/*
QUESTÃO 01: Faça um procedimento que receba por parâmetro três números inteiros e imprima:
    • "Todos são ímpares" se todos os números forem ímpares.
    • "Todos são pares" se todos os números forem pares.
    • "Pares e ímpares misturados" caso nenhuma opção acima seja verdadeira. 
*/

using System;

namespace Questao01
{
    internal class Program
    {
        internal static void Main(string[] args)
        {
            int num1 = 0, num2 = 0, num3 = 0;

            Console.WriteLine("Digite 3 números inteiros\n");

            for (int i = 1; i <= 3; i++)
            {
                Console.Write($"Digite o {i}º número inteiro: ");
                int num = Convert.ToInt32(Console.ReadLine());

                switch (i)
                {
                    case 1:
                        num1 = num;
                        break;
                    case 2:
                        num2 = num;
                        break;
                    case 3:
                        num3 = num;
                        break;
                }
            }

            VerificarNumeros(num1, num2, num3);

            Console.Write("\nPressione qualquer tecla para finalizar...");
            Console.ReadKey();
        }

        internal static void VerificarNumeros(int num1, int num2, int num3)
        {
            if ((num1 % 2 == 1) && (num2 % 2 == 1) && (num3 % 2 == 1))
            {
                Console.WriteLine("\nTodos são ímpares.");
            }
            else if ((num1 % 2 == 0) && (num2 % 2 == 0) && (num3 % 2 == 0))
            {
                Console.WriteLine("\nTodos são pares.");
            }
            else
            {
                Console.WriteLine("\nPares e ímpares misturados.");
            }
        }
    }
}
