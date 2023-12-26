package io.algopreorg.alog.containsduplicate;

import java.util.Arrays;

public class Solution2 {

    public boolean containsDuplicate(int[] nums) {
        return Arrays.stream(nums).distinct().count() != nums.length;
    }
    
}
