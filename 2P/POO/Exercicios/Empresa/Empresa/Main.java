import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner sc  = new Scanner(System.in);
        Empresa emp = new Empresa();
        
        System.out.println("Informe o nome da empresa: ");
        emp.setNome(sc.next());
        
        while (true) {
            System.out.println("Informe os dados do funcionario:");
            Funcionario f = new Funcionario();
            System.out.println("## Nome:");
            f.setNome(sc.next());
            System.out.println("## Cargo:");
            f.setFuncao(sc.next());
            System.out.println("## Salario:");
            f.setSalario( sc.nextDouble() );
            System.out.println("## Numero de Filhos:");
            f.setFilhos(sc.nextInt() );
            System.out.println("## Usa Vale Transporte:");
            f.setValeTrans( sc.nextBoolean() );    
            System.out.println("## Trabalha a noite:");
            f.setNoturno(sc.nextBoolean() );  
            if (f.getFuncao().equals("vendedor")  ){
                System.out.println("## Total Vendas:");
                f.setTotalVendas( sc.nextDouble() );                
            }
            
            emp.addFuncionario( f );
            System.out.println("Deseja cadastrar outro? (S)im (N)ao");
            if ( !sc.next().equals("S") ){                       
                break;
            }
        }  
        
        System.out.println("A empresa "+ emp.getNome()+" paga R$ "+ emp.somaSalarios());
        
        System.out.println("Funcionario com Maior Salario : "+ emp.funcionarioMaiorSalario().getNome());

    }
}