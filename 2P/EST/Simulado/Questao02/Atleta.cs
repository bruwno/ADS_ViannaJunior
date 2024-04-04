using System;

namespace Questao02
{
    public class Atleta
    {
        private string nome;
        private int idade;
        private double peso;

        public Atleta(string nome, int idade, double peso)
        {
            this.nome = nome;
            this.idade = idade;
            this.peso = peso;
        }
    }
}