using System;

namespace DivisaoRecursiva
{
    public class Divisao
    {
        public double Dividir(double d, double div)
        {
            if (div == 0)
            {
                throw new ArgumentException("[Operação ilegal] Tentativa de divisão por zero.");
            }

            // Caso base.
            if (d < div)
            {
                return 0;
            }
            // Caso recursivo.
            else
            {
                return 1 + Dividir(d - div, div);
            }
        }
    }
}