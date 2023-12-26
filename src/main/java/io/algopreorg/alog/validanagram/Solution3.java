package io.algopreorg.alog.validanagram;

import java.util.stream.Collectors;

public class Solution3 {

    public boolean isAnagram(String s, String t) {
        return this.convertToSortedString(s).equals(this.convertToSortedString(t));
    }

    private String convertToSortedString(String s) {
        return s.chars()
                .mapToObj(String::valueOf)
                .sorted()
                .collect(Collectors.joining());
    }
    
}
