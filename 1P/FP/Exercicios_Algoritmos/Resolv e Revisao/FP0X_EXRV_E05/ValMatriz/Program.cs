using System;

namespace ValMatriz
{
    internal class Program
    {
        internal static void Main(string[] args)
        {
            int[,] mat = new int[3, 3] { { 1, 2, 3 }, { 4, 5, 6 }, { 7, 8, 9 } };

            for (int i = 0; i < 3; i++)
            {
                Console.Write(mat[i, i] + " ");
                for (int j = 0; j < 3; j++)
                {
                    Console.Write(mat[j, j] + " ");
                }
                System.Console.WriteLine();
            }
        }
    }
}
