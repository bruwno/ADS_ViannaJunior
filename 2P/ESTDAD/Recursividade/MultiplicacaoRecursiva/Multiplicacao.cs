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