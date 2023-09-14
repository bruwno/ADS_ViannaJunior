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

        internal static int ValidarIPDigitado(int octeto)
        {
            string qtdDigitos = octeto.ToString();
            return qtdDigitos.Length;
        }
    }
}