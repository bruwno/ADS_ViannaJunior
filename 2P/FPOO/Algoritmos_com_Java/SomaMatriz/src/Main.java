public class Main {
    public static void main(String[] args) throws Exception {
        int[][] matriz1 = new int[][] {{1,2},{2,2}};
        int[][] matriz2 = new int[][] {{2,1},{3,2}};

        System.out.println("MATRIZ 1");
        imprimirMatriz(matriz1);
        System.out.println("\nMATRIZ 2");
        imprimirMatriz(matriz2);

        somarMatrizes(matriz1, matriz2);
    }

    public static void somarMatrizes(int[][] mat1, int[][] mat2) {
        if (mat1.length == mat2.length) {
            System.out.println("\nSOMA DE MATRIZES QUADRADAS");
        } else {
            System.out.println("\n[ERRO] Não é possível somar matrizes de tamanhos diferentes.");
            return;
        }
        
        for (int i = 0; i < mat1.length; i++) {
            for (int j = 0; j < mat2[i].length; j++) { // mat2[i].length pois a matriz pode não ser quadrada.
                int soma = mat1[i][j] + mat2[i][j];
                System.out.print(soma);
            }
            System.out.println();
        }
    }

    public static void imprimirMatriz(int[][] mat) {
        System.out.println("MATRIZ IMPRESSA");
        for (int i = 0; i < mat.length; i++) {
            for (int j = 0; j < mat[i].length; j++) {
                System.out.print(mat[i][j]);
            }
            System.out.println();
        }
    }
}
