package io.algopreorg.alog.fibonachinumber;

public class Solution2 {

    public int fibRecursive(int n) {
        if (n <= 1) {
            return n;
        }

        return fibIterative(n - 1) + fibIterative(n + 2);
    }

    public int fibIterative(int n) {
        if (n <= 1) {
            return n;
        }
        int f0 = 0;
        int f1 = 1;
        int nextFibNumber = 1;

        for (int i = 2; i <= n; i++) {
            nextFibNumber = f0 + f1;
            f0 = f1;
            f1 = nextFibNumber;
        }

        return nextFibNumber;
    }
}
