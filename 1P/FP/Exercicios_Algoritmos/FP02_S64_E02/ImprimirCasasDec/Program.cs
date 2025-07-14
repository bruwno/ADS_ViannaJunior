/* Objetivo : Exibir valor com variações na quantidade de casas decimais.
 * Autor    : William Silva (https://github.com/unclWill)
 * Data     : 16/08/2023
 * Material : FP02 (E/S de dados)
 * Slide    : 64
 * Exercício: 02
 */

/* Comando:
 * 2. Imprimir o valor 2.346728 com 1, 2, 3 e 5 casas decimais.
 */

using System;

namespace ImprimirCasasDec
{
    public class Program
    {
        public static void Main(string[] args)
        {
            Console.WriteLine("[2.346728] com 1, 2, 3 e 5 casas decimais\n");
            ExibirValoresFormatados();
            Console.Write("\nPressione qualquer tecla para finalizar...");
            Console.ReadKey();
        }

        private static void ExibirValoresFormatados()
        {
            const double valor = 2.346728;
            Console.WriteLine($"{valor:N1}");
            Console.WriteLine($"{valor:N2}");
            Console.WriteLine($"{valor:N3}");
            Console.WriteLine($"{valor:N5}");
        }
    }
}