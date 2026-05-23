package algoexpert.easy.depth_first_search;
import java.util.*;

// Approach: TODO.
class Solution3 {
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
            var S = new Stack<Node>();
            
            S.push(this);
            
            while(!S.isEmpty()) {
                var next = S.pop();
                
                R.add(next.name);
                
                for(var i = next.children.size() - 1; i >= 0 ; i--) {
                    var child = next.children.get(i);
                    
                    S.push(child);
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
