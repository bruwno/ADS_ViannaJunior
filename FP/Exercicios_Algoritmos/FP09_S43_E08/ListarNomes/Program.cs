/* Objetivo : Listar nomes da menor para a maior idade.
 * Autor    : William Silva (https://github.com/unclWill)
 * Data     : 07/11/2023
 * Material : FP09 (Classes)
 * Slide    : 43
 * Exercício: 08
 */

/* 8) Faça um programa que receba três nomes de no máximo 100 caracteres cada e as idades das respectivas pessoas em um vetor de objetos. 
 * Após o recebimento, listar os três nomes armazenados neste vetor por ordem crescente de idades.
 */

using System;

namespace ListarNomes
{
    internal class Program
    {
        internal static void Main(string[] args)
        {
            Pessoa[] pessoas = new Pessoa[3];

            for (int i = 0; i < pessoas.Length; i++)
            {
                pessoas[i] = new Pessoa();

                Console.WriteLine($"\nInforme os dados da {i + 1}ª pessoa");

                pessoas[i].Nome = LerNome();
                pessoas[i].Idade = LerIdade();
            }

            OrdenarIdades(pessoas);

            Console.Write("\nPressione qualquer tecla para finalizar...");
            Console.ReadKey();
        }

        private static void OrdenarIdades(Pessoa[] pessoas)
        {
            double moverIdade = 0.0;
            string moverPessoa = string.Empty;

            for (int i = pessoas.Length - 1; i >= 0; i--)
            {
                for (int j = 0; j < i; j++)
                {
                    string pessoaAtual = pessoas[j].Nome;
                    double idadeAtual = pessoas[j].Idade;
                    double proxIdade = pessoas[j + 1].Idade;

                    if (idadeAtual > proxIdade)
                    {
                        moverIdade = idadeAtual;
                        moverPessoa = pessoaAtual;
                        //
                        pessoas[j].Idade = pessoas[j + 1].Idade;
                        pessoas[j].Nome = pessoas[j + 1].Nome;
                        // Move a idade e o nome de posição.
                        pessoas[j + 1].Idade = moverIdade;
                        pessoas[j + 1].Nome = moverPessoa;
                    }
                }
            }

            Console.WriteLine("Exibindo os nomes pela ordem de idades");
            for (int x = 0; x < pessoas.Length; x++)
            {
                Console.WriteLine($"Nome: {pessoas[x].Nome} | Idade: {pessoas[x].Idade}");
            }
        }

        private static string LerNome()
        {
            Console.Write("Digite o nome : ");
            string nome = Console.ReadLine();
            return nome;
        }

        private static double LerIdade()
        {
            Console.Write($"Digite a idade: ");
            double idade = Convert.ToDouble(Console.ReadLine());
            return idade;
        }
    }
}