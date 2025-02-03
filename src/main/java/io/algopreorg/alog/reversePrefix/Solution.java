package io.algopreorg.alog.reversePrefix;

public class Solution {

  public String reversePrefix(String word, char ch) {
    int index = word.indexOf(ch);
    if (index == -1) {
      return word;
    }

    var sb = new StringBuilder(word.substring(0, index + 1)).reverse();
    return sb.append(word.substring(index + 1)).toString();
  }

  public static void main(String[] args) {
    Solution solution = new Solution();
    System.out.println(solution.reversePrefix("abcd", 'z'));
  }
}
