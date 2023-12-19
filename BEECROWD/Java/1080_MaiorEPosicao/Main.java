/*
 * Objetivo : Encontrar entre 100 npumeros e maior valor e a sua posição.
 * Autor : William Silva (https://github.com/unclWill)
 * Data : 19/12/2023
 * Tipo : 1 (INICIANTE)
 * ID : 1080
 * Nome : Maior e Posição
 * Link : https://www.beecrowd.com.br/judge/pt/problems/view/1080
 */

import java.io.IOException;
import java.util.Scanner;

public class Main {
    static final int dimArray = 100;

    public static void main(String[] args) throws IOException {
        int[] nums = new int[dimArray];
        Scanner readLine = new Scanner(System.in);

        for (int i = 0; i < nums.length; i++) {
            nums[i] = readLine.nextInt();
        }
        readLine.close();

        int maior = 0, posicao = 0;
        for (int i = 0; i < nums.length; i++) {
            if (nums[i] > maior) {
                maior = nums[i];
                posicao = i + 1;
            }
        }
        System.out.printf("%d\n%d\n", maior, posicao);
    }
}