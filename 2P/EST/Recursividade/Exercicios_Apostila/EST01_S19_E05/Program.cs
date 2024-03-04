/*
 * Autor: William Silva (https://github.com/unclWill)
 * Data : 04/03/2024
 *
 * Algoritmo que determina se um número n é primo.
 */

using System;

public class Program
{
    public static void Main(string[] args)
    {
        Console.Write("Digite um número: ");
        int n = int.Parse(Console.ReadLine());
        if (X(n))
        {
            Console.WriteLine($"O número {n} é primo");
        }
        else
        {
            Console.WriteLine($"O número {n} não é primo");
        }
    }

    public static bool X(int n)
    {
        if (n < 1)
            throw new Exception("Número inválido!");

        return X(n, n / 2);
    }

    public static bool X(int n, int d)
    {
        if (d > 1)
            if (n % d != 0)
                return X(n, d - 1);

        return d == 1;
    }
}