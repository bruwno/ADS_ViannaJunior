using System;

namespace Revisao
{
    public class Pessoa
    {
        private string nome = "";
        public string Nome
        {
            get { return nome; }
            set { nome = value; }
        }

        private string email = "";
        public string Email
        {
            get { return email; }
            set { email = value; }
        }

    }
}