import java.util.List;
import java.util.ArrayList;

public class Artigo
{
    private String titulo;
    private String resumo;
    private double nota;
    private List<Autor> autores;

    public Artigo() {
        this.autores = new ArrayList<>();
    }

    public Artigo(String titulo, String resumo) {
        setTitulo(titulo);
        setResumo(resumo);
        this.autores = new ArrayList<>();
    }

    public String getTitulo() {
        return this.titulo;
    }

    public void setTitulo(String titulo) {
        if (titulo != null && !titulo.equals("")) {
            this.titulo = titulo;
        }
    }

    public String getResumo() {
        return this.resumo;
    }

    public void setResumo(String resumo) {
        if (resumo != null && !resumo.equals("")) {
            this.resumo = resumo;
        }
    }

    public double getNota() {
        return this.nota;
    }

    public void setNota(double nota) {
        this.nota = nota;
    }

    public List<Autor> getAutores() {
        return this.autores;
    }

    public void addAutor(Autor autor) {
        this.autores.add(autor);
    }
}
