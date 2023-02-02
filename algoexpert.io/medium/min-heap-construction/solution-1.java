import java.util.*;

class Program {
    static class MinHeap {
        List<Integer> heap = new ArrayList<Integer>();

        public MinHeap(List<Integer> array) {
            heap = buildHeap(array);
        }

        public List<Integer> buildHeap(List<Integer> H) {
            var N = H.size();

            for(var i = parentIdx(N - 1); 0 <= i; i--)  { siftDown(i, N - 1, H); }

            return H;
        }

        public void siftDown(int idx, int endIdx, List<Integer> H) {
            var N = H.size();

            while(ltChildIdx(idx) < N) {
                var ltChildIdx = ltChildIdx(idx);
                var gtChildIdx = gtChildIdx(idx);

                var minChildIdx = (gtChildIdx < N) && H.get(gtChildIdx) < H.get(ltChildIdx)
                    ? gtChildIdx
                    : ltChildIdx;

                if(H.get(idx) <= H.get(minChildIdx)) { break; }

                swap(idx, minChildIdx, H);

                idx = minChildIdx;
            }
        }

        public void siftUp(int idx, List<Integer> H) {
            while(0 <= idx) {
                var parentIdx = parentIdx(idx);

                if(H.get(parentIdx) <= H.get(idx)) { break; }

                swap(idx, parentIdx, H);

                idx = parentIdx;
            }
        }

        public int peek() {
            if(this.heap.size() == 0) { return -1; }

            return this.heap.get(0);
        }

        public int remove() {
            var N = this.heap.size();

            swap(0, N - 1, this.heap);

            var ret = this.heap.get(N - 1);
            this.heap.remove(N - 1);

            siftDown(0, N - 2, this.heap);

            return ret;
        }

        public void insert(int value) {
            this.heap.add(value);

            var N = this.heap.size();

            siftUp(N - 1, this.heap);
        }

        private static void swap(int i, int j, List<Integer> H) {
            var x = H.get(i);
            H.set(i, H.get(j));
            H.set(j, x);
        }

        private static int ltChildIdx(int idx)  { return (2 * idx) + 1; }
        private static int gtChildIdx(int idx)  { return (2 * idx) + 2; }
        private static int parentIdx(int idx)   { return (idx - 1) / 2; }
    }
}