package algoexpert.veryhard.merge_sort;
import java.util.*;

// Approach: Recursive merge sort with single auxiliary array.
class Solution1 {
    public static int[] mergeSort(int[] A) {
        var N = A.length;
        var X = new int[N];
        
        sort(A, X, 0, N - 1);
        
        return A;
    }

    private static void sort(int[] A, int[] X, int lo, int hi) {
        if(hi <= lo) { return; }
        
        int mid = lo + (hi - lo) / 2;
        
        sort(A, X, lo, mid);
        sort(A, X, mid + 1, hi);
        
        merge(A, X, lo, mid, hi);
    }

    private static void merge(int[] A, int[] X, int lo, int mid, int hi) {
        if(A[mid] <= A[mid + 1]) { return; }

        for(int k = lo; k <= hi; k++) { X[k] = A[k]; }
        
        for(int i = lo, j = mid + 1, k = lo; k <= hi; k++) {
            if		(mid < i) 		{ A[k] = X[j++]; }
            else if	(hi < j) 	    { A[k] = X[i++]; }
            else if (X[j] < X[i])   { A[k] = X[j++]; }
            else 					{ A[k] = X[i++]; }
        }
    }
}
