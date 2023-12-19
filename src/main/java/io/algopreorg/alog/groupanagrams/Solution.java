package io.algopreorg.alog.groupanagrams;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

public class Solution {
    public List<List<String>> groupAnagrams(String[] strs) {
        Map<String, List<String>> listMap = new HashMap<>();
        Arrays.stream(strs)
                .forEach(str -> {
                    String sortString = sortString(str);
                    listMap.computeIfAbsent(sortString, k -> new ArrayList<>()).add(str);
                });
        return new ArrayList<>(listMap.values());
    }

    private String sortString(String str) {
        return str.chars()
                .sorted()
                .mapToObj(String::valueOf)
                .collect(Collectors.joining());
    }
}
