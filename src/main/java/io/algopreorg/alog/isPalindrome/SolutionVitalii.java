package io.algopreorg.alog.isPalindrome;

/**
 * [125. Valid Palindrome](https://leetcode.com/problems/valid-palindrome/)
 */
public class SolutionVitalii {

    public boolean isPalindrome(String s) {
        char leftChar, rightChar;
        String cleanString = cleanString(s);

        int left = 0;
        int right = cleanString.length() - 1;

        while (left < right) {
            leftChar = cleanString.charAt(left);
            rightChar = cleanString.charAt(right);
            if (Character.toLowerCase(leftChar) != Character.toLowerCase(rightChar)) {
                return false;
            }
            left++;
            right--;
        }
        return true;
    }

    private static String cleanString(String s) {
        StringBuilder stringBuilder = new StringBuilder();
        for (int i = 0; i < s.length(); i++) {
            char character = s.charAt(i);
            if (Character.isLetterOrDigit(character)) {
                stringBuilder.append(character);
            }
        }
        return stringBuilder.toString();
    }


}
