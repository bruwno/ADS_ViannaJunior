using System;

namespace EXC_ORD_05
{
    public class Livro
    {
        private int codigo;
        private string nome;
        private string autor;
        private int anoDeLancamento;
        private double preco;

        public Livro(int codigo, string nome, string autor, int anoDeLancamento, double preco)
        {
            this.codigo = codigo;
            this.nome = nome;
            this.autor = autor;
            this.anoDeLancamento = anoDeLancamento;
            this.preco = preco;
        }

        public int Codigo
        {
            get { return codigo; }
            set { codigo = value; }
        }

        public string Nome
        {
            get { return nome; }
            set { nome = value; }
        }

        public string Autor
        {
            get { return autor; }
            set { autor = value; }
        }

        public int AnoDeLancamento
        {
            get { return anoDeLancamento; }
            set { anoDeLancamento = value; }
        }

        public double Preco
        {
            get { return preco; }
            set { preco = value; }
        }
    }
}