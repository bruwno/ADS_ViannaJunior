import java.util.Scanner;

public class Principal
{
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        Banco bco = cadastrarBanco();
            
        System.out.println("Login do " + bco.getSigla());
        Bancario func = cadastrarBancario(sc);

        System.out.println("LOGIN");
        String login = sc.next();
        System.out.println("SENHA");
        String senha = sc.next();
        
        if (!(login.equals("func") && senha.equals("123"))) {
             System.out.println("Login Incorreto!");
             System.exit(-1);
        }
        System.out.println("############# BB Systems #############");
        bco.addBancario(func);
        
        while (true) {
            System.out.println("### MENU PRINCIPAL");
            System.out.println("## [1] Abrir Conta");
            System.out.println("## [2] Consultar Conta");
            System.out.println("## [3] Consultar Cliente");
            System.out.println("## [4] Realizar Operaçoes");
            System.out.println("## [5] Relatorio Financeiro");
            System.out.println("###########################");
            System.out.println("## [6] Sair");
            int menu = sc.nextInt();
        
            if (menu == 6) {
                System.out.println("Ate mais!");
                break;
            }
        }
    }
    
    public static Banco cadastrarBanco() {
        Scanner sc = new Scanner(System.in);
        Banco bco = new Banco();
        bco.setNome("Banco do Brasil");
        bco.setSigla("BB");
        System.out.println("Nome do Gerente do " + bco.getSigla() + "?");
        bco.setGerente(new Gerente(sc.nextLine()));
        return bco;
    }
    
    public static Bancario cadastrarBancario(Scanner sc) {
        System.out.println("Nome do Funcionario: ");
        Bancario func = new Bancario(sc.nextLine());
        return func;
    }
}
