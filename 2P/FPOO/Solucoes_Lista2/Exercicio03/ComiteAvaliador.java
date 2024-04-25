import java.util.ArrayList;
import java.util.List;

public class ComiteAvaliador
{
    private List<Artigo> artigos;
    
    public ComiteAvaliador() {
        this.artigos = new ArrayList<>();
    }
    
    public void avaliarArtigos(double nota) {
        for (Artigo artigo : artigos) {
            System.out.print("Atribua uma nota: ");
        }
    }
}
