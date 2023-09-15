/* Objetivo : Exibir um menu para navegação no sistema.
 * Autor    : William Silva (https://github.com/unclWill)
 * Data     : 13/09/2023
 */

using System;
using System.Text;

namespace CalcSubredes
{
    internal static class Menu
    {
        internal static void ExibirMenu()
        {
            Console.Clear();
            Console.WriteLine("Digite uma opção: ");

            StringBuilder menu = new StringBuilder("[1] Converter um endereço IPv4 decimal para binário\n" +
                                                   "[2] Converter um endereço IPv4 binário para decimal\n" +
                                                   "[3] Créditos\n" +
                                                   "[4] Sair\n\n" +
                                                   "[>] ");
            Console.Write(menu.ToString());

            int opcDigitada = Validacoes.ValidarEntrada();
            LerOpcaoSeleciona(opcDigitada);
        }

        internal static void LerOpcaoSeleciona(int opcSel)
        {
            Console.Clear();
            switch (opcSel)
            {
                case 1:
                    Program.LerEnderecoIP();
                    break;
                case 4:
                    Program.Encerrar();
                    break;
                default:
                    Console.WriteLine("[!] Funcionalidade ainda não implementada.");
                    break;
            }
        }

        internal static void ExibirRetornarAoMenu()
        {
            StringBuilder opcMenu = new StringBuilder("\n[1] Para converter outro IP\n" +
                                                      "[2] Para voltar ao menu principal\n" +
                                                      "[>] ");
            Console.Write(opcMenu.ToString(), Console.ForegroundColor = ConsoleColor.Yellow);
            Console.ForegroundColor = ConsoleColor.Gray;

            int opcDigitada = Validacoes.ValidarEntrada();

            switch (opcDigitada)
            {
                case 1:
                    Program.LerEnderecoIP();
                    break;
                case 2:
                    ExibirMenu();
                    break;
                default:
                    Validacoes.ValidarEntrada();
                    return;
            }
        }
    }
}