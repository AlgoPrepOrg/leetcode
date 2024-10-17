package io.algopreorg.alog.validateStackSequences;

import java.util.Stack;

public class Solution {

  public boolean validateStackSequences(int[] pushed, int[] popped) {
    int i = 0;
    var stack = new Stack<Integer>();

    for (var item : pushed) {
      stack.push(item);

      while (!stack.isEmpty() && stack.peek() == popped[i]) {
        stack.pop();
        i++;
      }
    }

    return stack.isEmpty();
  }
}
