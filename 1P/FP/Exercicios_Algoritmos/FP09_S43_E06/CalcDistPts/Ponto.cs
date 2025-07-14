/* Objetivo : Calcular distância entre dois pontos.
 * Autor    : William Silva (https://github.com/unclWill)
 * Data     : 07/11/2023
 * Material : FP09 (Classes)
 * Slide    : 43
 * Exercício: 06
 */

/* 6) Crie uma classe chamada ponto contendo apenas as coordenadas x e y (inteiros) do ponto. 
 * Declare 2 pontos, leia as coordenadas x e y de cada um e calcule a distância entre eles. 
 * Apresente no final a distância entre os dois pontos.
 */

using System;

namespace CalcDistPts
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