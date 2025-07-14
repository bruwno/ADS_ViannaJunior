/* Objetivo : Representar um cartão de crédito através de uma classe.
 * Autor    : William Silva (https://github.com/unclWill)
 * Data     : 31/10/2023
 * Material : FP09 (Classes)
 * Slide    : 20
 * Exercício: 01
 */

/* 1) Defina uma classe para representar as informações de um cartão de crédito. 
 * No método principal (Main) da classe Program, instancie dois objetos do tipo da classe criada, 
 * atribua valores a cada atributo dos objetos e imprima todos os atributos do segundo objeto instanciado.
 */

 using System;

 namespace CartaoCred
 {
    internal class Program
    {
        internal static void Main(string[] args)
        {
            CartaoCredito cartao1 = new CartaoCredito();
            cartao1.Titular = "JOHN DOE";
            cartao1.NumeroCartao = 01234567890001;
            cartao1.CodSeg = 123;
            cartao1.DataExpiracao = "12/27";
            cartao1.Bandeira = "Visa";

            CartaoCredito cartao2 = new CartaoCredito();
            cartao2.Titular = "GABE NEWELL";
            cartao2.NumeroCartao = 10025698741365;
            cartao2.CodSeg = 321;
            cartao2.DataExpiracao = "05/25";
            cartao2.Bandeira = "MasterCard";

            cartao2.ExibirDadosCartao();

            Console.Write("\nPressione qualquer tecla para finalizar...");
            Console.ReadKey();
        }
    }
 }