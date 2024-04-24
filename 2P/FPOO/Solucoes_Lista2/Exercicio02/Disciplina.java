
public class Disciplina
{
    private String nome;
    private int qtdCreditos;
    private Professor professor;
    private boolean ehEAD;

    public Disciplina() {}

    public Disciplina(String nome, int qtdCreditos, Professor professor) {
        this.nome = nome;
        this.qtdCreditos = qtdCreditos;
        this.professor = professor;
    }

    public String getNome() {
        return this.nome;
    }

    public void setNome(String nome) {
        if (nome != null && !nome.equals("")) {
            this.nome = nome;
        }
    }

    public int getQtdCreditos() {
        return this.qtdCreditos;
    }

    public void setQtdCreditos(int qtdCreditos) {
        if (qtdCreditos > 0) {
            this.qtdCreditos = qtdCreditos;
        }
    }

    public Professor getPŕofessor() {
        return this.professor;
    }

    public void setProfessor(Professor professor) {
        if (professor != null) {
            this.professor = professor;
        }
    }
    
    public boolean ehEAD() {
        return this.ehEAD;
    }
    
    public void setEhEAD(boolean ehEAD) {
        this.ehEAD = ehEAD;
    }
}
