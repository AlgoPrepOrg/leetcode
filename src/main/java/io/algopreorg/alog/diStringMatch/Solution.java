package io.algopreorg.alog.diStringMatch;

import java.util.Arrays;

public class Solution {

  public static int[] diStringMatch(String s) {
    int n = s.length();
    int[] perm = new int[n + 1];
    int low = 0;
    int high = n;

    for (int i = 0; i < n; i++) {
      char aChar = s.charAt(i);
      if (aChar == 'I') {
        perm[i] = low++;
      } else {
        perm[i] = high--;
      }
    }
    perm[n] = low;

    return perm;
  }

  public static void main(String[] args) {
    // Example test cases
    String s1 = "IDID";

    System.out.println(Arrays.toString(diStringMatch(s1))); // Example Output: [0, 4, 1, 3, 2]
  }
}
