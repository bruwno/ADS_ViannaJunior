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
    internal class Program
    {
        internal static void Main(string[] args)
        {
            Ponto p1 = new Ponto();
            Ponto p2 = new Ponto();

            Console.WriteLine("Ponto P1");
            Console.Write("Digite a coordenada X: ");
            p1.X = Convert.ToInt32(Console.ReadLine());
            Console.Write("Digite a coordenada Y: ");
            p1.Y = Convert.ToInt32(Console.ReadLine());

            Console.WriteLine("Ponto P2");
            Console.Write("Digite a coordenada X: ");
            p2.X = Convert.ToInt32(Console.ReadLine());
            Console.Write("Digite a coordenada Y: ");
            p2.Y = Convert.ToInt32(Console.ReadLine());

            double distancia = CalcularDistEntrePontos(p1.X, p1.Y, p2.X, p2.Y);
            Console.WriteLine($"\nA distância entre os pontos P1 e P2 = {distancia}");

            Console.Write("\nPressione qualquer tecla para finalizar...");
            Console.ReadKey();
        }

        private static double CalcularDistEntrePontos(int x1, int y1, int x2, int y2)
        {
            return Math.Sqrt(Math.Pow(x2 - x1, 2) + Math.Pow(y2 - y1, 2));
        }
    }
}