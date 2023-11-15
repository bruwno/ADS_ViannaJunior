/* Objetivo : Exibir mensagens de erro.
 * Autor    : William Silva (https://github.com/unclWill)
 * Data     : 14/09/2023
 */

using System;
using System.Threading.Tasks;

namespace CalcSubredes
{
    internal class Erro
    {
        #region // Mensagens de erro para entradas inválidas nas opções de menu.

        internal static void OpcaoDigitadaNoMenuInvalida()
        {
            Console.Write("\n[!] Opção inválida, tente novamente. \n[>] ", Console.ForegroundColor = ConsoleColor.DarkRed);
            Console.ForegroundColor = ConsoleColor.Gray;
        }

        #endregion

        #region // Mensagens de erro para entradas inválidas na leitura do endereço IP.

        /// <summary>
        /// Exibe uma mensagem de erro informando que a quantidade de dígitos do octeto é inválida.
        /// </summary>
        /// <param name="contOcteto">Recebe a variável contadora com a posição do atual do octeto testado.</param>
        /// <param name="valorOcteto">Recebe o valor que o usuário atribuiu ao octeto.</param>
        internal static void QtdDigitosDoOctetoInvalida(int contOcteto, int valorOcteto)
        {
            Console.WriteLine($"\n[!] Entrada inválida no {contOcteto}º octeto!\n" +
                          $"[?] Valor digitado: {valorOcteto}\n" +
                           "[i] Os octetos de um endereço IP não podem ter mais de 3 dígitos.\n", Console.ForegroundColor = ConsoleColor.DarkRed);
            Console.Write("[>] Pressione qualquer tecla para continuar...", Console.ForegroundColor = ConsoleColor.DarkGray);
            Console.ForegroundColor = ConsoleColor.Gray;
            //Thread.Sleep(2700);
            Console.ReadKey();
        }

        /// <summary>
        /// Exibe uma mensagem de erro informando que o valor digitado no octeto não corresponde á faixa de um IP válido.
        /// </summary>
        /// <param name="contOcteto">Recebe a variável contadora com a posição do atual do octeto testado.</param>
        /// <param name="valorOcteto">Recebe o valor que o usuário atribuiu ao octeto.</param>
        internal static void ValorDoOctetoInvalido(int contOcteto, int valorOcteto)
        {
            Console.WriteLine($"\n[!] Entrada inválida no {contOcteto}º octeto!\n" +
                              $"[?] Valor digitado: {valorOcteto}\n" +
                               "[i] Os valores de cada octeto devem estar entre 0 e 255.\n", Console.ForegroundColor = ConsoleColor.DarkRed);
            Console.Write("[>] Pressione qualquer tecla para continuar...", Console.ForegroundColor = ConsoleColor.DarkGray);
            Console.ForegroundColor = ConsoleColor.Gray;
            //Thread.Sleep(2700);
            Console.ReadKey();
        }

        internal static void CaractereDigitadoInvalido()
        {
            Console.Write($"\n[!] Entrada inválida!\n" +
                          "[i] Apenas são aceitos dígitos numéricos separados por ponto.", Console.ForegroundColor = ConsoleColor.DarkRed);
            Console.ForegroundColor = ConsoleColor.Gray;
            Thread.Sleep(2700);
        }

        #endregion
    }
}