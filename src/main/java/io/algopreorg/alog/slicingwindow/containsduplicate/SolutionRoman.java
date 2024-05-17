package io.algopreorg.alog.slicingwindow.containsduplicate;

import java.util.HashSet;
import java.util.Set;

// https://leetcode.com/problems/contains-duplicate-ii/description/


public class SolutionRoman {
    public boolean containsNearbyDuplicate(int[] nums, int k) {
        Set<Integer> set = new HashSet<>();
        int j = 0;
        for (int num : nums) {
            if (set.size() > k) {
                set.remove(nums[j++]);
            }
            if (!set.add(num)) {
                return true;
            }
        }
        return false;
    }
}
