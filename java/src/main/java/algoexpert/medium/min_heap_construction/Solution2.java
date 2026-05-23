package algoexpert.medium.min_heap_construction;
import java.util.*;

// Approach: TODO.
class Solution2 {
    static class MinHeap {
        List<Integer> heap = new ArrayList<Integer>();

        public MinHeap(List<Integer> array) {
            heap = buildHeap(array);
        }

        public List<Integer> buildHeap(List<Integer> H) {
            int N = H.size();
            
            for(int i = parentIndex(N - 1); 0 <= i; i--) {
                siftDown(i, N - 1, H);
            }
            
            return H;
        }

        public void siftDown(int i, int hi, List<Integer> H) {
            for(int j = oooChildIndex(i, H); j != -1; j = oooChildIndex(j, H)) {
                swap(i, j, H);
                
                i = j;
            }
        }

        public void siftUp(int i, List<Integer> H) {
            for(int j = oooParentIndex(i, H); j != -1; j = oooParentIndex(j, H)) {
                swap(i, j, H);
                
                i = j;
            }
        }

        public int peek() {
            return this.heap.get(0);
        }

        public int remove() {
            int N = this.heap.size();
            
            swap(0, N - 1, this.heap);
            
            int ret = this.heap.get(N - 1);
            this.heap.remove(N - 1);
            
            siftDown(0, N - 2, this.heap);
            
            return ret;
        }

        public void insert(int value) {
            this.heap.add(value);
            
            int N = this.heap.size();
            
            siftUp(N - 1, this.heap);
        }
            
        private static int parentIndex(int i) { return (i - 1) / 2; }
        
        private static int oooParentIndex(int i, List<Integer> H) {
            var ret = -1;
            var parentIndex = parentIndex(i);
            
            if(0 <= parentIndex && H.get(i) < H.get(parentIndex)) { ret = parentIndex; }
            
            return ret;
        }
            
        private static int oooChildIndex(int i, List<Integer> H) {
            var N = H.size();
            var ret = -1;
            var ltChildIndex = (2 * i) + 1;
            var gtChildIndex = (2 * i) + 2;
            
            if(ltChildIndex < N && H.get(ltChildIndex) < H.get(i)) { ret = ltChildIndex; }
            if(gtChildIndex < N && H.get(gtChildIndex) < H.get(i)) {
                if(ret == -1) { ret = gtChildIndex; }
                else {
                    ret = (H.get(ltChildIndex) < H.get(gtChildIndex))
                        ? ltChildIndex
                        : gtChildIndex;
                }
            }
            
            return ret;
        }
            
        private static void swap(int i, int j, List<Integer> H) {
            int T = H.get(i);
            H.set(i, H.get(j));
            H.set(j, T);
        }
    }
}
