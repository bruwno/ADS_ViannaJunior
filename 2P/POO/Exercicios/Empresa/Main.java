public class Main {
    public static void main(String[] args) {
        // Instanciando os funcionarios.
        Funcionario f1, f2, f3, f4, f5, f6;
        f1 = new Funcionario("Samuelzim", 6500.0, "Gerente", true, 1, true, 0);
        f2 = new Funcionario("Raphaelzim", 4500.0, "Vendedor", false, 0, true, 100);
        f3 = new Funcionario("Otaviozim", 4250.80, "Vendedor", true, 5, true, 290);
        f4 = new Funcionario("Renanzim", 4300.0, "Vendedor", false, 2, true, 180);
        f5 = new Funcionario("Diogin", 3900.0, "Vendedor", false, 1, true, 250);
        f6 = new Funcionario("William", 3910.75, "Vendedor", true, 0, false, 120);
        
        // Populando o array de funcionarios.
        Funcionario[] funcionarios = new Funcionario[] { f1, f2, f3, f4, f5, f6 };
        
        // Exibindo o salario liquido de cada funcionario.
        System.out.println("\nSalário liquido dos funcionários: ");
        for (Funcionario f : funcionarios) {
            System.out.printf("FUNCIONÁRIO: %s \t| SALÁRIO: R$ %.2f%n", f.getNome(), f.salarioLiquido());
        }
        
        // Instanciando a Empresa.
        Empresa emp = new Empresa("A firma", funcionarios);
        
        System.out.println("\nFuncionário com o maior salário: ");
        Funcionario funcMaiorSalario = emp.funcionarioMaiorSalario();
        System.out.printf("NOME FUNCIONÁRIO: %s%n", funcMaiorSalario.getNome());
        
        System.out.printf("%nSOMA DOS SALÁRIOS = R$ %.2f%n", emp.somaSalarios());
    }

}