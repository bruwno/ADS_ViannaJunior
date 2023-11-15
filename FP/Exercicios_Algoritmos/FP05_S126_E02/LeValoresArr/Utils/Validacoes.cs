/* Objetivo : Realizar a validação dos dados inseridos no programa.
 * Autor    : William Silva (https://github.com/unclWill)
 * Data     : 07/08/2023
 */

using System;
using System.Collections.Generic;

namespace LeValoresArr.Utils
{
    internal class Validacoes
    {
        internal static bool ValidarQtdValores(int[] val)
        {
            bool qtdValida = false;

            for (int i = 0; i < val.Length; i++)
            {
                if (val.Length > 10 || val.Length < 10)
                {
                    qtdValida = false;
                }
                else
                {
                    qtdValida = true;
                }
            }

            return qtdValida;
        }

        internal static void ExibirMsgQtdInvalida(int[] val)
        {
            int qtdValoresDigitados = 0;

            for (int i = 0; i < val.Length; i++)
            {
                if (val.Length != 10)
                {
                    qtdValoresDigitados = val.Length;
                }
            }

            switch (qtdValoresDigitados)
            {
                case 1:
                    Console.Clear();
                    Console.WriteLine($"(!) Você digitou {qtdValoresDigitados} valor apenas.\nPor favor digite exatamente 10 valores.", Console.ForegroundColor = ConsoleColor.DarkRed);
                    Console.ForegroundColor = ConsoleColor.Gray;
                    break;
                default:
                    Console.Clear();
                    Console.WriteLine($"(!) Você digitou {qtdValoresDigitados} valores.\nPor favor digite exatamente 10 valores.", Console.ForegroundColor = ConsoleColor.DarkRed);
                    Console.ForegroundColor = ConsoleColor.Gray;
                    break;
            }
        }
    }
}