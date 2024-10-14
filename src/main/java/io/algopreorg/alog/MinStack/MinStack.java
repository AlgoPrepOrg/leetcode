package io.algopreorg.alog.MinStack;

import java.util.Stack;

public class MinStack {

  private final Stack<Integer> stack;
  private final Stack<Integer> minStack;

  public MinStack() {
    this.stack = new Stack<>();
    this.minStack = new Stack<>();
  }

  public void push(int val) {
    stack.push(val);
    minStack.push(Math.min(val, minStack.isEmpty() ? val : minStack.peek()));
  }

  public void pop() {
    stack.pop();
    minStack.pop();
  }

  public int top() {
    return stack.peek();
  }

  public int getMin() {
    return minStack.peek();
  }
}
