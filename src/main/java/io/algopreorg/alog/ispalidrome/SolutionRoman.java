package io.algopreorg.alog.ispalidrome;

import java.util.function.IntPredicate;

public class SolutionRoman {

    public boolean isPalindrome(String s) {
        IntPredicate charPredicate = c -> (c >= 47 && c <= 57) || (c >= 97 && c <= 122);
        int[] array = s.toLowerCase().chars()
                .filter(charPredicate)
                .toArray();

        int j = array.length - 1;
        int k = 0;
        while (k < j) {
            if (array[k++] != array[j--]) {
                return false;
            }
        }
        return true;
    }
}
