import java.util.ArrayList;

public class Empresa
{
    private String nome;
    private ArrayList<Funcionario> funcionarios;
    
    public Empresa(){
        funcionarios = new ArrayList<>();
    }
    public Empresa(String nome){
        this.nome = nome;
        this.funcionarios = new ArrayList<>();
    }
    
    public Funcionario funcionarioMaiorSalario(){
        if (funcionarios.get(0) == null){
           return null;   
        }
        Funcionario maior = funcionarios.get(0);
        for(int i = 1; i < funcionarios.size(); i++){
            if (funcionarios.get(i) != null){
                 if ( funcionarios.get(i).salarioLiquido() > maior.salarioLiquido() ){
                     maior = funcionarios.get(i);
                 }
            }
        }
        
        return maior;
    }
    
    public double somaSalarios(){
        double soma = 0;
        for(int i = 0; i < funcionarios.size(); i++){
            if (funcionarios.get(i) != null){
                soma += funcionarios.get(i).salarioLiquido();
            }
        }
        
        return soma;
    }
    
    public void setNome(String novoNome){
        nome = novoNome;
    }
    public String getNome(){
        return nome;
    }

    public ArrayList<Funcionario> getFuncionarios(){
        return funcionarios;
    }
    public void addFuncionario(Funcionario newFunc){        
        funcionarios.add(newFunc);
    } 
}
