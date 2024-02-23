public class Empresa {
    // Atributos.
    private String nome;
    public Funcionario[] listaFuncionarios;

    // Construtor
    public Empresa() {}

    public Empresa(String nome, Funcionario[] listaFuncionarios) {
        this.nome = nome;
        this.listaFuncionarios = listaFuncionarios;
    }

    // Métodos acessores.
    public String getNome() {
        return this.nome;
    }

    public void setNome(String nome) {
        if (nome != null || !nome.equals("")) {
            this.nome = nome;
        }
    }

    public Funcionario[] getFuncionarios() {
        return this.listaFuncionarios;
    }

    // Métodos da classe (Responsabilidades).
    public Funcionario funcionarioMaiorSalario() {
        double maiorSalario = 0.0;
        Funcionario funcMaiorSalario = new Funcionario();

        // Retorna o funcionário com o maior salário bruto.
        /*
        for (int i = 0; i < listaFuncionarios.length; i++) {
        if (listaFuncionarios[i].getSalario() > maiorSalario) {
        maiorSalario = listaFuncionarios[i].getSalario();
        funcMaiorSalario = listaFuncionarios[i];
        }
        }
         */
        // Retorna o funcionário com o maior salário líquido.
        for (int i = 0; i < listaFuncionarios.length; i++) {
            if (listaFuncionarios[i].salarioLiquido() > maiorSalario) {
                maiorSalario = listaFuncionarios[i].salarioLiquido();
                funcMaiorSalario = listaFuncionarios[i];
            }
        }

        return funcMaiorSalario;
    }

    public double somaSalarios() {
        double somaSalarios = 0.0;

        for (Funcionario funcionario : listaFuncionarios) {
            somaSalarios += funcionario.getSalario();
        }
        return somaSalarios;
    }
}
