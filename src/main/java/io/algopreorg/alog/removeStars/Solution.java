package io.algopreorg.alog.removeStars;

import java.util.ArrayDeque;

public class Solution {

  private static final Character STAR = '*';

  public String removeStars(String s) {
    var stack = new ArrayDeque<>();
    for (var aChar: s.toCharArray()) {
      if (STAR.equals(aChar)) {
        stack.pop();
      } else {
        stack.push(aChar);
      }
    }

    var sb = new StringBuilder();
    while (!stack.isEmpty()) {
      sb.append(stack.pop());
    }
    return sb.reverse().toString();
  }

  public static void main(String[] args) {
    Solution solution = new Solution();
    System.out.println(solution.removeStars("leet**cod*e")); //"lecoe"
    System.out.println(solution.removeStars("erase*****")); //""
  }
}
