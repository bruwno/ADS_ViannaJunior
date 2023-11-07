/* Objetivo : Realizar operações com matrizes.
 * Autor    : William Silva (https://github.com/unclWill)
 * Data     : 07/11/2023
 * Material : FP08 (Matrizes)
 * Slide    : 51
 * Exercício: 09
 */

/* 9) Idem ao exercício 1, agora com o seguinte “Menu”:
 * Escolha uma opção de cálculo para matrizes:
 * 1) Soma
 * 2) Diferença
 * 3) Transposta
 * 4) Produto
 * 5) Sair
 * Na opção (3) o usuário só precisa fornecer uma matriz, nas opções
 * (1), (2) e (4) o usuário deve fornecer duas matrizes.
 * Observação, a matriz deve ser 3x3.
 */

using System;
using System.Text;

namespace OpComMatrizes
{
    internal class Program
    {
        internal static void Main(string[] args)
        {
            Menu();

        }

        private static void Menu()
        {
            StringBuilder opcoesMenu = new StringBuilder("Escolha uma opção de cálculo para matrizes: \n" +
                                                         "1) Soma\n" +
                                                         "2) Diferença\n" +
                                                         "3) Transposta\n" +
                                                         "4) Produto\n" +
                                                         "5) Sair\n" +
                                                         "Opção: ");

            Console.Write(opcoesMenu.ToString());
            int opcDigitada = Convert.ToInt32(Console.ReadLine());
            while ((opcDigitada < 1) || (opcDigitada > 5))
            {
                Console.Write("A opção digitada não é válida, tente novamente: ");
                opcDigitada = Convert.ToInt32(Console.ReadLine());
            }

            switch (opcDigitada)
            {
                case 1:
                    SomarMatrizes();
                    break;
                case 2:
                    SubtrairMatrizes();
                    break;
                case 3:
                    TransporMatriz();
                    break;
                case 4:
                    MultiplicarMatrizes();
                    break;
                case 5:
                    Console.WriteLine("\nVocê escolheu sair.");
                    return;
            }
        }

        private static double LerValores()
        {
            return 0.0;
        }

        private static void SomarMatrizes()
        {

        }

        private static void SubtrairMatrizes()
        {

        }

        private static void TransporMatriz()
        {

        }

        private static void MultiplicarMatrizes()
        {

        }

    }
}