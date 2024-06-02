package io.algopreorg.alog.slicingwindow.besttimetobuyandsellstock;

// https://leetcode.com/problems/best-time-to-buy-and-sell-stock/description/


public class Solution {
    public int maxProfit(int[] prices) {
        if (prices.length == 0) {
            return 0;
        }

        int max = 0;
        int minIndex = 0;
        for (int i = 1; i < prices.length; i++) {
            if (prices[minIndex] > prices[i]) {
                minIndex = i;
            } else if (prices[minIndex] < prices[i]) {
                max = Math.max(max, prices[i] - prices[minIndex]);
            }
        }
        return max;
    }
}
