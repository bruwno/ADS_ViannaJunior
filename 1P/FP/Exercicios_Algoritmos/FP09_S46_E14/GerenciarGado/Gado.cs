/* Objetivo : Gerenciar dados sobre as cabeças de gado de uma fazenda.
 * Autor    : William Silva (https://github.com/unclWill)
 * Data     : 11/12/2023
 * Material : FP09 (Classes)
 * Slide    : 46
 * Exercício: 14
 */

/* 14) Elabore um programa que auxilie no controle de uma fazenda de gado que possua um total de 100 cabeças de gado.
 * O programa deverá conter uma classe que comporte:
 * - código: código da cabeça de gado;
 * - leite: número de litros de leite produzido por semana;
 * - alimento: quantidade de alimento ingerida por semana (kg);
 * - mês de nascimento;
 * - ano de nascimento;
 * - abate: ‘N”(não) ou ‘S’ (sim).
 */

using System;

namespace GerenciarGado
{
    internal class Gado
    {
        private int codigo;
        private double leite;
        private double alimento;
        private int mesNascimento;
        private int anoNascimento;
        private bool abate;

        public int Codigo
        {
            get { return codigo; }
            set { codigo = value; }
        }

        public double Leite
        {
            get { return leite; }
            set { leite = value; }
        }

        public double Alimento
        {
            get { return alimento; }
            set { alimento = value; }
        }

        public int MesNascimento
        {
            get { return mesNascimento; }
            set { mesNascimento = value; }
        }

        public int AnoNascimento
        {
            get { return anoNascimento; }
            set { anoNascimento = value; }
        }

        public bool Abate
        {
            get { return abate; }
            set { abate = value; }
        }
    }
}