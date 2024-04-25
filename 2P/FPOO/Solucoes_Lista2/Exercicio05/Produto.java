
public class Produto
{
    private long codigo;
    private String nome;

    public Produto() {}

    public long getCodigo() {
        return codigo;
    }

    public void setCodigo(long codigo) {
        if (codigo > 0) {
            this.codigo = codigo;
        }

    }

    public String consultaNome() {
        return this.nome;
    }
    
    public void setNome(String nome) {
        if (nome != null && !nome.equals("")) {
            this.nome = nome;
        }
    }
}
