package io.algopreorg.alog.lettercombinations;

import java.util.ArrayList;

import java.util.List;

public class Solution2 {

    private static final String[] KEYPAD = {
            "",     // 0
            "",     // 1
            "abc",  // 2
            "def",  // 3
            "ghi",  // 4
            "jkl",  // 5
            "mno",  // 6
            "pqrs", // 7
            "tuv",  // 8
            "wxyz"  // 9
    };

    public List<String> letterCombinations(String digits) {
        List<String> result = new ArrayList<>();

        if (digits == null || digits.isEmpty()) {
            return result;
        }

        result.add("");

        for (char digit : digits.toCharArray()) {
            String letters = KEYPAD[digit - '0'];
            List<String> temp = new ArrayList<>();

            for (String combination : result) {
                for (char letter : letters.toCharArray()) {
                    temp.add(combination + letter);
                }
            }

            result = temp;
        }

        return result;
    }

    public static void main(String[] args) {
        Solution2 lc = new Solution2();
        String digits = "23";
        List<String> combinations = lc.letterCombinations(digits);
        System.out.println(combinations); // Output: ["ad","ae","af","bd","be","bf","cd","ce","cf"]
    }
}
