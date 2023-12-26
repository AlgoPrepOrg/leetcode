package io.algopreorg.alog.goodpairs;

public class Solution2 {
    
    public int numIdenticalPairs(int[] nums) {
        int pairs = 0;
        for (int i = 0; i < nums.length - 1; i++) {
            for (int j = 1; j < nums.length; j++) {
                if (i < j && nums[i] == nums[j]) {
                    pairs++;
                }
            }
        }
        
        return pairs;
    }
}
