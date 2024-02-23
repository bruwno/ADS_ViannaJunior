public class Professor {
    private Aluno[] alunos;

    // Construtor da classe Professor.
    public Professor(Aluno[] alunos) {
        this.alunos = alunos;
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