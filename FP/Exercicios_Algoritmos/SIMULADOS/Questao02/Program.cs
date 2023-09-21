/*QUESTÃO 02: Faça uma função que receba por parâmetro um inteiro N. A função deve ler N números informados pelo usuário e retornar o maior número lido. No método principal (Main), solicite ao usuário que informe a quantidade de números que serão lidos e passe esse número por parâmetro para a função criada, imprimindo em seguida o seu retorno.*/

using System;

namespace Questao02
{
    internal class Program
    {
        internal static void Main(string[] args)
        {
            Console.Write("Digite a quantidade de números que serão lidos: ");
            int qtdNumeros = Convert.ToInt32(Console.ReadLine());

            int maiorNumeroLido = RetornaMaiorNumeroLido(qtdNumeros);
            Console.WriteLine($"\nO maior número lido foi {maiorNumeroLido}");

            Console.Write("\nPressione qualquer tecla para finalizar...");
            Console.ReadKey();
        }

        internal static int RetornaMaiorNumeroLido(int qtdNums)
        {
            int maiorNumero = Int32.MinValue;

            for (int i = 1; i <= qtdNums; i++)
            {
                Console.Write($"Digite o {i}º número: ");
                int num = Convert.ToInt32(Console.ReadLine());

                if (num > maiorNumero)
                {
                    maiorNumero = num;
                }
            }

            return maiorNumero;
        }
    }
}