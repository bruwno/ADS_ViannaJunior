/* Autor: William Silva (https://github.com/unclWill)
 * Data : 09/04/2024
 * 
 * Utilizando o método de ordenação SelectionSort, ordene um vetor de objetos do tipo Pessoa, 
 * onde as idades dessas pessoas deverão ser exibidas da pessoa mais jovem para a mais velha.
 */

namespace EXC_ORD_01;

class Program
{
    static void Main(string[] args)
    {
        Pessoa[] vet = new Pessoa[]
        {
            new Pessoa("José dos Santos", 45, 'M'),
            new Pessoa("Fernanda Monte", 29, 'F'),
            new Pessoa("Maurício Camargo", 12, 'M'),
            new Pessoa("Fabrícia Santoro", 37, 'F'),
            new Pessoa("Júlia Piasentini", 19, 'F')
        };

        SelectionSort(vet);

        foreach (var pessoa in vet)
        {
            Console.WriteLine(pessoa.ToString());
        }
    }

    public static void SelectionSort(Pessoa[] vet)
    {
        for (int i = 0; i < vet.Length - 1; i++)
        {
            int indiceMenor = i;
            for (int j = i + 1; j < vet.Length; j++)
            {
                if (vet[j].Idade < vet[indiceMenor].Idade)
                {
                    indiceMenor = j;
                }
            }

            if (i != indiceMenor)
            {
                Troca(vet, i, indiceMenor);
            }
        }
    }

    // Ordena pelo gênero.
    // public static void SelectionSort(Pessoa[] vet)
    // {
    //     for (int i = 0; i < vet.Length - 1; i++)
    //     {
    //         int indiceMenor = i;
    //         for (int j = i + 1; j < vet.Length; j++)
    //         {
    //             if (vet[j].Genero < vet[indiceMenor].Genero)
    //             {
    //                 indiceMenor = j;
    //             }
    //         }

    //         if (i != indiceMenor)
    //         {
    //             Troca(vet, i, indiceMenor);
    //         }
    //     }
    // }

    public static void Troca(Pessoa[] vet, int i, int j)
    {
        Pessoa aux = vet[i];
        vet[i] = vet[j];
        vet[j] = aux;
    }
}
