/* Objetivo : Contar a quantidade de vogais em uma String e retornar em uma função.
 * Autor    : William Silva (https://github.com/unclWill)
 * Data     : 15/11/2023
 * Material : Simulado
 * Slide    : 00
 * Exercício: 03
 */

/* Questão 3: Clerysmar é o jogador mais importante da seleção brasileira de futebol. 
 * É de conhecimento de todos que esse jogador possui um pouco de dificuldade para se manter em pé dentro de campo. 
 * Para essa questão, vamos representar um jogo de futebol como tendo um adversário (string), o número de pontos somados (inteiro) e o número de vezes que Clerysmar caiu em campo (inteiro). 
 * Leia um conjunto de sete jogos e, em seguida, imprima a média de quedas de Clerysmar e quantos jogos o número de quedas ficou abaixo da média.
 */

using System;

namespace EstatisticasJogo
{
    internal class Program
    {
        internal static void Main(string[] args)
        {
            for (int i = 0; i < 7; i++)
            {
                Console.WriteLine($"[JOGO {i + 1} de 7]");
                Jogo[] jogos = new Jogo[7];
                jogos[i] = LerInfoJogo();
            }
        }

        private static Jogo LerInfoJogo()
        {
            Jogo jogo = new Jogo();

            Console.Write("Seleção adversária     : ");
            jogo.Adversario = Console.ReadLine();
            Console.Write("Quantidade de pontos   : ");
            jogo.Pontos = Convert.ToInt32(Console.ReadLine());
            Console.Write("Qtd de quedas Clerysmar: ");
            jogo.QuedasClerysmar = Convert.ToInt32(Console.ReadLine());

            return jogo;
        }
    }
}