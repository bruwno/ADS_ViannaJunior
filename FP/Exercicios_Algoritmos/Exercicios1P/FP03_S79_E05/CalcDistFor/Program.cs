/* Objetivo : Determinar resultados a partir de coordenadas informadas pelo usuário.
 * Autor    : William Silva (https://github.com/unclWill)
 * Data     : 17/08/2023
 * Material : FP03
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
    }
}