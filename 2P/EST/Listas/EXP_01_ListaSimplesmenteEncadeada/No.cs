using System;

namespace EXP01_ListaSimplesmenteEncadeada
{
    internal class No
    {

        private No proximo = null;

        public int Valor { get; set; }

        public No Proximo
        {
            get 
            {
                return proximo;
            }
            set
            {
                proximo = value;
            }
        }
    }
}