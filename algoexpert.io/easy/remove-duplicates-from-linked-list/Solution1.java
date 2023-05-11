import java.util.*;

class Solution1 {
    public static class LinkedList {
        public int value;
        public LinkedList next;

        public LinkedList(int value) {
            this.value = value;
            this.next = null;
        }
    }

    public LinkedList removeDuplicatesFromLinkedList(LinkedList head) {
        for(var current = head; current != null; current = current.next) {
            for(var duplicate = current.next; duplicate != null && duplicate.value == current.value; duplicate = duplicate.next) { current.next = duplicate.next; }
        }

        return head;
    }
}