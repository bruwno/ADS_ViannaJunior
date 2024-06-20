using System;

namespace EXC_Arvores
{
    public class No<T>
    {
        private T valor;
        private No<T> esquerda = null;
        private No<T> direita = null;

        public T Valor { get => valor; set => valor = value; }
        public No<T> Esquerda { get => esquerda; set => esquerda = value; }
        public No<T> Direita { get => direita; set => direita = value; }

        public No(T valor)
        {
            this.valor = valor;
        }
    }
}