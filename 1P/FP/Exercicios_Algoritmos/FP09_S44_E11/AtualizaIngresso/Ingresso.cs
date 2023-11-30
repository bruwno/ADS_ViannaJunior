/* Objetivo : Ler e atualizar valores de ingressos.
 * Autor    : William Silva (https://github.com/unclWill)
 * Data     : 30/11/2023
 * Material : FP09 (Classes)
 * Slide    : 44
 * Exercício: 11
 */

/* 11) Utilizando a classe definida no exercício anterior.
 * Faça um procedimento que recebe um parâmetro do tipo ingresso e outro contendo um novo preço que atualiza o preço do ingresso para o novo valor. 
 * E um procedimento que recebe um parâmetro do tipo ingresso e mostra na tela os valores de seus campos.
 */

using System;

namespace AtualizaIngresso
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