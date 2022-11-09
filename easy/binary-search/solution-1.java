import java.util.*;

class Program {
    public static int binarySearch(int[] A, int key) {
        var N = A.length;

        int lo = 0, hi = N - 1;

        while(lo <= hi) {
            var mid = lo + (hi - lo) / 2;

            if      (key < A[mid])  { hi = mid - 1; }
            else if (A[mid] < key)  { lo = mid + 1; }
            else                    { return mid;  }
        }

        return -1;
    }
}