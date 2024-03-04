using System;

namespace ConversorBinario
{
    public class Conversor
    {
        public void Converter(int n)
        {
            if (n == 0)
            {
                return;
            }
            Converter(n / 2);
            Console.Write(n % 2);
        }
    }
}