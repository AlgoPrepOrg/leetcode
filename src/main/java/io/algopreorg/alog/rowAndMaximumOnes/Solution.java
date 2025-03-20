package io.algopreorg.alog.rowAndMaximumOnes;

public class Solution {
  public int[] rowAndMaximumOnes(int[][] mat) {
    int maxOnes = 0;
    int rowIndex = -1;

    for (int i = 0; i < mat.length; i++) {
      int countOnes = countOnesInRow(mat[i]);

      if (countOnes > maxOnes) {
        maxOnes = countOnes;
        rowIndex = i;
      }
    }

    return new int[]{rowIndex, maxOnes};
  }

  private int countOnesInRow(int[] row) {
    int count = 0;
    for (int num : row) {
      if (num == 1) {
        count++;
      }
    }
    return count;
  }

  public static void main(String[] args) {
    new Solution().rowAndMaximumOnes(new int[][]{new int[]{0,1}, new int[]{1,0}});
  }
}
