using System;

namespace AuxiliarSort;

public static class AuxiliarSort
{
    public static void Troca(double[] vet, int i, int j)
    {
        //Guarda o valor armazenado na posição i do vetor.
        double aux = vet[i];
        vet[i] = vet[j];
        vet[j] = aux;
    }
}
