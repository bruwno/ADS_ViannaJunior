class Casting{
    public static void main(String[] args){
        //DOUBLE para INT
        double pi = 3.14;
        int piInteiro = (int)pi;
        System.out.println("Valor de Pi = " + pi);
        System.out.println("Valor de Pi armazenado em uma variavel inteira = " + piInteiro);

        // LONG para INT
        long x = 1234567890;
        int xInteiro = (int)x;
        System.out.println("Valor de x = " + x);
        System.out.println("Valor de armazenado em  uma variavel inteira = " + xInteiro);

        // FLOAT para INT
        float y = 5.156f;
        int yInteiro = (int)y;
        System.out.println("Valor de y = " + y);
        System.out.println("Valor de y armazenado em uma variavel inteira = " + yInteiro);

        // DOUBLE para FLOAT
        double d = 5;
        float f = 3;
        float z = f + (float)d;
        System.out.println("Valor de z = " + z);
    }
}