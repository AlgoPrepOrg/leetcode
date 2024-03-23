package io.algopreorg.alog.isPalindrome;

public class Solution {

    public boolean isPalindrome(String s) {
        var builder = new StringBuilder();

        for (char c : s.toLowerCase().toCharArray()) {
            if (Character.isLetterOrDigit(c)) {
                builder.append(c);
            }
        }

        int left = 0;
        int right = builder.length() - 1;

        while (left < right) {
            if (builder.charAt(left) != builder.charAt(right)) {
                return false;
            }
            left++;
            right--;
        }

        return true;
    }

    public static void main(String[] args) {
        var s = "0P";
        boolean isPalindrome = new Solution().isPalindrome(s);
        System.out.println(isPalindrome);
    }
}
