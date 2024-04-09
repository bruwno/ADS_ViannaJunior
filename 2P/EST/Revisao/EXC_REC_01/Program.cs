/* Autor: William Silva (https://github.com/unclWill)
 * Data : 09/04/2024
 * 
 * O máximo divisor comum dos inteiros x e y é o maior inteiro que é divisível por x e
 * y. Escreva uma função recursiva MDC em C#, que retorna o máximo divisor comum de x e y. 
 * O mdc de x e y é definido como segue: se y é igual a 0, então mdc(x,y) é x; caso
 * contrário, mdc(x,y) é mdc (y, x%y), onde % é o operador resto.
 */

namespace EXC_REC_01
{
    public class Program
    {
        public static void Main(string[] args)
        {
            double n1 = 81;
            double n2 = 24;
            Console.WriteLine($"Máximo divisor comum de {n1} e {n2} = {MDC(n1, n2)}");
        }

        public static double MDC(double x, double y)
        {
            if (y == 0)
            {
                return x;
            }
            else
            {
                return MDC(y, x % y);
            }
        }
    }
}
