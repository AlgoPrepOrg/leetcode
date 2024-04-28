## Two-Pointer Approach

The two-pointer technique is a powerful algorithmic technique used in solving various problems efficiently, especially in array and linked list-related tasks. It involves using two pointers that traverse the array or list, typically converging towards a solution.

### Example 1: Finding Pairs with Target Sum

**Problem:** Given a sorted array of integers and a target sum, find two numbers in the array that sum up to the target.

**Solution:**

```java
public int[] twoSum(int[] nums, int target) {
    // We initialize two pointers, left pointing to the start of the array and right pointing to the end.
    int left = 0;
    int right = nums.length - 1;
    
    while (left < right) {
        // We calculate the sum of elements at these pointers.
        int sum = nums[left] + nums[right];
        // If the sum equals the target, we return the indices.
        if (sum == target) {
            return new int[]{left, right};
        // If the sum is less than the target, we increment left to increase the sum.    
        } else if (sum < target) {
            left++;
        // If the sum is greater than the target, we decrement right to decrease the sum.    
        } else {
            right--;
        }
    }
    return new int[]{-1, -1}; // If no such pair found
}
```

### Example 2: Detecting Cycle in Linked List

**Problem:** Given a linked list, determine if it has a cycle.

**Solution:**
```java
class ListNode {
    int val;
    ListNode next;
    ListNode(int x) {
        val = x;
        next = null;
    }
}

public boolean hasCycle(ListNode head) {
    if (head == null || head.next == null) return false;
    
    // We initialize two pointers, slow and fast, both initially pointing to the head of the linked list.
    // slow moves one step at a time, while fast moves two steps at a time.
    ListNode slow = head;
    ListNode fast = head.next;
    
    // If there is a cycle, fast will eventually catch up to slow, indicating the presence of a cycle.
    while (slow != fast) {
        //If fast reaches the end of the list (null), there is no cycle, and we return false.
        if (fast == null || fast.next == null) {
            return false;
        }
        slow = slow.next;
        fast = fast.next.next;
    }
    return true;
}
```

[**Video**](https://www.youtube.com/watch?v=On03HWe2tZM)
