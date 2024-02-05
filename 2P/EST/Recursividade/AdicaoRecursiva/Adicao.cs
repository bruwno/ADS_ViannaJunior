using System;

namespace AdicaoRecursiva
{
    public class Adicao
    {
        public int Somar(int n)
        {
            // Caso base.
            if (n == 0)
            {
                return 0;
            }
            // Chamada recursiva.
            return n + Somar(n - 1);
        }
    }
}