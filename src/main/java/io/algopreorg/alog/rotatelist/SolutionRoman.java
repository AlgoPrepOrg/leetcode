package io.algopreorg.alog.rotatelist;

//https://leetcode.com/problems/rotate-list

/**
 * Input: head = [1,2,3,4,5], k = 2
 * Output: [4,5,1,2,3]
 */

public class SolutionRoman {
    public ListNode rotateRight(ListNode head, int k) {
        if (k == 0 || head == null) {
            return head;
        }
        var current = head;
        int size = 1; // find the size of the ListNode
        while (current.next != null) {
            size++;
            current = current.next;
        }
        k %= size; // find the quantity of rotations
        if (k == 0) {
            return head;
        }

        current.next = head; // link last node with the first
        // travers to the node where rotation should happen
        for (int i = 0; i < size - k; i++) {
            current = current.next;
        }
        head = current.next;    // head = [1,2,3,4,5], k = 2 -> current = 3, head = 4
        current.next = null;    // output: [4,5,1,2,3]

        return head;
    }
}
