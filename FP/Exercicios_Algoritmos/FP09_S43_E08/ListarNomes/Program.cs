/* Objetivo : Listar nomes da menor para a maior idade.
 * Autor    : William Silva (https://github.com/unclWill)
 * Data     : 08/11/2023
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
                Console.WriteLine($"\nInforme os dados da {i + 1}ª pessoa");
                pessoas[i] = LerDadosPessoas();
            }

            OrdenarPessoasPorIdade(pessoas);
            ListarNomesPelaLetraInicial(pessoas);

            Console.Write("\nPressione qualquer tecla para finalizar...");
            Console.ReadKey();
        }

        private static Pessoa LerDadosPessoas()
        {
            Pessoa pessoa = new Pessoa();

            Console.Write("Digite o nome : ");
            pessoa.Nome = Console.ReadLine();
            Console.Write("Digite a idade: ");
            pessoa.Idade = Convert.ToDouble(Console.ReadLine());

            return pessoa;
        }

        private static void OrdenarPessoasPorIdade(Pessoa[] pessoas)
        {
            for (int i = pessoas.Length - 1; i >= 0; i--)
            {
                Pessoa moverPessoa = pessoas[i];

                for (int j = 0; j < i; j++)
                {
                    double idadeAtual = pessoas[j].Idade;
                    double proxIdade = pessoas[j + 1].Idade;

                    if (idadeAtual > proxIdade)
                    {
                        moverPessoa = pessoas[j];
                        pessoas[j] = pessoas[j + 1];
                        pessoas[j + 1] = moverPessoa;
                    }
                }
            }

            Console.WriteLine("\nExibindo os nomes pela ordem de idades");
            Console.WriteLine("\nNOME\t\t\tIDADE");
            for (int p = 0; p < pessoas.Length; p++)
            {
                Console.WriteLine($"{pessoas[p].Nome}\t\t{pessoas[p].Idade}");
            }
        }

        private static void ListarNomesPelaLetraInicial(Pessoa[] pessoas)
        {
            Console.Write("\nDigite a letra inicial para filtrar os nomes: ");
            char letraInicial = Convert.ToChar(Console.ReadLine());

            Console.WriteLine($"\nNomes na lista iniciados com a letra '{letraInicial}'");
            for (int i = 0; i < pessoas.Length; i++)
            {
                if (pessoas[i].Nome[0] == letraInicial)
                {
                    Console.WriteLine($"{pessoas[i].Nome}");
                }
            }
        }
    }
}