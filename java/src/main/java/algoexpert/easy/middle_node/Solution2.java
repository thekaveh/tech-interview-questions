package algoexpert.easy.middle_node;
import java.util.*;

// Approach: Slow and fast pointer.
class Solution2 {
    // This is an input class. Do not edit.
    public static class LinkedList {
        public int value;
        public LinkedList next;

        public LinkedList(int value) {
            this.value = value;
            this.next = null;
        }
    }

    public LinkedList middleNode(LinkedList head) {
        var slow = head;
        var fast = head;

        while(fast != null && fast.next != null) {
            slow = slow.next;
            fast = fast.next.next;
        }

        return slow;
    }
}
