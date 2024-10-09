package io.algopreorg.alog.stack;

import java.util.ArrayDeque;
import java.util.Deque;

public class MyStack {

  private final Deque<Integer> stack;

  public MyStack() {
    stack = new ArrayDeque<>();
  }
  public void push(int x) {
    stack.add(x);
  }
  public int pop() {
    return stack.pollLast();
  }
  public int top() {
    return stack.peekLast();
  }
  public boolean empty() {
    return stack.isEmpty();
  }
}
