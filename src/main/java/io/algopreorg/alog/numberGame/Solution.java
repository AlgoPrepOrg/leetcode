package io.algopreorg.alog.numberGame;

import java.util.Arrays;
import java.util.Collections;
import java.util.PriorityQueue;

public class Solution {
  public int[] numberGame(int[] nums) {
    PriorityQueue<Integer> quque = new PriorityQueue<>(Collections.reverseOrder());
    for (int num : nums) {
      quque.add(num);
    }

    int[] answer = new int[nums.length];
    int index = nums.length - 1;

    while (quque.size() >= 2) {
      int first = quque.poll();
      int second = quque.poll();
      answer[index--] = second;
      answer[index--] = first;
    }

    return answer;
  }

  public static void main(String[] args) {
    Solution solution = new Solution();
    int[] answer = solution.numberGame(new int[]{5,4,2,3});
    System.out.println(Arrays.toString(answer));
  }
}
