
/* Objetivo : Ler as notas e determinar a média das provas de um aluno.
 * Autor    : William Silva (https://github.com/unclWill)
 * Data     : 23/08/2023
 * Material : FP03
 * Slide    : 101
 * Exercício: 06
 */

/* Comando:
 * 6) Considerando o critério de aprovação de uma disciplina que determina que um aluno está aprovado se a média
 * ponderada de suas três provas for maior ou igual a 5.0, onde
 a média é dada pela fórmula: Média = (P1 + P2 + 2.0 * P3) / 4.0
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
            Console.WriteLine("Calcular média das provas");
            ObterValores();
            Console.Write("\nPressione qualquer tecla para finalizar...");
            Console.ReadKey();
        }

        private static void ObterValores()
        {
            Console.Write("[i] Digite a nota da primeira prova: ");
            double prova1 = Convert.ToDouble(Console.ReadLine());
            Console.Write("[i] Digite a nota da segunda prova : ");
            double prova2 = Convert.ToDouble(Console.ReadLine());

            double resultado = CalcularMedia(prova1, prova2, prova3);
            Console.WriteLine($"[>]  {resultado}");
        }

        private static double CalcularNotaNecessariaNaP3(double p1, double p2, double p3)
        {

        }


    }
}