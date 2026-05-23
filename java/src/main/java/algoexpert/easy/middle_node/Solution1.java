package algoexpert.easy.middle_node;
import java.util.*;

// Approach: TODO.
class Solution1 {
    public static class LinkedList {
        public int value;
        public LinkedList next;

        public LinkedList(int value) {
            this.value = value;
            this.next = null;
        }
    }

    public LinkedList middleNode(LinkedList head) {
        var N = 0;
        for(var node = head; node != null; node = node.next) { N++; }

        var mid = N / 2;
        var ret = head;

        while(0 < mid) { ret = ret.next; mid--; }

        return ret;
    }
}
