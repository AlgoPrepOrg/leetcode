package io.algopreorg.alog.sortVowels;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.HashSet;
import java.util.Set;

public class Solution {

  public String sortVowels(String s) {
    Set<Character> vowelsDictionary = new HashSet<>(Arrays.asList('a', 'e', 'i', 'o', 'u', 'A', 'E', 'I', 'O', 'U'));

    var vowels = new ArrayList<Character>();
    char[] input = s.toCharArray();
    for (var vowel : input) {
      if (vowelsDictionary.contains(vowel)) {
        vowels.add(vowel);
      }
    }

    Collections.sort(vowels);

    var result = new StringBuilder();
    int vowelIndex = 0;
    for (var vowel : input) {
      if (vowelsDictionary.contains(vowel)) {
        result.append(vowels.get(vowelIndex++));
      } else {
        result.append(vowel);
      }
    }

    return result.toString();
  }

  public static void main(String[] args) {
    System.out.println(new Solution().sortVowels("lYmpH"));
  }
}
