/* Objetivo : Representar o peso e altura de uma pessoa.
 * Autor    : William Silva (https://github.com/unclWill)
 * Data     : 01/11/2023
 * Material : FP09 (Classes)
 * Slide    : 20
 * Exercício: 03
 */

/* 3) Considerando a classe do exercício (2) e a inicialização abaixo:
 * joao.altura <- 1.90; joao.peso <- 98;
 * maria.altura <- 1.50; maria.peso <- 55;
 * - Escreva uma instrução que atribua 1.78 à altura de joao;
 * - Escreva uma instrução que atribua 75 ao peso de maria.
 * - Escreva um conjunto de instruções para imprimir a média das alturas e a média dos pesos de joao e maria.
 */

using System;

namespace ExibePesoAlturaV2
{
    internal class Program
    {
        internal static void Main(string[] args)
        {
            Pessoa joao = new Pessoa();
            Pessoa maria = new Pessoa();

            joao.peso = 98.0;
            joao.altura = 1.90;

            maria.peso = 55.0;
            maria.altura = 1.50;

            Console.WriteLine("Altura João");
            joao.altura = LerAltura();

            Console.WriteLine("Peso Maria");
            maria.peso = LerPeso();

            Console.WriteLine($"\nPeso João = {joao.peso:F2} m");
            Console.WriteLine($"Altura João = {joao.altura:F2} kg");

            Console.WriteLine($"Peso Maria = {maria.peso:F2} kg");
            Console.WriteLine($"Altura Maria = {maria.altura:F2} m");

            double mediaPeso = CalcularMediaPeso(joao.peso, maria.peso);
            double mediaAltura = CalcularMediaAltura(joao.altura, maria.altura);

            Console.WriteLine($"\nMedia dos peso : {mediaPeso:F2} kg");
            Console.WriteLine($"Media de altura: {mediaAltura:F2} m");

            Console.Write("\nPressione qualquer tecla para finalizar...");
            Console.ReadKey();
        }

        private static double CalcularMediaPeso(double peso1, double peso2)
        {
            return (peso1 + peso2) / 2.0;
        }

        private static double CalcularMediaAltura(double altura1, double altura2)
        {
            return (altura1 + altura2) / 2.0;
        }

        private static double LerPeso()
        {
            Console.Write("Digite o peso: ");
            double peso = Convert.ToDouble(Console.ReadLine());

            return peso;
        }

        private static double LerAltura()
        {
            Console.Write("Digite a altura: ");
            double altura = Convert.ToDouble(Console.ReadLine());

            return altura;
        }
    }
}