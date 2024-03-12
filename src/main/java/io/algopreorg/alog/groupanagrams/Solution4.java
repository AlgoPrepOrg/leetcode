package io.algopreorg.alog.groupanagrams;

import java.util.*;

public class Solution4 {

    public List<List<String>> groupAnagrams(String[] strs) {
        Map<String, List<String>> result = new HashMap<>();
        for (var str : strs) {
            String hash = getHash(str);
            if (result.containsKey(hash)) {
                result.get(hash).add(str);
            } else {
                result.put(hash, new ArrayList<>(List.of(str)));
            }
        }
        return new ArrayList<>(result.values());
    }

    private static String getHash(String str) {
        char[] charArray = str.toCharArray();
        Arrays.sort(charArray);
        return new String(charArray);
    }

}
