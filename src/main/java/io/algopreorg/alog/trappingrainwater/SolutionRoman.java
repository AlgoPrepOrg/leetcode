package io.algopreorg.alog.trappingrainwater;

// https://leetcode.com/problems/trapping-rain-water/
public class SolutionRoman {
    public int trap(int[] height) {
        // create two pointers: left and right
        int left = 0;
        int right = height.length - 1;

        // keep track of the highest level of the side
        int leftSum = height[0];
        int rightSum = height[height.length - 1];

        int result = 0;
        while (left < right) {
            if (leftSum < rightSum) {
                left++;
                if (leftSum > height[left]) {          // if the left side is higher than this side, so the water can be trapped
                    result += leftSum - height[left];
                } else {
                    leftSum = height[left];     // if no, move the pointer of the highest side to present one
                }
            } else {    // the same approach to the moving right side
                right--;
                if (rightSum > height[right]) {
                    result += rightSum - height[right];
                } else {
                    rightSum = height[right];
                }
            }
        }
        return result;
    }
}
