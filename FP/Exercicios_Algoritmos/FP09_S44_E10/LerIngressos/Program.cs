/* Objetivo : Listar nomes da menor para a maior idade.
 * Autor    : William Silva (https://github.com/unclWill)
 * Data     : 07/11/2023
 * Material : FP09 (Classes)
 * Slide    : 44
 * Exercício: 10
 */

/* 10) Faça um programa que leia os dados de 10 ingressos. 
 * As informações que deverão ser lidas de cada ingresso são: preço, local e atração. 
 * Ao final, informe os eventos de ingresso mais barato e mais caros.
 */

using System;

namespace LerIngressos
{
    internal class Program
    {
        internal static void Main(string[] args)
        {
            Ingresso[] ingressos = new Ingresso[4];

            for (int i = 0; i < ingressos.Length; i++)
            {
                Console.WriteLine($"\nDigite os dados do {i + 1}º ingresso");
                ingressos[i] = LerDadosDeIngressos();
            }

            VerificarEventosMaisBaratos(ingressos);
        }

        private static Ingresso LerDadosDeIngressos()
        {
            Ingresso ingresso = new Ingresso();

            Console.Write("Atração: ");
            ingresso.Atracao = Console.ReadLine();
            Console.Write("Local  : ");
            ingresso.Local = Console.ReadLine();
            Console.Write("Preço  : ");
            ingresso.Preco = Convert.ToDouble(Console.ReadLine());

            return ingresso;
        }

        private static void VerificarEventosMaisBaratos(Ingresso[] ingressos)
        {
            Ingresso maisBarato = ingressos[0];
            Ingresso maisCaro = ingressos[0];

            for (int i = 0; i < ingressos.Length; i++)
            {
                if (ingressos[i].Preco < maisBarato.Preco)
                {
                    maisBarato = ingressos[i];
                }
                else if (ingressos[i].Preco > maisCaro.Preco)
                {
                    maisCaro = ingressos[i];
                }
            }

            Console.WriteLine("\nEvento mais barato");
            Console.WriteLine($"ATRAÇÃO: {maisBarato.Atracao}\nLOCAL {maisBarato.Local}\nPREÇO: {maisBarato.Preco:C}");

            Console.WriteLine("\nEvento mais caro");
            Console.WriteLine($"ATRAÇÃO: {maisCaro.Atracao}\nLOCAL: {maisCaro.Local}\nPREÇO: {maisCaro.Preco:C}");
        }
    }
}
