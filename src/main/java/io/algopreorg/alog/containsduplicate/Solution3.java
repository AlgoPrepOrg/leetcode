package io.algopreorg.alog.containsduplicate;

public class Solution3 {
    public boolean containsDuplicate(int[] nums) {
        int current = nums[0];
        for (int i = 1; i < nums.length; i++) {
            if (current == nums[i]) {
                return false;
            }
        }
        return true;
    }
}
