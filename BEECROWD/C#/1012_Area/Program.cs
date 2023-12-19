/* Objetivo : Calcular área.
 * Autor    : William Silva (https://github.com/unclWill)
 * Data     : 26/09/2023
 * Tipo     : 1 (INICIANTE)
 * ID       : 1012
 * Nome     : Área
 * Link     : https://www.beecrowd.com.br/judge/pt/problems/view/1012
 */

using System;

class URI
{
    const int dimArray = 3;
    const double pi = 3.14159;
    public static void Main(string[] args)
    {
        string[] entrada = new string[dimArray];

        entrada = Console.ReadLine().Trim().Split(' ');

        double[] valores = ConverterArray(entrada);
        double a = valores[0], b = valores[1], c = valores[2];

        double areaTriangRet = a * c / 2.0;
        double areaCirculo = pi * Math.Pow(c, 2.0);
        double areaTrapezio = (a + b) * c / 2.0;
        double areaQuad = Math.Pow(b, 2.0);
        double areaRet = a * b;

        Console.WriteLine($"TRIANGULO: {areaTriangRet:F3}\n" +
                          $"CIRCULO: {areaCirculo:F3}\n" +
                          $"TRAPEZIO: {areaTrapezio:F3}\n" +
                          $"QUADRADO: {areaQuad:F3}\n" +
                          $"RETANGULO: {areaRet:F3}");
    }

    public static double[] ConverterArray(string[] entrada)
    {
        return Array.ConvertAll(entrada, double.Parse);
    }
}