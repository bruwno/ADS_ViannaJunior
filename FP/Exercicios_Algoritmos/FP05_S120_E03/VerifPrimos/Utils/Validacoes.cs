/* Objetivo : Realizar a validação dos dados inseridos no programa.
 * Autor    : William Silva (https://github.com/unclWill)
 * Data     : 02/08/2023
 */

using System;

namespace VerifPrimos.Utils
{
    public class Validacoes
    {
        internal static int ValidarOpcMenuDigitada(string txt)
        {
            int opc;
            while (!int.TryParse(Console.ReadLine(), out opc))
            {
                Console.Clear();
                Console.WriteLine("(!) Opção inválida! Tente novamente.", Console.ForegroundColor = ConsoleColor.DarkRed);
                Console.Write(txt, Console.ForegroundColor = ConsoleColor.Gray);
            }
            return opc;
        }
    }
}