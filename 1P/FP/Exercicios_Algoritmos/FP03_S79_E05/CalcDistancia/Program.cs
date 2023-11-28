/* Objetivo : Determinar resultados a partir de coordenadas informadas pelo usuário.
 * Autor    : William Silva (https://github.com/unclWill)
 * Data     : 17/08/2023
 * Material : FP03 (Subrotinas)
 * Slide    : 79
 * Exercício: 05
 */

/* Comando:
 * 5) Considerando a fórmula para o cálculo da distância entre dois pontos (x1, y1) e (x2,y2):
 *    a) Escreva uma função que receba como parâmetros as coordenadas de dois pontos e retorne a distância entre eles.
 *    b) Escreva um programa C# (função principal) que capture do teclado as coordenadas dos 3 vértices de um triângulo,
 *    calcule e imprima o perímetro deste triângulo. Este programa deve utilizar a função do item anterior.
 */

using System;

namespace CalcDistancia
{
    public class Program
    {
        public static void Main()
        {
            Console.WriteLine("Calcular distância entre pontos\n");
            ObterPerimetroTriangulo();
            Console.Write("\nPressione qualquer tecla para finalizar...");
            Console.ReadKey();
        }

        private static void ObterPerimetroTriangulo()
        {
            Console.WriteLine("[Coordenadas do 1º vértice]");
            Console.Write("[i] Digite a coordenada X: ");
            double primVertX = Convert.ToDouble(Console.ReadLine());
            Console.Write("[i] Digite a coordenada Y: ");
            double primVertY = Convert.ToDouble(Console.ReadLine());

            Console.WriteLine("\n[Coordenadas do 2º vértice]");
            Console.Write("[i] Digite a coordenada X: ");
            double segVertX = Convert.ToDouble(Console.ReadLine());
            Console.Write("[i] Digite a coordenada Y: ");
            double segVertY = Convert.ToDouble(Console.ReadLine());

            Console.WriteLine("\n[Coordenadas do 3º vértice]");
            Console.Write("[i] Digite a coordenada X: ");
            double tercVertX = Convert.ToDouble(Console.ReadLine());
            Console.Write("[i] Digite a coordenada Y: ");
            double tercVertY = Convert.ToDouble(Console.ReadLine());

            double distAeB = CalcularDistEntrePontos(primVertX, primVertY, segVertX, segVertY);
            double distAeC = CalcularDistEntrePontos(primVertX, primVertY, tercVertX, tercVertY);
            double distBeC = CalcularDistEntrePontos(segVertX, segVertY, tercVertX, tercVertY);

            double perimetro = distAeB + distAeC + distBeC;

            Console.WriteLine($"\n[>] O perímetro do triângulo é {perimetro:N1}");
        }

        private static double CalcularDistEntrePontos(double x1, double y1, double x2, double y2)
        {
            double distancia = Math.Sqrt(Math.Pow(x2 - x1, 2) + Math.Pow(y2 - y1, 2));
            return distancia;
        }
    }
}
