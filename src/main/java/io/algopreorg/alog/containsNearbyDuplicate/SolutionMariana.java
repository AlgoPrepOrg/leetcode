package io.algopreorg.alog.containsNearbyDuplicate;

import java.util.HashMap;
import java.util.Map;

public class SolutionMariana {

    public boolean containsNearbyDuplicate(int[] nums, int k) {
        Map<Integer, Integer> numToIndex = new HashMap<>();
        for (int i = 0; i < nums.length; i++) {
            if (numToIndex.containsKey(nums[i]) && i - numToIndex.get(nums[i]) <= k) {
                return true;
            }

            numToIndex.put(nums[i], i);
        }

        return false;
    }
}
