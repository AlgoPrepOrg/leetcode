package io.algopreorg.alog.longestsubstring;

import java.util.HashMap;
import java.util.Map;

public class Solution3 {

    public int lengthOfLongestSubstring(String s) {
        Map<Character, Integer> charIndexMap = new HashMap<>();
        int maxLength = 0;
        int l = 0;
        for (int r = 0; r < s.length(); r++) {
            var current = s.charAt(r);
            if (charIndexMap.containsKey(current) && charIndexMap.get(current) >= l) {
                l = charIndexMap.get(current) + 1;
            } else {
                maxLength = Integer.max(r - l + 1, maxLength);
            }
            charIndexMap.put(current, r);
        }
        return maxLength;
    }

}
