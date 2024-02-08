using System;

namespace Aula01
{
    public class Program
    {
        public static void Main(string[] args)
        {
            var nome = "William";
            var idade = 26;
            string texto = string.Format("Nome: {0}, idade: {1}", nome, idade);
            Console.WriteLine(texto);

            var txt = "@bcde";
            var txtCorrigido = texto.Replace('@', 'a');
            Console.WriteLine(txtCorrigido);

            // Passando um array para o método Formatar.
            string[] valores = new string[] { "William", "26" };
            Console.WriteLine(Formatar(texto, valores));
        }

        public static string Formatar(string texto, params string[] valores)
        {
            for (int i = 0; i < valores.Length; i++)
            {
                texto = texto.Replace("{" + i + "}", valores[i]);
            }
            return texto;
        }
    }
}