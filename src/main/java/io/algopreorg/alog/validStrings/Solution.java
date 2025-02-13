package io.algopreorg.alog.validStrings;

import java.util.ArrayList;
import java.util.List;

public class Solution {
  public List<String> validStrings(int n) {
    List<String> result = new ArrayList<>();
    if (n <= 0) {
      return result;
    }
    generateHelper("", n, result);
    return result;
  }

  private void generateHelper(String current, int n, List<String> result) {
    if (current.length() == n) {
      result.add(current);
      return;
    }

    generateHelper(current + "1", n, result);

    if (current.isEmpty() || current.charAt(current.length() - 1) != '0') {
      generateHelper(current + "0", n, result);
    }
  }

  public static void main(String[] args) {
    int n = 4;
    List<String> validStrings = new Solution().validStrings(n);

    System.out.println("Valid binary strings of length " + n + ":");
    for (String s : validStrings) {
      System.out.println(s);
    }
  }
}
