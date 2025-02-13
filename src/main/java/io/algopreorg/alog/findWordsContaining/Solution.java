package io.algopreorg.alog.findWordsContaining;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Solution {

  public List<Integer> findWordsContaining(String[] words, char x) {
      List<Integer> result = new ArrayList<>();
      int index = 0;
      for (var word : words) {
        word.indexOf(x);
        char[] charArray = word.toCharArray();
        for(char c : charArray) {
          if (c == x) {
            result.add(index);
            break;
          }
        }
        index++;
      }

      return result;
  }

  public static void main(String[] args) {
    Solution solution = new Solution();
    System.out.println(Arrays.toString(solution.findWordsContaining(new String[]{"abc","bcd","aaaa","cbc"}, 'a').toArray()));
  }
}
