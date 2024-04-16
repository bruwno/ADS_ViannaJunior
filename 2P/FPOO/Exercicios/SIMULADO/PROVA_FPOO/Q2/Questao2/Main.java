import java.util.Scanner;
import java.util.ArrayList;
import java.util.List;

public class Main
{
    private static final int QTD_ALUNOS = 5;

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        Votacao votacao = new Votacao();
        votacao.setAnoEleicao(2024);

        System.out.println("# Informe os nomes dos alunos que estão participando da eleição");
        for (int i = 0; i < QTD_ALUNOS; i++) {
            System.out.printf("Digite o nome do %dº aluno: ", i + 1);
            String nome = sc.nextLine();
            votacao.addAluno(nome);
        }

        System.out.printf("%n# Votação %d%n", votacao.getAnoEleicao());
        for (Aluno aluno : votacao.getAlunos()) {
            System.out.printf("Digite o nome do aluno em quem vai votar: ");
            String voto = sc.nextLine();
            votacao.registrarVoto(voto);
            System.out.println("Voto registrado com sucesso!\n");
        }

        Aluno alunoMaisVotado = votacao.getAlunoMaisVotado();
        System.out.printf("\nO aluno mais votado foi: %s", alunoMaisVotado.getNome());
    }
}
