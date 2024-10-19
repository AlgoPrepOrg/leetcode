package io.algopreorg.alog.generateParenthesis;

import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

public class Solution {
  private static final char OPEN = '(';
  private static final char CLOSE = ')';

  public List<String> generateParenthesis(int n) {
    var result = new ArrayList<String>();
    var stack = new Stack<Character>();

    generate(n, 0, 0, stack, result);
    return result;
  }

  private void generate(int n, int open, int close, Stack<Character> stack, List<String> result) {
    if (open == close && open == n) {
      var sb = new StringBuilder();
      for (var c : stack) {
        sb.append(c);
      }
      result.add(sb.toString());
      return;
    }

    if (open < n) {
      stack.push(OPEN);
      generate(n, open + 1, close, stack, result);
      stack.pop();
    }
    if (close < open) {
      stack.push(CLOSE);
      generate(n, open, close + 1, stack, result);
      stack.pop();
    }
  }
}
