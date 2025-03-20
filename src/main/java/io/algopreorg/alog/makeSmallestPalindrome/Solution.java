package io.algopreorg.alog.makeSmallestPalindrome;

public class Solution {
  public static String makeSmallestPalindrome(String s) {
    char[] chars = s.toCharArray();
    int n = chars.length;

    for (int i = 0; i < n / 2; i++) {
      char left = chars[i];
      char right = chars[n - i - 1];

      if (left != right) {
        chars[i] = chars[n - i - 1] = (char) Math.min(left, right);
      }
    }

    return String.valueOf(chars);
  }

  public static void main(String[] args) {
    String s = "ebcda";
    System.out.println(makeSmallestPalindrome(s)); // Expected Output: "abcba"
  }
}
