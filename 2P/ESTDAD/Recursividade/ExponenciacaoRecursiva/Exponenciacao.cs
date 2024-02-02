using System;

namespace ExponenciacaoRecursiva
{
    public class Exponenciacao
    {
        public int Potencia(int b, int e)
        {
            // Caso base.
            if (e == 0)
            {
                return 1;
            }
            // Caso recursivo.
            else
            {
                return b * Potencia(b, e - 1);
            }
        }
    }
}