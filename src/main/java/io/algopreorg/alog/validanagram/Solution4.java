package io.algopreorg.alog.validanagram;

import java.util.Arrays;

public class Solution4 {

    public boolean isAnagram(String s, String t) {
        if (s.length() != t.length()) {
            return false;
        }
        char[] sChars = s.toCharArray();
        char[] tChars = t.toCharArray();
        Arrays.sort(sChars);
        Arrays.sort(tChars);

        int result = Arrays.compare(sChars, tChars);

        return result == 0;
    }

}
