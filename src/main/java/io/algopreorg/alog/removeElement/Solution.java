package io.algopreorg.alog.removeElement;

import java.util.Arrays;

public class Solution {

    public static int removeElement(int[] nums, int val) {
        int addIndex = 0;

        for (int i = 0; i < nums.length; i++) {
            if (nums[i] != val) {
                nums[addIndex++] = nums[i];
            }
        }

        return addIndex;
    }

    public static void main(String[] args) {
        int i = removeElement(new int[]{3,2,2,3}, 3);
        System.out.println(i);
    }
}
