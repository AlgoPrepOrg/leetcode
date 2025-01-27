package io.algopreorg.alog.largestLocal;

public class Solution {

  public int[][] largestLocal(int[][] grid) {
    int n = grid.length;
    int[][] maxLocal = new int[n - 2][n - 2];

    for (int i = 1; i < n - 1; i++) {
      for (int j = 1; j < n - 1; j++) {
        maxLocal[i - 1][j - 1] = getMaxVal(grid, i, j);
      }
    }

    return maxLocal;
  }

  private static int getMaxVal(int[][] grid, int n, int m) {
    int maxVal = Integer.MIN_VALUE;

    for (int i = n - 1; i <= n + 1; i++) {
      for (int j = m - 1; j <= m + 1; j++) {
        int currentVal = grid[i][j];
        if (currentVal > maxVal) {
          maxVal = currentVal;
        }
      }
    }
    return maxVal;
  }

  public void printMatrix(int[][] matrix) {
    for (int[] row : matrix) {
      for (int val : row) {
        System.out.print(val + " ");
      }
      System.out.println();
    }
  }

  public static void main(String[] args) {
    Solution solution = new Solution();
    int[][] grid = {
        {1, 2, 3, 4},
        {5, 6, 7, 8},
        {9, 10, 11, 12},
        {13, 14, 15, 16}
    };

    int[][] maxLocal = solution.largestLocal(grid);
    solution.printMatrix(maxLocal);
  }
}
