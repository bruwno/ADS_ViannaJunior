/* Objetivo: Ler um número, que representa uma senha, e exibir o número que vem depois dele.
 * Autor   : William Silva (https://github.com/bruwno)
 * Data    : 30/09/2025
 * Tipo    : 5 (MATEMÁTICA)
 * ID      : 3104
 * Nome    : Resto 2.0
 * Link    : https://www.beecrowd.com.br/judge/pt/problems/view/3104
 */

using System;

class URI
{
    static void Main()
    {
        string a = Console.ReadLine();
        int b = int.Parse(Console.ReadLine());
        long resto = 0;

        foreach (char digito in a)
        {
            int valor = digito - '0';
            resto = (resto * 10 + valor) % b;
        }

        Console.WriteLine(resto);
    }
}