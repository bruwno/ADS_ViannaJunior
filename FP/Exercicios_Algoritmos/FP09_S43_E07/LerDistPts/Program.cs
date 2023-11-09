/* Objetivo : Calcular distância entre dois pontos.
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
    internal class Program
    {
        internal static void Main(string[] args)
        {
            Ponto p1 = new Ponto();
            Ponto p2 = new Ponto();
            Ponto p3 = new Ponto();
            Ponto p4 = new Ponto();

            for (int i = 0; i < 4; i++) 
            {
                switch (i)
                {
                    case 0:
                        Console.Write($"Ponto P{i+1} X: ");
                        p1.X = Convert.ToInt32(Console.ReadLine());
                        Console.Write($"Ponto P{i+1} Y: ");
                        p1.Y = Convert.ToInt32(Console.ReadLine());
                        break;
                    case 1:
                        Console.Write($"Ponto P{i+1} X: ");
                        p2.X = Convert.ToInt32(Console.ReadLine());
                        Console.Write($"Ponto P{i+1} Y: ");
                        p2.Y = Convert.ToInt32(Console.ReadLine());
                        break;
                    case 2:
                        Console.Write($"Ponto P{i+1} X: ");
                        p3.X = Convert.ToInt32(Console.ReadLine());
                        Console.Write($"Ponto P{i+1} Y: ");
                        p3.Y = Convert.ToInt32(Console.ReadLine());
                        break;
                    case 3:
                        Console.Write($"Ponto P{i+1} X: ");
                        p4.X = Convert.ToInt32(Console.ReadLine());
                        Console.Write($"Ponto P{i+1} Y: ");
                        p4.Y = Convert.ToInt32(Console.ReadLine());
                        break;
                }
                Console.WriteLine();
            }

            double distP1P2 = CalcularDistEntrePontos(p1.X, p1.Y, p2.X, p2.Y);
            double distP1P3 = CalcularDistEntrePontos(p1.X, p1.Y, p3.X, p3.Y);
            double distP1P4 = CalcularDistEntrePontos(p1.X, p1.Y, p4.X, p4.Y);
            
            System.Console.WriteLine($"|DEBUG| P1-P2 {distP1P2}");
            System.Console.WriteLine($"|DEBUG| P1-P3 {distP1P3}");
            System.Console.WriteLine($"|DEBUG| P1-P4 {distP1P4}");

            VerificaPontoMaisProximo(distP1P2, distP1P3, distP1P4);

            Console.Write("\nPressione qualquer tecla para finalizar...");
            Console.ReadKey();
        }

        private static void VerificaPontoMaisProximo(double p1p2, double p1p3, double p1p4)
        {
            double menorDist = double.MaxValue;

            if (p1p2 <= p1p3 && p1p2 <= p1p4)
            {
                menorDist = p1p2;
                Console.WriteLine($"O ponto P2 é o mais proximo de P1. {p1p2}");
            }
            else if (p1p3 <= p1p2 && p1p3 <= p1p4)
            {
                menorDist = p1p3;
                Console.WriteLine($"O ponto P3 é o mais próximo de P1. {p1p3}");
            }
            else if (p1p4 <= p1p2 && p1p4 <= p1p3)
            {
                menorDist = p1p4;
                Console.WriteLine($"O ponto P4 é o mais próximo de P1. {p1p4}");
            }
        }

        private static double CalcularDistEntrePontos(int x1, int y1, int x2, int y2)
        {
            return Math.Sqrt(Math.Pow(x2 - x1, 2) + Math.Pow(y2 - y1, 2));
        }
    }
 }