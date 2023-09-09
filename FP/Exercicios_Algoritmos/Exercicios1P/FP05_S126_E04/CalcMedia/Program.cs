/* Objetivo : Calcular a taxa de crescimento.
 * Autor    : William Silva (https://github.com/unclWill)
 * Data     : 06/08/2023
 * Material : FP05
 * Slide    : 126
 * Exercício: 04
 */

/* 4. Escreva um algoritmo que leia a matrícula de um aluno e suas três notas. 
 * Calcule a média ponderada do aluno, considerando que o peso para a maior 
 * nota seja 4 e para as duas restantes, 3. Mostre ao final a média calculada e 
 * uma mensagem "APROVADO" se a média for maior ou igual a 5 e 
 * "REPROVADO" se a média for menor que 5. Repita a operação até que o 
 * código lido seja negativo. 
 */

using System;

namespace CalcMedia
{
    public class Program
    {
        public static void Main()
        {
            Console.WriteLine("Ler dados do aluno");
            LerDados();
            Console.Write("\nPressione qualquer tecla para finalizar...");
            Console.ReadKey();
        }

        private static void LerDados()
        {

        }

        private static double CalculaMedia(double n1, double n2, double n3)
        {
            double menorNora = DeterminarMaiorNota(n1, n2, n3);
            double maiorNota = DeterminarMenorNota(n1, n2, n3);
            double notaMedia = DeterminarMenorEMaiorNota(n1, n2, n3);

            if ()
            {

            }

            double media = maiorNota * media;
        }

        private static double DeterminarMenorNota(double n1, double n2, double n3)
        {
            double menorNota = 0.0;

            if (n1 < n2 && n1 < n3)
            {
                maiorNota = n1;
            }
            else if (n2 < n1 && n2 < n3)
            {
                maiorNota = n2;
            }
            else if (n3 < n1 && n3 < n2)
            {
                maiorNota = n3;
            }

            return menorNota;
        }

        private static double DeterminarMaiorNota(double n1, double n2, double n3)
        {
            double maiorNota = 0.0;

            if (n1 > n2 && n1 > n3)
            {
                maiorNota = n1;
            }
            else if (n2 > n1 && n2 > n3)
            {
                maiorNota = n2;
            }
            else if (n3 > n1 && n3 > n2)
            {
                maiorNota = n3;
            }

            return maiorNota;
        }

        private static double DeterminarNotaMedia(double n1, double n2, double n3)
        {
            double notaMedia = 0.0;

            if (n1 > n2 && n1 < n3)
            {
                notaMedia = n1;
            }
            else if (n2 > n1 && n2 > n3)
            {
                maiorNota = n2;
            }
            else if (n3 > n1 && n3 > n2)
            {
                maiorNota = n3;
            }

            return notaMedia;
        }
    }
}
