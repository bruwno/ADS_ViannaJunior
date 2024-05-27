using System;

namespace ListasContiguas
{
    class ListaContigua2
    {
        private int indiceIni;
        private int indiceFim;
        private double[] valores;

        public int Tamanho { get => indiceFim - indiceIni + 1; }

        public ListaContigua2() : this(100)
        {
        }

        public ListaContigua2(int tamanho)
        {
            indiceIni = tamanho / 2;
            indiceFim = indiceIni - 1;
            valores = new double[tamanho];
        }

        public void AdicionarNoInicio(double valor)
        {
            if (indiceIni == 0)
                throw new Exception("Não é possível adicionar mais elementos ao início.");

            valores[--indiceIni] = valor;
        }

        public void AdicionarNoFinal(double valor)
        {
            if (indiceFim == valores.Length - 1)
                throw new Exception("Não é possível adicionar mais elementos no final.");

            valores[++indiceFim] = valor;
        }

        public void RemoverNoInicio()
        {
            if (Tamanho == 0)
                throw new Exception("Não existe elemento a ser removido.");

            indiceIni++;
        }

        public void RemoverNoFinal()
        {
            if (Tamanho == 0)
                throw new Exception("Não existe elemento a ser removido.");

            indiceFim--;
        }

        public double Get(int indice)
        {
            if (indice < 0 || indice >= Tamanho)
                throw new Exception("Índice inválido!");

            return valores[indiceIni + indice];
        }
    }
}