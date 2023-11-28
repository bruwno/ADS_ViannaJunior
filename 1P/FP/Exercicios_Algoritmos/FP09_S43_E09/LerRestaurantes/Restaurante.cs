/* Objetivo : Ler dados de restaurantes e exibir o endereço do mais bem avaliado.
 * Autor    : William Silva (https://github.com/unclWill)
 * Data     : 22/11/2023
 * Material : FP09 (Classes)
 * Slide    : 43
 * Exercício: 09
 */

/* 9) Faça um programa que armazene informações de restaurantes. 
 * Cada restaurante é identificado pelo nome, endereço, o tipo de comida (brasileira, chinesa, francesa, italiana, japonesa, etc.) e uma nota para a cozinha (entre 0 e 5). 
 * O programa deverá ler todas as informações e imprimir ao final a lista de todos os restaurantes, e o endereço do restaurante com maior nota para a cozinha.
 */

using System;

namespace LerRestaurantes
{
    public class Restaurante
    {
        private string nome;
        private Endereco endereco;
        private string tipoComida;
        private double nota;

        public string Nome
        {
            get { return nome; }
            set { nome = value; }
        }

        public Endereco Endereco
        {
            get { return endereco; }
            set { endereco = value; }
        }

        public string TipoComida
        {
            get { return tipoComida; }
            set { tipoComida = value; }
        }

        public double Nota
        {
            get { return nota; }
            set { nota = value; }
        }
    }
}