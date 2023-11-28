/* Objetivo : Determinar resultados a partir de coordenadas informadas pelo usuário.
 * Autor    : William Silva (https://github.com/unclWill)
 * Data     : 17/08/2023
 * Material : FP03 (Subrotinas)
 * Slide    : 79
 * Exercício: 05 (Utilizando o laço for nessa versão).
 */

/* Comando:
 * 5) Considerando a fórmula para o cálculo da distância entre dois pontos (x1, y1) e (x2,y2):
 *    a) Escreva uma função que receba como parâmetros as coordenadas de dois pontos e retorne a distância entre eles.
 *    b) Escreva um programa C# (função principal) que capture do teclado as coordenadas dos 3 vértices de um triângulo,
 *    calcule e imprima o perímetro deste triângulo. Este programa deve utilizar a função do item anterior.
 */

using System;

namespace CalcDistFor
{
    public class Program
    {
        public static void Main(string[] args)
        {
            Console.WriteLine("Calcular distância entre pontos\n");
            ObterPerimetroTriangulo();
            Console.Write("\nPressione qualquer tecla para finalizar...");
            Console.ReadKey();
        }

        private static void ObterPerimetroTriangulo()
        {
            double primVertX = 0.0, primVertY = 0.0;
            double segVertX = 0.0, segVertY = 0.0;
            double tercVertX = 0.0, tercVertY = 0.0;

            for (int i = 1; i <= 3; i++)
            {
                Console.WriteLine($"\n[Coordenadas do {i}º vértice]");
                Console.Write("[i] Digite a coordenada de X: ");
                double vertX = Convert.ToDouble(Console.ReadLine());
                Console.Write("[i] Digite a coordenada de Y: ");
                double vertY = Convert.ToDouble(Console.ReadLine());

                switch (i)
                {
                    case 1:
                        primVertX = vertX;
                        primVertY = vertY;
                        break;
                    case 2:
                        segVertX = vertX;
                        segVertY = vertY;
                        break;
                    case 3:
                        tercVertX = vertX;
                        tercVertY = vertY;
                        break;
                }
            }

            double distAeB = CalcularDistEntrePontos(primVertX, primVertY, segVertX, segVertY);
            double distAeC = CalcularDistEntrePontos(primVertX, primVertY, tercVertX, tercVertY);
            double distBeC = CalcularDistEntrePontos(segVertX, segVertY, tercVertX, tercVertY);

            double perimetro = distAeB + distAeC + distBeC;

            Console.WriteLine($"\n[>] O perímetro do triângulo é {perimetro:N1}");
        }

        private static double CalcularDistEntrePontos(double x1, double y1, double x2, double y2)
        {
            return Math.Sqrt(Math.Pow(x2 - x1, 2) + Math.Pow(y2 - y1, 2));
        }
    }
}