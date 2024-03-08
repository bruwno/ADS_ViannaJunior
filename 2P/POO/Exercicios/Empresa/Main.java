import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Empresa emp = new Empresa();
        Scanner read = new Scanner(System.in);
        
        System.out.println("Informe o nome do Empresa:");
        emp.setNome( read.next() );
        
        
        
        while(true){
            System.out.println("Informe os dados do funcionario:");
            Funcionario f = new Funcionario();
            System.out.println("## nome:");
            f.setNome( read.next() );
            System.out.println("## cargo:");
            f.setFuncao( read.next() );
            System.out.println("## Salario:");
            f.setSalario( read.nextDouble() );
            System.out.println("## Numero de Filhos:");
            f.setFilhos( read.nextInt() );
            System.out.println("## Usa Vale Transporte:");
            f.setValeTrans( read.nextBoolean() );    
            System.out.println("## Trabalha a noite:");
            f.setNoturno( read.nextBoolean());  
            if (f.getFuncao().equals("vendedor")){
                System.out.println("## Total Vendas:");
                f.setTotalVendas( read.nextDouble());                
            }
            
            emp.addFuncionario( f );
            System.out.println("Deseja cadastrar outro? (S)im (N)ao");
            if ( !read.next().equals("S") ){                       
                break;
            }
        }  
        
        System.out.println("A empresa "+emp.getNome()+" paga R$ "+emp.somaSalarios());
        
        System.out.println("Funcionario com Maior Salario : "+emp.funcionarioMaiorSalario().getNome());
    }
}