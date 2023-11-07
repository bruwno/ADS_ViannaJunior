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
            Console.Clear();
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

            Console.Clear();
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

        private static double[,] LerValores()
        {
            double[,] mat = new double[2, 2];

            for (int i = 0; i < mat.GetLength(0); i++)
            {
                for (int j = 0; j < mat.GetLength(1); j++)
                {
                    Console.Write($"Digite o valor {i},{j}: ");
                    mat[i, j] = Convert.ToDouble(Console.ReadLine());
                }
            }

            return mat;
        }

        private static void SomarMatrizes()
        {
            double[,] mat1 = new double[2, 2];
            double[,] mat2 = new double[2, 2];
            double soma = 0.0;
            // Operação selecionada.
            Console.WriteLine("[SOMA]", Console.ForegroundColor = ConsoleColor.Yellow);
            Console.ForegroundColor = ConsoleColor.Gray;
            //
            Console.WriteLine("Informe os valores da 1ª matriz");
            mat1 = LerValores();
            Console.WriteLine("Informe os valores da 2ª matriz");
            mat2 = LerValores();

            for (int i = 0; i < mat2.GetLength(0); i++)
            {
                for (int j = 0; j < mat2.GetLength(1); j++)
                {
                    soma = mat1[i, j] + mat2[i, j];
                    Console.WriteLine($"Resultado de {mat1[i, j]} + {mat2[i, j]} = {soma}");
                }
            }

            Console.Write($"\nPressione qualquer tecla para retornar ao menu...");
            Console.ReadKey();
            Menu();
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