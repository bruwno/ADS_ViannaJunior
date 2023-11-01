/* Objetivo : Representar o peso e altura de uma pessoa.
 * Autor    : William Silva (https://github.com/unclWill)
 * Data     : 31/10/2023
 * Material : FP09 (Classes)
 * Slide    : 20
 * Exercício: 02
 */

/* 2) Defina uma classe para representar o peso e a altura de uma pessoa. 
 * Crie um programa que pergunte ao usuário o seu peso e a sua altura, atribuindo-os aos respectivos atributos de um objeto da classe criada. 
 * Imprima os atributos da classe criada.
 */

 using System;

 namespace ExibirPesoAltura
 {
    public class Pessoa
    {
        private double peso;
        private double altura;

        public double Peso
        {
            get => peso;
            set => peso = value;
        }

        public double Altura
        {
            get => altura;
            set => altura = value;
        }

        public void ExibirPesoEAltura()
        {
            Console.WriteLine($"Peso  : {Peso} kg");
            Console.WriteLine($"Altura: {Altura} m");
        }
    }
 }