using System;
using ExemploAssociacao.models;

namespace ExemploAssociacao
{
    public class Program
    {
        public static void Main(string[] args)
        {
            var a1 = new Aluno
            {
                Matricula = 123,
                Nome = "Ana",
                Email = "ana@email.com"
            };

            var a2 = new Aluno
            {
                Matricula = 234,
                Nome = "Bruno",
                Email = "bruno@email.com"
            };

            var a3 = new Aluno
            {
                Matricula = 345,
                Nome = "Carlos",
                Email = "carlos@email.com"
            };

            var prof = new Professor { Nome = "Daniel", Matricula = 123 };

            var turma = new Turma();
            turma.Periodo = 2;
            turma.Professor = prof;
            turma.Matricular(a1);
            turma.Matricular(a2);
            turma.Matricular(a3);

            var temp = turma.Alunos;

            foreach (var aluno in temp) {
                Console.WriteLine(aluno);
            }
        }
    }
}