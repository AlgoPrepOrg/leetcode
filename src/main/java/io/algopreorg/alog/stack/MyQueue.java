package io.algopreorg.alog.stack;

import java.util.Stack;

public class MyQueue {

  private final Stack<Integer> s1;
  private final Stack<Integer> s2;

  public MyQueue() {
    this.s1 = new Stack();
    this.s2 = new Stack();
  }

  public void push(int x) {
    s1.push(x);
  }

  public int pop() {
    copyToS2();
    return s2.pop();
  }

  public int peek() {
    copyToS2();
    return s2.peek();
  }

  public boolean empty() {
    return s1.isEmpty() && s2.isEmpty();
  }

  private void copyToS2() {
    if (s2.isEmpty()) {
      while (!s1.isEmpty()) {
        s2.push(s1.pop());
      }
    }
  }
}
