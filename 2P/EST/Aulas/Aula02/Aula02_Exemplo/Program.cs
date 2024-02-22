/* O entendimento de recursão está em entender a pilha de execução.
 *
 */

namespace Aula02_Exemplo
{
    public class Program
    {
        public static void Main(string[] args)
        {
            Imprime(3);
        }

        public static void Imprime(int num)
        {
            if (num < 1)
            {
                return;
            }
            else 
            {
                Imprime(num - 1); // Imprime de forma crescente. -> Empilha 3, 2 ,1 --> Imprime 1, 2, 3
                Console.WriteLine(num);
                Imprime(num - 1); // Imprime de forma decrescente. -> Empilha 1, 2, 3 --> Imprime 3, 2, 1
            }
        }
    }
}