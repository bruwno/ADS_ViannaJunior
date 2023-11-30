
/* Objetivo : Ler dados de veículos e exibir informações.
 * Autor    : William Silva (https://github.com/unclWill)
 * Data     : 30/11/2023
 * Material : FP09 (Classes)
 * Slide    : 45
 * Exercício: 13
 */

/* 13) Faça um programa que permita o cadastro de veículos. A classe veículo deverá conter os campos placa, marca, modelo e ano.
 * O programa deverá ter as seguintes características:
 * - No primeiro item, peça inicialmente o índice do vetor que deseja alterar.
 * - No terceiro item, peça o ano mínimo e máximo e imprima os veículos que estão nesse intervalo.
 * Faça funções para realizar as operações de cada um dos itens do menu.
 */

using System;

namespace CadastroVeiculos
{
    public class Veiculo
    {
        private string placa;
        private string marca;
        private string modelo;
        private int ano;

        public string Placa
        {
            get { return placa; }
            set { placa = value; }
        }

        public string Marca
        {
            get { return marca; }
            set { marca = value; }
        }

        public string Modelo
        {
            get { return modelo; }
            set { modelo = value; }
        }

        public int Ano
        {
            get { return ano; }
            set { ano = value; }
        }
    }
}
