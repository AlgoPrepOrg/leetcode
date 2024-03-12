package io.algopreorg.alog.longestsubstring;

import java.util.HashSet;
import java.util.Set;

public class SolutionLeetCode {
    public int lengthOfLongestSubstring(String s) {
        Set<Character> characterSet = new HashSet<>();
        for (int i = 0; i < s.length(); i++) {
            if (characterSet.contains(s.charAt(i))) {
                characterSet.remove(s.charAt(i));
            } else {
                characterSet.add(s.charAt(i));

            }
        }
        return 0;
    }

}
