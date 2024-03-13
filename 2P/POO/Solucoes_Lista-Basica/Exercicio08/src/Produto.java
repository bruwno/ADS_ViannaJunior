public class Produto {
    private String nome;
    private String codigoDeBarras;
    private double preco;
    private int quantidadeEmEstoque;
    public Produto() {}

    public Produto(String nome, String codigoDeBarras, double preco, int quantidadeEmEstoque) {
        this.nome = nome;
        this.codigoDeBarras = codigoDeBarras;
        this.preco = preco;
        this.quantidadeEmEstoque = quantidadeEmEstoque;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getCodigoDeBarras() {
        return codigoDeBarras;
    }

    public void setCodigoDeBarras(String codigoDeBarras) {
        this.codigoDeBarras = codigoDeBarras;
    }

    public double getPreco() {
        return preco;
    }

    public void setPreco(double preco) {
        this.preco = preco;
    }

    public int getQuantidadeEmEstoque() {
        return quantidadeEmEstoque;
    }

    public void setQuantidadeEmEstoque(int quantidadeEmEstoque) {
        this.quantidadeEmEstoque = quantidadeEmEstoque;
    }

    public String verificaDispProdutoNoEstoque() {
        return (quantidadeEmEstoque >= 1) ? "Disponível" : "Indisponível";
    }

    public String exibeInformacoes() {
        return String.format("%nInformações do produto %nNome: %s %nCódigo de barras: %s %nPreço: R$ %.2f",
                nome, codigoDeBarras, preco, quantidadeEmEstoque);
    }
}