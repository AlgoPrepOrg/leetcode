package io.algopreorg.alog.SquaresOfSortedArray;

public class Solution {

  public int[] sortedSquares(int[] nums) {
    int[] res = new int[nums.length];

    int left = 0;
    int right = nums.length - 1;

    while (left < right) {
      int leftVal = Math.abs(nums[left]);
      int rightVal = Math.abs(nums[right]);

      if (leftVal > rightVal) {
        res[right] = leftVal;
        right--;
      } else if (leftVal <= rightVal){
        res[left] = rightVal;
      }
    }
    return res;
  }
}
