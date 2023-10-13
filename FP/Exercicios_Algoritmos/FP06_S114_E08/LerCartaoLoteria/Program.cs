/* Objetivo : Verificar número de acertos de apostas.
 * Autor    : William Silva (https://github.com/unclWill)
 * Data     : 11/10/2023
 * Material : FP06 (Vetores)
 * Slide    : 114
 * Exercício: 08
 */

/* 8) Faça um programa que leia um vetor G[13] que é o gabarito de um teste da loteria esportiva, contendo os valores 1 quando for coluna 1, 
 * 0 quando for coluna do meio e 2 quando for coluna 2.
 * Ler a seguir, para 5 apostadores, seu cartão de apostas (R[13]) e depois da leitura imprimir quantos acertos o apostador teve.
 * Faça o teste através de funções.
 */

using System;

namespace LerCartaoLoteria
{
    internal class Program
    {
        internal static void Main(string[] args)
        {
            int[] g = new int[13];

            Console.WriteLine("Loteria\n");

            Console.Write("Preencha o gabarito (13 números): ");
            for (int i = 0, j = 12; i < g.Length; i++, j--)
            {
                g[i] = Convert.ToInt32(Console.ReadLine());
                AtualizarDigitosGabarito(g, j);
            }

            LerDadosApostador(g);

            Console.Write("\nPressione qualquer tecla para finalizar...");
            Console.ReadKey();
        }

        private static void LerDadosApostador(int[] g)
        {
            int[] aposta = new int[13];

            for (int i = 1; i <= 5; i++)
            {
                Console.Write("\nDigite o número do cartão de apostas: ");
                int numeroCartao = Convert.ToInt32(Console.ReadLine());

                Console.WriteLine("[Preencha o cartão de apostas]");
                for (int j = 0, k = 1; j < aposta.Length; j++, k++)
                {
                    Console.Write($"Digite o {k,2}º número: ", Console.ForegroundColor = ConsoleColor.Blue);
                    aposta[j] = Convert.ToInt32(Console.ReadLine());
                }

                int qtdAcertos = ContabilizarAcertos(g, aposta);

                Console.WriteLine($"O apostador {numeroCartao} teve {qtdAcertos} acertos.", Console.ForegroundColor = ConsoleColor.Gray);
            }
        }

        private static int ContabilizarAcertos(int[] g, int[] aposta)
        {
            int qtdAcertos = 0;

            for (int i = 0; i < g.Length; i++)
            {
                if (aposta[i] == g[i])
                {
                    qtdAcertos++;
                }
            }

            return qtdAcertos;
        }

        private static void AtualizarDigitosGabarito(int[] g, int cont)
        {
            Console.Clear();
            Console.Write("[GABARITO] ", Console.ForegroundColor = ConsoleColor.Green);
            Console.ForegroundColor = ConsoleColor.Gray;

            for (int i = 0; i < g.Length - cont; i++)
            {
                Console.Write($"{g[i]} | ");
            }

            if (cont > 0)
            {
                Console.Write($"\n\nDigite mais {cont} número(s): ");
            }
            else
            {
                Console.Write("\nGabarito preenchido.\n");
            }
        }
    }
}