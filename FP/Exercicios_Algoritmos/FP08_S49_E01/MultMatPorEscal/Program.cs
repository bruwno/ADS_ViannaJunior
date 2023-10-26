/* Objetivo : Multiplicar matriz por escalar.
 * Autor    : William Silva (https://github.com/unclWill)
 * Data     : 25/10/2023
 * Material : FP08 (Matriz)
 * Slide    : 49
 * Exercício: 01
 */

/* 1) Faça um procedimento para calcular a multiplicação de uma matriz 3 x 4 por um escalar. 
 * Faça também um procedimento capaz de imprimir esta matriz. 
 * Ao final, desenvolva uma função principal onde será criada e lida uma matriz 3 x 4. 
 * Faça nesta função a chamada dos dois procedimentos criados anteriormente.
 */

using System;

namespace MultMatPorEscal
{
    internal class Program
    {
        internal static void Main(string[] args)
        {
            double[,] mat = new double[3,4];

            Console.Write("Informe o valor escalar: ");
            double escalar = Convert.ToInt32(Console.ReadLine());

            for (int i = 0; i < mat.GetLength(0); i++)
            {
                for (int j = 0; j < mat.GetLength(1); j++)
                {
                    Console.Write($"Elemento {i},{j}: ");
                    mat[i,j] = Convert.ToInt32(Console.ReadLine());
                }
            }

            Multiplicar(mat, escalar);
            ImprimirMatriz(mat);

            Console.Write("\nPressione qualquer tecla para finalizar...");
            Console.ReadKey();
        }

        private static void Multiplicar(double[,] mat, double escalar)
        {

            for (int i = 0; i < mat.GetLength(0); i++)
            {
                for (int j = 0; j < mat.GetLength(1); j++)
                {
                    mat[i,j] = mat[i,j] * escalar;
                }
            }
        }

        private static void ImprimirMatriz(double[,] mat)
        {
            for (int i = 0; i < mat.GetLength(0); i++) 
            {
                for (int j = 0; j < mat.GetLength(1); j++) 
                {
                    Console.Write($"{mat[i,j]} ");
                }
                Console.WriteLine();
            }
        }
    }
}