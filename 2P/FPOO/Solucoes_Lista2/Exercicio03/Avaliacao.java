
public class Avaliacao
{
    private Artigo artigo;
    private double nota;
    
    public Avaliacao() {}
    
    public Avaliacao(Artigo artigo, double nota) {
        setArtigo(artigo);
        setNota(nota);
    }
    
    public Artigo getArtigo() {
        return this.artigo;
    }
    
    public void setArtigo(Artigo artigo) {
        if (artigo != null) {
            this.artigo = artigo;
        }
    }
    
    public double getNota() {
        return this.nota;
    }
    
    public void setNota(double nota) {
        this.nota = nota;
    }
}
