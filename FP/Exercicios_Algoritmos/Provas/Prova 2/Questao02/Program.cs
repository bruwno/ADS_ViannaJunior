using System;

namespace Questao02
{
    internal class Program
    {
        const int TAM = 10;
        internal static void Main(string[] args)
        {
            Investimento[] investimentos = new Investimento[TAM];

            for (int i = 0; i < investimentos.Length; i++)
            {
                Console.Write($"\nInvestimento {i+1} de {TAM}\n");
                investimentos[i] = LerERetornarDados();
            }

            Console.Write("\nPesquisar investimentos");
            Console.Write("\nDigite o tempo em meses: ");
            int faixaDaPesquisa = Convert.ToInt32(Console.ReadLine());
            for (int j = 0; j < investimentos.Length; j++)
            {
                if (investimentos[j].TempoEmMeses == faixaDaPesquisa)
                {
                    Console.WriteLine($"{investimentos[j].Valor:C2}");
                }
            }
        }

        internal static Investimento LerERetornarDados()
        {
            Investimento investimento = new Investimento();

            Console.Write("Digite o valor: ");
            investimento.Valor = Convert.ToDouble(Console.ReadLine());
            Console.Write("Tempo em meses: ");
            investimento.TempoEmMeses = Convert.ToInt32(Console.ReadLine());

            return investimento;
        }
    }
}
