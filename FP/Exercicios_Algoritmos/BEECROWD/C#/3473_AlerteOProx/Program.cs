/* Objetivo : Ler um número, que representa uma senha, e exibir o número que vem depois dele.
 * Autor    : William Silva (https://github.com/unclWill)
 * Data     : 27/09/2023
 * Tipo     : 2 (AD-HOC)
 * ID       : 3473
 * Nome     : Alerte o Próximo!
 * Link     : https://www.beecrowd.com.br/judge/pt/problems/view/3473
 */

using System;

class URI
{
    static void Main()
    {
        string senha;

        while (!string.IsNullOrEmpty(senha = Console.ReadLine()))
        {
            int proxSenha = int.Parse(senha);
            proxSenha++;
            Console.WriteLine(proxSenha);
        }
    }
}