package io.algopreorg.alog.find132pattern;

import java.util.Stack;

public class Solution {
  public boolean find132pattern(int[] nums) {
    int n = nums.length;
    var stack = new Stack<Integer>();
    int secondMax = Integer.MIN_VALUE;

    for (int i = n - 1; i >= 0; i--) {
      int num = nums[i];

      if (num < secondMax) {
        return true;
      }

      while (!stack.isEmpty() && stack.peek() < num) {
        secondMax = Math.max(stack.pop(), secondMax);
      }

      stack.push(num);
    }

    return false;
  }

  public static void main(String[] args) {
    Solution solution = new Solution();
    solution.find132pattern(new int[]{1,2,3,4});
  }
}
