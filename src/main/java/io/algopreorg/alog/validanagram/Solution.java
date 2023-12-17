package io.algopreorg.alog.validanagram;

import java.util.Arrays;

public class Solution {

    public boolean isAnagram(String s, String t) {
        return Arrays.equals(s.chars().sorted().toArray(),
                t.chars().sorted().toArray());
    }
}
