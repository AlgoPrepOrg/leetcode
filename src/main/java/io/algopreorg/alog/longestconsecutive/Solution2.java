package io.algopreorg.alog.longestconsecutive;

import java.util.HashSet;
import java.util.Set;

public class Solution2 {
    public int longestConsecutive(int[] nums) {
        int result = 0;
        Set<Integer> set = new HashSet<>();
        for (int num : nums) {
            set.add(num);
        }

        for (int num : nums) {
            int max = 1;
            var current = num;
            while (set.contains(--current)) {
                max++;
                set.remove(current);
            }

            current = num;
            while (set.contains(++current)) {
                max++;
                set.remove(current);
            }
            result = Math.max(result, max);
        }
        return result;
    }
}
