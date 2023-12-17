package io.algopreorg.alog.concatenationofarray;

public class Solution {

    public int[] getConcatenation(int[] nums) {
        int[] newArray = new int[2 * nums.length];
        System.arraycopy(nums, 0, newArray, 0, nums.length);
        System.arraycopy(nums, 0, newArray, nums.length, nums.length);
        return newArray;
    }
}
