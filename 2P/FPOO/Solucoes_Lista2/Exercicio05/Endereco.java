
public class Endereco
{
    private String logradouro;
    private String cidade;
    private String estado;

    public String consultarLogradouro() {
        return this.logradouro;
    }

    public void setLogradouro(String logradouro) {
        if (logradouro != null && !logradouro.equals("")) {
            this.logradouro = logradouro;
        }
    }

    public String getCidade() {
        return this.cidade;
    }
    
    public void setCidade(String cidade) {
        if (cidade != null && !cidade.equals("")) {
            this.cidade = cidade;
        }
    }
    
    public String getEstado() {
        return this.estado;
    }
    
    public void setEstado(String estado) {
        if (estado != null && !estado.equals("")) {
            this.estado = estado;
        }
    }
}
