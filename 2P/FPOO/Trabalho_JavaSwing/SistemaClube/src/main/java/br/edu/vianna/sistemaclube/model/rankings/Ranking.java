package br.edu.vianna.sistemaclube.model.rankings;

import br.edu.vianna.sistemaclube.model.atividades.Atividade;
import br.edu.vianna.sistemaclube.model.usuarios.Membro;

public class Ranking {
    private int id;
    private Membro membro;
    private Atividade atividade;
    private double media;

    public Ranking() {}

    public Ranking(int id, Membro membro, Atividade atividade, double media) {
        setId(id);
        setMembro(membro);
        setAtividade(atividade);
        setMedia(media);
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        if (id > 0) {
            this.id = id;
        }
    }

    public Membro getMembro() {
        return membro;
    }

    public void setMembro(Membro membro) {
        if (membro != null) {
            this.membro = membro;
        }
    }

    public Atividade getAtividade() {
        return atividade;
    }

    public void setAtividade(Atividade atividade) {
        if (atividade != null) {
            this.atividade = atividade;
        }
    }

    public double getMedia() {
        return media;
    }

    public void setMedia(double media) {
        if (media >= 0 && media <= 10) {
            this.media = media;
        }
    }

    @Override
    public String toString() {
        return String.format("Id: %d\nMembro: %s\nAtividade: %s\nTipo de atividade: %s\nNota: %.1f\n",
                getId(),
                getMembro().getNome(),
                getAtividade().getNome(),
                getAtividade().getTipoAtividade(),
                getMedia());
    }
}
