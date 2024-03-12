package io.algopreorg.alog.hascycle;

public class SolutionRoman {
    class ListNode {
        int value;
        ListNode next;

        public ListNode(int value) {
            this.value = value;
            next = null;
        }
    }

    public boolean hasCycle(ListNode head) {
        var slow = head;
        var fast = head;
        while (fast != null && fast.next != null) {
            slow = slow.next;
            fast = fast.next.next;

            if (slow == fast) {
                return true;
            }
        }
        return false;
    }
}
