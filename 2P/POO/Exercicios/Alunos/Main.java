
/* Autor: William Silva (github.com/unclWill)
 * Data : 11/02/2024
 */
import java.util.Random;

public class Main {
    public static void main(String[] args) {
        // Gerando notas pseudo-aleatorias, de 0 a 10.
        Random random = new Random();

        Aluno a1, a2, a3, a4, a5, a6;
        a1 = new Aluno("Samuelzim", random.nextDouble(0, 10));
        a2 = new Aluno("Dili", random.nextDouble(0, 10));
        a3 = new Aluno("Otaviozim", random.nextDouble(0, 10));
        a4 = new Aluno("Renanzim", random.nextDouble(0, 10));
        a5 = new Aluno("Raphaelzim", random.nextDouble(0, 10));
        a6 = new Aluno("William", random.nextDouble(0, 10));

        // Populando o array de alunos.
        Aluno[] alunos = new Aluno[] { a1, a2, a3, a4, a5, a6 };

        // Exibindo os resultados.
        System.out.println("[RESULTADOS]");
        for (Aluno aluno : alunos) {
            if (aluno.aprovado()) {
                System.out.printf("O aluno %s esta APROVADO.\n", aluno.getNome());
            } else {
                System.out.printf("O aluno %s esta REPROVADO.\n", aluno.getNome());
            }
        }
        
        // Instancia da classe Professor.
        Professor prof = new Professor(alunos);
        
        System.out.println("\n[PROFESSOR]");
        Aluno maiorNota = prof.calculaMaiorNota();
        System.out.printf("A maior nota foi do aluno %s com %.1f pontos.\n", maiorNota.getNome(), maiorNota.getNota());
    }
}