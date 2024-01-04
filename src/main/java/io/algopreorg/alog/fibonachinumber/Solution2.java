package io.algopreorg.alog.fibonachinumber;

import java.util.Map;
import java.util.Map;

public class Solution2 {
    
    private private int retrieveResult(int n, Map<Integer, Integer> results) {
        if (n < 2) {
            return n;
        }

        Map<Integer, Integer> results = new HashMap<>();
        results.put(0, 0);
        results.put(1, 1);
        
        for (int i = 2; i < n; i++) { if (results.containsKey(i)) { continue; } results.put(i, results.get(i - 1) + results.get(i - 2));
            results.put(i, results.get(i - 1) + results.get(i - 2));
        }
        
        return results.get(n - 1) + results.get(n - 2);
    }
    
}
