package io.algopreorg.alog.stack;

/**
 * A simple implementation of a stack data structure using an array.
 * The stack follows the Last-In-First-Out (LIFO) principle.
 */
public class Stack {
  private int maxSize;      // Maximum size of the stack
  private int top;          // Index of the top element
  private int[] stackArray; // Array to store stack elements

  /**
   * Constructs a stack with a specified maximum size.
   *
   * @param size the maximum number of elements the stack can hold
   */
  public Stack(int size) {
    this.maxSize = size;
    this.stackArray = new int[maxSize];
    this.top = -1; // Initially, the stack is empty
  }

  /**
   * Pushes an element onto the top of the stack.
   *
   * @param value the value to be pushed onto the stack
   */
  public void push(int value) {
    if (isFull()) {
      System.out.println("Stack is full. Cannot push " + value);
    } else {
      stackArray[++top] = value;
      System.out.println("Pushed " + value);
    }
  }

  /**
   * Pops the top element from the stack and returns it.
   *
   * @return the top element of the stack, or -1 if the stack is empty
   */
  public int pop() {
    if (isEmpty()) {
      System.out.println("Stack is empty. Cannot pop.");
      return -1;
    } else {
      return stackArray[top--];
    }
  }

  /**
   * Peeks at the top element of the stack without removing it.
   *
   * @return the top element of the stack, or -1 if the stack is empty
   */
  public int peek() {
    if (isEmpty()) {
      System.out.println("Stack is empty. Cannot peek.");
      return -1;
    } else {
      return stackArray[top];
    }
  }

  /**
   * Checks whether the stack is empty.
   *
   * @return true if the stack is empty, false otherwise
   */
  public boolean isEmpty() {
    return (top == -1);
  }

  /**
   * Checks whether the stack is full.
   *
   * @return true if the stack is full, false otherwise
   */
  public boolean isFull() {
    return (top == maxSize - 1);
  }

  /**
   * Returns the current number of elements in the stack.
   *
   * @return the number of elements in the stack
   */
  public int size() {
    return top + 1;
  }

  /**
   * Main method for testing the Stack implementation.
   *
   * @param args the command-line arguments (not used)
   */
  public static void main(String[] args) {
    Stack stack = new Stack(5); // Create a stack of size 5

    stack.push(10);
    stack.push(20);
    stack.push(30);
    stack.push(40);
    stack.push(50);

    System.out.println("Top element: " + stack.peek()); // Should print 50
    System.out.println("Popped element: " + stack.pop()); // Should print 50
    System.out.println("Is stack empty? " + stack.isEmpty()); // Should print false
  }
}
