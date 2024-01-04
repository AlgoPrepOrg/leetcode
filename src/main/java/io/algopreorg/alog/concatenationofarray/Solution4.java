package io.algopreorg.alog.concatenationofarray;

public class Solution4 {

    public int[] getConcatenation(int[] nums) {
        int[] arr = new int[nums.length * 2];
        System.arraycopy(nums, 0, arr, 0, nums.length);
        System.arraycopy(nums, 0, arr, nums.length, nums.length);
        return arr;
    }

}
