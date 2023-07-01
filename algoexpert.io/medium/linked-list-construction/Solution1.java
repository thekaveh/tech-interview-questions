import java.util.*;

class Solution1 {
    static class DoublyLinkedList {
        public Node head;
        public Node tail;

        public boolean isEmpty() { return (this.head == null) && (this.tail == null); }

        public void setHead(Node node) {
            if(isEmpty())   { this.head = this.tail = node; }
            else            { insertBefore(this.head, node); }
        }

        public void setTail(Node node) {
            if(isEmpty())   { this.head = this.tail = node; }
            else            { insertAfter(this.tail, node); }
        }

        public void insertBefore(Node atNode, Node node) {
            if(isEmpty() || atNode == null || node == null) { return; }

            if(node.prev != null || node.next != null) { remove(node); }

            node.prev = atNode.prev;
            node.next = atNode;

            if(atNode.prev != null) { atNode.prev.next = node; }
            else                    { this.head = node; }

            atNode.prev = node;
        }

        public void insertAfter(Node atNode, Node node) {
            if(isEmpty() || atNode == null || node == null) { return; }

            if(node.prev != null || node.next != null) { remove(node); }

            node.prev = atNode;
            node.next = atNode.next;

            if(atNode.next != null) { atNode.next.prev = node; }
            else                    { this.tail = node; }

            atNode.next = node;
        }

        public void insertAtPosition(int at, Node node) {
            if(node == null) { return; }

            var atNode = this.head;

            for(var i = 1; atNode != null && i < at; atNode = atNode.next, i++);

            if(atNode != null)  { insertBefore(atNode, node); }
            else                { setTail(node); }
        }

        public void removeNodesWithValue(int key) {
            if(isEmpty()) { return; }

            var atNode = this.head;
            while(atNode != null) {
                var next = atNode.next;

                if(atNode.value == key) { remove(atNode); }

                atNode = next;
            }
        }

        public void remove(Node node) {
            if(isEmpty() || node == null) { return; }

            if(node.prev != null)   { node.prev.next = node.next; }
            else                    { this.head = node.next; }

            if(node.next != null)   { node.next.prev = node.prev; }
            else                    { this.tail = node.prev; }

            node.prev = null;
            node.next = null;
            node = null;
        }

        public boolean containsNodeWithValue(int key) {
            if(isEmpty()) { return false; }

            for(var atNode = this.head; atNode != null; atNode = atNode.next) {
                if(atNode.value == key) { return true; }
            }

            return false;
        }
    }

    // Do not edit the class below.
    static class Node {
        public int value;
        public Node prev;
        public Node next;

        public Node(int value) {
            this.value = value;
        }
    }
}