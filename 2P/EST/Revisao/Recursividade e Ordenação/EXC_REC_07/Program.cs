/* Data: 10/04/2024
 *
 * Faça um procedimento que receba o montante reservado para a aposentadoria de uma
 * pessoa e a quantia que ela pretende retirar por mês. O montante reservado é corrigido a
 * cada mês com a taxa de 0,55%, aplicada logo após a retirada. O procedimento deve
 * imprimir o montante (após a retirada e a correção), mês a mês. O procedimento também
 * deve imprimir o número de meses em que a pessoa conseguirá fazer a sua retirada.
 */

namespace EXC_REC_07;

class Program
{
    public static void Main(string[] args)
    {
        double montante = 200000.0;
        double quantiaParaRetirada = 5000.0;

        CalcularQuantiaMensal(montante, quantiaParaRetirada);
    }

    public static void CalcularQuantiaMensal(double montante, double quantiaParaRetirada, int qtdMeses = 0)
    {
        if (montante <= quantiaParaRetirada)
        {
            Console.WriteLine($"A retirada do valor mensal de {quantiaParaRetirada:C} poderá ser feita por: {qtdMeses} meses");
            return;
        }
        else
        {
            double montanteCorrigido = (montante - quantiaParaRetirada) * 1.0055;
            if (montanteCorrigido >= quantiaParaRetirada)
            {
                Console.WriteLine($"Quantia do mês: {montanteCorrigido:C}");
            }
            CalcularQuantiaMensal(montanteCorrigido, quantiaParaRetirada, qtdMeses + 1);
        }
    }
}
