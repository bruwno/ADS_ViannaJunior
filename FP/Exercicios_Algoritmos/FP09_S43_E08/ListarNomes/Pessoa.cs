/* Objetivo : Listar nomes da menor para a maior idade.
 * Autor    : William Silva (https://github.com/unclWill)
 * Data     : 07/11/2023
 * Material : FP09 (Classes)
 * Slide    : 43
 * Exercício: 08
 */

/* 8) Faça um programa que receba três nomes de no máximo 100 caracteres cada e as idades das respectivas pessoas em um vetor de objetos. 
 * Após o recebimento, listar os três nomes armazenados neste vetor por ordem crescente de idades.
 */

using System;

namespace ListarNomes
{
    public class Pessoa
    {
        private string nome;
        private double[] idade;

        public string Nome
        {
            get { return nome; }
            set
            {
                if (nome.Length > 100) 
                {
                    
                }
                nome = value;
            }
        }

        public double Idade
        {
            get { return idade; }
            set { idade = value; }
        }
    }
}