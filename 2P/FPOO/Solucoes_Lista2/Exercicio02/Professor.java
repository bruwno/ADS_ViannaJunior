import java.time.LocalDate;
import java.util.List;
import java.util.ArrayList;

public class Professor
{
    private String nome;
    private LocalDate dataRegistro;
    private boolean possuiEspecializacao;
    private List<Disciplina> disciplinas;

    public Professor() {
        dataRegistro = LocalDate.now();
        disciplinas = new ArrayList<>();
    }

    public Professor(String nome, int idade, LocalDate dataRegistro, boolean possuiEspecializacao) {
        this.nome = nome;
        this.dataRegistro = dataRegistro;
        this.possuiEspecializacao = possuiEspecializacao;
        disciplinas = new ArrayList<>();
    }

    public String getNome() {
        return this.nome;
    }

    public void setNome(String nome) {
        if (nome != null && !nome.equals("")) {
            this.nome = nome;
        }
    }

    public LocalDate getDataRegistro() {
        return this.dataRegistro;
    }

    public void setDataRegistro(LocalDate dataRegistro) {
        this.dataRegistro = dataRegistro;
    }

    public boolean getPossuiEspecializacao() {
        return this.possuiEspecializacao;
    }

    public void setPossuiEspecializacao(boolean possuiEspecializacao) {
        this.possuiEspecializacao = possuiEspecializacao;
    }

    public List<Disciplina> getDisciplinas() {
        return disciplinas;
    }

    public void addDisciplina(Disciplina disciplina) {
        if (disciplina != null) {
            this.disciplinas.add(disciplina);
        }
    }

    // Métodos auxiliares.
    public double valorHoraAula() {
        return 25.0;
    }

    public double calculaSalarioBase() {
        double salarioBase = 0.0;
        
        for (Disciplina disciplina : disciplinas) {
            double valorHoraAula = valorHoraAula();
            if (disciplina.ehEAD()) {
                valorHoraAula *= 0.75;
            }
            salarioBase += valorHoraAula * calculaQtdHorasAula();
        }
        
        return salarioBase;
    }

    public double aplicaBonusEspecializacao() {
        return (this.possuiEspecializacao) ? valorHoraAula() * 0.15 : 0;
    }

    public double calculaQtdHorasAula() {
        int qtdCreditos = 0;

        for (Disciplina disciplina : disciplinas) {
            qtdCreditos += disciplina.getQtdCreditos();
        }

        return qtdCreditos;
    }

    public double salarioProfessor() {
        return (calculaSalarioBase() + aplicaBonusEspecializacao());
    }

}
