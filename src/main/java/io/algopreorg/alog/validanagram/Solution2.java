package io.algopreorg.alog.validanagram;

import java.util.Arrays;

public class Solution2 {

    public boolean isAnagram(String s, String t) {
        char[] sChars = s.toCharArray();
        char[] tChars = t.toCharArray();
        boolean result = true;

        if (sChars.length != tChars.length) {
            return false;
        }

        Arrays.sort(sChars);
        Arrays.sort(tChars);

        for(int i=0; i< sChars.length; i++){
            if(sChars[i]!= tChars[i]) {
                result = false;
                break;
            }
        }

        return result;
    }
}
