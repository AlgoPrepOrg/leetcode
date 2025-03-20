package io.algopreorg.alog.isPerfectSquare;

public class Solution {
  public boolean isPerfectSquare(int num) {
    if (num < 1) return false; // Edge case: Numbers less than 1 can't be perfect squares

    long low = 1, high = num; // Use long to handle potential overflow
    while (low <= high) {
      long mid = low + (high - low) / 2; // Avoid overflow
      long square = mid * mid;

      if (square == num) {
        return true;
      } else if (square < num) {
        low = mid + 1;
      } else {
        high = mid - 1;
      }
    }
    return false; // Not a perfect square
  }
}
