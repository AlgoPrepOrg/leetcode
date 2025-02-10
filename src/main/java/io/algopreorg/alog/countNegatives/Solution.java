package io.algopreorg.alog.countNegatives;

public class Solution {

  public int countNegatives(int[][] grid) {
    int sum = 0;
    for (int [] row : grid) {
      sum += countNegativesInRow(row);
    }
    return sum;
  }

  private int countNegativesInRow(int[] row) {
    int l = 0;
    int r = row.length - 1;

    while (l <= r) {
      int m = l + (r - l) / 2;

      if (row[m] < 0) {
        r = m - 1;
      } else {
        l = m + 1;
      }
    }

    if (l == row.length) {
      return 0;
    }

    return row.length - l;
  }

  public static void main(String[] args) {
    Solution solution = new Solution();
    int count = solution.countNegativesInRow(new int[] {3,2});
    System.out.println(count);
  }
}
