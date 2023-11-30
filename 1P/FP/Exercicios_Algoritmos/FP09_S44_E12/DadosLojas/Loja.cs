/* Objetivo : Ler dados de lojas e exibir a média dos preços praticados.
 * Autor    : William Silva (https://github.com/unclWill)
 * Data     : 30/11/2023
 * Material : FP09 (Classes)
 * Slide    : 44
 * Exercício: 12
 */

/* 12) Faça um programa que avalie o preço de um eletrodoméstico em diferentes lojas. 
 * Faça a leitura das informações das lojas, que contenham os seguintes campos: nome da loja, telefone e preço do eletrodoméstico. 
 * Ao final, informe os dados de todas as lojas. Informe também a média dos preços cadastrados e uma relação contendo o nome e o telefone das lojas cujo preço estava abaixo da média. 
 * Utilize funções para realizar operações de leitura e escrita e faça um menu que possibilite ler todas as informações das lojas, ler uma loja com um endereço específico, 
 * caso ela esteja cadastrada, e imprimir as informações citadas anteriormente
 */

using System;

namespace DadosLojas
{
    public class Loja
    {
        private string nome;
        private long telefone;
        private double preco;

        public string Nome
        {
            get { return nome; }
            set { nome = value; }
        }

        public long Telefone
        {
            get { return telefone; }
            set { telefone = value; }
        }

        public double Preco
        {
            get { return preco; }
            set { preco = value; }
        }
    }
}