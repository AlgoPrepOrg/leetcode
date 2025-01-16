package io.algopreorg.alog.thirdMax;

import java.util.HashSet;
import java.util.PriorityQueue;

class Solution {
  public int thirdMax(int[] nums) {
    var minHeap = new PriorityQueue<Integer>();
    var taken = new HashSet<Integer>();

    for (int num : nums) {
      if (taken.contains(num)) {
        continue;
      }

      if (minHeap.size() == 3) {
        if (minHeap.peek() < num) {
          taken.remove(minHeap.poll());

          minHeap.add(num);
          taken.add(num);
        }
      } else {
        minHeap.add(num);
        taken.add(num);
      }
    }

    if (minHeap.size() == 1) {
      return minHeap.peek();
    }

    if (minHeap.size() == 2) {
      int firstNum = minHeap.poll();
      return Math.max(firstNum, minHeap.peek());
    }

    return minHeap.peek();
  }

  public static void main(String[] args) {
    Solution solution = new Solution();
    System.out.println(solution.thirdMax(new int[]{1, 2}));
  }
}
