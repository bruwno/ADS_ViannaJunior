/* Objetivo : Ler o código de uma forma de pagamento e exibir uma descrição sobre as condições associadas a ela.
 * Autor    : William Silva (https://github.com/unclWill)
 * Data     : 29/08/2023
 * Material : FP04
 * Slide    : 49
 * Exercício: 09
 */

/* 9) Para auxiliar os vendedores de uma loja na orientação aos clientes sobre as diversas
 * formas de pagamento, desenvolver um algoritmo para:
 * a) Imprimir o menu de opções;
 * b) Ler o código da opção de pagamento;
 * c) Imprimir uma das mensagens de acordo com a opção lida.
 */

using System;
using System.Text;

namespace ImprimirMenu
{
    public class Program
    {
        public static void Main(string[] args)
        {
            Console.WriteLine("Condições e formas de pagamento\n");
            ExibeMenu();
            Console.Write("\nPressione qualquer tecla para finalizar...");
            Console.ReadKey();
        }

        private static void ExibeMenu()
        {
            StringBuilder menu = new StringBuilder(
            "Formas de pagamento:\n" +
            "[1] - À vista.\n" +
            "[2] - Cheque para trinta dias.\n" +
            "[3] - Em duas vezes.\n" +
            "[4] - Em três vezes.\n" +
            "[5] - Em quatro vezes.\n" +
            "[6] - A partir de cinco vezes.\n" +
            "\nEntre com sua opção: ");
            Console.Write(menu.ToString());

            int opcDigitada = Convert.ToInt32(Console.ReadLine());
            ExibirMensagem(opcDigitada);
        }

        private static void ExibirMensagem(int opc)
        {
            if (opc == 1)
            {
                Console.WriteLine("\n[>] Desconto de 20%");
            }
            else if (opc == 2 || opc == 3 || opc == 4)
            {
                Console.WriteLine("\n[>] Mesmo preço ou a vista");
            }
            else if (opc == 5)
            {
                Console.WriteLine("\n[>] Juros de 3% ao mês");
            }
            else if (opc == 6)
            {
                Console.WriteLine("\n[>] Juros de 5% ao mês");
            }
            else
            {
                Console.WriteLine("\n[!] Opção inválida!");
                return;
            }
        }
    }
}