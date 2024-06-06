package io.algopreorg.alog.slicingwindow.longestrepeatingcharacterreplacement;

//https://leetcode.com/problems/longest-repeating-character-replacement/description/

public class SolutionRoman {

    public int characterReplacement(String s, int k) {
        if (s.isEmpty()) {
            return 0;
        }

        int[] arr = new int[26];
        int beginning = 0;
        int result = 0;
        int largestCount = 0;

        for (int end = 0; end < s.length(); end++) {

            // incrementing number of character by current end position
            arr[s.charAt(end) - 'A']++;

            // finding max number of occurences
            largestCount = Math.max(largestCount, arr[s.charAt(end) - 'A']);

            // check if current window is valid,
            // that is if the number of necessary changes is less than k
            if (end - beginning + 1 - largestCount > k) {
                // decrementing the number of character by position 'beginning'
                // as long as the window is shortened and won't be in window
                arr[s.charAt(beginning) - 'A']--;
                // shorten the window
                beginning++;
            }
            // find the max window
            result = Math.max(result, end - beginning + 1);
        }
        return result;
    }
}
