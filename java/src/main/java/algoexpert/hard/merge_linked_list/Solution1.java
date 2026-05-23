package algoexpert.hard.merge_linked_list;
import java.util.*;

// Approach: Iterative two-pointer merge.
class Solution1 {
    // This is an input class. Do not edit.
    public static class LinkedList {
        int value;
        LinkedList next;

        LinkedList(int value) {
            this.value = value;
            this.next = null;
        }
    }

    public static LinkedList mergeLinkedLists(LinkedList A, LinkedList B) {
        LinkedList R = null, r = null;

        while (A != null || B != null) {
            var a = (A != null) ? A.value : Integer.MAX_VALUE;
            var b = (B != null) ? B.value : Integer.MAX_VALUE;

            LinkedList v = null;
            if  (a < b) { v = A; A = A.next; }
            else        { v = B; B = B.next; }

            if  (r == null) { R = r = v; }
            else            { r.next = v; r = r.next; }
        }

        return R;
    }
}
