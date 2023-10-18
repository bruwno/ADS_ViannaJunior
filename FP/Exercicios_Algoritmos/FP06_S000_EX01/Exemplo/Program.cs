//Altere o programa para trabalhar com dados de 10 alunos.
//O programa deve listar a matrícula e o nome dos alunos aprovados.
//Um aluno é aprovado quando a média das suas notas for maior ou igual a 7.

internal class Program
{
    const int TAM = 4;

    private static void Main(string[] args)
    {
        int[] matriculas = new int[TAM];
        string[] nomes = new string[TAM];
        double[] notas1 = new double[TAM];
        double[] notas2 = new double[TAM];

        for (int i = 0; i < matriculas.Length; i++)
        {
            Console.WriteLine("Aluno {0} de {1}:", i + 1, matriculas.Length);

            Console.Write("  Matrícula: ");
            matriculas[i] = Convert.ToInt32(Console.ReadLine());

            Console.Write("  Nome: ");
            nomes[i] = Console.ReadLine();

            Console.Write("  Nota 1: ");
            notas1[i] = Convert.ToDouble(Console.ReadLine());

            Console.Write("  Nota 2: ");
            notas2[i] = Convert.ToDouble(Console.ReadLine());
        }

        double[] mediaAlunos = VerificarAprovados(notas1, notas2);

        Console.WriteLine("Lista de alunos aprovados:");
        for (int i = 0; i < mediaAlunos.Length; i++)
        {
            double media = mediaAlunos[i];

            if (media >= 7.0)
            {
                Console.WriteLine($"Matrícula: {matriculas[i]}");
                Console.WriteLine($"Nome     : {nomes[i]}");
                Console.WriteLine($"Média    : {media:N2}");
                Console.WriteLine();
            }
        }

        Console.Write("\nPressione qualquer tecla para finalizar...");
        Console.ReadKey();
    }

    private static double[] VerificarAprovados(double[] notas1, double[] notas2)
    {
        double[] mediaAlunos = new double[TAM];

        for (int i = 0; i < notas1.Length; i++)
        {
            double media = (notas1[i] + notas2[i]) / 2.0;
            mediaAlunos[i] = media;
        }

        return mediaAlunos;
    }
}