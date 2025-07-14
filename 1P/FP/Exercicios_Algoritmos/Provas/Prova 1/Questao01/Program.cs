using System;

namespace Questao01
{
    internal class Program
    {
        internal static void Main(string[] args)
        {
            Console.Write("Informe o valor do boleto: ");
            double valorBoleto = Convert.ToDouble(Console.ReadLine());
            double valorComDesconto = AplicarDesconto(valorBoleto);
            Console.WriteLine($"Valor após acréscimo: {valorComDesconto:C}");
            Console.ReadKey();
        }

        internal static double AplicarDesconto(double valor)
        {
            if ((valor >= 50.0) && (valor <= 1000.0))
            {
                return valor += valor * 5.0 / 100.0;
            }
            else if (valor > 1000.0)
            {
                return valor += valor * 2.0 / 100.0;
            }
            else
            {
                return valor;
            }
        }
    }
}
