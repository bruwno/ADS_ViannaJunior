
/* Autor: William Silva (github.com/unclWill)
 * Data : 11/02/2024
 */
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        Professor prof = new Professor();
        boolean sair = false;
        
        while(true) { 
            Aluno aluno = new Aluno();
            System.out.println("Digite o nome do Aluno: ");
            aluno.setNome(sc.next());
            
            System.out.println("Digite a nota do Aluno: ");
            aluno.setNota(sc.nextDouble());
            
            prof.addAluno(aluno);
            
            System.out.println("Deseja adicionar outro aluno? (S)im (N)ão");
            if (!sc.next().toUpperCase().equals("S")) {
                break;
            }
        }
        
        System.out.println("\n[PROFESSOR]");
        Aluno maiorNota = prof.calculaMaiorNota();
        System.out.printf("A maior nota foi do aluno %s com %.1f pontos.\n", maiorNota.getNome(), maiorNota.getNota());
    }
}