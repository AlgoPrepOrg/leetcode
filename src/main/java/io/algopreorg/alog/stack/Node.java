package io.algopreorg.alog.stack;

/**
 * A class representing a node in the stack.
 *
 * @param <T> the type of data stored in the node
 */
class Node<T> {
  T data;       // Data stored in the node
  Node<T> next; // Reference to the next node in the stack

  /**
   * Constructor to create a new node with given data.
   *
   * @param data the data to be stored in the node
   */
  public Node(T data) {
    this.data = data;
    this.next = null; // Initially, the next node is null
  }
}
