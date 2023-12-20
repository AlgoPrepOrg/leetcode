package io.algopreorg.alog.lettercombinations;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

public class Solution {
    public List<String> letterCombinations(String digits) {
        if (digits.isBlank()) {
            return Collections.emptyList();
        }

        char[] charDigits = digits.toCharArray();
        List<List<String>> stringsList = new ArrayList<>();
        for (char digit : charDigits) {
          stringsList.add(getLetters(digit));
        }

        List<String> currentCombinations = new ArrayList<>(stringsList.get(0));
        for (int i = 1; i < stringsList.size(); i++) {
            currentCombinations = getCombinations(currentCombinations, stringsList.get(i));
        }
        return currentCombinations;
    }

    private List<String> getCombinations(List<String> letters1, List<String> letters2) {
        List<String> combinations = new ArrayList<>();
        for (String letter1 : letters1) {
            for (String letter2 : letters2) {
                combinations.add(letter1 + letter2);
            }
        }
        return combinations;
    }

    private List<String> getLetters(char digit) {
        return switch (digit) {
            case '2' -> Arrays.asList("a", "b", "c");
            case '3' -> Arrays.asList("d", "e", "f");
            case '4' -> Arrays.asList("g", "h", "i");
            case '5' -> Arrays.asList("j", "k", "l");
            case '6' -> Arrays.asList("m", "n", "o");
            case '7' -> Arrays.asList("p", "q", "r", "s");
            case '8' -> Arrays.asList("t", "u", "v");
            case '9' -> Arrays.asList("w", "x", "y", "z");
            default -> Collections.emptyList();
        };
    }
}
