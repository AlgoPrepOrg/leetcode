package io.algopreorg.alog.asteroidCollision;

import java.util.Arrays;
import java.util.Stack;

public class Solution {

  public int[] asteroidCollision(int[] asteroids) {
    var stack = new Stack<Integer>();

    for (var asteroid : asteroids) {
     while (!stack.isEmpty() && asteroid< 0 && stack.peek() >0) {
        int diff = asteroid + stack.peek();
        if (diff < 0) {
          stack.pop();
        } else if (diff > 0){
          asteroid = 0;
        } else {
          asteroid = 0;
          stack.pop();
        }
     }

     if (asteroid != 0) {
       stack.push(asteroid);
     }
    }

    int i = stack.size() - 1;
    int[] res = new int[stack.size()];
    while (!stack.isEmpty()) {
      res[i--] = stack.pop();
    }

    return res;
  }

  public static void main(String[] args) {
    var solution = new Solution();
    int[] ints = solution.asteroidCollision(new int[] {5, -5});
    System.out.println(Arrays.toString(ints));
  }
}
