namespace EXC_ORD_01
{
    public class Pessoa
    {
        private string nome;
        private int idade;
        private char genero;

        public Pessoa(string nome, int idade, char genero)
        {
            this.nome = nome;
            this.idade = idade;
            this.genero = genero;
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

        public char Genero
        {
            get { return genero; }
            set { genero = value; }
        }

        public override string ToString()
        {
            return $"Nome: {Nome} \t| Idade: {Idade} anos\t| Gênero: {Genero}";
        }
    }
}