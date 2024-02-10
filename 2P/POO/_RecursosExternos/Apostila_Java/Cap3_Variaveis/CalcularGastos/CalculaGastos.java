class CalculaGastos{
    public static void main(String[] args){
        double gastosJaneiro = 15.000;
        double gastosFevereiro = 23.000;
        double gastosMarco = 17.000;

        double gastosDoTrimestre = gastosJaneiro + gastosFevereiro + gastosMarco;
        double mediaDeGastos = gastosDoTrimestre / 3;

        System.out.println("Gastos no trimestre (JAN-FEV-MAR) = R$ " + gastosDoTrimestre);
        System.out.println("Media mensal de gastos = R$ " + mediaDeGastos);
    }
}