package io.algopreorg.alog.evalRPN;

import java.util.Stack;

public class Solution {
  public int evalRPN(String[] tokens) {
    var stack = new Stack<Integer>();

    for (var token : tokens) {
      if ("+".equals(token)) {
        stack.push(stack.pop() + stack.pop());
      } else if ("-".equals(token)) {
        var first = stack.pop();
        var second = stack.pop();
        stack.push(second - first);
      } else if ("*".equals(token)) {
        stack.push(stack.pop() * stack.pop());
      } else if ("/".equals(token)) {
        var first = stack.pop();
        var second = stack.pop();
        stack.push(second / first);
      } else {
        stack.push(Integer.parseInt(token));
      }
    }

    return  stack.pop();
  }

  public static void main(String[] args) {
    Solution solution = new Solution();
    System.out.println(solution.evalRPN(new String[]{"1","2","+","3","*","4","-"})); // 5
    System.out.println(solution.evalRPN(new String[]{"4","13","5","/","+"})); // 5
  }
}
