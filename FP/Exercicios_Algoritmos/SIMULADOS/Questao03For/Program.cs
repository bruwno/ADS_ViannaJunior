/* Autor: William Silva (github.com/unclWill)
 * Data : 21/09/2023
 * 
 * QUESTÃO 03: Faça um programa que leia números inteiros informados pelo usuário. Um primeiro número deve ser lido e, após isso, o programa deve continuar lendo números informados pelo usuário enquanto o número informado for igual ao número informado anteriormente. Ao término do programa, imprima a soma de todos os números informados pelo usuário (o flag, ou seja, o número que termina a leitura, não deve ser considerado na soma).
 * Exemplo de execução do algoritmo:
		Informe um número: 2	
		Informe um número: 2
		Informe um número: 2
		Informe um número: 2
		Informe um número: 2
		Informe um número: 5
		Soma: 10*/

using System;

namespace Questao03For
{
    internal class Program
    {
        internal static void Main(string[] args)
        {
            Console.WriteLine("Ler valores");
            LerNumeros();

            Console.Write("\nPressione qualquer tecla para finalizar...");
            Console.ReadKey();
        }

        internal static void LerNumeros()
        {
            int soma = 0, i;

            Console.Write("Digite um número inteiro: ");
            int primeiroNumLido = Convert.ToInt32(Console.ReadLine());
            int num = primeiroNumLido;

            for (i = 0; num == primeiroNumLido; i++)
            {
                Console.Write("Digite um número inteiro: ");
                num = Convert.ToInt32(Console.ReadLine());
            }

            soma = primeiroNumLido * i;

            Console.WriteLine($"A soma do números é = {soma}");
        }
    }
}