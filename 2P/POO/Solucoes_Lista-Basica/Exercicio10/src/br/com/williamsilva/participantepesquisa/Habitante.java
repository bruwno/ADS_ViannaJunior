package br.com.williamsilva.participantepesquisa;

import java.util.ArrayList;

public class Habitante extends Pessoa {
    private ArrayList<Habitante> listaDeHabitantes;

    private final Character MASCULINO = Generos.MASCULINO.getGenero();
    private final Character FEMININO = Generos.FEMININO.getGenero();

    private final String OLHOS_VERDES = CoresOlhos.VERDES.getCorDosOlhos();
    private final String CABELOS_LOUROS = CoresCabelos.LOUROS.getCorDosCabelos();

    public Habitante() {
        listaDeHabitantes = new ArrayList<>();
    }

    public Habitante(Character sexo, String corDosOlhos, String corDosCabelos, double altura, int idade) {
        setSexo(sexo);
        setCorDosOlhos(corDosOlhos);
        setCorDosCabelos(corDosCabelos);
        setAltura(altura);
        setIdade(idade);
        listaDeHabitantes = new ArrayList<>();
    }

    public ArrayList<Habitante> getListaDeHabitantes() {
        return listaDeHabitantes;
    }

    public void addHabitante(Habitante habitante) {
        listaDeHabitantes.add(habitante);
    }

    // Métodos.
    public double calcularMenorAltura() {
        double menorAltura = listaDeHabitantes.get(0).getAltura();
        for (Habitante h : listaDeHabitantes) {
            if (h.getAltura() < menorAltura) {
                menorAltura = h.getAltura();
            }
        }
        return menorAltura;
    }

    public double calcularMaiorAltura() {
        double maiorAltura = listaDeHabitantes.get(0).getAltura();
        for (Habitante h : listaDeHabitantes) {
            if (h.getAltura() > maiorAltura) {
                maiorAltura = h.getAltura();
            }
        }
        return maiorAltura;
    }

    public double calcularMediaAlturaMulheres() {
        double somaAlturas = 0.0, mediaAlturas = 0.0;
        int qtdMulheres = 0;

        if (calcularQtdHabitantesSexoFeminino() == 0) {
            return 0.0;
        }

        for (Habitante h : listaDeHabitantes) {
            if (h.getSexo() == FEMININO) {
                somaAlturas += h.getAltura();
                qtdMulheres++;
            }
        }

        mediaAlturas = somaAlturas / qtdMulheres;
        return mediaAlturas;
    }

    public int calcularQtdHabitantesSexoMasculino() {
        int qtdHomens = 0;

        for (Habitante h : listaDeHabitantes) {
            if (h.getSexo() == MASCULINO) {
                qtdHomens++;
            }
        }
        return qtdHomens;
    }

    public int calcularQtdHabitantesSexoFeminino() {
        int qtdMulheres = 0;
        for (Habitante h : listaDeHabitantes) {
            if (h.getSexo() == FEMININO) {
                qtdMulheres++;
            }
        }
        return qtdMulheres;
    }

    public String obterPorcentDeHomensEMulheres() {
        return String.format("Homens: %.2f%% | " +
                "Mulheres: %.2f%%",
                calcularPorcentDeHomens(),
                calcularPorcentDeMulheres());
    }

    public double obterPorcentLoirasOlhosVerdes() {
        int totalMulheres = 0;
        double percentual;

        if (calcularQtdHabitantesSexoFeminino() == 0) {
            return 0.0;
        }

        for (Habitante h : listaDeHabitantes) {
            if ((h.getSexo() == FEMININO) && (h.getIdade() >= 18 && h.getIdade() <= 35)) {
                if (h.getCorDosOlhos().equals(OLHOS_VERDES) && h.getCorDosCabelos().equals(CABELOS_LOUROS)) {
                    totalMulheres++;
                }
            }
        }

        percentual = ((double) totalMulheres / calcularQtdHabitantesSexoFeminino()) * 100.0;
        return percentual;
    }

    private int calcularTotalHabitantes() {
        return listaDeHabitantes.size();
    }

    private double calcularPorcentDeHomens() {
        return ((double) calcularQtdHabitantesSexoMasculino() / calcularTotalHabitantes()) * 100.0;
    }

    private double calcularPorcentDeMulheres() {
        return ((double) calcularQtdHabitantesSexoFeminino() / calcularTotalHabitantes()) * 100.0;
    }
}
