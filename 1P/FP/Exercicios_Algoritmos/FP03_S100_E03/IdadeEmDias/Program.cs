/* Objetivo : Calcular idade em dias.
 * Autor    : William Silva (https://github.com/unclWill)
 * Data     : 22/08/2023
 * Material : FP03 (Subrotinas)
 * Slide    : 100
 * Exercício: 03
 */

/* Comando:
 * 3) Faça uma função que receba a idade de uma pessoa em anos, meses e dias e retorne essa idade expressa em dias.
 */

using System;

namespace IdadeEmDias
{
    public class Program
    {
        public static void Main()
        {
            Console.WriteLine("Calcular idade em dias\n");
            ObterValores();
            Console.Write("Pressione qualquer tecla para finalizar...");
            Console.ReadKey();
        }

        private static void ObterValores()
        {
            Console.Write("[i] Informe a sua idade em anos : ");
            int idadeEmAnos = Convert.ToInt32(Console.ReadLine());
            Console.Write("[i] Informe a sua idade em meses: ");
            int idadeEmMeses = Convert.ToInt32(Console.ReadLine());
            Console.Write("[i] Informe a sua idade em dias : ");
            int idadeEmDias = Convert.ToInt32(Console.ReadLine());

            int idadeTotalEmDias = CalcularIdadeEmDias(idadeEmAnos, idadeEmMeses, idadeEmDias);
            Console.WriteLine($"[>] Você já viveu {idadeTotalEmDias} dias.");
        }

        private static int CalcularIdadeEmDias(int anos, int meses, int dias)
        {
            int qtdDiasAnos, qtdDiasMeses;
            qtdDiasAnos = anos * 365;
            qtdDiasMeses = (365 / 12) * meses;
            return qtdDiasAnos + qtdDiasMeses + dias;
        }
    }
}