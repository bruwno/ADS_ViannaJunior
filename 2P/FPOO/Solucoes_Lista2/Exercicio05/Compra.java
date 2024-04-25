import java.util.List;
import java.util.ArrayList;

public class Compra
{
    private Pessoa pessoa;
    private Produto produto;

    public Compra() {
        //produtosComprados = new ArrayList<>();
    }

    public Compra(Pessoa pessoa, Produto produto) {
        setPessoa(pessoa);
        setProduto(produto);
    }

    public Pessoa getPessoa() {
        return this.pessoa;
    }

    public void setPessoa(Pessoa pessoa) {
        if (pessoa != null) {
            this.pessoa = pessoa;
        }
    }

    public Produto getProduto() {
        return this.produto;
    }

    public void setProduto(Produto produto) {
        if (produto != null) {
            this.produto = produto;
        }
    }

    public void comprar(Pessoa pessoa, Produto produto) {
        
    }

    public String verificarCompra() {
        return String.format("%s comprou %s", this.pessoa.consultaNome(), this.produto.consultaNome());
    }
}
