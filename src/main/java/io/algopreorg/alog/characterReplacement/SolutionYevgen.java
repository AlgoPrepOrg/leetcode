package io.algopreorg.alog.characterReplacement;

/**
 * 424. Longest Repeating Character Replacement
 * Solved
 * Medium
 * Topics
 * Companies
 * You are given a string s and an integer k. You can choose any character of the string and change it to any other uppercase English character. You can perform this operation at most k times.
 *
 * Return the length of the longest substring containing the same letter you can get after performing the above operations.
 *
 *
 *
 * Example 1:
 *
 * Input: s = "ABAB", k = 2
 * Output: 4
 * Explanation: Replace the two 'A's with two 'B's or vice versa.
 * Example 2:
 *
 * Input: s = "AABABBA", k = 1
 * Output: 4
 * Explanation: Replace the one 'A' in the middle with 'B' and form "AABBBBA".
 * The substring "BBBB" has the longest repeating letters, which is 4.
 * There may exists other ways to achieve this answer too.
 *
 *
 * Constraints:
 *
 * 1 <= s.length <= 105
 * s consists of only uppercase English letters.
 * 0 <= k <= s.length
 */
public class SolutionYevgen {

    public int characterReplacement(String s, int k) {
        int[] charCounts = new int[26];

        int start = 0;
        int max = 0;

        int res = 0;

        for(int end = 0; end < s.length(); end++) {
            int currentCount = ++charCounts[index(s, end)];
            max = Math.max(max, currentCount);

            while (end - start - max + 1 > k) {
                charCounts[index(s, start)]--;
                start++;
            }

            res = Math.max(res, end - start + 1);
        }


        return res;
    }

    private int index(String source, int position) {
        return source.charAt(position) - 'A';
    }
}
