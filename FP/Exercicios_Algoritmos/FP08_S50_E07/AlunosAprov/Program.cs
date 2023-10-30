/* Objetivo : Calcular a média e exibir os alunos aprovados.
 * Autor    : William Silva (https://github.com/unclWill)
 * Data     : 30/10/2023
 * Material : FP08 (Matrizes)
 * Slide    : 50
 * Exercício: 07
 */

/* 7) Crie uma matriz tridimensional onde as linhas indicam as notas de matemática, história e geografia em três provas de
 * 10 alunos e crie uma função que verifique quantos alunos passaram, ou seja, os que tenham média aritmética > 60 nas 3 disciplinas.
 */

using System;

namespace AlunosAprov
{
    internal class Program
    {
        internal static void Main(string[] args)
        {
            double[,,] mat = new double[10, 3, 3];

            // ALUNOS.
            for (int i = 0, numAluno = 1; i < mat.GetLength(0); i++, numAluno++)
            {
                Console.WriteLine($"[{numAluno} de {mat.GetLength(0)}] Digite as notas do {numAluno}º aluno");
                // DISCIPLINAS.
                for (int j = 0; j < mat.GetLength(1); j++)
                {
                    switch (j)
                    {
                        case 0:
                            Console.WriteLine("NOTAS DE MATEMÁTICA");
                            break;
                        case 1:
                            Console.WriteLine("NOTAS DE HISTÓRIA");
                            break;
                        case 2:
                            Console.WriteLine("NOTAS DE GEOGRAFIA");
                            break;
                    }
                    // NOTAS.
                    for (int k = 0, posicNota = 1; k < mat.GetLength(2); k++, posicNota++)
                    {
                        Console.Write($"Digite a {posicNota}ª nota: ");
                        mat[i, j, k] = Convert.ToDouble(Console.ReadLine());
                    }
                    Console.WriteLine();
                }
            }

            int qtdAprovados = CalcularMedia(mat);
            Console.WriteLine($"Quantidade de alunos aprovados nas três disciplinas: {qtdAprovados} de {mat.GetLength(0)}");

            Console.Write("\nPressione qualquer tecla para finalizar...");
            Console.ReadKey();
        }

        private static int CalcularMedia(double[,,] mat)
        {
            int qtdAprovados = 0;

            // ALUNOS.
            for (int i = 0; i < mat.GetLength(0); i++)
            {
                int aprovado = 0;
                // DISCIPLINAS.
                for (int j = 0; j < mat.GetLength(1); j++)
                {
                    double soma = 0.0, media = 0.0;
                    // NOTAS.
                    for (int k = 0; k < mat.GetLength(2); k++)
                    {
                        soma += mat[i, j, k];
                    }

                    media = soma / mat.GetLength(2);

                    if (media >= 60.0)
                    {
                        aprovado++;
                    }
                }

                if (aprovado == 3)
                {
                    qtdAprovados++;
                }
            }

            return qtdAprovados;
        }
    }
}