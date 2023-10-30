/* Objetivo : Calcular a média e exibir os alunos aprovados.
 * Autor    : William Silva (https://github.com/unclWill)
 * Data     : 30/10/2023
 * Material : FP08 (Matrizes)
 * Slide    : 50
 * Exercício: 07
 */

/* 7) Crie uma matriz tridimensional onde as linhas indicam as notas de matemática, história e geografia em três provas de
 * 10 alunos e crie uma função que verifique quantos alunos passaram, ou seja, os que tenham média aritmética > 60 nas3 disciplinas.
 */

using System;

namespace AlunosAprov
{
    internal class Program
    {
        internal static void Main(string[] args)
        {
            double[,] mat = new double[2, 3, 3];



            Console.Write("\nPressione qualquer tecla para finalizar...");
            Console.ReadKey();
        }

        private static double CalcularMedia(double[,] mat)
        {

        }
    }
}