package io.algopreorg.alog.containsduplicate;

import java.util.HashSet;
import java.util.Set;

public class Solution {

    public boolean containsDuplicate(int[] nums) {
        Set<Integer> uniqueNumbers = new HashSet<>();
        for (int num : nums) {
            if (!uniqueNumbers.add(num)) {
               return true;
            }
        }
        return false;
    }
}
