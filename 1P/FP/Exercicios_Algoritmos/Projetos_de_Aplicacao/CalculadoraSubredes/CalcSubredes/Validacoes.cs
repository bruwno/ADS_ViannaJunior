/* Objetivo : Validar valores digitados pelo usuário.
 * Autor    : William Silva (https://github.com/unclWill)
 * Data     : 13/09/2023
 */

using System;

namespace CalcSubredes
{
    internal class Validacoes
    {
        internal static int ValidarEntrada()
        {
            int opcDigitada;

            while (!int.TryParse(Console.ReadLine(), out opcDigitada))
            {
                Erro.OpcaoDigitadaNoMenuInvalida();
            }

            return opcDigitada;
        }

        internal static bool ValidarQtdDigitosIP(int octeto)
        {
            string qtdDigitos = octeto.ToString();

            if (qtdDigitos.Length > 3)
            {
                return false;
            }
            else
            {
                return true;
            }
        }

        internal static bool ValidarIPDigitado(int octeto)
        {
            if (octeto < 0 || octeto > 255)
            {
                // IP inválido.
                return false;
            }
            else
            {
                // IP válido.
                return true;
            }
        }
    }
}