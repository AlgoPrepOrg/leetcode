package io.algopreorg.alog.containerwithmostwater;


public class Solution2 {

    public int maxArea(int[] heights) {
        int currentMax = 0;
        int leftIndex = 0;
        int rightIndex = heights.length - 1;

        while (leftIndex < rightIndex) {
            int left = heights[leftIndex];
            int right = heights[rightIndex];

            int currentArea = Math.min(left, right) * (rightIndex - leftIndex);
            currentMax = Math.max(currentArea, currentMax);

            if (right > left) {
                leftIndex++;
            } else {
                rightIndex--;
            }
        }

        return currentMax;
    }
}
