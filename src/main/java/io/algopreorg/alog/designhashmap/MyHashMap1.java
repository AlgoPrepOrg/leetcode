package io.algopreorg.alog.designhashmap;

public class MyHashMap1 {
    private static final int DEFAULT_SIZE = 1000;
    private static final float THRESHOLD = 0.75f;
    private Object[] table;
    private int size;


    public MyHashMap1() {
        table = new Object[DEFAULT_SIZE];
    }

    private int getIndex(int key, Object[] table) {
        return key & (table.length - 1);
    }

    private void resize() {
        Object[] newTable = new Object[table.length * 2];
        for (int i = 0; i < table.length; i++) {
            var current = (Node) table[i];
            while (current != null) {
                putNode(current, newTable);
                current = current.next;
            }
        }
        table = newTable;
        size = newTable.length;
    }

    private void putNode(Node node, Object[] table) {
        int index = getIndex(node.key, table);
        if (table[index] == null) {
            table[index] = node;
        } else {
            var current = (Node)table[index];
            var prev = current;
            while (current != null) {
                if (current.key == node.key) {
                    current.element = node.element;
                    return;
                }
                prev = current;
                current = current.next;
            }
            prev.next = node;
        }
    }


    public void put(int key, int value) {
        if (table.length * THRESHOLD <= size) {
            resize();
        }
        Node newNode = new Node(key, value);
        putNode(newNode, table);
        size++;
    }

    public int get(int key) {
        int index = getIndex(key, table);
        var current = (Node)table[index];
        while (current != null) {
            if (current.key == key) {
                return current.element;
            }
            current = current.next;
        }
        return -1;
    }

    public void remove(int key) {
        int index = getIndex(key, table);
        var current = (Node)table[index];
        Node prev = null;
        while (current != null) {
            if (current.key == key) {
                if (prev != null) {
                    prev.next = current.next;
                } else {
                    table[index] = current.next;
                }
                size--;
                return;
            }
            prev = current;
            current = current.next;
        }
    }

    class Node {

        int key;
        int element;
        Node next;

        public Node(int key, int element) {
            this.key = key;
            this.element = element;
        }
    }
}
