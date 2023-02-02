import java.util.*;

class Program {
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

        public int pop() {
            if(isEmpty()) { return -1; }

            var ret = this.head.val;

            this.head = this.head.next;

            return ret;
        }

        public void push(Integer number) {
            this.head = new Node(
                number
                , isEmpty() ? number : Math.min(this.head.min, number)
                , isEmpty() ? number : Math.max(this.head.max, number)
                , this.head
            );
        }

        public int getMin() {
            if(isEmpty()) { return -1; }

            return this.head.min;
        }

        public int getMax() {
            if(isEmpty()) { return -1; }

            return this.head.max;
        }
    }
}