public class Funcionario {
    private String nome;
    private double salario;
    private String funcao;
    private boolean noturno;
    private int filhos;
    private boolean valeTrans;
    private int totalVendas;
    
    public Funcionario() {}
    
    public Funcionario(String nome, double salario, String funcao, boolean noturno, int filhos, boolean valeTrans,int totalVendas) {
        this.nome = nome;
        this.salario = salario;
        this.funcao = funcao;
        this.noturno = noturno;
        this.filhos = filhos;
        this.valeTrans = valeTrans;
        this.totalVendas = totalVendas;
    }
    
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
    
    public String getFuncao() {
        return this.funcao;
    }
    
    
    public double salarioLiquido() {
        if (this.getFuncao().equals("Gerente")) {
            
        } else {
            
        }
    }
}