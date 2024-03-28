/* Autor: William Silva (https://github.com/unclWill)
 * Data : 25/03/2024
 *
 * Questão 3)
 * Faça um procedimento que receba o montante reservado para a aposentadoria de uma
 * pessoa e a quantia que ela pretende retirar por mês. O montante reservado é corrigido a
 * cada mês com a taxa de 0,55%, aplicada logo após a retirada. O procedimento deve
 * imprimir o montante (após a retirada e a correção), mês a mês. O procedimento também
 * deve imprimir o número de meses em que a pessoa conseguirá fazer a sua retirada.
 * Restrição: não utilize comandos de repetição.
 */

using System;

namespace Questao3
{
    public class Program
    {
        public static void Main(string[] args)
        {
            double montante = 100000.0;
            double quantiaParaRetirada = 2000.0;

            ImprimirQuantiaMensal(montante, quantiaParaRetirada);
        }

        public static void ImprimirQuantiaMensal(double montante, double quantiaParaRetirada, int qtdMeses = 0)
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
                ImprimirQuantiaMensal(montanteCorrigido, quantiaParaRetirada, qtdMeses + 1);
            }
        }
    }
}