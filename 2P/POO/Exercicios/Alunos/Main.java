public class Main{
    public static void main(String[] args) {
        Aluno a1, a2;
        a1 = new Aluno("Samuelzin", 9);
        a2 = new Aluno("Dili", 6);
        
        System.out.println("[RESULTADOS]");
        exibirMsgAprovacao(a1);
        exibirMsgAprovacao(a2);

        Aluno[] alunos = new Aluno[2];
        alunos[0] = a1;
        alunos[1] = a2;
        
        System.out.println("\n[PROFESSOR]");
        Professor prof = new Professor(alunos);
        Aluno maiorNota = prof.calcularMaiorNota();
        System.out.printf("A maior nota foi do aluno %s com %.1f pontos\n", maiorNota.nome, maiorNota.nota);
        
    }
    
    public static void exibirMsgAprovacao(Aluno aluno) {
        if (aluno.aprovado()) {
            System.out.println("O aluno " + aluno.nome + " esta Aprovado");
        } else {
            System.out.println("O aluno " + aluno.nome + " esta Reprovado");
        }
    }
    
}    