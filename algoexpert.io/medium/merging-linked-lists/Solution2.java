import java.util.*;

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

    public LinkedList mergingLinkedLists(LinkedList A, LinkedList B) {
        var M = 0; for (var a = A; a != null; a = a.next) { M++; }
        var N = 0; for (var b = B; b != null; b = b.next) { N++; }

        if (M < N)  { for (var i = 0; i < N - M; i++) { B = B.next;  } }
        else        { for (var i = 0; i < M - N; i++) { A = A.next;  } }

        while (A != B) { A = A.next; B = B.next; }

        return A;
    }
}