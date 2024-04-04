/*
Questão 2) Faça três procedimentos. Cada procedimento deve receber um vetor de atletas e reorganizar o mesmo em ordem decrescente do peso do atleta. O primeiro procedimento deve utilizar o método bolha, o segundo o método da inserção e o terceiro o método da seleção.
*/

using System;
using System.ComponentModel.DataAnnotations;

namespace Questao02
{
    public class Program
    {
        public static void Main(string[] args)
        {
            Atleta[] atletas = new Atleta[]
            {
                new Atleta("João", 20, 65),
                new Atleta("Marcos", 30, 65.3),
                new Atleta("Saulo", 28, 80.1),
                new Atleta("Jacob", 22, 75.0),
                new Atleta("Tomé", 27, 72.8)
            };

            BubbleSort(atletas, 0);
        }

        public static void BubbleSort(Atleta[] vet, int i)
        {

        }
    }
}