
/* Objetivo : Ler as notas e determinar a média das provas de um aluno.
 * Autor    : William Silva (https://github.com/unclWill)
 * Data     : 23/08/2023
 * Material : FP03 (Subrotinas)
 * Slide    : 101
 * Exercício: 06
 */

/* Comando:
 * 6) Considerando o critério de aprovação de uma disciplina que determina que um aluno está aprovado se a média
 * ponderada de suas três provas for maior ou igual a 5.0, onde a média é dada pela fórmula: Média = (P1 + P2 + 2.0 * P3) / 4.0
 *** (a) Escreva uma função que receba como parâmetros as notas das duas primeiras provas de um aluno (P1 e P2) e retorne a nota
 * mínima que o aluno precisa tirar na terceira prova para que seja aprovado.
 *** (b) Escreva um programa em C# completo que leia do teclado as duas primeiras notas de um aluno, calcule e imprima a nota mínima que
 * o aluno precisa tirar na P3 para que seja aprovado. Este programa deve fazer uso da função do item anterior.
 */

using System;

namespace CalculaMediaPond
{
    public class Program
    {
        public static void Main(string[] args)
        {
            Console.WriteLine("Calcular média mínima para aprovação");
            ObterValores();
            Console.Write("\nPressione qualquer tecla para finalizar...");
            Console.ReadKey();
        }

        private static void ObterValores()
        {
            Console.Write("\n[i] Digite a nota da P1: ");
            double prova1 = Convert.ToDouble(Console.ReadLine());
            Console.Write("\n[i] Digite a nota da P2: ");
            double prova2 = Convert.ToDouble(Console.ReadLine());

            double resultado = CalcularNotaParaAprovacao(prova1, prova2);
            Console.WriteLine($"\n[>] O aluno precisa tirar {resultado} pontos na P3 para ser aprovado.");
        }

        private static double CalcularNotaParaAprovacao(double p1, double p2)
        {
            return ((5.0 * 4.0) - (p1 + p2)) / 2.0;
        }
    }
}