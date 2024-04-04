package br.com.williamsilva.participantepesquisa;

public class Habitante extends Pessoa {
    public Habitante() {}

    public Habitante(Generos sexo, CoresOlhos corDosOlhos, CoresCabelos corDosCabelos, double altura, int idade) {
        setSexo(sexo);
        setCorDosOlhos(corDosOlhos);
        setCorDosCabelos(corDosCabelos);
        setAltura(altura);
        setIdade(idade);
    }

    // Métodos.
    public double calcularMenorAltura() {
        double menorAltura = getListaDePessoas().get(0).getAltura();
        for (Pessoa habitante : getListaDePessoas()) {
            if (habitante.getAltura() < menorAltura) {
                menorAltura = habitante.getAltura();
            }
        }
        return menorAltura;
    }

    public double calcularMaiorAltura() {
        double maiorAltura = getListaDePessoas().get(0).getAltura();
        for (Pessoa habitante : getListaDePessoas()) {
            if (habitante.getAltura() > maiorAltura) {
                maiorAltura = habitante.getAltura();
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

        for (Pessoa habitante : getListaDePessoas()) {
            if (ehMulher(habitante)) {
                somaAlturas += habitante.getAltura();
                qtdMulheres++;
            }
        }

        mediaAlturas = somaAlturas / qtdMulheres;
        return mediaAlturas;
    }

    public int calcularQtdHabitantesSexoMasculino() {
        int qtdHomens = 0;

        for (Pessoa habitante : getListaDePessoas()) {
            if (ehHomem(habitante)) {
                qtdHomens++;
            }
        }
        return qtdHomens;
    }

    public int calcularQtdHabitantesSexoFeminino() {
        int qtdMulheres = 0;
        for (Pessoa habitante : getListaDePessoas()) {
            if (ehMulher(habitante)) {
                qtdMulheres++;
            }
        }
        return qtdMulheres;
    }

    public String obterPercentDeHomensEMulheres() {
        return String.format(
                "Homens: %.2f%% | " +
                "Mulheres: %.2f%%",
                calcularPercentDeHomens(),
                calcularPercentDeMulheres());
    }

    public double obterPercentLoirasOlhosVerdes() {
        int totalMulheres = 0;
        double percentual;

        if (calcularQtdHabitantesSexoFeminino() == 0) {
            return 0.0;
        }

        for (Pessoa habitante : getListaDePessoas()) {
            if (ehMulher(habitante) && ehDaFaixaEtaria1835Anos(habitante)) {
                if (temOlhosVerdes(habitante) && (temCabelosLouros(habitante))) {
                    totalMulheres++;
                }
            }
        }

        percentual = ((double) totalMulheres / calcularQtdHabitantesSexoFeminino()) * 100.0;
        return percentual;
    }

    private int calcularTotalHabitantes() {
        return getListaDePessoas().size();
    }

    private double calcularPercentDeHomens() {
        return ((double) calcularQtdHabitantesSexoMasculino() / calcularTotalHabitantes()) * 100.0;
    }

    private double calcularPercentDeMulheres() {
        return ((double) calcularQtdHabitantesSexoFeminino() / calcularTotalHabitantes()) * 100.0;
    }

    private boolean ehHomem(Pessoa habitante) {
        return habitante.getSexo().equals(Generos.MASCULINO);
    }

    private boolean ehMulher(Pessoa habitante) {
        return habitante.getSexo().equals(Generos.FEMININO);
    }

    private boolean ehDaFaixaEtaria1835Anos(Pessoa habitante) {
        return habitante.getIdade() >= 18 && habitante.getIdade() <= 35;
    }

    private boolean temOlhosVerdes(Pessoa habitante) {
        return habitante.getCorDosOlhos().equals(CoresOlhos.VERDES);
    }

    private boolean temCabelosLouros(Pessoa habitante) {
        return habitante.getCorDosCabelos().equals(CoresCabelos.LOUROS);
    }
}
