package io.algopreorg.alog.containerwithmostwater;

public class Solution4 {

    public int maxArea(int[] height) {
        int maxArea = 0;
        int left = 0;
        int right = height.length - 1;
        while (left != right) {
            int leftHeight = height[left];
            int rightHeight = height[right];
            int area = Integer.min(leftHeight, rightHeight) * (right - left);
            maxArea = Math.max(maxArea, area);
            if (leftHeight < rightHeight) {
                left++;
            } else {
                right--;
            }
        }

        return maxArea;
    }

}
