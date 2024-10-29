package io.algopreorg.alog.decodeString;

import java.util.Stack;

public class Solution {
  public String decodeString(String s) {
    StringBuilder res = new StringBuilder();
    Stack<Integer> counts = new Stack<>();
    Stack<String> words = new Stack<>();
    int index = 0;

    while (index < s.length()) {
      if (Character.isDigit(s.charAt(index))) {
        int start = index;
        while (Character.isDigit(s.charAt(index))) {
          index++;
        }
        counts.push(Integer.parseInt(s.substring(start, index)));
      }
      else if (s.charAt(index) == '[') {
        words.push(res.toString());
        res = new StringBuilder();
        index++;
      }
      else if (s.charAt(index) == ']') {
        res = new StringBuilder(words.pop() + res.toString().repeat(counts.pop()));
        index++;
      }
      else {
        res.append(s.charAt(index++));
      }
    }
    return res.toString();
  }
}
