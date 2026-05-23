package algoexpert.hard.find_loop;
import java.util.*;

// Approach: Floyd's cycle detection (two-pointer).
class Solution1 {
    public static LinkedList findLoop(LinkedList head) {
        var pA = head.next;
        var pB = head.next.next;

        while (pA != pB) {
            pA = pA.next;
            pB = pB.next.next;
        }

        pB = head;

        while (pA != pB) {
            pA = pA.next;
            pB = pB.next;
        }

        return pA;
    }

    static class LinkedList {
        int value;
        LinkedList next = null;

        public LinkedList(int value) {
            this.value = value;
        }
    }
}
