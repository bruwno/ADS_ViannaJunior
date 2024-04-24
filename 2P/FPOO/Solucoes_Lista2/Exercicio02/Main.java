import java.util.Scanner;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;

public class Main
{
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        Professor prof = cadastrarProfessor(sc);
        System.out.printf("\nSALÁRIO: R$ %.2f", prof.salarioProfessor());

    }

    public static Professor cadastrarProfessor(Scanner sc) {
        System.out.print("Para começar informe qual é a formação do professor: ");
        Professor prof = escolherFormacao(sc);

        System.out.print("Digite o nome do professor: ");
        prof.setNome(sc.next());
        sc.nextLine();
        System.out.print("Digite a data de registro do professor na instituicao (DD/MM/AAAA): ");
        prof.setDataRegistro(leRetornaDataFormatada(sc));

        System.out.print("O professor possui especialização? (S/N): ");
        prof.setPossuiEspecializacao(retornaSePossuiEspecializacao(sc));

        System.out.println("\nDisciplinas ministradas: ");
        cadastrarDisciplina(sc, prof);

        return prof;
    }

    public static Professor escolherFormacao(Scanner sc) {
        int formacao = 0;
        while (formacao <= 0 || formacao > 2) {
            System.out.print("\nFormação");
            System.out.println("\n1 - Mestre\n2 - Doutor");
            formacao = sc.nextInt();
        }

        Professor prof = new Professor();

        if (formacao == 1) {
            prof = new Mestre();
        } else if (formacao == 2) {
            prof = new Doutor();
        }

        return prof;
    }

    public static LocalDate leRetornaDataFormatada(Scanner sc) {
        String data = sc.next();
        DateTimeFormatter dtf = DateTimeFormatter.ofPattern("dd/MM/yyyy");
        return LocalDate.parse(data, dtf);
    }

    public static boolean retornaSePossuiEspecializacao(Scanner sc) {
        String especializacao = sc.next().toUpperCase();
        if (especializacao.equals("S")) {
            return true;
        } else {
            return false;
        }
    }

    public static void cadastrarDisciplina(Scanner sc, Professor professor) {
        boolean continuarCadastrando = true;    
        Disciplina disciplina = new Disciplina();

        while (continuarCadastrando == true) {
            System.out.print("Digite o nome da disciplina: ");
            disciplina.setNome(sc.next());
            sc.nextLine();
            System.out.print("Digite a quantidade de créditos da disciplina: ");
            disciplina.setQtdCreditos(sc.nextInt());
            System.out.print("Essa disciplina é na modalidade EAD? (S/N): ");
            disciplina.setEhEAD(leRetornaOpcao(sc));
            disciplina.setProfessor(professor);

            professor.addDisciplina(disciplina);

            System.out.print("\nCadastrar outra disciplina? (S/N): ");
            continuarCadastrando = leRetornaOpcao(sc);
        }
    }

    public static boolean leRetornaOpcao(Scanner sc) {
        String opc = sc.next().toUpperCase();
        if (opc.equals("S")) {
            return true;
        } else {
            return false;
        }
    }
}
