package io.algopreorg.alog.rotatelist;

public class SolutionMariana {

    public ListNode rotateRight(ListNode head, int k) {
        if (head == null || k == 0) {
            return head;
        }
        
        int size = getNodeSize(head);
        int rotations = k % size;

        if (rotations == 0) {
            return head;
        }

        ListNode rotated = head;
        for (int i = 0; i < rotations; i++) {
            rotated = rotate(rotated);
        }

        return rotated;
    }

    private int getNodeSize(ListNode head) {
        int i = 0;
        ListNode current = head;
        while (current != null) {
            current = current.next;
            i++;
        }

        return i;
    }

    private ListNode rotate(ListNode head) {
        ListNode current = head;
        while (current.next.next != null) {
            current = current.next;
        }

        ListNode rotated = current.next;
        current.next = null;
        rotated.next = head;

        return rotated;
    }
}
