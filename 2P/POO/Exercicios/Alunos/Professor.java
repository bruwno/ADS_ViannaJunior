public class Professor {
    private Aluno[] alunos;

    // Construtor da classe Professor.
    public Professor(Aluno[] alunos) {
        this.alunos = alunos;
    }

    public void exibeSituacaoAluno() {
        for (Aluno aluno : alunos) {
            if (aluno.aprovado()) {
                System.out.printf("O aluno %s esta APROVADO.\n", aluno.getNome());
            } else {
                System.out.printf("O aluno %s esta REPROVADO.\n", aluno.getNome());
            }
        }
    }

    public Aluno calculaMaiorNota() {
        double maiorNota = 0.0;
        Aluno alunoMaiorNota = new Aluno();

        for (int i = 0; i < alunos.length; i++) {
            if (alunos[i].getNota() > maiorNota) {
                maiorNota = alunos[i].getNota();
                alunoMaiorNota = alunos[i];
            }
        }
        return alunoMaiorNota;
    }
}