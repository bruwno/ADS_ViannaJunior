/* Objetivo : Calcular média das idades e retornar em uma função.
 * Autor    : William Silva (https://github.com/unclWill)
 * Data     : 10/10/2023
 * Material : FP06 (Vetores)
 * Slide    : 103
 * Exercício: 06
 */

/* 6) Refaça o exercício (3) criando uma função que receba o vetor com a idade dos alunos e retorne a 
 * quantidade de alunos com idade superior a média.
 */

using System;

namespace CalcMediaIdades
{
    internal class Program
    {
        internal static void Main(string[] args)
        {
            int[] idades = new int[10];

            Console.WriteLine("Ler idades\n");

            for (int i = 0, j = 1; i < idades.Length; i++, j++)
            {
                Console.Write($"Digite a idade do {j}º aluno: ");
                idades[i] = int.Parse(Console.ReadLine());
            }

            var resultados = CalcularMediaIdades(idades);
            Console.WriteLine($"\nOs alunos tem em média: {resultados.mediaIdades} anos de idade.\nDos 10 alunos verificados {resultados.idadesSupMedia} tem idade superior a média.");

            Console.Write("\nPressione qualquer tecla para finalizar...");
            Console.ReadKey();
        }

        // Retorno de Tupla contendo a média das idades e a quantidade de idades que são superiores à a média.
        private static (double mediaIdades, int idadesSupMedia) CalcularMediaIdades(int[] idades)
        {
            double media = 0.0, acm = 0.0;
            int qtdIdadesSupMedia = 0;

            for (int i = 0; i < idades.Length; i++)
            {
                acm += idades[i];
            }

            media = acm / 10.0;

            for (int j = 0; j < idades.Length; j++)
            {
                if (idades[j] > media)
                {
                    qtdIdadesSupMedia++;
                }
            }

            return (media, qtdIdadesSupMedia);
        }
    }
}