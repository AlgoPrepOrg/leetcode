package io.algopreorg.alog.goodpairs;

import java.util.HashMap;
import java.util.Map;

public class Solution4 {

    public int numIdenticalPairs(int[] nums) {
        Map<Integer, Integer> frequencyMap = new HashMap<>();

        for (int current : nums) {
            Integer count = frequencyMap.getOrDefault(current, 0);
            frequencyMap.put(current, ++count);
        }

        return frequencyMap.values().stream()
                .mapToInt(Integer::intValue)
                .map(e -> (e * (e - 1)) / 2)
                .sum();
    }

}
