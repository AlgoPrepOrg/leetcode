package io.algopreorg.alog.longestconsecutivesequence;

import java.util.HashSet;
import java.util.Set;

public class Solution {

    public static int longestConsecutive(int[] nums) {
        if (nums.length == 0) {
            return 0;
        }
        Set<Integer> numSet = new HashSet<>();
        for (int num : nums) {
            numSet.add(num);
        }

        int maxCount = 1;
        for (int num : numSet) {
            if (!numSet.contains(num - 1)) {
                int currentNum = num;
                int currentCount = 1;

                while (numSet.contains(currentNum + 1)) {
                    currentNum++;
                    currentCount++;
                }

                maxCount = Math.max(maxCount, currentCount);
            }
        }

        return maxCount;
    }

    public static void main(String[] args) {
        int i = longestConsecutive(new int[]{0,3,7,2,5,8,4,6,0,1});
        System.out.println(i);
    }
}
