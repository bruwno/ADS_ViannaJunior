/* Objetivo : Calcular a média das idades de 10 alunos.
 * Autor    : William Silva (https://github.com/unclWill)
 * Data     : 10/10/2023
 * Material : FP06
 * Slide    : 103
 * Exercício: 03
 */

/* Comando:
 * 3) Dada um tabela contendo a idade de 10 alunos, faça um algoritmo que calcule o número de alunos com idade superior a média.
 */

using System;

namespace CalcMediaIdades
{
    internal class Program
    {
        internal static void Main(string[] args)
        {
            Console.WriteLine("Tabela de média das idades\n");
            int[] tabelaIdades = new int[] { 25, 32, 19, 21, 30, 21, 18, 27, 32, 26 };

            ExibirTabelaDeIdades(tabelaIdades);
            ExibirMediaIdades(tabelaIdades);

            Console.Write("\nPressione qualquer tecla para finalizar...");
            Console.ReadKey();
        }

        private static void ExibirTabelaDeIdades(int[] tabelaIdades)
        {
            Console.WriteLine(" Aluno   Idade");

            for (int i = 0, j = 1; i < tabelaIdades.Length; i++, j++)
            {
                Console.Write($"{j,3}º {tabelaIdades[i],7}\n");
            }
        }

        private static void ExibirMediaIdades(int[] idades)
        {
            double mediaIdades = CalcularMediaIdades(idades);
            int qtdComIdadeSup = 0;

            for (int i = 0; i < idades.Length; i++)
            {
                int idade = idades[i];

                if (idade > mediaIdades)
                {
                    qtdComIdadeSup++;
                }
            }

            Console.Write($"\n[>] Média das idades = {mediaIdades} anos.");
            Console.Write($"\n[>] {qtdComIdadeSup} alunos tem idades superiores à média.\n");
        }

        private static double CalcularMediaIdades(int[] idades)
        {
            double acm = 0.0, media = 0.0;

            for (int i = 0; i < idades.Length; i++)
            {
                acm += idades[i];
            }

            return media = acm / 10.0;
        }
    }
}
