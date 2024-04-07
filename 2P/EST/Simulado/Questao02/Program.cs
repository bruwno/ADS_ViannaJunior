/*
Questão 2) Faça três procedimentos. Cada procedimento deve receber um vetor de atletas e reorganizar o mesmo em ordem decrescente do peso do atleta. O primeiro procedimento deve utilizar o método bolha, o segundo o método da inserção e o terceiro o método da seleção.
*/

using System;

namespace Questao02
{
    public class Program
    {
        public static void Main(string[] args)
        {
            Atleta[] atletas = new Atleta[]
            {
                new Atleta("João", 20, 65.0),
                new Atleta("Marcos", 30, 65.3),
                new Atleta("Saulo", 28, 80.1),
                new Atleta("Jacob", 22, 75.0),
                new Atleta("Tomé", 27, 72.8)
            };

            EscolherMetodoDeOrdenacao(atletas, 0);
        }

        public static void BubbleSort(Atleta[] vet)
        {
            for (int i = vet.Length - 1; i >= 0; i--)
            {
                for (int j = 0; j < i; j++)
                {
                    if (vet[j].Peso < vet[j + 1].Peso)
                    {
                        Troca(vet, j, j + 1);
                    }
                }
            }
        }

        public static void InsertionSort(Atleta[] vet)
        {
            for (int i = 1; i < vet.Length; i++)
            {
                // Valor a ser inserido na parte ordenada
                double chave = vet[i].Peso;
                int j;
                // Percorre a parte ordenada e encontra a posição correta para inserir a chave
                for (j = i - 1; j >= 0 && chave < vet[j].Peso; j--)
                {
                    // Desloca os elementos maiores para a direita
                    // PADRÃO -> vet[j + 1].Peso = vet[j].Peso;
                    Troca(vet, j, j + 1);
                }
                // Insere a chave na posição correta
                vet[j + 1].Peso = chave;
            }
        }

        public static void SelectionSort(Atleta[] vet)
        {
            for (int i = 0; i < vet.Length - 1; i++)
            {
                int menorIndice = i;
                for (int j = i + 1; j < vet.Length; j++)
                {
                    if (vet[j].Peso < vet[menorIndice].Peso)
                    {
                        menorIndice = j;
                    }
                    if (i != menorIndice)
                    {
                        Troca(vet, i, menorIndice);
                    }
                }
            }
        }

        // Função auxiliar.
        private static void Troca(Atleta[] vet, int i, int j)
        {
            Atleta aux = vet[i];
            vet[i] = vet[j];
            vet[j] = aux;
        }

        private static void ImprimeArrayOrdenado(Atleta[] atletas)
        {
            foreach (Atleta atleta in atletas)
            {
                Console.WriteLine($"NOME DO ATLETA: {atleta.Nome} \t| IDADE: {atleta.Idade} \t| PESO: {atleta.Peso}kg");
            }
        }

        private static void EscolherMetodoDeOrdenacao(Atleta[] atletas, int metodo)
        {
            int m = metodo;

            if (m == 0)
            {
                Random random = new Random();
                m = random.Next(1, 4);
            }

            switch (m)
            {
                case 1:
                    Console.WriteLine("Ordenado pelo método [BubbleSort]");
                    BubbleSort(atletas);
                    break;
                case 2:
                    Console.WriteLine("Ordenado pelo método [InsertionSort]");
                    InsertionSort(atletas);
                    break;
                case 3:
                    Console.WriteLine("Ordenado pelo método [SelectionSort]");
                    SelectionSort(atletas);
                    break;
                default:
                    Console.WriteLine("Ordenado pelo método [BubbleSort <default>]");
                    BubbleSort(atletas);
                    break;
            }

            ImprimeArrayOrdenado(atletas);
        }
    }
}