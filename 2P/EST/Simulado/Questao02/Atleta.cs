using System;

namespace Questao02
{
    public class Atleta(string nome, int idade, double peso)
    {
        private string nome = nome;
        private int idade = idade;
        private double peso = peso;

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