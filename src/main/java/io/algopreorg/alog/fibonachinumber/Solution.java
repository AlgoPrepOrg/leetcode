package io.algopreorg.alog.fibonachinumber;

import java.util.HashMap;
import java.util.Map;

public class Solution {
    public int fibWithMap(int n) {
        if (n < 2) {
            return n;
        }

        Map<Integer, Integer> fibonacciMap = new HashMap<>();
        fibonacciMap.put(0, 0);
        fibonacciMap.put(1, 1);
        int compute = 0;
        for (int i = 2; i <= n; i++) {
            compute = fibonacciMap.get(i - 1) + fibonacciMap.get(i - 2);
            fibonacciMap.put(i, compute);
        }
        return compute;
    }

    public int fibWithTwoReference(int n) {
        if (n < 2) {
            return n;
        }

        int beforePrevious = 0;
        int previous = 1;
        for (int i = 2; i < n; i++) {
            int number = beforePrevious + previous;
            beforePrevious = previous;
            previous = number;
        }
        return beforePrevious + previous;
    }

    public int fibRecursively(int n) {
        if (n < 2) {
            return n;
        }

        return fibRecursively(n - 1) + fibRecursively(n - 2);
    }
}
