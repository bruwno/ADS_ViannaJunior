package br.edu.vianna.clientes;

public class Endereco {
    private String rua;
    private String numero;
    private String complemento;
    private String bairro;
    private String cidade;
    private String cep;
    private String uf;

    public Endereco() {
    }

    public Endereco(String rua, String numero, String complemento, String bairro, String cidade, String cep, String uf) {
        setRua(rua);
        setNumero(numero);
        setComplemento(complemento);
        setBairro(bairro);
        setCidade(cidade);
        setCep(cep);
        setUf(uf);
    }

    public String getRua() {
        return rua;
    }

    public void setRua(String rua) {
        if (rua != null && !rua.isEmpty()) {
            this.rua = rua;
        }
    }

    public String getNumero() {
        return numero;
    }

    public void setNumero(String numero) {
        if (numero != null && !numero.isEmpty()) {
            this.numero = numero;
        }
    }

    public String getComplemento() {
        return complemento;
    }

    public void setComplemento(String complemento) {
        if (complemento.isBlank()) {
            this.complemento = "Nenhum complemento informado.";
        } else {
            this.complemento = complemento;
        }
    }

    public String getBairro() {
        return bairro;
    }

    public void setBairro(String bairro) {
        if (bairro != null && !bairro.isEmpty()) {
            this.bairro = bairro;
        }
    }

    public String getCidade() {
        return cidade;
    }

    public void setCidade(String cidade) {
        if (cidade != null && !cidade.isEmpty()) {
            this.cidade = cidade;
        }
    }

    public String getCep() {
        return cep;
    }

    public void setCep(String cep) {
        if (cep != null && !cep.isEmpty()) {
            this.cep = cep;
        }
    }

    public String getUf() {
        return uf;
    }

    public void setUf(String uf) {
        if (uf != null && !uf.isEmpty()) {
            this.uf = uf;
        }
    }

    @Override
    public String toString() {
        return String.format("%n Rua: %s%n Número %s%n Complemento: %s%n CEP: %s%n Bairro: %s%n Cidade: %s%n UF: %s%n",
                rua, numero, complemento, cep, bairro, cidade, uf);
    }
}
