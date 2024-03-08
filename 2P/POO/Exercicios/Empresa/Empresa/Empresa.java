// O relacionamento entre as classes pode ser uni-direcional ou bi-direcional.
// Ou seja, nesse caso, apenas a Empresa precisa conhecer seus funcionarios (relacionamento uni-direcional),
// Caso o funcionario tbm precise conhecer a empresa, basta declarar um atributo do tipo Empresa na classe Funcionario (relacionamento di-direcional).

public class Empresa {
    // Atributos.
    private String nome;
    private Funcionario[] listaFuncionarios;

    // Construtor
    public Empresa() {
        listaFuncionarios = new Funcionario[20];
    }

    public Empresa(String nome, Funcionario[] listaFuncionarios) {
        this.nome = nome;
        listaFuncionarios = new Funcionario[20];
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
    
    public void addFuncionario(Funcionario newFunc) {
        for (int i = 0; i < listaFuncionarios.length; i++) {
            if (listaFuncionarios[i] == null) {
                listaFuncionarios[i] = newFunc;
                return;
            }
        }
    }

    // Métodos da classe (Responsabilidades).
    public Funcionario funcionarioMaiorSalario() {
        if (listaFuncionarios[0] == null) {
            return null;
        }
        
        Funcionario funcMaiorSalario = listaFuncionarios[0];
        // Retorna o funcionário com o maior salário líquido.
        for (int i = 0; i < listaFuncionarios.length; i++) {
            if (listaFuncionarios[i] != null) {
                if (listaFuncionarios[i].salarioLiquido() > funcMaiorSalario.salarioLiquido()) {
                    funcMaiorSalario = listaFuncionarios[i];
                }
            }
        }

        return funcMaiorSalario;
    }

    public double somaSalarios() {
        double somaSalarios = 0.0;

        for (Funcionario funcionario : listaFuncionarios) {
            somaSalarios += funcionario.salarioLiquido();
        }
        return somaSalarios;
    }
}
