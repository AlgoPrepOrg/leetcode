package io.algopreorg.alog.pairsuminarray;

import java.util.Arrays;

/**
 * Input: nums = [3,5,2,3]
 * Output: 7
 * Explanation: The elements can be paired up into pairs (3,3) and (5,2).
 * The maximum pair sum is max(3+3, 5+2) = max(6, 7) = 7.
 */

//https://leetcode.com/problems/minimize-maximum-pair-sum-in-array/description

public class SolutionRoman {

    public int minPairSum(int[] nums) {

        // sort the array
        Arrays.sort(nums);

        // two pointers moving from start and end
        int left = 0;
        int right = nums.length - 1;
        int max = 0;
        while (left < right) {
            int sum = nums[left++] + nums[right--];
            max = Math.max(sum, max);
        }
        return max;
    }
}
