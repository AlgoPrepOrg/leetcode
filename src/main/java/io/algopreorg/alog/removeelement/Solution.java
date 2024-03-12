package io.algopreorg.alog.removeelement;

public class Solution {

    public static void main(String[] args) {
        int[] nums = {1, 1, 2, 4, 3, 1, 7, 10};
        int elems = removeElement(nums, 1);

        System.out.println(elems);
    }
    
    public static int removeElement(int[] nums, int val) {
        if(nums.length == 0) {
            return 0;
        } else if (nums.length == 1) {
            return nums[0] != val ? 1 : 0;
        }
        
        int count = 0;
        for (int i = 0; i < nums.length; i ++) {
            if (nums[i] != val) {
                nums[count++] = nums[i];
            }
        }
        
        return count;
    }
}
