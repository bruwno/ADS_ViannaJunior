using System;

namespace ExponenciacaoRecursiva
{
    public class Exponenciacao
    {
        public int Exponencial(int b, int e)
        {
            // Caso base.
            if (e == 0)
            {
                return 1;
            }
            // Caso recursivo.
            else
            {
                return b * Exponencial(b, e - 1);
            }
        }
    }
}