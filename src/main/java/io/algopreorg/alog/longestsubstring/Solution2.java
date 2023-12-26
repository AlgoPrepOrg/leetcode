package io.algopreorg.alog.longestsubstring;

import java.util.*;

public class Solution2 {

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

    public static void main(String[] args) {
        var s = "abcabcbb";

        int i = new Solution2().lengthOfLongestSubstring(s);
        System.out.println(i);
    }
    
}
