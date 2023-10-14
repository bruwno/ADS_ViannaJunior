/* Objetivo : Verificar percentual de acertos em apostas.
 * Autor    : William Silva (https://github.com/unclWill)
 * Data     : 12/10/2023
 * Material : FP06 (Vetores)
 * Slide    : 114
 * Exercício: 09
 */

/* 9) Com relação ao exercício anterior, calcule e mostre o percentual dos apostadores que fizeram de 10 a 13 pontos e 
 * o percentual dos apostadores que fizeram menos do que 10 pontos.
 */

using System;

namespace CalcPercAcertos
{
    internal class Program
    {
        internal static void Main(string[] args)
        {
            Console.WriteLine("Loteria\n");

            int[] g = new int[13];

            Random rdm = new Random();
            for (int i = 0; i < g.Length; i++)
            {
                g[i] = rdm.Next(0, 4);
            }
            for (int i = 0; i < g.Length; i++)
            {
                Console.Write($"{g[i]} | ");
            }

            LerDadosApostador(g);

            Console.Write("\nPressione qualquer tecla para finalizar...");
            Console.ReadKey();
        }

        private static void LerDadosApostador(int[] g)
        {
            int[] aposta = new int[13];
            int maisPontos = 0, menosPontos = 0;

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

                if (qtdAcertos >= 10)
                {
                    maisPontos++;
                }
                else
                {
                    menosPontos++;
                }

                Console.WriteLine($"O apostador {numeroCartao} teve {qtdAcertos} acertos.", Console.ForegroundColor = ConsoleColor.Gray);
            }

            var percAcertos = CalcularPercentualAcertos(maisPontos, menosPontos);
            Console.WriteLine($"\n{percAcertos.percMaisPts}% dos apostadores fizeram de 10 a 13 pontos." +
                              $"\n{percAcertos.percMenosPts}% dos apostadores fizeram menos de 10 pontos.");
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

        private static (double percMaisPts, double percMenosPts) CalcularPercentualAcertos(int maisPts, int menosPts)
        {
            double percMaisPontos = (maisPts / 5.0) * 100.0;
            double percMenosPontos = (menosPts / 5.0) * 100.0;

            return (percMaisPontos, percMenosPontos);
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
