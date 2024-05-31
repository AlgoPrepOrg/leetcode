package io.algopreorg.alog.removeduplicates;

public class Solution {
    public static void main(String[] args) {
        int[] nums = {1, 1, 2, 2, 3, 4, 5, 6, 9, 9};
        int unique = removeDuplicates(nums);

        System.out.println(unique);
    }
    public static int removeDuplicates(int[] nums) {
        if (nums.length <= 1) {
            return nums.length;
        }

        int count = 1;

        for (int i = 1; i < nums.length; i++) {
            if (nums[i - 1] != nums[i]) {
                nums[count++] = nums[i];
            }
        }

        return count;
    }
}