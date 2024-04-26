import java.util.ArrayList;
import java.util.List;

public class ComiteAvaliador
{   
    List<Artigo> artigos;
    
    public ComiteAvaliador() {
        this.artigos = new ArrayList<>();
    }
    
    public List<Artigo> avaliarArtigo(Artigo artigo) {
        double nota = 0;
        
        artigo.setNota(nota);
        addArtigo(artigo);
        
        return artigos;
    }
    
    public void addArtigo(Artigo artigo) {
        this.artigos.add(artigo);
    }
}
