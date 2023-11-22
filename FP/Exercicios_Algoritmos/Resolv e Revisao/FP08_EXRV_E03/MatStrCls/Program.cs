/* Objetivo : Exibir os valores das diagonaias.
 * Autor    : William Silva (https://github.com/unclWill)
 * Data     : 22/11/2023
 * Material : FP08 (Matrizes)
 * Slide    : EXRV (Exercícios de Revisão)
 * Exercício: 03
 */

/* 3) Faça um programa que leia o nome e as notas de 10 alunos e exiba a lista dos aprovados e dos reprovados.
 * Se o primeiro caractere do nome for uma vogal, toda a string deverá ser convertida para maiúscula.
 * Se a primeiro caractere do nome for uma consoante, toda a string deverá ser convertida para minúscula.
 */

using System;
using System.Text;

namespace MatStrCls
{
    internal class Program
    {
        const int qtdAlunos = 2;
        internal static void Main(string[] args)
        {
            Aluno[] alunos = new Aluno[qtdAlunos];

            for (int i = 0; i < alunos.Length; i++)
            {
                Console.Write($"Informe os dados do {i + 1}º aluno: ");
                alunos[i] = LerDadosAlunos();
            }

            ExibirAlunosENotas(alunos);

            Console.Write("\nPressione qualquer tecla para finalizar...");
            Console.ReadKey();
        }

        private static void ExibirAlunosENotas(Aluno[] alunos)
        {
            StringBuilder strConv = new StringBuilder();

            char letraInicial = alunos[0].Nome;

            if (EhVogal(letraInicial) == true)
            {
                for (int i = 0; i < alunos.Length; i++)
                {
                    if (alunos[i].Nome >= 'a' && alunos[i].Nome <= 'z')
                    {
                        strConv.Append(Convert.ToChar(alunos[i].Nome - 'a' + 'A'));
                    }
                    else
                    {
                        strConv.Append(alunos[i].Nome);
                    }
                }
            }
            else
            {
                for (int j = 0; j < alunos.Length; j++)
                {
                    if (alunos[i].Nome >= 'A' && alunos[i].Nome <= 'Z')
                    {
                        strConv.Append(Convert.ToChar(alunos[i].Nome - 'A' + 'a'));
                    }
                    else
                    {
                        strConv.Append(alunos[i].Nome);
                    }
                }
            }

            for (int k = 0; k < alunos.Length; k++)
            {
                System.Console.WriteLine(alunos[i].Nome);
            }

        }

        private static Aluno LerDadosAlunos()
        {
            Console.Write("Digite o nome do aluno: ");
            aluno.Nome = Console.ReadLine();
            Console.Write("Digite a nota do aluno: ");
            auno.Nota = Convert.ToDouble(Console.ReadLine());

            return aluno;
        }

        private static bool EhVogal(string str)
        {
            const string vogais = "aeiouAEIOU";

            for (int i = 0; i < str.Length; i++)
            {
                char caractere = str[i];

                if (vogais[i] == caractere)
                {
                    return true;
                }
            }

            return false;
        }
    }

}
