package io.algopreorg.alog.twoSum;

/**
 * [167. Two Sum II - Input Array Is Sorted](https://leetcode.com/problems/two-sum-ii-input-array-is-sorted)
 */
public class SolutionVitalii {

    public int[] twoSum(int[] numbers, int target) {
        int left = 0;
        int right = numbers.length - 1;

        while (left < right) {
            int sum = numbers[left] + numbers[right];
            if (sum == target) {
                break;
            }
            if (sum < target) {
                left++;
            } else {
                right--;
            }
        }
        return new int[]{++left, ++right};
    }

}
