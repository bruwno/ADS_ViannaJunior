/* Objetivo : Determinar se 3 comprimentos digitados formam um triângulo.
 * Autor    : William Silva (https://github.com/unclWill)
 * Data     : 30/08/2023
 * Material : FP04
 * Slide    : 62
 * Exercício: 04
 */

/* 4. Faça um programa que leia 3 comprimentos (x, y e z) e responda se eles formam um
 * triângulo, ou seja, se x < y + z e y < x + z e z < x + y.
 */

using System;

namespace VerifTriang
{
    public class Program
    {
        public static void Main()
        {
            Console.WriteLine("Verificar se valores foram um triângulo\n");
            ObterValores();
            Console.Write("\nPressione qualquer tecla para finalizar...");
            Console.ReadKey();
        }

        private static void ObterValores()
        {
            Console.Write("\n[i] Digite o valor de X: ");
            float valorX = float.Parse(Console.ReadLine());
            Console.Write("\n[i] Digite o valor de Y: ");
            float valorY = float.Parse(Console.ReadLine());
            Console.Write("\n[i] Digite o valor de Z: ");
            float valorZ = float.Parse(Console.ReadLine());

            VerifSeFormaTriangulo(valorX, valorY, valorZ);
        }

        private static void VerifSeFormaTriangulo(float x, float y, float z)
        {
            if ((x < y + z) && (y < x + z) && (z < x + y))
            {
                Console.WriteLine("\n[>] Os valores de comprimento informados formam um triângulo!");
            }
            else
            {
                Console.WriteLine("\n[>] Os valores de comprimento informados NÃO formam um triângulo!");
            }
        }
    }
}