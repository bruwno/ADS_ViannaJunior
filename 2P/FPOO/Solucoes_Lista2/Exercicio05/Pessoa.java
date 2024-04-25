
public class Pessoa
{
    private String nome;
    private Endereco endereco;
    private String numero;

    public String consultaNome() {
        return this.nome;
    }

    public void setNome(String nome) {
        if (nome != null && !nome.equals("")) {
            this.nome = nome;
        }
    }

    public Endereco consultaEndereco() {
        return this.endereco;
    }

    public void setEndereco(Endereco endereco) {
        if (endereco != null) {
            this.endereco = endereco;
        }
    }

    public String getNumero(String numero) {
        return this.numero;
    }

    public void setNumero(String numero) {
        if (numero != null) {
            this.numero = numero;
        }
    }
}
