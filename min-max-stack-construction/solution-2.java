import java.util.*;

class Program {
    static class MinMaxStack {
        int N = 0;
        
        List<Integer> vals = new ArrayList<>();
        List<Integer> mins = new ArrayList<>();
        List<Integer> maxs = new ArrayList<>();
        
        public boolean isEmpty() { return N == 0; }
        
        public void push(Integer number) {
            this.vals.add(number);
            
            this.mins.add(isEmpty()
                ? number
                : (number < this.mins.get(N - 1))
                    ? number
                    : this.mins.get(N - 1));
            
            this.maxs.add(isEmpty()
                ? number
                : (number > this.maxs.get(N - 1))
                    ? number
                    : this.maxs.get(N - 1));
                    
            N++;
        }

        public int pop() {
            if(isEmpty()) { return -1; }
            
            int ret = this.vals.remove(--N);
            
            this.mins.remove(N);
            this.maxs.remove(N);
            
            return ret;
        }
            
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
    }
}