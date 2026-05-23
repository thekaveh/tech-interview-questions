package algoexpert.medium.three_number_sort;
import java.util.*;

// Approach: Three-pointer Dutch National Flag partition.
class Solution1 {
    public int[] threeNumberSort(int[] A, int[] O) {
        var N = A.length;

        // pre: A[0..N-1]

        int at = 0, lt = 0, gt = N - 1;

        while(at <= gt) {
            if      (A[at] == O[0]) { swap(A, at++, lt++); }
            else if (A[at] == O[1]) { at++; }
            else if (A[at] == O[2]) { swap(A, at, gt--); }
        }

        // post: A = {O[0]=A[0..lt-1]} + {O[1]=A[lt..gt]} + {O[2]=A[gt+1..N-1]}

        return A;
    }

    private static void swap(int[] A, int i, int j) {
        var t = A[i];
        A[i] = A[j];
        A[j] = t;
    }
}
