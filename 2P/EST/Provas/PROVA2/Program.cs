/*
Gabarito: A

Questão 1) Crie uma pilha de caracteres (char) para armazenar caracteres digitados em um texto. No Main, leia uma string e, para cada caractere da string lida, faça:
  a) Se o caractere for '*', desempilhe todo o conteúdo da pilha.
  b) Se o caractere for '!', desempilhe o último caractere empilhado.
  c) Caso (a) e (b) não se aplique, empilhe o caractere.
  d) Imprima os caracteres restantes na pilha, na ordem que os mesmos foram digitados.

Exemplo de execução: para a string "Teste*1234!56", deve ser impresso "12356".
 */

namespace PROVA2;

class Program
{
    static void Main(string[] args)
    {
        string texto = Console.ReadLine()!; // string de teste: Teste*1234!56

        Pilha pilha = new Pilha();
        PercorreString(texto, pilha);

        pilha.ParaCadaRecursivo();
    }

    static void PercorreString(string texto, Pilha pilha)
    {
        for (int i = 0; i < texto.Length; i++)
        {
            char caractere = texto[i];
            if (caractere == '*')
            {
                pilha.DesempilharRecursivo();
            }
            else if (caractere == '!')
            {
                pilha.Desempilhar();
            }
            else
            {
                pilha.Empilhar(caractere);
            }
        }
    }
}

