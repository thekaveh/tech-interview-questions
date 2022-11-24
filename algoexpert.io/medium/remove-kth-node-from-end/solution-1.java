import java.util.*;

class Program {
    public static void removeKthNodeFromEnd(LinkedList head, int k) {
        LinkedList pre = null
            , cur = head
            , tail = head;

        for(var i = 1; i < k ; i++) { tail = tail.next; }
        for(; tail.next != null; tail = tail.next) { pre = cur; cur = cur.next; }

        if(cur != head) { pre.next = cur.next; cur.next = null; cur = null; }
        else            { cur.value = cur.next.value; cur.next = cur.next.next; }
    }

    static class LinkedList {
        int value;
        LinkedList next = null;

        public LinkedList(int value) {
            this.value = value;
        }
    }
}