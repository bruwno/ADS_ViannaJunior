/* Objetivo: Imprimir a quantidade de números pares, ípares, positivos e negativos.
 * Autor   : William Silva (https://github.com/unclWill)
 * Data    : 19/12/2023
 * Tipo    : 1 (INICIANTE)
 * ID      : 1066
 * Nome    : Pares, Ímpares, Positivos e Negativos
 * Link    : https://www.beecrowd.com.br/judge/pt/problems/view/1066
 */

using System;

class URI
{
    public static void Main(string[] args)
    {
        int[] nums = new int[5];

        for (int i = 0; i < 5; i++)
        {
            nums[i] = int.Parse(Console.ReadLine());
        }

        int contPares = 0, contImpares = 0, contPositivos = 0, contNegativos = 0;
        foreach (int num in nums)
        {
            if (ehPar(num) == true & ehPositivo(num) == true)
            {
                contPares++;
                contPositivos++;
            }
            else if (ehPar(num) == true & (ehPositivo(num) == false && num != 0))
            {
                contPares++;
                contNegativos++;
            }
            else if (ehPar(num) == false & ehPositivo(num) == true)
            {
                contImpares++;
                contPositivos++;
            }
            else if (ehPar(num) == false & (ehPositivo(num) == false && num != 0))
            {
                contImpares++;
                contNegativos++;
            }
            else
            {
                contPares++;
            }
        }

        Console.WriteLine($"{contPares} valor(es) par(es)\n{contImpares} valor(es) impar(es)\n{contPositivos} valor(es) positivo(s)\n{contNegativos} valor(es) negativo(s)");

    }

    public static bool ehPar(int num)
    {
        if (num % 2 == 0)
        {
            return true;
        }
        return false;
    }

    public static bool ehPositivo(int num)
    {
        if (num > 0)
        {
            return true;
        }
        return false;
    }
}