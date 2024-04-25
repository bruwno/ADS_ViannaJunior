import java.util.List;
import java.util.ArrayList;

public class Autor
{
    private String nome;
    
    public Autor(String nome) {
        setNome(nome);
    }
    
    public String getNome() {
        return this.nome;
    }
    
    public void setNome(String nome) {
        if (nome != null && !nome.equals("")) {
            this.nome = nome;
        }
    }
}
