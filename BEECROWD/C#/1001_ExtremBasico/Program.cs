/* Objetivo : Realizar uma soma e exibir na tela.
 * Autor    : William Silva (https://github.com/unclWill)
 * Data     : 18/12/2023
 * Tipo     : 1 (INICIANTE)
 * ID       : 1001
 * Nome     : Extremamente Básico
 * Link     : https://www.beecrowd.com.br/judge/pt/problems/view/1001
 */

using System;

class URI
{
    static void Main(string[] args)
    {
        int a = int.Parse(Console.ReadLine());
        int b = int.Parse(Console.ReadLine());

        int x = a + b;

        Console.WriteLine($"X = {x}");
    }
}