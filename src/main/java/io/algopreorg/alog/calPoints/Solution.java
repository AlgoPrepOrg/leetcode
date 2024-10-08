package io.algopreorg.alog.calPoints;

import java.util.ArrayDeque;
import java.util.Deque;

public class Solution {

  public int calPoints(String[] operations) {
    Deque<Integer> stack = new ArrayDeque<>();
    int sum = 0;

    for (String operation : operations) {
      switch (operation) {
        case "D":
          int doubled = stack.peek() * 2;
          stack.push(doubled);
          sum += doubled;
          break;

        case "C":
          sum -= stack.pop();
          break;

        case "+":
          int top = stack.pop();
          int second = stack.peek();
          int newTop = top + second;
          stack.push(top);
          stack.push(newTop);
          sum += newTop;
          break;

        default:
          int value = Integer.parseInt(operation);
          stack.push(value);
          sum += value;
      }
    }

    return sum;
  }

  public static void main(String[] args) {
    Solution solution = new Solution();
    System.out.println(solution.calPoints(new String[]{"5","2","C","D","+"})); //30
    System.out.println(solution.calPoints(new String[]{"5","-2","4","C","D","9","+","+"})); //27
    System.out.println(solution.calPoints(new String[]{"1","C"})); //0
  }
}
