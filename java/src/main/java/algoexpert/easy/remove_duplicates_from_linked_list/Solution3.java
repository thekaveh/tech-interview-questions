package algoexpert.easy.remove_duplicates_from_linked_list;
import java.util.*;

// Approach: TODO.
class Solution3 {
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
            var next = current.next;
            
            while(next != null && current.value == next.value) { next = next.next; }
            
            current.next = next;
        }
        
        return head;
    }
}
