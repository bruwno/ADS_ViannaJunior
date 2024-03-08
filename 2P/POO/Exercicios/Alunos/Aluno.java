public class Aluno {
    // Declarar atributos.
    private String nome;
    private double nota;
    
    // Metodo Construtor
    public Aluno(String nNome, double nNota) {
        nome = nNome;
        nota = nNota;
    }
    
    public Aluno(double nNota, String nNome) {
        nome = nNome;
        nota = nNota;
    }
    
    public Aluno(String nNome) {
        nome = nNome;
        nota = 0;
    }
    
    public Aluno(double nNota){
        nome = "";
        nota = nNota;
    }
    
    public Aluno(){
        nome = "";
        nota = 0;
    }
    
    // Metodos acessores
    public String getNome() {
        return this.nome;
    }
    
    public void setNome(String nome) {
        if (nome != null && !nome.equals("")) {
            this.nome = nome;
        }
    }
    
    public double getNota() {
        return this.nota;
    }
    
    public void setNota(double nota) {
        if (nota >= 0) {
            this.nota = nota;
        }
    }
     
    // Declarar metodos.
    public boolean aprovado() {
      return nota >= 7.0;
    }
}