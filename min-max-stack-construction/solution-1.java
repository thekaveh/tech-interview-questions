import java.util.*;

class Program {
    // Feel free to add new properties and methods to the class.
    static class MinMaxStack {
        private static final int CAPACITY = 10;

        int[] nums = new int[CAPACITY];
        int[] mins = new int[CAPACITY];
        int[] maxs = new int[CAPACITY];

        int N = 0;

        public int peek() {
            if(N == 0) { return -1; }

            return this.nums[N - 1];
        }

        public int pop() {
            if(N == 0) { return -1; }

            return this.nums[--N];
        }

        public void push(Integer number) {
            this.nums[N] = number;
            this.mins[N] = (N > 0) ? Math.min(this.mins[ N - 1], number) : number;
            this.maxs[N] = (N > 0) ? Math.max(this.maxs[ N - 1], number) : number;

            N++;
        }

        public int getMin() {
            if(N == 0) { return -1; }

            return this.mins[N - 1];
        }

        public int getMax() {
            if(N == 0) { return -1; }

            return this.maxs[N - 1];
        }
    }
}