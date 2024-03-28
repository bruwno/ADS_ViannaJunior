using System;

namespace SubtracaoRecursiva
{
    public class Subtracao
    {
        public int Subtrair(int m, int s)
        {
            // Caso base.
            if (s == 0)
            {
                return m;
            }
            // Caso recursivo.
            else
            {
                return Subtrair(m - 1, s - 1);
            }
        }
    }
}