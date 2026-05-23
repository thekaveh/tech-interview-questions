package algoexpert.medium.breadth_first_search;
import java.util.*;

// Approach: TODO.
class Solution1 {
    // Do not edit the class below except
    // for the breadthFirstSearch method.
    // Feel free to add new properties
    // and methods to the class.
    static class Node {
        String name;
        List<Node> children = new ArrayList<Node>();

        public Node(String name) {
            this.name = name;
        }

        public List<String> breadthFirstSearch(List<String> R) {
            var Q = new ArrayDeque<Node>();
            
            Q.addLast(this);
            
            while(!Q.isEmpty()) {
                var next = Q.removeFirst();

                R.add(next.name);
                
                for(var child : next.children) {
                    Q.addLast(child);
                }
            }
            
            return R;
        }

        public Node addChild(String name) {
            Node child = new Node(name);
            children.add(child);
            return this;
        }
    }
}
