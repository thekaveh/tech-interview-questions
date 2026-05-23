package algoexpert.easy.depth_first_search;
import java.util.*;

// Approach: Recursive DFS, pre-order.
class Solution1 {
    // Do not edit the class below except
    // for the depthFirstSearch method.
    // Feel free to add new properties
    // and methods to the class.
    static class Node {
        String name;
        List<Node> children = new ArrayList<Node>();

        public Node(String name) {
            this.name = name;
        }

        public List<String> depthFirstSearch(List<String> R) {
            R.add(name);
            
            for(var child : children) {
                child.depthFirstSearch(R);
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
