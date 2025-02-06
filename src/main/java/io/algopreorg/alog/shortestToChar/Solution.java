package io.algopreorg.alog.shortestToChar;

import java.util.Arrays;

public class Solution {
  public int[] shortestToChar(String s, char c) {
    int n = s.length();
    int[] answer = new int[n];

    for (int i = 0; i < n; i++) {
      answer[i] = getMinDistance(s, c, n, i);
    }
    return answer;
  }

  private static int getMinDistance(String s, char c, int n, int i) {
    int minDistance = Integer.MAX_VALUE;

    for (int j = 0; j < n; j++) {
      if (s.charAt(j) == c) {
        minDistance = Math.min(minDistance, Math.abs(i - j));
      }
    }

    return minDistance;
  }


  public int[] shortestToCharOptimal(String s, char c) {
    int n = s.length();
    int[] answer = new int[n];

    int prev = -n; // Set to a large negative value
    for (int i = 0; i < n; i++) {
      if (s.charAt(i) == c) {
        prev = i;
      }
      answer[i] = i - prev;
    }

    prev = 2 * n; // Set to a large positive value
    for (int i = n - 1; i >= 0; i--) {
      if (s.charAt(i) == c) {
        prev = i;
      }
      answer[i] = Math.min(answer[i], prev - i);
    }

    return answer;
  }


  public static void main(String[] args) {
    int[] ints = new Solution().shortestToChar("abc", 'c');
    System.out.println(Arrays.toString(ints));
  }
}
