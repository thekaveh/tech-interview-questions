import java.util.*;

class Program {
    // This is an input class. Do not edit.
    public static class LinkedList {
        public int value;
        public LinkedList next;

        public LinkedList(int value) {
            this.value = value;
            this.next = null;
        }
    }

    public LinkedList removeDuplicatesFromLinkedList(LinkedList head) {
        var curr = head;
        
        while(curr != null) {
            var next = curr.next;
            
            while(next != null && curr.value == next.value) { next = next.next; }
            
            curr.next = next;
            
            curr = curr.next;
        }
        
        return head;
    }
}