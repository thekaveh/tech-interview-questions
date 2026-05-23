package algoexpert.hard.heap_sort;
import java.util.*;

// Approach: TODO.
class Solution1 {
    public static int[] heapSort(int[] A) {
        var N = A.length;

        if(N == 0 || N == 1) { return A; }

        maxHeapify(A);

        for(var at = N - 1; 0 < at; at--) {
            swap(0, at, A);

            sink(0, at - 1, A);
        }

        return A;
    }

    private static void maxHeapify(int[] A) {
        var N = A.length;

        for(var at = parentAt(N - 1); 0 <= at; at--) { sink(at, N - 1, A); }
    }

    private static void sink(int at, int hi, int[] A) {
        while(ltChildAt(at) <= hi) {
            var ltChildAt = ltChildAt(at);
            var rtChildAt = rtChildAt(at);

            var maxChildAt = (rtChildAt <= hi && A[ltChildAt] < A[rtChildAt])
                ? rtChildAt
                : ltChildAt;

            if(A[maxChildAt] <= A[at]) { break; }

            swap(maxChildAt, at, A);

            at = maxChildAt;
        }
    }

    private static int parentAt(int at)     { return (at - 1) / 2; }
    private static int ltChildAt(int at)    { return (2 * at) + 1; }
    private static int rtChildAt(int at)    { return (2 * at) + 2; }

    private static void swap(int i, int j, int[] A) {
        int t   = A[i];
        A[i] 	= A[j];
        A[j] 	= t;
    }
}
