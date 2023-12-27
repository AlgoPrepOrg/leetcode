package io.algopreorg.alog.longestsubstring;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;

public class Solution {

    public int lengthOfLongestSubstring(String s) {
        if (s.isEmpty()) {
            return 0;
        }
        
        List<String> strCharacters = s.chars()
                .mapToObj(c -> String.valueOf((char) c))
                .toList();
        
        List<String> substrings = new ArrayList<>();
        substrings.add(strCharacters.get(0));
        
        int index = 0;
        for (int i = 1; i < strCharacters.size(); i++) {
            String character = strCharacters.get(i);
            String currentSubstring = substrings.get(index);
            
            int repeatedCharIndex = currentSubstring.indexOf(character);
            if (repeatedCharIndex == -1) {
                substrings.set(index, currentSubstring + character);
            } else if (repeatedCharIndex != currentSubstring.length() - 1) {
                String newSubstring = currentSubstring.substring(repeatedCharIndex + 1) + character;
                substrings.add(newSubstring);
                index++;
            } else {
                substrings.add(character);
                index++;
            }
        }
        
        return substrings.stream()
                .max(Comparator.comparing(String::length))
                .orElse("")
                .length();
    }
    
}
