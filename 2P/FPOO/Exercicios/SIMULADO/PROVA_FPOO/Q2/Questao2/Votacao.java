import java.util.ArrayList;
import java.util.List;

public class Votacao
{
    private List<Aluno> alunos;
    private int anoEleicao;

    public Votacao() {
        this.alunos = new ArrayList<Aluno>();
        this.anoEleicao = 0;
    }

    public Votacao(int anoEleicao) {
        this.alunos = new ArrayList<Aluno>();
        this.anoEleicao = anoEleicao;
    }

    public int getAnoEleicao() {
        return anoEleicao;
    }
    
    public void setAnoEleicao(int anoEleicao) {
        this.anoEleicao = anoEleicao;
    }
    
    public void addAluno(String nome) {
        Aluno aluno = new Aluno(nome);
        alunos.add(aluno);
    }

    public List<Aluno> getAlunos() {
        return alunos;
    }
    
    public void registrarVoto(String nome) {
        for (Aluno candidato : alunos) {
            if (candidato.getNome().toUpperCase().equals(nome)) {
                candidato.receberVoto();
            }
        }
    }  

    public Aluno getAlunoMaisVotado() {
        Aluno maisVotado = alunos.get(0);
        for (int i = 0; i < alunos.size(); i++) {
            Aluno aluno = alunos.get(i);
            if (aluno.getVotos() > maisVotado.getVotos()) {
                maisVotado = aluno;
            }
        }
        return maisVotado;
    }
}
