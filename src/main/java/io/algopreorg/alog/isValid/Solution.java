package io.algopreorg.alog.isValid;

import java.util.ArrayDeque;
import java.util.Map;

public class Solution {

  public boolean isValid(String s) {
    var dictionary = Map.of(')', '(', ']', '[', '}', '{');
    var stack = new ArrayDeque<Character>();

    for (var aChar : s.toCharArray()) {
      if (dictionary.containsKey(aChar)) {
        if (stack.isEmpty() || !stack.pop().equals(dictionary.get(aChar))) {
          return false;
        }
      } else {
        stack.push(aChar);
      }
    }

    return stack.isEmpty();
  }

  public static void main(String[] args) {
    Solution solution = new Solution();
    System.out.println(solution.isValid("]")); //false
    System.out.println(solution.isValid("[]")); //true
    System.out.println(solution.isValid("([{}])")); //true
    System.out.println(solution.isValid("[(])")); //false
  }
}
