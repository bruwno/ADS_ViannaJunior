public class Funcionario {
    // Atributos.
    private String nome;
    private double salario;
    private String funcao;
    private boolean noturno;
    private int filhos;
    private boolean valeTrans;
    private double totalVendas;

    // Construtor.
    public Funcionario() {}

    public Funcionario(String nome, double salario, String funcao, boolean noturno, int filhos, boolean valeTrans,double totalVendas) {
        this.nome = nome;
        this.salario = salario;
        this.funcao = funcao;
        this.noturno = noturno;
        this.filhos = filhos;
        this.valeTrans = valeTrans;
        this.totalVendas = totalVendas;
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

    public double getSalario() {
        return this.salario;
    }

    public void setSalario(double salario) {
        if (salario >= 0.0) {
            this.salario = salario;
        }
    }

    public String getFuncao() {
        return this.funcao;
    }

    public void setFuncao(String funcao) {
        if (funcao != null || !funcao.equals("")) {
            this.funcao = funcao;
        }
    }

    public boolean getTurno() {
        return this.noturno;
    }

    public void setNoturno(String turno) {
        if (turno != null || !turno.equals("")) {
            this.noturno = noturno;
        }
    }

    public int getFilhos() {
        return this.filhos;
    }

    public void setFilhos(int filhos) {
        if (filhos >= 0) {
            this.filhos = filhos;
        }
    }

    public boolean getValeTrans() {
        return this.valeTrans;
    }

    public void setValeTrans(boolean valeTrans) {
        this.valeTrans = valeTrans;
    }

    public double getTotalVendas() {
        return this.totalVendas;
    }

    public void setTotalVendas(int totalVendas) {
        if (totalVendas >= 0) {
            this.totalVendas = totalVendas;
        }
    }

    // Métodos da classe (Responsabilidades).
    public double descontoInss() { 
        return salario * 0.13;
    }

    public double bonusGerente(){
        return (funcao.toUpperCase().trim().equals("GERENTE") ? salario - 0.10 : 0);
    }

    public double bonusVendedor() {
        return (funcao.toUpperCase().trim().equals("VENDEDOR") ? salario - 0.02 : 0);
    }
    
    public double descValeTransporte() {
        return (valeTrans) ? (salario * 0.03) : 0;
    }
    
    public double bonusTrabalhadorNoturno() {
        return (noturno) ? (salario * 0.02) : 0;
    }
    
    public double bonusPorFilho() {
        return (filhos < 3) ? filhos * 50 : 150;
    }
    
    public double salarioLiquido() {
        return salario - descontoInss() + bonusGerente() + bonusVendedor() - descValeTransporte() + bonusTrabalhadorNoturno() + bonusPorFilho();
    }
}
