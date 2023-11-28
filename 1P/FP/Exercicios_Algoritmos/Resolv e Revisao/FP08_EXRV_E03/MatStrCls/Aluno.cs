/* Objetivo : Exibir os valores das diagonaias.
 * Autor    : William Silva (https://github.com/unclWill)
 * Data     : 22/11/2023
 * Material : FP08 (Matrizes)
 * Slide    : EXRV (Exercícios de Revisão)
 * Exercício: 03
 */

/* 3) Faça um programa que leia o nome e as notas de 10 alunos e exiba a lista dos aprovados e dos reprovados.
 * Se o primeiro caractere do nome for uma vogal, toda a string deverá ser convertida para maiúscula.
 * Se a primeiro caraceter do nome for uma consoante, toda a string deverá ser convertida para minúscula.
 */

using System;

namespace MatStrCls
{
    public class Aluno
    {
        private string nome;
        private double nota;

        public string Nome
        {
            get { return nome; }
            set
            {
                if (value.Length > 10)
                {
                    Console.WriteLine("Nome muito comprido!");
                }
                else
                {
                    nome = value;
                }
            }
        }

        public double Nota
        {
            get { return nota; }
            set { nota = value; }
        }
    }

}