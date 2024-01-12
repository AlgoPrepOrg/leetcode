package io.algopreorg.alog.containerwithmostwater;

public class Solution3 {
    public int maxArea(int[] height) {
        int max = 0;
        int length = height.length;
        int right = 0, i = 0;
        int left = 0, j = length - 1;
        while (i != j) {
            right = height[i];
            left = height[j];
            var smallest = Math.min(right, left);
            max = Math.max(max, smallest * (j - i));

            if (right < left) {
                i++;
            } else {
                j--;
            }
        }
        return max;
    }
}
