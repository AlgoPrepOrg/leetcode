package io.algopreorg.alog.fibonachinumber;

import java.util.HashMap;
import java.util.Map;

public class Solution2 {
    
    public int fib(int n) {
        if (n < 2) {
            return n;
        }

        Map<Integer, Integer> results = new HashMap<>();
        results.put(0, 0);
        results.put(1, 1);
        
        for (int i = 2; i < n; i++) {
            results.put(i, results.get(i - 1) + results.get(i - 2));
        }
        
        return results.get(n - 1) + results.get(n - 2);
    }
    
}
