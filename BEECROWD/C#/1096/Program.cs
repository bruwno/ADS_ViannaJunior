/* Objetivo: Apresentar uma sequência numérica.
 * Autor   : William Silva (https://github.com/bruwno)
 * Data    : 14/03/2025
 * Tipo    : 1 (INICIANTE)
 * ID      : 1096
 * Nome    : Sequência IJ 2
 * Link    : https://www.beecrowd.com.br/judge/pt/problems/view/1096
 */

using System;

class URI
{
    public static void Main(string[] args)
    {
        for (int cont = 0, i = 1, j = 7; cont < 11; cont++)
        {
            i = cont;
            j = 7;
            int contRepeticoes = 3;

            if (cont < 15 && ehImpar(i))
            {
                while (contRepeticoes > 0)
                {
                    Console.WriteLine($"I={i} J={j}");
                    j--;
                    contRepeticoes--;
                }
            }
        }
    }

    public static bool ehImpar(int n)
    {
        return n % 2 == 1;
    }
}