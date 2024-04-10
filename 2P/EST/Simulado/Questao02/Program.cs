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

            EscolherMetodoDeOrdenacao(atletas, 2);
        }

        public static void BubbleSort(Atleta[] vet)
        {
            // Loop externo que percorre o vetor do final ao início.
            for (int i = vet.Length - 1; i >= 0; i--)
            {
                // Loop interno que percorre o vetor até o índice i.
                for (int j = 0; j < i; j++)
                {
                    // Compara o peso do atleta atual com o peso do próximo atleta.
                    if (vet[j].Peso < vet[j + 1].Peso)
                    {
                        // Se o peso do atleta atual for menor que o próximo, realiza a troca.
                        Troca(vet, j, j + 1);
                    }
                }
            }
        }

        public static void InsertionSort(Atleta[] vet)
        {
            // Loop externo que percorre o vetor a partir do segundo elemento até o final
            for (int i = 1; i < vet.Length; i++)
            {
                // Armazena o peso do atleta atual em uma variável chave
                Atleta chave = vet[i];
                int j;

                // Loop interno que percorre o vetor da posição anterior à atual até o início
                // e verifica se o peso da chave é maior que o peso do atleta atual
                for (j = i - 1; j >= 0 && chave.Peso > vet[j].Peso; j--)
                {
                    // Se o peso da chave for maior que o peso do atleta na posição j,
                    // realiza a troca dos elementos
                    //Troca(vet, j, j + 1); // Também pode ser usado.
                    vet[j + 1] = vet[j];
                }

                // Após encontrar a posição correta para a chave, atribui o valor da chave 
                // ao peso do atleta na posição j + 1
                vet[j + 1] = chave;
            }
        }


        public static void SelectionSort(Atleta[] vet)
        {
            // Loop externo que percorre todo o vetor, exceto o último elemento.
            for (int i = 0; i < vet.Length - 1; i++)
            {
                // Inicializa o índice do menor elemento como o índice atual.
                int indiceMenor = i;

                // Loop interno que percorre o restante do vetor a partir do próximo elemento.
                for (int j = i + 1; j < vet.Length; j++)
                {
                    // Verifica se o peso do atleta atual é menor que o peso do atleta no menor índice.
                    if (vet[j].Peso < vet[indiceMenor].Peso)
                    {
                        // Se sim, atualiza o menor índice para o índice atual.
                        indiceMenor = j;
                    }
                }

                // Após percorrer todo o vetor interno, verifica se o menor índice mudou.
                if (i != indiceMenor)
                {
                    // Se sim, realiza a troca de posição entre os elementos nos índices i e indiceMenor.
                    Troca(vet, i, indiceMenor);
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

        private static void EscolherMetodoDeOrdenacao(Atleta[] atletas, int metodo = 0)
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
            }

            ImprimeArrayOrdenado(atletas);
        }
    }
}