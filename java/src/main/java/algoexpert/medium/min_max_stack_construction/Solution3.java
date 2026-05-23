package algoexpert.medium.min_max_stack_construction;
import java.util.*;

// Approach: Intrusive linked list where each node carries its min/max.
class Solution3 {
    static class Node {
        Integer min;
        Integer max;
        Integer val;

        Node next; 

        public Node(int val, int min, int max, Node next) {
            this.min = min;
            this.max = max;
            this.val = val;

            this.next = next;
        }
    }
    
    static class MinMaxStack {
        Node head;

        private boolean isEmpty() { return this.head == null; }

        public int peek() {
            if(isEmpty()) { return -1; }

            return this.head.val;
        }

        public int getMin() {
            if(isEmpty()) { return -1; }

            return this.head.min;
        }

        public int getMax() {
            if(isEmpty()) { return -1; }

            return this.head.max;
        }

        public int pop() {
            if(isEmpty()) { return -1; }

            var ret = this.head.val;

            this.head = this.head.next;

            return ret;
        }

        public void push(Integer value) {
            this.head = new Node(
                value
                , isEmpty() ? value : Math.min(this.head.min, value)
                , isEmpty() ? value : Math.max(this.head.max, value)
                , this.head
            );
        }
    }
}
