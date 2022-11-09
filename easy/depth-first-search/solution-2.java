import java.util.*;

class Program {
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

        public List<String> depthFirstSearch(List<String> array) {
            var S = new Stack<String>();
            
            visitDFS(this, S);
            
            return new ArrayList<String>(S);
        }
            
        private static void visitDFS(Node node, Stack<String> S) {
            S.push(node.name);
            
            for(Node child : node.children) {
                visitDFS(child, S);
            }
        }

        public Node addChild(String name) {
            Node child = new Node(name);
            children.add(child);
            return this;
        }
    }
}