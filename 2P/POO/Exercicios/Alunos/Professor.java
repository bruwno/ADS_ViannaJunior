public class Professor {
    Aluno[] notas;
    
    // Construtor da classe Professor.
    public Professor(Aluno[] notas) {
        this.notas = notas;
    }
    
    public Aluno calcularMaiorNota(){
        double maiorNota = 0.0;
        Aluno alunoMaiorNota = new Aluno();
        
        for (int i = 0; i < notas.length; i++) {
            if (notas[i].nota > maiorNota) {
                maiorNota = notas[i].nota;
                alunoMaiorNota = notas[i];
            }
        }
        
        return alunoMaiorNota;
    }
}