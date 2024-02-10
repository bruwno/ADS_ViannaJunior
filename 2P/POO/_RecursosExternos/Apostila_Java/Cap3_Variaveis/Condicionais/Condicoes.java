public class Condicoes{
    public static void main(String[] args) {
        int[] idades = {12, 18, 17, 15, 45, 60, 34, 19, 15};
        boolean amigoDoDono = false;

        for (int i = 0; i < idades.length; i++) {
            int idade = idades[i];

            if (idade == 15) {
                amigoDoDono = true;
            }

            if (idade >= 18 || amigoDoDono != false) {
                System.out.println("[AUTORIZADO] A pessoa no indice [" + i + "] e maior de idade." );
            }
            else {
                System.out.println("[BARRADO] A pessoa no indice [" + i +"] e menor de idade.");
            }
        }
    }
}