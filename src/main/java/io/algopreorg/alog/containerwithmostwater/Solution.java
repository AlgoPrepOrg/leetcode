package io.algopreorg.alog.containerwithmostwater;

public class Solution {

    public int maxArea(int[] height) {
        int currentMax = 0;
        int leftIndex = 0;
        int rightIndex = height.length - 1;

        while (leftIndex < rightIndex) {
            int left = height[leftIndex];
            int right = height[rightIndex];
            
            int currentArea = this.calculateArea(leftIndex, rightIndex, left, right);
            currentMax = Math.max(currentArea, currentMax);
            
            if (right > left) {
                leftIndex++;
            } else {
                rightIndex--;
            }
        }

        return currentMax;
    }
    
    private int calculateArea(int leftIndex, int rightIndex, int left, int right) {
        return Math.min(left, right) * (rightIndex - leftIndex);
    }
    
}
