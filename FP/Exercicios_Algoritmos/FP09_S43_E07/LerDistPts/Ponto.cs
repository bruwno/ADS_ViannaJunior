/* Objetivo : Calcular distância entre quatro pontos.
 * Autor    : William Silva (https://github.com/unclWill)
 * Data     : 08/11/2023
 * Material : FP09 (Classes)
 * Slide    : 43
 * Exercício: 07
 */

/* 7) Utilizando a classe ponto definida no exercício anterior, faça um programa que leia 4 pontos. 
 * Em seguida imprima qual o ponto mais próximo do primeiro ponto lido.
 */

 using System;

 namespace LerDistPts
 {
    public class Ponto
    {
        private int x;
        private int y;

        public int X
        {
            get { return x; }
            set { x = value; }
        }

        public int Y
        {
            get { return y; }
            set { y = value; }
        }
    }
 }