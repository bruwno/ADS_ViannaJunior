public class Professor {
    private Aluno[] alunos;

    public Professor() {
        alunos = new Aluno[6];
    }
    
    public Professor(Aluno[] alunos) {
        alunos = new Aluno[6];
    }

    public void addAluno(Aluno novoAluno) {
        for (int i = 0; i < alunos.length; i++) {
            if (alunos[i] == null) {
                alunos[i] = novoAluno;
                return;
            }
        }
    }
    
    public Aluno calculaMaiorNota() {
        Aluno alunoMaiorNota = alunos[0];

        for (int i = 0; i < alunos.length; i++) {
            if (alunos[i] != null) { 
                if (alunos[i].getNota() > alunoMaiorNota.getNota()) {
                alunoMaiorNota = alunos[i];
                }            
            }
        }
        return alunoMaiorNota;
    }
}