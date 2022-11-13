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

    public LinkedList sumOfLinkedLists(LinkedList A, LinkedList B) {
        var carry = 0;
        LinkedList R = null, r = null;

        while(A != null || B != null || carry != 0) {
            var a = (A != null) ? A.value : 0;
            var b = (B != null) ? B.value : 0;
            var c = a + b + carry;

            carry = c / 10;
            c %= 10;

            if(R == null)   { R = r = new LinkedList(c); }
            else            { r.next = new LinkedList(c); r = r.next; }

            A = (A != null) ? A.next : null;
            B = (B != null) ? B.next : null;
        }

        return R;
    }
}