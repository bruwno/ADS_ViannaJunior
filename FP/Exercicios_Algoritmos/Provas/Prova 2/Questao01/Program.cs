using System;

namespace Questao01
{
    internal class Program
    {
        internal static void Main(string[] args)
        {
            string str = "Teste 123 .:;!?";
            char retorno = RetornarPontuacao(str);

            Console.WriteLine(retorno);
        }

        internal static char RetornarPontuacao(string str)
        {
            for (int i = 0; i < str.Length; i++)
            {
                char caract = str[i];
                if (EhPontuacao(caract) == true)
                {
                    return caract;
                }
            }
            return '\n';
        }

        internal static bool EhPontuacao(char caractere)
        {
            const string pontuacoes = ".,:;!?";

            for (int i = 0; i < pontuacoes.Length; i++)
            {
                if (pontuacoes[i] == caractere)
                {
                    return true;
                }
            }
            return false;
        }
    }
}