/* Objetivo : Exibir os textos com informações a respeito do programa.
 * Autor    : William Silva (https://github.com/unclWill)
 * Data     : 01/08/2023
 */

using System;
using System.Text;
using VerifPrimos;

namespace VerifPrimos.Utils
{
    public class Sobre
    {
        internal static void ExibirSobre()
        {
            Console.Clear();
            //
            StringBuilder txtSobre = new StringBuilder("(i) Programa para verificar números primos\n\n" +
                                                       "Versão          : v0.1-01.09.23\n" +
                                                       "Desenvolvido por: William Silva\n" +
                                                       "GitHub          : unclWill\n" +
                                                       "Contato         : william.silva@viannasempre.com.br\n\n" +
                                                       "[i] Pressione qualquer tecla para voltar ao menu anterior...");

            Console.Write(txtSobre.ToString());
            Console.ReadKey();
            Menu.ExibirMenu();
        }
    }
}