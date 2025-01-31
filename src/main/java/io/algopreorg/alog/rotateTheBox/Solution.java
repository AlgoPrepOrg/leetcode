package io.algopreorg.alog.rotateTheBox;

import java.util.Arrays;

class Solution {

  public static char[][] rotateTheBox(char[][] boxGrid) {
    int m = boxGrid.length;
    int n = boxGrid[0].length;
    char[][] rotated = new char[n][m];

    // Initialize the rotated matrix with empty spaces
    for (char[] row : rotated) {
      Arrays.fill(row, '.');
    }

    // Rotate the box
    for (int i = 0; i < m; i++) {
      for (int j = 0; j < n; j++) {
        rotated[j][m - 1 - i] = boxGrid[i][j];
      }
    }

    // Apply gravity
    for (int j = 0; j < m; j++) {
      int emptyRow = n - 1;
      for (int i = n - 1; i >= 0; i--) {
        if (rotated[i][j] == '#') {
          rotated[i][j] = '.';
          rotated[emptyRow--][j] = '#';
        } else if (rotated[i][j] == '*') {
          emptyRow = i - 1;
        }
      }
    }

    return rotated;
  }

  public static void main(String[] args) {
    char[][] boxGrid = {
        {'#', '.', '#'}
    };

    char[][] result = Solution.rotateTheBox(boxGrid);

    for (char[] row : result) {
      System.out.println(Arrays.toString(row));
    }
  }
}
