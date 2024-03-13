/*
 * Autor: William Silva (https://gitlab.com/unclWill)
 * br.com.williamsilva.utils.Data : 07/03/2024
 */

import br.com.williamsilva.utils.Data;

public class Main {
    public static void main(String[] args) {
        Data data = new Data(29,2,1996);

        //data.setDia(31);
        //data.setMes(6);
        //data.setAno(1996);

        data.avancaData();
        System.out.println(data);
    }
}