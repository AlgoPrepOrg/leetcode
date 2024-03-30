package io.algopreorg.alog.rotateimage;

public class Solution1 {

    public void rotate(int[][] matrix) {
        int length = matrix.length;

        transpose(matrix, length);
        reverse(matrix, length);
    }

    private static void reverse(int[][] matrix, int length) {
        int j, k;
        for (int i = 0; i < length; i++) {
            j = 0;
            do {
                k = length - j - 1;
                int tmp = matrix[i][j];
                matrix[i][j] = matrix[i][k];
                matrix[i][k] = tmp;
                j++;
            } while (j < k);
        }
    }

    private static void transpose(int[][] matrix, int length) {
        for (int i = 0; i < length; i++) {
            for (int j = i; j < length; j++) {
                int tmp = matrix[i][j];
                matrix[i][j] = matrix[j][i];
                matrix[j][i] = tmp;
            }
        }
    }

}
