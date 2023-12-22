/* Objetivo: Calcular a posição de uma partícula.
 * Autor   : William Silva (https://github.com/unclWill)
 * Data    : 27/09/2023
 * Tipo    : 5 (MATEMÁTICA)
 * ID      : 1197
 * Nome    : Volta à Faculdade de Física
 * Link    : https://www.beecrowd.com.br/judge/pt/problems/view/1197
 */

using System;
using System.Linq;

class URI
{
    static void Main(string[] args)
    {
        string valor;

        while (!string.IsNullOrEmpty(valor = Console.ReadLine()))
        {
            int[] dados = valor.Split(' ').Select(int.Parse).ToArray();

            int v = dados[0];
            int t = dados[1];

            Console.WriteLine(2 * v * t);
        }
    }
}