
public class Aluno
{
    private String nome;
    private int votos;
    
    public Aluno(String nome) {
        setNome(nome);
        this.votos = 0;
    }
    
    public String getNome() {
        return this.nome;
    }
    
    public void setNome(String nome) {
        if (nome != null && !nome.equals("")) {
            this.nome = nome.toUpperCase();
        }
    }
    
    public int getVotos() {
        return votos;
    }
    
    public void receberVoto() {
        votos++;
    }
}
