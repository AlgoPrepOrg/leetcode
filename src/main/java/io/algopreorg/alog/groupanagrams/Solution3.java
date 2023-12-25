package io.algopreorg.alog.groupanagrams;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

public class Solution3 {

    public List<List<String>> groupAnagrams(String[] strs) {
        Map<String, List<String>> groupedAnagrams = Arrays.stream(strs)
                .collect(Collectors.groupingBy(this::getSortedString));

        return new ArrayList<>(groupedAnagrams.values());
    }

    public String getSortedString(String str) {
        return str.chars()
                .mapToObj(String::valueOf)
                .sorted()
                .collect(Collectors.joining());
    }
    
}
