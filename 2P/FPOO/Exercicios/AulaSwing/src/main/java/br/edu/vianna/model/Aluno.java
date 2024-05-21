package br.edu.vianna.model;

import br.edu.vianna.model.escola.Matricula;
import java.time.LocalDateTime;
import java.util.ArrayList;

/**
 *
 * @author William
 */
public class Aluno extends Usuario {
    private String matricula;
    private double valorMensalidade;

    private ArrayList<Matricula> matriculas;

    public Aluno(int id, String nome, String email, String login, String senha, LocalDateTime dataUltimoAcesso, String matricula, double valorMensalidade) {
        super(id, nome, email, login, senha, dataUltimoAcesso);
        this.matricula = matricula;
        this.valorMensalidade = valorMensalidade;
        matriculas = new ArrayList<>();
    }


    public Aluno() {
        matriculas = new ArrayList<>();
    }

    public ArrayList<Matricula> getMatriculas() {
        return matriculas;
    }

    public String getMatricula() {
        return matricula;
    }

    public void setMatricula(String matricula) {
        this.matricula = matricula;
    }

    public double getValorMensalidade() {
        return valorMensalidade;
    }

    public void setValorMensalidade(double valorMensalidade) {
        this.valorMensalidade = valorMensalidade;
    }
}
