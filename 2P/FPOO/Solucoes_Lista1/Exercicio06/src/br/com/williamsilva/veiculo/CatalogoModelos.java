package br.com.williamsilva.veiculo;

import java.util.HashMap;
import java.util.Map;

import static br.com.williamsilva.opcionaiscarro.TiposDePintura.PADRAO;

public class CatalogoModelos {
    private Map<Integer, ModeloCarro> modelosDisponiveis;

    public CatalogoModelos() {
        modelosDisponiveis = new HashMap<>();
        modelosDisponiveis.put(1,
                new ModeloCarro("Gol", "Volkswagen", PADRAO.getTipoPintura(), new Motor(1.0), false, 40000));
        modelosDisponiveis.put(2,
                new ModeloCarro("HB20", "Hyundai", PADRAO.getTipoPintura(), new Motor(1.6), false, 86000.0));
        modelosDisponiveis.put(3,
                new ModeloCarro("Mustang", "Ford", PADRAO.getTipoPintura(), new Motor(5.0), true, 500000.0));
        modelosDisponiveis.put(4,
                new ModeloCarro("Accord", "Honda", PADRAO.getTipoPintura(), new Motor(3.5), true, 93000.0));
    }

    public void adicionaModelo(ModeloCarro modelo, int id) {
        modelosDisponiveis.put(id, modelo);
    }

    public void removeModelo(int id) {
        modelosDisponiveis.remove(id);
    }

    public ModeloCarro getModelo(int id) {
        return modelosDisponiveis.get(id);
    }

    public Map<Integer, ModeloCarro> retonarModelosDisponiveis() {
        return modelosDisponiveis;
    }
}
