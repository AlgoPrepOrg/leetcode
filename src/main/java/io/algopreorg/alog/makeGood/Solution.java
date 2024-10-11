package io.algopreorg.alog.makeGood;

import java.util.Stack;

public class Solution {
  private char toLowerCase(char c) {
    if (c >= 'A' && c <= 'Z') {
      return (char) (c + 32);
    }
    return c;
  }

  public String makeGood(String s) {
    int i = 0;
    char[] aChars = s.toCharArray();
    var stack = new Stack<Character>();

    while (i < aChars.length) {
      char aChar = aChars[i];

      if (stack.isEmpty()) {
        stack.push(aChar);
      } else {
        Character pop = stack.peek();
        if (aChar != pop && toLowerCase(pop) == toLowerCase(aChar)) {
          stack.pop();
        } else {
          stack.push(aChar);
        }
      }
      i++;
    }

    var sb = new StringBuilder(stack.size());
    while (!stack.isEmpty()) {
      sb.insert(0, stack.pop());
    }

    return sb.toString();
  }

  public static void main(String[] args) {
    Solution solution = new Solution();
    System.out.println(solution.makeGood("leEeetcode"));
  }
}
