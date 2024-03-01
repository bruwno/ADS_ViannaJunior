/*
 * Autor   : William Silva (https://gitlab.com/unclWill)
 * Data    : 26/02/2024
 */

import java.util.ArrayList;

public class NumerosImpares {
    private int a;
    private int b;

    public NumerosImpares() {}

    public NumerosImpares(int a, int b) {
        this.a = a;
        this.b = b;
    }

    public int getA() {
        return a;
    }

    public void setA(int a) {
        this.a = a;
    }

    public int getB() {
        return b;
    }

    public void setB(int b) {
        this.b = b;
    }

    public ArrayList<Integer> retornaListaDeImpares() {
        ArrayList<Integer> listaDeImpares = new ArrayList<>();
        if (a < b) {
            for (int i = a; i <= b; i++) {
                if (i % 2 != 0) {
                    listaDeImpares.add(i);
                }
            }
        }
        return listaDeImpares;
    }
}
