/* Objetivo : Exibir dados de nascimento em linhas separadas.
 * Autor    : William Silva (https://github.com/unclWill)
 * Data     : 16/08/2023
 * Material : FP02
 * Slide    : 64
 * Exercício: 01
 */

/* Comando:
 * 1. Fazer um programa para imprimir na primeira linha o dia, 
 * na segunda linha o mês e na terceira o ano de seu nascimento.
 */

using System;

namespace ImprimeDadosNasc
{
    public class Program
    {
        public static void Main()
        {
            Console.WriteLine("Exibir dados de nascimento\n");
            DefinirDadosNasc();
            Console.Write("\nPressione qualquer tecla para finalizar...");
            Console.ReadKey();
        }

        private static void DefinirDadosNasc()
        {
            const int diaNasc = 18;
            const int mesNasc = 06;
            const int anoNasc = 1997;

            ExibirDadosNasc(diaNasc, mesNasc, anoNasc);
        }

        private static void ExibirDadosNasc(int diaNasc, int mesNasc, int anoNasc)
        {
            Console.WriteLine($"[Dia] {diaNasc}");
            Console.WriteLine($"[Mês] {mesNasc}");
            Console.WriteLine($"[Ano] {anoNasc}");
        }
    }
}
