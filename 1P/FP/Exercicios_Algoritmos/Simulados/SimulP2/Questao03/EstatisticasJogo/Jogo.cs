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
    public class Jogo
    {
        private string adversario;
        private int pontos;
        private int quedasEmCampo;

        public string Adversario
        {
            get { return adversario; }
            set { adversario = value; }
        }

        public int Pontos
        {
            get { return pontos; }
            set { pontos = value; }
        }

        public int QuedasEmCampo
        {
            get { return quedasEmCampo; }
            set { quedasEmCampo = value; }
        }

    }
}