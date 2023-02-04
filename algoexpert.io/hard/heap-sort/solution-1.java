import java.util.*;

class Program {
    public static int[] heapSort(int[] A) {
        var N = A.length;

        if(N == 0 || N == 1) { return A; }

        maxHeapify(A);

        for(var idx = N - 1; 0 < idx; idx--) {
            swap(0, idx, A);

            sink(0, idx - 1, A);
        }

        return A;
    }

    private static void maxHeapify(int[] A) {
        var N = A.length;

        for(var idx = parentIdx(N - 1); 0 <= idx; idx--) { sink(idx, N - 1, A); }
    }

    private static void sink(int idx, int hi, int[] A) {
        while(ltChildIdx(idx) <= hi) {
            var ltChildIdx = ltChildIdx(idx);
            var rtChildIdx = rtChildIdx(idx);

            var maxChildIdx = (rtChildIdx <= hi && A[ltChildIdx] < A[rtChildIdx])
                ? rtChildIdx
                : ltChildIdx;

            if(A[maxChildIdx] <= A[idx]) { break; }

            swap(maxChildIdx, idx, A);

            idx = maxChildIdx;
        }
    }

    private static int parentIdx(int idx) { return (idx - 1) / 2; }
    private static int ltChildIdx(int idx) { return (2 * idx) + 1; }
    private static int rtChildIdx(int idx) { return (2 * idx) + 2; }

    private static void swap(int i, int j, int[] A) {
        int T = A[i];
        A[i] 	= A[j];
        A[j] 	= T;
    }
}