using System;

namespace ListasContiguas
{
    public class ListaContigua
    {
        private int tamanho = 0;
        private double[] valores = new double[100];

        public int Tamanho { get => tamanho; }

        public void AdicionarNoFinal(double valor)
        {
            if (tamanho > valores.Length)
            {
                throw new Exception("A lista está cheia.");
            }
            valores[tamanho++] = valor;
        }

        public void RemoverNoFinal()
        {
            if (tamanho == 0)
            {
                throw new Exception("Não é possível remover um elemento de uma lista vazia.");
            }
            tamanho--;
        }


        public double Get(int indice)
        {
            if (indice < 0 || indice >= tamanho)
                throw new Exception("Índice inválido!");

            return valores[indice];
        }
    }
}