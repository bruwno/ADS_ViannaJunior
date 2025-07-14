/* Objetivo : Calcular notas de alunos e retornar.
 * Autor    : William Silva (https://github.com/unclWill)
 * Data     : 11/10/2023
 * Material : FP06 (Vetores)
 * Slide    : 113
 * Exercício: 06
 */

/* 6) Dada uma tabela com as notas de uma turma de 20 alunos, faça funções que retornem:
 * a) A média da turma;
 * b) a quantidade de alunos aprovados (>=60);
 * c) a quantidade de alunos reprovados (< 60).
 */

using System;

namespace CalcNotas
{
    internal class Program
    {
        internal static void Main(string[] args)
        {
            double[] vet = new double[20] { 50.7, 60.7, 61.6, 45.0, 60.0, 69.0, 70.4, 80.8, 90.2, 100, 45.1, 74.9, 56.4, 59.0, 47.8, 63.7, 63.5, 59.9, 45.0, 20.0 };

            Console.WriteLine("Ler notas");

            double mediaNotas = CalcularMedia(vet);

            Console.WriteLine($"Média da turma = {mediaNotas:N2}");
            Console.WriteLine($"Quantidade de aluno reprovados: {VerificarReprovados(vet, mediaNotas)}");
            Console.WriteLine($"Quantidade de aluno aprovados: {VerificarAprovados(vet, mediaNotas)}");

            Console.Write("\nPressione qualquer tecla para finalizar...");
            Console.ReadKey();
        }

        private static double CalcularMedia(double[] vet)
        {
            double somatorioNotas = 0.0;

            for (int i = 0; i < vet.Length; i++)
            {
                somatorioNotas += vet[i];
            }

            double media = somatorioNotas / 20.0;

            return media;
        }

        private static int VerificarReprovados(double[] vet, double mediaNotas)
        {
            int qtdReprovados = 0;

            for (int i = 0; i < vet.Length; i++)
            {
                if (vet[i] >= 60.0)
                {
                    qtdReprovados++;
                }
            }

            return qtdReprovados;
        }

        private static int VerificarAprovados(double[] vet, double mediaNotas)
        {
            int qtdAprovados = 0;

            for (int i = 0; i < vet.Length; i++)
            {
                if (vet[i] < 60.0)
                {
                    qtdAprovados++;
                }
            }

            return qtdAprovados;
        }
    }
}