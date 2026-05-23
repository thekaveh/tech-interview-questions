package algoexpert.hard.heap_sort;
import java.util.*;

// Approach: In-place max-heap with sink (for-loop, OOO child helper).
class Solution2 {
    public static int[] heapSort(int[] A) {
        int N = A.length;
        
        buildMaxHeap(A);
        
        for(int i = N - 1; i > 0; i--) {
            swap(0, i, A);
            
            sink(0, i - 1, A);
        }
        
        return A;
    }

    private static void buildMaxHeap(int[] A) {
        int N = A.length;
        
        for(int i = parentIndex(N - 1); i >= 0; i--) { sink(i, N - 1, A); }
    }

    private static void sink(int i, int hi, int[] A) {
        for(int j = oooChildIndex(i, hi, A); j != -1; j = oooChildIndex(j, hi, A)) {
            swap(i, j, A);
            
            i = j;
        }
    }

    private static int oooChildIndex(int i, int hi, int[] A) {
        int N = (A.length > hi + 1) ? hi + 1 : A.length
            , ltChildIndex = (2 * i) + 1
            , gtChildIndex = (2 * i) + 2
            , ret = -1;
        
        if(ltChildIndex < N && A[ltChildIndex] > A[i]) { ret = ltChildIndex; }
        if(gtChildIndex < N && A[gtChildIndex] > A[i]) {
            if(ret == -1) { ret = gtChildIndex; }
            else {
                ret = (A[gtChildIndex] > A[ltChildIndex]) ? gtChildIndex : ltChildIndex;
            }
        }
        
        return ret;
    }

    private static int parentIndex(int i) {
        return (i - 1) / 2;
    }

    private static void swap(int i, int j, int[] A) {
        int T = A[i];
        A[i] 	= A[j];
        A[j] 	= T;
    }
}
