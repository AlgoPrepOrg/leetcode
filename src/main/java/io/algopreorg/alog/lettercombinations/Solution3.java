package io.algopreorg.alog.lettercombinations;

import java.util.*;

public class Solution3 {

    private static final Map<Character, List<String>> mapping = Map.of(
            '2', List.of("a", "b", "c"),
            '3', List.of("d", "e", "f"),
            '4', List.of("g", "h", "i"),
            '5', List.of("j", "k", "l"),
            '6', List.of("m", "n", "o"),
            '7', List.of("p", "q", "r", "s"),
            '8', List.of("t", "u", "v"),
            '9', List.of("w", "x", "y", "z")
    );

    public List<String> letterCombinations(String digits) {
        if (digits.isEmpty()) {
            return Collections.emptyList();
        }

        char[] numbersChars = digits.toCharArray();
        List<List<String>> numberLetters = new ArrayList<>();
        
        for (char numChar : numbersChars) {
            numberLetters.add(mapping.get(numChar));
        }

        List<String> result = new ArrayList<>(numberLetters.get(0));

        int i = 1;
        while(i < numberLetters.size()) {
            result = this.combine(result, numberLetters.get(i));
            i++;
        }

        return result;
    }
    
    private List<String> combine(List<String> list1, List<String> list2) {
        List<String> result = new ArrayList<>();
        
        list1.forEach(str1 -> list2.forEach(str2 -> result.add(str1 + str2)));
        
        return result;
    }
    
}
