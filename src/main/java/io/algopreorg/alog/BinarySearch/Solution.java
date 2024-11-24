package io.algopreorg.alog.BinarySearch;

/**
 * https://neetcode.io/problems/binary-search
 */
public class Solution {

  public int search(int[] nums, int target) {
    int left = 0;
    int right = nums.length - 1;

    while (left <= right) {
      int mid = left + (right - left) / 2;
      if (nums[mid] == target) {
        return mid;
      } else if (nums[mid] < target) {
        left = mid + 1;
      } else if (nums[mid] > target) {
        right = mid - 1;
      }
    }

    return -1;
  }

  public static void main(String[] args) {
    Solution solution = new Solution();
    int result = solution.search(new int[] {-1, 0, 2, 4, 6, 8}, 4);
    System.out.println(result);
  }
}
