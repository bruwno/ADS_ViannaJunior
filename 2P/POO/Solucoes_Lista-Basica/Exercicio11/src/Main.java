/*
 * Autor: William Silva (https://gitlab.com/unclWill)
 * br.com.williamsilva.utils.Data : 07/03/2024
 */

import br.com.williamsilva.utils.Data;

public class Main {
    public static void main(String[] args) {
        Data data = new Data();

        data.setDia(28);
        data.setMes(2);
        data.setAno(20234);

        data.avancaData();
        System.out.println(data);
    }
}