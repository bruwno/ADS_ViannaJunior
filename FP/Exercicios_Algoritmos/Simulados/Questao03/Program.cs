/*QUESTÃO 03: Faça um programa que leia números inteiros informados pelo usuário. Um primeiro número deve ser lido e, após isso, o programa deve continuar lendo números informados pelo usuário enquanto o número informado for igual ao número informado anteriormente. Ao término do programa, imprima a soma de todos os números informados pelo usuário (o flag, ou seja, o número que termina a leitura, não deve ser considerado na soma).
	Exemplo de execução do algoritmo:
		Informe um número: 2	
		Informe um número: 2
		Informe um número: 2
		Informe um número: 2
		Informe um número: 2
		Informe um número: 5
		Soma: 10*/

using System;

namespace Questao03
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
            Console.Write("Digite um número inteiro: ");
            int numLido = Convert.ToInt32(Console.ReadLine());

            int num = numLido;
            int acmSoma = numLido;

            while (num == numLido)
            {
                Console.Write("Digite um número inteiro: ");
                num = Convert.ToInt32(Console.ReadLine());

                if (num == numLido)
                {
                    acmSoma += num;
                }
            }

            Console.WriteLine($"A soma do números é = {acmSoma}");
        }
    }
}