import java.util.*;

class Program {
    public static int binarySearch(int[] array, int v) {
        var N = array.length;

        var lo = 0;
        var hi = N - 1;

        while(lo <= hi) {
            var mid = lo + (hi - lo) / 2;
            var cmp = Integer.valueOf(v).compareTo(array[mid]);

            if     (cmp < 0) { hi = mid - 1; }
            else if(0 < cmp) { lo = mid + 1; }
            else             { return mid; }
        }

        return -1;
    }
}