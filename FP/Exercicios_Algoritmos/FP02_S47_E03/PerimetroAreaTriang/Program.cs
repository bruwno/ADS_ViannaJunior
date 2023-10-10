/* Objetivo : Determinar o perímetro e a área de um triângulo.
 * Autor    : William Silva (https://github.com/unclWill)
 * Data     : 15/08/2023
 * Material : FP02 (E/S de dados)
 * Slide    : 47
 * Exercício: 03
 */

/* Comando:
 * 3. Faça um programa que leia os valores dos lados e
 * altura de um triângulo, calcule e imprima seu perímetro e área.
 */

using System;

namespace CalcPerimetroAreaTriangulo
{
    public class Program
    {
        public static void Main(string[] args)
        {
            Console.WriteLine("Calcular perímetro e área do triângulo\n");
            ObterDadosDoTriangulo();
            Console.Write("\nPressione qualquer tecla para finalizar...");
            Console.ReadKey();
        }

        private static void ObterDadosDoTriangulo()
        {
            double baseDoTriangulo = 0.0;
            double perimetroDoTriangulo = 0.0;
            double areaDoTriangulo = 0.0;

            Console.WriteLine("[i] Digite os valores dos lados do triângulo\n");
            Console.Write("[i] Lado A: ");
            double ladoA = Convert.ToDouble(Console.ReadLine());
            Console.Write("[i] Lado B: ");
            double ladoB = Convert.ToDouble(Console.ReadLine());
            Console.Write("[i] Lado C: ");
            double ladoC = Convert.ToDouble(Console.ReadLine());
            Console.Write("[i] Altura do triângulo: ");
            double alturaDoTriangulo = Convert.ToDouble(Console.ReadLine());

            if (ladoA > ladoB & ladoA > ladoC)
            {
                baseDoTriangulo = ladoA;
            }
            else if (ladoB > ladoA & ladoB > ladoC)
            {
                baseDoTriangulo = ladoB;
            }
            else if (ladoC > ladoA & ladoC > ladoB)
            {
                baseDoTriangulo = ladoC;
            }

            Console.WriteLine($"\nBase do triângulo = {baseDoTriangulo}\n");

            perimetroDoTriangulo = CalcularPerimetro(ladoA, ladoB, ladoC);
            areaDoTriangulo = CalcularArea(baseDoTriangulo, alturaDoTriangulo);
            //areaDoTriangulo = CalcularArea(ladoA, ladoB, ladoC);

            Console.Write($"\n[>] O perímetro do triângulo é igual a: {perimetroDoTriangulo}\n");
            Console.Write($"[>] A área do triângulo é igual a: {areaDoTriangulo:N1}\n");
        }

        private static double CalcularPerimetro(double ladoA, double ladoB, double ladoC)
        {
            return ladoA + ladoB + ladoC;
        }

        private static double CalcularArea(double baseDoTriangulo, double altura)
        {
            return baseDoTriangulo * altura / 2.0;
        }

        // Para triângulo retângulo.
        private static double CalcularArea(double ladoA, double ladoB, double ladoC)
        {
            double perimetro = (ladoA + ladoB + ladoC) / 2.0;
            return Math.Sqrt(perimetro * (perimetro - ladoA) * (perimetro - ladoB) * (perimetro - ladoC));
        }
    }
}
