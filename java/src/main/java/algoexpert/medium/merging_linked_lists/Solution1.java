package algoexpert.medium.merging_linked_lists;
import java.util.*;

// Approach: HashSet of nodes from list A, scan list B.
class Solution1 {
    // This is an input class. Do not edit.
    public static class LinkedList {
        public int value;
        public LinkedList next;

        public LinkedList(int value) {
            this.value = value;
            this.next = null;
        }
    }

    public LinkedList mergingLinkedLists(LinkedList A, LinkedList B) {
        var M = new HashSet<LinkedList>();

        for (var a = A; a != null; a = a.next) { M.add(a); }
        for (var b = B; b != null; b = b.next) { if (M.contains(b)) { return b; } }

        return null;
    }
}
