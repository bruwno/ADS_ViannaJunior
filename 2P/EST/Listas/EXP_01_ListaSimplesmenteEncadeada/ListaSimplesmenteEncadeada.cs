using System;

namespace EXP01_ListaSimplesmenteEncadeada
{
    internal class ListaEncadeada
    {
        private No primeiro = null;
        public No Primeiro
        {
            get
            {
                return primeiro;
            }
        }

        public void AdicionarNoInicio(int valor)
        {
            No novoNo = new No();
            novoNo.Valor = valor;

            if (primeiro == null)
            {
                primeiro = novoNo;
            }
            else
            {
                novoNo.Proximo = primeiro;
                primeiro = novoNo;
            }
        }

        public void AdicionarNoFinal(int valor)
        {
            No novoNo = new No();
            novoNo.Valor = valor;

            if (primeiro == null)
            {
                primeiro = novoNo;
            }
            else
            {
                No aux = primeiro;
                while (aux.Proximo != null)
                {
                    aux = aux.Proximo; // Irá apontar para o último elemento da lista.
                }
                aux.Proximo = novoNo;
            }
        }

        public void RemoverNoInicio()
        {
            if (primeiro == null)
            {
                throw new Exception("Lista vazia!");
            }
            primeiro = primeiro.Proximo;
        }

        public void RemoverNoFinal()
        {
            if (primeiro == null)
            {
                throw new Exception("Lista vazia!");
            }
            if (primeiro.Proximo == null)
            {
                primeiro = null;
            }
            else
            {
                No aux = primeiro;
                while (aux.Proximo.Proximo != null)
                {
                    aux = aux.Proximo;
                }
                aux.Proximo = null;
            }
        }
    }
}