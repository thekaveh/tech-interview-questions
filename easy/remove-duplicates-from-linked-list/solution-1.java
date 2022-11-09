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

    public LinkedList removeDuplicatesFromLinkedList(LinkedList H) {
        for(var C = H; C != null; C = C.next) {
            for(var N = C.next; N != null && N.value == C.value; N = N.next) { C.next = N.next; }
        }

        return H;
    }
}