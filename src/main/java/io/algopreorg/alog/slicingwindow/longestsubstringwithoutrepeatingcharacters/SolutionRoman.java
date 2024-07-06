package io.algopreorg.alog.slicingwindow.longestsubstringwithoutrepeatingcharacters;

//https://leetcode.com/problems/longest-substring-without-repeating-characters/description/

public class SolutionRoman {

    public static int lengthOfLongestSubstring(String s) {

        if (s.length() <= 1) {
            return s.length();
        }

        int beginningOfWindow = 0;
        int length = 0;

        for (int i = 1; i < s.length(); i++) {
            var substring = s.substring(beginningOfWindow, i);
            if (substring.contains(String.valueOf(s.charAt(i)))) {
                int index = s.indexOf(s.charAt(i), beginningOfWindow);
                beginningOfWindow = index + 1;
            }
            length = Math.max(length, (i - beginningOfWindow + 1));
        }
        return length;
    }
}
