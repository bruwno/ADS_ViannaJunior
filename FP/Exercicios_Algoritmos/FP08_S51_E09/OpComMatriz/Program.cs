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
        const int dim = 3;

        internal static void Main(string[] args)
        {
            Menu();
        }

        private static double[,] LerValoresMatriz()
        {
            double[,] mat = new double[dim, dim];

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

        private static void PreencherMatrizes(int tipoOp)
        {
            double[,] mat1 = new double[dim, dim];
            double[,] mat2 = new double[dim, dim];
            int qtdMatrizes = 2; // Valor padrão.

            if (tipoOp == 3)
            {
                qtdMatrizes = 1;
            }

            int matrizAtual = 1;
            while (matrizAtual < qtdMatrizes)
            {
                Console.WriteLine($"\nInforme os valores da {matrizAtual}ª matriz");
                switch (matrizAtual)
                {
                    case 1:
                        mat1 = LerValoresMatriz();
                        break;
                    case 2:
                        mat2 = LerValoresMatriz();
                        break;
                }

                if (tipoOp != 3)
                {
                    matrizAtual++;
                }
            }

            switch (tipoOp)
            {
                case 1:
                    ExibirCabecalhoDaOpSelec("SOMA");
                    SomarMatrizes(mat1, mat2);
                    break;
                case 2:
                    ExibirCabecalhoDaOpSelec("SUBTRAÇÃO");
                    SubtrairMatrizes(mat1, mat2);
                    break;
                case 3:
                    ExibirCabecalhoDaOpSelec("MATRIZ TRANSPOSTA");
                    TransporMatriz(mat1);
                    break;
                case 4:
                    ExibirCabecalhoDaOpSelec("MULTIPLICAÇÃO");
                    MultiplicarMatrizes(mat1, mat2);
                    break;
            }
        }

        private static void SomarMatrizes(double[,] mat1, double[,] mat2)
        {
            for (int i = 0; i < mat1.GetLength(0); i++)
            {
                for (int j = 0; j < mat1.GetLength(1); j++)
                {
                    double soma = mat1[i, j] + mat2[i, j];
                    Console.WriteLine($"Resultado de {mat1[i, j]} + {mat2[i, j]} = {soma}");
                }
            }

            ExibirMsgPosOperacao();
        }

        private static void SubtrairMatrizes(double[,] mat1, double[,] mat2)
        {
            for (int i = 0; i < mat1.GetLength(0); i++)
            {
                for (int j = 0; j < mat1.GetLength(1); j++)
                {
                    double subtracao = mat1[i, j] - mat2[i, j];
                    Console.WriteLine($"Resultado de {mat1[i, j]} - {mat2[i, j]} = {subtracao}");
                }
            }

            ExibirMsgPosOperacao();
        }

        private static void TransporMatriz(double[,] mat)
        {
            for (int i = 0; i < mat.GetLength(0); i++)
            {
                for (int j = 0; j < mat.GetLength(1); j++)
                {

                }
            }

            ExibirMsgPosOperacao();
        }

        private static void MultiplicarMatrizes(double[,] mat1, double[,] mat2)
        {
            for (int i = 0; i < mat1.GetLength(0); i++)
            {
                for (int j = 0; j < mat1.GetLength(1); j++)
                {
                    double mult = mat1[i, j] * mat2[i, j];
                    Console.WriteLine($"{mat1[i, j]} * {mat2[i, j]} = {mult}");
                }
            }

            ExibirMsgPosOperacao();
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
                Console.Write("A opção digitada é inválida, tente novamente: ");
                opcDigitada = Convert.ToInt32(Console.ReadLine());
            }
            Console.Clear();

            switch (opcDigitada)
            {
                case 5:
                    Console.WriteLine("\nVocê escolheu sair.");
                    return;
                default:
                    PreencherMatrizes(opcDigitada);
                    break;
            }
        }

        // Métodos utilitários.
        private static void ExibirCabecalhoDaOpSelec(string nomeOp = "OPERAÇÃO")
        {
            // Randomizando a cor.
            Random randomizarCor = new Random();
            byte cor = (byte)randomizarCor.Next(1, 14);
            // Exibindo o texto com a cor sorteada.
            Console.WriteLine($"[{nomeOp}]", Console.ForegroundColor = (ConsoleColor)cor);
            // Resetando o texto do Console para a cor padrão.
            Console.ForegroundColor = ConsoleColor.Gray;
        }

        private static void ExibirMsgPosOperacao()
        {
            Console.Write($"\nPressione qualquer tecla para retornar ao menu...");
            Console.ReadKey();
            Menu();
        }
    }
}