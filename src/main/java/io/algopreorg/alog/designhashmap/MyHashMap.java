package io.algopreorg.alog.designhashmap;

public class MyHashMap {

    private static final int CAPACITY = 16;
    
    private final Node[] map;
    
    public MyHashMap() {
        this.map = new Node[CAPACITY];
    }

    public void put(int key, int value) {
        Node node = new Node(key, value);
        
        int index = this.getIndex(key);
        Node head = this.map[index];

        if (head != null) {
            Node current = head;
            while (current != null) {
                if (current.key == key) {
                    current.value = value;
                    return;
                }
                current = current.next;
            }

            node.next = head;
        }
        this.map[index] = node;
    }

    public int get(int key) {
        int index = this.getIndex(key);
        Node current = this.map[index];
        
        while (current != null) {
            if (current.key == key) {
                return current.value;
            }
            current = current.next;
        }
        
        return -1;
    }

    public void remove(int key) {
        int index = this.getIndex(key);
        Node current = this.map[index];
        Node previous = null;
        
        while (current != null) {
            if (current.key == key) {
                if (previous == null) {
                    this.map[index] = current.next;
                } else {
                    previous.next = current.next;
                }
            }
            previous = current;
            current = current.next;
        }
    }
    
    private int getIndex(int key) {
        int length = this.map.length;
        return (key % length + length) % length;
    }
    
    private static class Node {
        int key;
        
        int value;
        
        Node next;
        
        public Node(int key, int value) {
            this.key = key;
            this.value = value;
        }
    }
}

