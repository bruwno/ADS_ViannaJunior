/* Objetivo: Determinas se um sobrenome í difícil a partir da quantidade de consoantes consecutivas.
 * Autor   : William Silva (https://github.com/unclWill)
 * Data    : 23/12/2023
 * Tipo    : 3 (STRINGS)
 * ID      : 3358
 * Nome    : Sobrenome Não é Fácil
 * Link    : https://www.beecrowd.com.br/judge/pt/problems/view/3358
 */

using System;

class URI
{
    public static void Main(string[] args)
    {
        int qtdSobrenomes = int.Parse(Console.ReadLine());
        string[] sobrenomes = new string[qtdSobrenomes];

        for (int i = 0; i < sobrenomes.Length; i++)
        {
            sobrenomes[i] = Console.ReadLine();
        }

        DeterminarComplexidadeDoSobrenome(sobrenomes);
    }

    public static void DeterminarComplexidadeDoSobrenome(string[] sobrenomes)
    {
        for (int i = 0; i < sobrenomes.Length; i++)
        {
            string sobrenome = sobrenomes[i];
            int qtdConsoantes = 0;

            for (int j = 0; j < sobrenome.Length; j++)
            {
                char caractere = sobrenome[j];
                if (ehConsoante(caractere) == false)
                {
                    qtdConsoantes = 0;
                }
                else
                {
                    qtdConsoantes++;
                    if (qtdConsoantes == 3)
                    {
                        break;
                    }
                }
            }

            if (qtdConsoantes < 3)
            {
                Console.WriteLine($"{sobrenomes[i]} eh facil");
            }
            else
            {
                Console.WriteLine($"{sobrenomes[i]} nao eh facil");
            }
        }
    }

    public static bool ehLetra(char caractere)
    {
        if ((caractere >= 'a' && caractere <= 'z') || (caractere >= 'A' && caractere <= 'Z'))
        {
            return true;
        }
        return false;
    }

    public static bool ehVogal(char caractere)
    {
        const string vogais = "aeiouAEIOU";
        for (int i = 0; i < vogais.Length; i++)
        {
            if (vogais[i] == caractere)
            {
                return true;
            }
        }
        return false;
    }

    public static bool ehConsoante(char caractere)
    {
        if (ehLetra(caractere) == true && ehVogal(caractere) == false)
        {
            return true;
        }
        else
        {
            return false;
        }
    }
}