package io.algopreorg.alog.SearchInsertPosition;

public class Solution {
  public int searchInsert(int[] nums, int target) {
    int left = 0;
    int right = nums.length - 1;

    while(left <= right) {
      int middle = left + (right - left) / 2;
      int val = nums[middle];

      if(val == target) {
        return middle;
      } else if(val < target) {
        left = middle + 1;
      } else{
        right = middle - 1;
      }
    }
    return left;
  }
}
