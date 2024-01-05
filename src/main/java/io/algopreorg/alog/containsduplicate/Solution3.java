package io.algopreorg.alog.containsduplicate;

import java.util.HashSet;
import java.util.Set;

public class Solution3 {
    public boolean containsDuplicate(int[] nums) {
        Set<Integer> uniqueNums = new HashSet<>();
        for (int num : nums) {
            if (uniqueNums.contains(num)) {
                return true;
            }
            uniqueNums.add(num);
        }
        return false;
    }
}
