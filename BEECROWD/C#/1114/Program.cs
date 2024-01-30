/* Objetivo: Testar um valor de entrada.
 * Autor   : William Silva (https://github.com/unclWill)
 * Data    : 30/01/2024
 * Tipo    : 1 (INICIANTE)
 * ID      : 1114
 * Nome    : Senha Fixa
 * Link    : https://www.beecrowd.com.br/judge/pt/problems/view/1114
 */

using System;

class URI
{
    public static void Main(string[] args)
    {
        int senha;

        do
        {
            senha = int.Parse(Console.ReadLine());

            if (senha != 2002)
            {
                Console.WriteLine("Senha Invalida");
            }
            else
            {
                Console.WriteLine("Acesso Permitido");
                break;
            }
        }
        while (true);
    }
}