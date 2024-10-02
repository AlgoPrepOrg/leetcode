package io.algopreorg.alog.slicingwindow.permutationinstring;

import java.util.Arrays;

//https://leetcode.com/problems/permutation-in-string/description/

public class SolutionRoman {
    public static void main(String[] args) {
        var s1 = "ab";
        var s2 = "eidboaooo";
        System.out.println(checkInclusion(s1, s2));
    }

    public static boolean checkInclusion(String s1, String s2) {
        if (s2.length() < s1.length()) {
            return false;
        }

        // create array for frequency of smaller string
        int[] freq = new int[26];
        for (int i = 0; i < s1.length(); i++) {
            freq[s1.charAt(i) - 'a']++;
        }


        for (int j = 0; j <= s2.length() - s1.length(); j++) {
          int[] s2freq = new int[26];

          // populate each window from larger sting
            for (int i = 0; i < s1.length(); i++) {
                s2freq[s2.charAt(i+j) - 'a']++;
            }

            if (Arrays.equals(freq, s2freq)) {
                return true;
            }
        }
        return false;
    }
}
