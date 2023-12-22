/* Objetivo: Imprimir o quadrado dos pares até o número n informado.
 * Autor   : William Silva (https://github.com/unclWill)
 * Data    : 22/12/2023
 * Tipo    : 1 (INICIANTE)
 * ID      : 1073
 * Nome    : Quadrado de Pares
 * Link    : https://www.beecrowd.com.br/judge/pt/problems/view/1073
 */

using System;

class URI
{
    static void Main(string[] args)
    {
        int n = int.Parse(Console.ReadLine());

        for (int i = 2; i <= n; i += 2)
        {
            int result = (int)Math.Pow(i, 2);
            Console.WriteLine($"{i}^2 = {result}");
        }
    }
}
