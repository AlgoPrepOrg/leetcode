package io.algopreorg.alog.ispalidrome;

import java.util.Objects;

public class SolutionMariana {

    public boolean isPalindrome(String s) {
        String str = removeNonAlphaNumeric(s);
        
        int index1 = 0;
        int index2 = str.length() - 1;
        while (index1 <= index2) {
            if (!Objects.equals(str.charAt(index1++), str.charAt(index2--))) {
                return false;
            }
        }
        
        return true;
    }
    
    private String removeNonAlphaNumeric(String s) {
        return s.replaceAll("[^a-zA-Z0-9]", "").toLowerCase();
    }
}
