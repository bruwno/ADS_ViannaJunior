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

        public string Nome
        {
            get { return nome; }
            set { nome = value; }
        }

        public int Idade
        {
            get { return idade; }
            set { idade = value; }
        }

        public double Peso
        {
            get { return peso; }
            set { peso = value; }
        }

    }
}