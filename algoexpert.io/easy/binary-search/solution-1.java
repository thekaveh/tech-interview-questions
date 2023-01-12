import java.util.*;

class Program {
    public static int binarySearch(int[] A, int v) {
        var N = A.length;

        int lo = 0, hi = N - 1;

        while(lo <= hi) {
            var mid = lo + (hi - lo) / 2;

            if      (v < A[mid])  { hi = mid - 1; }
            else if (A[mid] < v)  { lo = mid + 1; }
            else                    { return mid;  }
        }

        return -1;
    }
}