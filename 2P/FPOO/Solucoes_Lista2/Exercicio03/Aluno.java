
public class Aluno extends Autor
{
    private int indicadorDeParticipacao;
    
    public Aluno(String nome, int indicadorDeParticipacao) {
        super(nome);
        setIndicadorDeParticipacao(indicadorDeParticipacao);
    }

    public int getIndiceDeParticipacao() {
        return this.indicadorDeParticipacao;
    }
    
    public void setIndicadorDeParticipacao(int indicadorDeParticipacao) {
        if (indicadorDeParticipacao >= 0) {
            this.indicadorDeParticipacao = indicadorDeParticipacao;
        }
    }
}
