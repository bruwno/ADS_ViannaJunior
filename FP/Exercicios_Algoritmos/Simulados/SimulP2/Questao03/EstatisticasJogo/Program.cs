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
        const int qtdJogos = 7;
        internal static void Main(string[] args)
        {
            Jogo[] jogos = new Jogo[qtdJogos];

            for (int i = 0; i < jogos.Length; i++)
            {
                Console.WriteLine($"\n[JOGO {i + 1} de {jogos.Length}]");
                jogos[i] = LerInfoJogo();
            }

            CalcularMediaDeQuedas(jogos);

            Console.Write("\nPressione qualquer tecla para finalizar...");
            Console.ReadKey();
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

        private static void CalcularMediaDeQuedas(Jogo[] jogos)
        {
            int quedasAbaixoDaMedia = 0;
            double mediaQuedas = 0.0;
            double soma = 0.0;

            for (int i = 0; i < jogos.Length; i++)
            {
                soma += jogos[i].QuedasClerysmar;
            }

            mediaQuedas = soma / jogos.Length;

            for (int j = 0; j < jogos.Length; j++)
            {
                if (jogos[j].QuedasClerysmar < mediaQuedas)
                {
                    Console.WriteLine($"\nNo jogo contra {jogos[j].Adversario}, Clerysmar caiu {jogos[j].QuedasClerysmar} vezes.");
                    quedasAbaixoDaMedia++;
                }
            }

            Console.WriteLine($"\nClerysmar caiu em média {mediaQuedas:N2} vezes por jogo.");
            Console.WriteLine($"Em {quedasAbaixoDaMedia} jogos Clerysmar caiu menos que o normal.");
        }
    }
}