using System;
using System.Collections.Generic;

namespace ExemploAssociacao.models
{
    public class Turma
    {
        public int Periodo { get; set; }
        public Professor? Professor { get; set; }
        private List<Aluno> alunos = new List<Aluno>();

        public void Matricular(Aluno aluno)
        {
            if (alunos.Count() > 100)
            {
                throw new Exception("O número máximo de aliunos foi excedido.");
                this.alunos.Add(aluno);
            }
        }

        public Aluno[] Alunos
        {
            get => alunos.ToArray();
        }
    }
}