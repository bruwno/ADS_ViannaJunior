/* Objetivo : Listar nomes da menor para a maior idade.
 * Autor    : William Silva (https://github.com/unclWill)
 * Data     : 07/11/2023
 * Material : FP09 (Classes)
 * Slide    : 44
 * Exercício: 10
 */

/* 10) Faça um programa que leia os dados de 10 ingressos. 
 * As informações que deverão ser lidas de cada ingresso são: preço, local e atração. 
 * Ao final, informe os eventos de ingresso mais barato e mais caros.
 */

using System;

namespace LerIngressos
{
    public class Ingresso
    {
        private double preco;
        private string local;
        private string atracao;

        public double Preco
        {
            get { return preco; }
            set { preco = value; }
        }

        public string Local
        {
            get { return local; }
            set { local = value; }
        }

        public string Atracao
        {
            get { return atracao; }
            set { atracao = value; }
        }
    }
}