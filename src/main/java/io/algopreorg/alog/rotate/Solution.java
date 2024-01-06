package io.algopreorg.alog.rotate;

public class Solution {

    public static void rotate(int[][] matrix) {
        //Current matrix
        /*
        1 2 3
        4 5 6
        7 8 9
         */
        transpose(matrix);


        // Reverse each row
        /*
        7 4 1
        8 5 2
        9 6 3
        */
        for (int[] row : matrix) {
            reverseArray(row);
        }
    }

    /**
     * The transpose of a matrix involves flipping the elements over its diagonal.
     * For an n x n matrix, this means swapping matrix[i][j] with matrix[j][i].
     * This nested loop goes through the upper triangle of the matrix (i < j) and swaps
     * the elements across the diagonal, effectively transposing the matrix.
     * @param matrix - return
     */
    private static void transpose(int[][] matrix) {
        // Transpose the matrix to
        /*
        1 4 7
        2 5 8
        3 6 9
        */
        int n = matrix.length;
        for (int i = 0; i < n; i++) {
            for (int j = i; j < n; j++) {
                int temp = matrix[i][j];
                matrix[i][j] = matrix[j][i];
                matrix[j][i] = temp;

                //If you want to trace every iteration.
                //System.out.println("Iteration:");
                //printMatrix(matrix);
            }
        }
    }

    /**
     * Reverse array from stat to end
     * @param arr - reversed array
     */
    public static void reverseArray(int[] arr) {
        int start = 0;
        int end = arr.length - 1;

        while (start < end) {
            int temp = arr[start];
            arr[start] = arr[end];
            arr[end] = temp;

            start++;
            end--;
        }
    }

    public static void main(String[] args) {
        System.out.println("Matrix:");
        int[][] matrix = {
                {1, 2, 3},
                {4, 5, 6},
                {7, 8, 9}
        };
        printMatrix(matrix);

        rotate(matrix);

        System.out.println("Rotated Matrix:");
        printMatrix(matrix);
    }

    private static void printMatrix(int[][] matrix) {
        for (int[] row : matrix) {
            for (int num : row) {
                System.out.print(num + " ");
            }
            System.out.println();
        }
    }
}
