/*QUESTÃO 02: Faça uma função que receba por parâmetro um inteiro N. A função deve ler N números informados pelo usuário e retornar o maior número lido. No método principal (Main), solicite ao usuário que informe a quantidade de números que serão lidos e passe esse número por parâmetro para a função criada, imprimindo em seguida o seu retorno.*/

using System;

namespace Questao02While
{
    internal class Program
    {
        internal static void Main(string[] args)
        {
            Console.Write("Digite a quantidade de números que serão lidos: ");
            int qtdNumeros = Convert.ToInt32(Console.ReadLine());

            int maiorNumeroLido = RetornaMaiorNumeroLido(qtdNumeros);
            Console.WriteLine($"O maior número lido foi {maiorNumeroLido}");

            Console.Write("\nPressione qualquer tecla para finalizar...");
            Console.ReadKey();
        }

        internal static int RetornaMaiorNumeroLido(int qtdNums)
        {
            int cont = 2, maiorNumero;

            Console.Write("Digite o 1º número: ");
            int num = Convert.ToInt32(Console.ReadLine());
            maiorNumero = num;

            while(cont <= qtdNums)
            {
                Console.Write($"Digite o {cont}º número: ");
                num = Convert.ToInt32(Console.ReadLine());
                
                if (num > maiorNumero) 
                {
                    maiorNumero = num;
                }

                cont++;
            }

            return maiorNumero;
        }
    }
}