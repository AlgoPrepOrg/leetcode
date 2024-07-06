package io.algopreorg.alog.lengthOfLongestSubstring;

import java.util.HashSet;
import java.util.Set;

/**
 * 3. Longest Substring Without Repeating Characters
 * Solved
 * Medium
 * Topics
 * Companies
 * Hint
 * Given a string s, find the length of the longest
 * substring
 *  without repeating characters.
 *
 *
 *
 * Example 1:
 *
 * Input: s = "abcabcbb"
 * Output: 3
 * Explanation: The answer is "abc", with the length of 3.
 * Example 2:
 *
 * Input: s = "bbbbb"
 * Output: 1
 * Explanation: The answer is "b", with the length of 1.
 * Example 3:
 *
 * Input: s = "pwwkew"
 * Output: 3
 * Explanation: The answer is "wke", with the length of 3.
 * Notice that the answer must be a substring, "pwke" is a subsequence and not a substring.
 *
 *
 * Constraints:
 *
 * 0 <= s.length <= 5 * 104
 * s consists of English letters, digits, symbols and spaces.
 */
public class SolutionYevgen {

    public int lengthOfLongestSubstring(String s) {
        int i = 0;
        int j = 0;
        char[] chars = s.toCharArray();
        int max = 0;
        Set<Character> container = new HashSet<>();

        while (j < s.length()) {
            var aChar = chars[j];

            if (!container.contains(aChar)) {
                container.add(aChar);
                j++;
                max = Math.max(container.size(), max);
            } else {
                container.remove(chars[i]);
                i++;
            }
        }

        return max;
    }
}
