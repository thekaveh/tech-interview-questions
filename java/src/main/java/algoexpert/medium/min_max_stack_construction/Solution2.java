package algoexpert.medium.min_max_stack_construction;
import java.util.*;

// Approach: TODO.
class Solution2 {
    static class MinMaxStack {
        int N = 0;
        
        List<Integer> vals = new ArrayList<>();
        List<Integer> mins = new ArrayList<>();
        List<Integer> maxs = new ArrayList<>();
        
        public boolean isEmpty() { return N == 0; }
            
        public int peek() {
            if(isEmpty()) { return -1; }
            
            return this.vals.get(N - 1);
        }

        public int getMin() {
            if(isEmpty()) { return -1; }
            
            return this.mins.get(N - 1);
        }

        public int getMax() {
            if(isEmpty()) { return -1; }
            
            return this.maxs.get(N - 1);
        }

        public int pop() {
            if(isEmpty()) { return -1; }
            
            N--;
            
            this.mins.remove(N);
            this.maxs.remove(N);
            
            return this.vals.remove(N);
        }
        
        public void push(Integer value) {
            this.vals.add(value);
            
            this.mins.add(
                isEmpty()
                    ? value
                    : Math.min(this.getMin(), value)
            );
            
            this.maxs.add(
                isEmpty()
                    ? value
                    : Math.max(this.getMax(), value)
            );
                    
            N++;
        }
    }
}
