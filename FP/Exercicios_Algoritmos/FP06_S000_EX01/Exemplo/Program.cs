//Altere o programa para trabalhar com dados de 10 alunos.
//O programa deve listar a matrícula e o nome dos alunos aprovados.
//Um aluno é aprovado quando a média das suas notas for maior ou igual a 7.

internal class Program
{
    private static void Main(string[] args)
    {
        const int TAM = 10;

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

        string aprovados = VerificarAprovados(matriculas, nomes, notas1, notas2);
        Console.WriteLine(aprovados);

    }

    private static string VerificarAprovados(int[] mat, string[] nome, double[] notas1, double[] notas2)
    {
        string[] aprovados = new string[10];
        int matricula = 0;
        string nomeAluno = string.Empty;

        for (int i = 0; i < notas1.Length; i++)
        {
            matricula = mat[i];
            nomeAluno = nome[i];

            double media = notas1[i] + notas2[i];

            if (media >= 7.0) 
            {
                aprovados[i] += matricula[i].ToString();
                aprovados[i+1] += nome[i];
            }
        }

        return aprovados;
    }
}