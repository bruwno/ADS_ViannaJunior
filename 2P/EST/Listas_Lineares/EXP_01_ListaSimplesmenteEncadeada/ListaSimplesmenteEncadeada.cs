using System;
using System.Collections.Generic;
using System.Linq;
using System.Threading.Tasks;

namespace EXP_01_ListaSimplesmenteEncadeada
{
    public class ListaSimplesmenteEncadeada
    {
        public No Primeiro { get => Primeiro; set => primeiro = value; }

        public void AdicionarNoInicio(int valor)
        {
            var novoNo = new No { Valor = valor };

            if (primeiro == null)
            {
                Primeiro = novoNo;
            }
            else
            {
                novoNo.Proximo = primeiro;
                primeiro = novoNo;
            }
        }

        public void AdicionarNoFinal(int valor)
        {
            var novoNo = new No { Valor = valor };

            if (primeiro == null)
            {
                primeiro = novoNo;
            }
            else
            {
                var atual = primeiro;

                while (atual.Proximo != null)
                {
                    atual = atual.Proximo;
                }
                atual.Proximo = novoNo;
            }
        }

        public void RemoverNoInicio()
        {
            if (primeiro != null) primeiro = primeiro.Proximo;
        }

        public void RemoverNoFinal()
        {
            if (primeiro != null)
            {
                if (primeiro.Proximo == null)
                {
                    primeiro = null;
                }
                else
                {
                    var atual = Primeiro;

                    while (atual.Proximo.Proximo != null)
                    {
                        atual = atual.Proximo;
                    }
                    atual.Proximo = null;
                }
            }
        }

        public No Localizar(int valor)
        {
            for (var no = primeiro; no != null; no = no.Proximo)
            {
                if (no.Valor == valor)
                {
                    return no;
                }
            }
            return null;
        }

        private No primeiro = null;
    }
}