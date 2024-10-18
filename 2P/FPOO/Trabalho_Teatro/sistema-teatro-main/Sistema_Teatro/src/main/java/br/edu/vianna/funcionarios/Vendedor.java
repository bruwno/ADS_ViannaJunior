package br.edu.vianna.funcionarios;

import br.edu.vianna.avaliacoes.Avaliacao;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

public class Vendedor extends Funcionario {
    private int codVendedor;
    private double notaDeAtendimento;
    private List<Avaliacao> avaliacoes;

    public Vendedor() {
        this.avaliacoes = new ArrayList<>();
    }

    public Vendedor(int codVendedor, String nome, String email, String senha, double notaDeAtendimento, String dataRegistro) {
        super(nome, email, senha);
        setNotaDeAtendimento(notaDeAtendimento);
        setCodVendedor(codVendedor);
        super.setDataRegistro(dataRegistro);
        this.avaliacoes = new ArrayList<>();
    }
    public int getCodVendedor() {
        return codVendedor;
    }

    public void setCodVendedor(int codVendedor) {
        if(codVendedor > 0){
            this.codVendedor = codVendedor;
        }
    }
    public double getNotaDeAtendimento() {
        calcularNotaMedia();
        return notaDeAtendimento;
    }

    public void setNotaDeAtendimento(double notaDeAtendimento) {
        if(notaDeAtendimento >= 0 && notaDeAtendimento <= 5){
            this.notaDeAtendimento = notaDeAtendimento;
        }
    }

    public List<Avaliacao> getAvaliacoes() {
        return this.avaliacoes;
    }

    public void addAvaliacao(Avaliacao avaliacaoAtendimento) {
        if (avaliacaoAtendimento != null) {
            this.avaliacoes.add(avaliacaoAtendimento);
        }
    }

    private void calcularNotaMedia() {
        int soma = 0;
        double media = 0.0;
        for (Avaliacao aval : avaliacoes) {
            soma += aval.getNota();
        }
        if (!avaliacoes.isEmpty()) {
            media = (double) soma / avaliacoes.size();
        }
        this.notaDeAtendimento = media;
    }
}