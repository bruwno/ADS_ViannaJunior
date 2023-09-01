/* Objetivo : Exibir os menus de interação com o usuário.
 * Autor    : William Silva (https://github.com/unclWill)
 * Data     : 01/08/2023
 */

using System;
using System.Text;

namespace VerifPrimos.Utils
{
    public class Menu
    {
        internal static void ExibirMenu()
        {
            Console.Clear();
            Console.WriteLine("Verificar números primos\n");
            //
            StringBuilder txtMenu = new StringBuilder("[1] Testar números\n" +
                                                      "[2] Sobre\n" +
                                                      "[3] Sair\n\n" +
                                                      "[i] Digite uma opção: ");

            Console.Write(txtMenu.ToString(), Console.ForegroundColor = ConsoleColor.Gray);

            int opcaoSelecionada = ValidarOpcDigitada(txtMenu.ToString());
            SelecOpcMenu(opcaoSelecionada);
        }

        internal static void VoltarAoMenu()
        {
            StringBuilder txtOpcMenu = new StringBuilder("\n[i] Voltar ao menu principal?\n" +
                                                         "[1] SIM.\n" +
                                                         "[2] NÃO, testar outros valores\n\n" +
                                                         "[>] Digite a sua opção: ");
            Console.Write(txtOpcMenu.ToString(), Console.ForegroundColor = ConsoleColor.Gray);

            int opcaoSelecionada = ValidarOpcDigitada(txtOpcMenu.ToString());

            if (opcaoSelecionada == 1)
            {
                ExibirMenu();
            }
            else
            {
                NumerosPrimos.LerNumeros();
            }
        }

        private static void SelecOpcMenu(int opc)
        {
            switch (opc)
            {
                case 1:
                    NumerosPrimos.LerNumeros();
                    break;
                case 2:
                    Sobre.ExibirSobre();
                    break;
                default:
                    return;
            }
        }

        private static int ValidarOpcDigitada(string txt)
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