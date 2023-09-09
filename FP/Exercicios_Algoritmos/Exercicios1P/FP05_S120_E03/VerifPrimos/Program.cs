/* Objetivo : Imprimir os números pares entre 1 e 100.
 * Autor    : William Silva (https://github.com/unclWill)
 * Data     : 01/09/2023
 * Material : FP05
 * Slide    : 120
 * Exercício: 03
 *******************************************************************************************************
 * OBS.     : Esta versão permite testar vários números em uma única entrada de dados, utilizando array.
 *            Propositalmente o algoritmo utilizado para testar os números não é o mais performático.
 *            A classe NumerosPrimos contém o algoritmo que realiza os testes com os valores.
 *******************************************************************************************************
 */

/* 3. Ler um número inteiro e positivo e verificar se este é ou não um número primo.
 */

using System;
using System.Text;
using VerifPrimos.Utils;

namespace VerifPrimos
{
    public class Program
    {
        public static void Main()
        {
            Console.Title = "Verificar Números Primos";
            Menu.ExibirMenu();
            Console.Write("\nPressione qualquer tecla para finalizar...");
            Console.ReadKey();
        }
    }
}