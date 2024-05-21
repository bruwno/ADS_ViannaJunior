package br.edu.vianna.model;

import br.edu.vianna.model.esp.EEspecializacao;
import java.time.LocalDateTime;

/**
 *
 * @author William
 */
public class Professor extends Usuario {
private EEspecializacao especializacao;
    private int tempoCasa;
    private double valorHoraAula;

    public Professor() {}

    public Professor(int id, String nome, String email, String login, String senha, LocalDateTime dataUltimoAcesso, EEspecializacao especializacao, int tempoCasa, double valorHoraAula) {
        super(id, nome, email, login, senha, dataUltimoAcesso);
        this.especializacao = especializacao;
        this.tempoCasa = tempoCasa;
        this.valorHoraAula = valorHoraAula;
    }

    public EEspecializacao getEspecializacao() {
        return especializacao;
    }

    public void setEspecializacao(EEspecializacao especializacao) {
        this.especializacao = especializacao;
    }

    public int getTempoCasa() {
        return tempoCasa;
    }

    public void setTempoCasa(int tempoCasa) {
        this.tempoCasa = tempoCasa;
    }

    public double getValorHoraAula() {
        return valorHoraAula;
    }

    public void setValorHoraAula(double valorHoraAula) {
        this.valorHoraAula = valorHoraAula;
    }

    @Override
    public String toString() {
        return String.format("ID: %d, Nome: %s, Email: %s, Login: %s, Especialização: %s, Tempo de casa: %d, Valor hora-aula: %.2f%n",
                super.getId(), super.getNome(), super.getEmail(), super.getLogin(),
                this.getEspecializacao(), this.getTempoCasa(), this.getValorHoraAula());
    }
}
