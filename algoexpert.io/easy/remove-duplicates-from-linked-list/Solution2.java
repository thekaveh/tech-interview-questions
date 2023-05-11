import java.util.*;

class Solution2 {
    public static class LinkedList {
        public int value;
        public LinkedList next;

        public LinkedList(int value) {
            this.value = value;
            this.next = null;
        }
    }

    public LinkedList removeDuplicatesFromLinkedList(LinkedList head) {
        var current = head;
        
        while(current != null) {
            var next = current.next;
            
            while(next != null && current.value == next.value) { next = next.next; }
            
            current.next = next;
            
            current = current.next;
        }
        
        return head;
    }
}