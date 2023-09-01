/* Objetivo : Ler e determinar quais número do array são primos.
 * Autor    : William Silva (https://github.com/unclWill)
 * Data     : 01/08/2023
 */

using System;
using System.Collections.Generic;
using System.Text;
using VerifPrimos.Utils;

namespace VerifPrimos
{
    public class NumerosPrimos
    {
        internal static void LerNumeros()
        {
            Console.Clear();
            //
            StringBuilder txtInstrucao = new StringBuilder("--------- | TESTAR NÚMEROS | ---------\n\n" +
                                                        "(i) Dica: Separe os números por vírgula\n\n" +
                                                        "[i] Digite os números que deseja testar:\n\n" +
                                                        "[>] ");
            Console.Write(txtInstrucao.ToString());
            string[] valoresDigitados = Console.ReadLine()!.Trim().Split(",");

            int[] numeros = Array.ConvertAll(valoresDigitados, int.Parse);
            VerificarNumerosPrimos(numeros);
        }

        private static void VerificarNumerosPrimos(int[] nums)
        {
            for (int i = 0; i < nums.Length; i++)
            {
                int numeroAtual = nums[i];
                int qtdDivisores = 0;

                for (int j = 1; j <= numeroAtual; j++)
                {
                    if (numeroAtual % j == 0)
                    {
                        qtdDivisores++;
                    }
                }

                StatusDoNumeroVerificado(numeroAtual, qtdDivisores);
            }
            Menu.VoltarAoMenu();
        }

        private static void StatusDoNumeroVerificado(int num, int qtdDiv)
        {
            string statusNum = string.Empty;

            switch (qtdDiv)
            {
                case 2:
                    Console.ForegroundColor = ConsoleColor.Green;
                    statusNum = $"[>] O número {num} é primo";
                    break;
                default:
                    Console.ForegroundColor = ConsoleColor.DarkGray;
                    statusNum = $"[>] O número {num} NÃO é primo";
                    break;
            }

            Console.WriteLine(statusNum);
        }
    }
}