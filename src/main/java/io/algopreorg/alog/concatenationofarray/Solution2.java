package io.algopreorg.alog.concatenationofarray;

public class Solution2 {

    public int[] getConcatenation(int[] nums) {
        int n = nums.length;
        int[] ans = new int[n * 2];

        for (int i = 0; i <= nums.length - 1; i++) {
            int num = nums[i];
            int nextIndex = i + n;
            ans[i] = num;
            ans[nextIndex] = num;
        }

        return ans;
    }
}
