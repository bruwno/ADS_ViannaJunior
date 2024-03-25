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