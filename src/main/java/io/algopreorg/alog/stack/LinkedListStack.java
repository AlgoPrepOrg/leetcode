package io.algopreorg.alog.stack;

/**
 * A stack implementation using a linked list.
 * This stack follows the Last-In-First-Out (LIFO) principle.
 *
 * @param <T> the type of elements stored in the stack
 */
public class LinkedListStack<T> {
  private Node<T> top; // Pointer to the top node of the stack

  /**
   * Constructs an empty stack.
   */
  public LinkedListStack() {
    this.top = null; // Initially, the stack is empty
  }

  /**
   * Pushes an element onto the top of the stack.
   *
   * @param value the value to be pushed onto the stack
   */
  public void push(T value) {
    Node<T> newNode = new Node<>(value); // Create a new node
    newNode.next = top;                  // Link the new node to the current top
    top = newNode;                       // Update the top to the new node
    System.out.println("Pushed " + value);
  }

  /**
   * Pops the top element from the stack and returns it.
   *
   * @return the top element of the stack, or null if the stack is empty
   */
  public T pop() {
    if (isEmpty()) {
      System.out.println("Stack is empty. Cannot pop.");
      return null;
    } else {
      T poppedValue = top.data; // Get the top value
      top = top.next;            // Update the top to the next node
      return poppedValue;        // Return the popped value
    }
  }

  /**
   * Peeks at the top element of the stack without removing it.
   *
   * @return the top element of the stack, or null if the stack is empty
   */
  public T peek() {
    if (isEmpty()) {
      System.out.println("Stack is empty. Cannot peek.");
      return null;
    } else {
      return top.data; // Return the top value without removing it
    }
  }

  /**
   * Checks whether the stack is empty.
   *
   * @return true if the stack is empty, false otherwise
   */
  public boolean isEmpty() {
    return top == null; // If top is null, the stack is empty
  }

  /**
   * Returns the current number of elements in the stack.
   *
   * @return the number of elements in the stack
   */
  public int size() {
    int size = 0;
    Node<T> current = top; // Start from the top of the stack

    while (current != null) {
      size++;                    // Increment the size for each node
      current = current.next;    // Move to the next node
    }

    return size; // Return the total size
  }

  /**
   * Main method for testing the LinkedListStack implementation.
   *
   * @param args the command-line arguments (not used)
   */
  public static void main(String[] args) {
    LinkedListStack<Integer> stack = new LinkedListStack<>(); // Create a new stack

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
