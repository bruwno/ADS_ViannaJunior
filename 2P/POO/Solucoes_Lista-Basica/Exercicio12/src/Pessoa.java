import br.com.williamsilva.calendario.Data;

public class Pessoa {
    private String nome;
    private Data anoNascimento;
    private String email;

    public Pessoa() {
        this.nome = "";
        this.anoNascimento = new Data();
        this.email = "";
    }

    public Pessoa(String nome, Data anoNascimento, String email) {
        this.nome = nome;
        this.anoNascimento = anoNascimento;
        this.email = email;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public Data getAnoNascimento() {
        return anoNascimento;
    }

    public void setAnoNascimento(Data anoNascimento) {
        this.anoNascimento = anoNascimento;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public int verificarIdade() {
        return new Data().getAno() - anoNascimento.getAno();
    }
}
