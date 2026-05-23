package algoexpert.medium.sum_of_linked_lists;
import java.util.*;

// Approach: Simultaneous traversal with carry propagation.
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

    public LinkedList sumOfLinkedLists(LinkedList A, LinkedList B) {
        var c = 0;
        LinkedList R = null, r = null;

        while (A != null || B != null || c != 0) {
            var a = (A != null) ? A.value : 0;
            var b = (B != null) ? B.value : 0;

            var s = a + b + c;
            c = s / 10;
            s %= 10;

            if (R == null)  { R = r = new LinkedList(s); }
            else            { r.next = new LinkedList(s); r = r.next; }

            A = (A != null) ? A.next : null;
            B = (B != null) ? B.next : null;
        }

        return R;
    }
}
