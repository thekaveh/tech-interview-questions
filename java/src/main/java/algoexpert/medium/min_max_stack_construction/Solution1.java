package algoexpert.medium.min_max_stack_construction;
import java.util.*;

// Approach: TODO.
class Solution1 {
    // Feel free to add new properties and methods to the class.
    static class MinMaxStack {
        private static final int CAPACITY = 10;

        int[] vals = new int[CAPACITY];
        int[] mins = new int[CAPACITY];
        int[] maxs = new int[CAPACITY];

        int N = 0;

        public int peek() {
            if(N == 0) { return -1; }

            return this.vals[N - 1];
        }

        public int getMin() {
            if(N == 0) { return -1; }

            return this.mins[N - 1];
        }

        public int getMax() {
            if(N == 0) { return -1; }

            return this.maxs[N - 1];
        }

        public int pop() {
            if(N == 0) { return -1; }

            return this.vals[--N];
        }

        public void push(Integer value) {
            this.vals[N] = value;
            this.mins[N] = (N > 0) ? Math.min(this.getMin(), value) : value;
            this.maxs[N] = (N > 0) ? Math.max(this.getMax(), value) : value;

            N++;
        }
    }
}
