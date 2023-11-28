/* Objetivo : Representar uma pessoa que possui salário e idade.
 * Autor    : William Silva (https://github.com/unclWill)
 * Data     : 01/11/2023
 * Material : FP09 (Classes)
 * Slide    : 20
 * Exercício: 03
 */

/* 5) Imagine que tenha sido realizada uma pesquisa com 6 pessoas a respeito de salário e idade. 
 * Crie uma classe Pessoa e faça um programa que leia os dados coletados e forneça a média salarial e a média de idades dos entrevistados.
 */

using System;

namespace LerDados
{
    public class Pessoa
    {
        private double salario;
        private double idade;

        public double Salario
        {
            get { return salario; }
            set { salario = value; }
        }

        public double Idade
        {
            get { return salario; }

            set
            {
                if (idade > 0)
                {
                    idade = value;
                }
            }
        }
    }
}