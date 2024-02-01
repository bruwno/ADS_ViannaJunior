/* Autor: William Silva (https://github.com/unclWill) | Retirado de: https://www.youtube.com/watch?v=78OjRDFO2n4
 * Data : 01/02/2024
 */

namespace MultiplicacaoRecursiva
{
    public class Multiplicacao
    {
        public int Multiplicar(int m, int n)
        {
            if (n == 0)
            {
                return 0;
            }
            else
            {
                return m + Multiplicar(m, n - 1);
            }
        }
    }
}