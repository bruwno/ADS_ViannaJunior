package br.edu.vianna.eventos;

import br.edu.vianna.avaliacoes.Avaliacao;
import br.edu.vianna.modelosteatro.Assento;
import br.edu.vianna.modelosteatro.IAssento;
import br.edu.vianna.utils.datahora.FormataData;
import br.edu.vianna.utils.datahora.FormataHora;

import java.time.LocalDate;
import java.time.LocalTime;
import java.util.ArrayList;
import java.util.List;

public class Evento implements IAssento {
    private int codEvento;
    private String nome;
    private LocalDate data;
    private LocalTime horario;
    private String descricao;
    private double preco;
    private int capacidade;
    private Assento[][] assentos;
    private List<Ingresso> ingressos;
    private List<Avaliacao> avaliacoes;

    public Evento() {
        this.assentos = new Assento[10][10];
        this.ingressos = new ArrayList<>();
        this.avaliacoes = new ArrayList<>();
        inicializarAssentos();
    }

    public Evento(String nome, String data, String horario, String descricao, double preco, int capacidade) {
        setCodEvento(codEvento);
        setNome(nome);
        setData(data);
        setHorario(horario);
        setDescricao(descricao);
        setPreco(preco);
        this.assentos = new Assento[10][10];
        this.ingressos = new ArrayList<>();
        this.avaliacoes = new ArrayList<>();
        inicializarAssentos();
        setCapacidade(capacidade);
    }

    public int getCodEvento() {
        return codEvento;
    }

    public void setCodEvento(int codEvento) {
        if (codEvento > 0) {
            this.codEvento = codEvento;
        }
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        if (nome != null && !nome.isEmpty()) {
            this.nome = nome;
        }
    }

    public String getData() {
        return FormataData.formataDataParaString(data);
    }

    public void setData(String data) {
        this.data = FormataData.formataStringParaData(data);
    }

    public String getHorario() {
        return FormataHora.formataHoraParaString(horario);
    }

    public void setHorario(String horario) {
        this.horario = FormataHora.formataStringParaHora(horario);
    }

    public String getDescricao() {
        return descricao;
    }

    public void setDescricao(String descricao) {
        if (descricao != null && !descricao.isEmpty()) {
            this.descricao = descricao;
        }
    }

    public double getPreco() {
        return preco;
    }

    public void setPreco(double preco) {
        if (preco >= 0) {
            this.preco = preco;
        }
    }

    public int getCapacidade() {
        return capacidade;
    }

    public void setCapacidade(int capacidade) {
        int tamanhoMatriz = assentos[0].length * assentos[1].length;
        if (capacidade > 0 && capacidade <= tamanhoMatriz) {
            this.capacidade = capacidade;
        }
    }

    public List<Ingresso> getIngressos() {
        return this.ingressos;
    }

    public void addIngresso(Ingresso ingresso) {
        if (ingressos.size() < this.capacidade) {
            ingressos.add(ingresso);
        }
    }

    public List<Avaliacao> getAvaliacoes() {
        return avaliacoes;
    }

    public void addAvaliacao(Avaliacao avaliacaoEvento) {
        if (avaliacaoEvento != null) {
            this.avaliacoes.add(avaliacaoEvento);
        }
    }

    @Override
    public Assento[][] retornarAssentos() {
        return assentos;
    }

    @Override
    public void inicializarAssentos() {
        int numAssento = 1;
        for (int i = 0; i < assentos.length; i++) {
            for (int j = 0; j < assentos[0].length; j++) {
                assentos[i][j] = new Assento();
                assentos[i][j].setNumero(numAssento++);
                assentos[i][j].setReservado(false);
            }
        }
    }

    @Override
    public Assento reservarAssento(int numeroAssento) {
        Assento assento = converterNumeroAssentoParaCoordenadas(numeroAssento);
        if (!assento.isReservado()) {
            assento.reservar();
            return assento;
        } else {
            return null;
        }
    }

    public int contarAssentosLivres() {
        int qtdAssentosLivres = capacidade;

        for (Assento[] assento : assentos) {
            for (Assento assnt : assento) {
                if (assnt.isReservado()) {
                    qtdAssentosLivres--;
                }
            }
        }

        return qtdAssentosLivres;
    }

    private Assento converterNumeroAssentoParaCoordenadas(int numeroAssento) {
        int linha = (numeroAssento - 1) / 10;
        int coluna = (numeroAssento - 1) % 10;
        return assentos[linha][coluna];
    }
}
