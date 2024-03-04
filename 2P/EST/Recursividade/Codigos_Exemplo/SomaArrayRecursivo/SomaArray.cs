using System;

namespace SomaArrayRecursivo
{
    public class SomaArray
    {
        public double Somar(double[] valores, int n)
        {
            // Caso base. --> Quando a dimensão do array for 0.
            if (n == 0)
            {
                return 0;
            }
            return valores[n - 1] + Somar(valores, n - 1);
        }
    }
}