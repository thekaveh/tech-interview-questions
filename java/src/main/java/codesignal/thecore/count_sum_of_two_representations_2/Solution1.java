package codesignal.thecore.count_sum_of_two_representations_2;
import javax.lang.model.util.ElementScanner6;
import java.util.*;
import java.util.stream.*;
import java.math.*;

// Approach: Two-pointer converging from l and r, counting pairs that sum to n.
class Solution1 {
    static int solution(int n, int l, int r) {
        var ret = 0;

        var lo = l;
        var hi = r;

        while(lo <= hi) {
            var t = lo + hi;

            if      (t < n) { lo++; }
            else if (n < t) { hi--; }
            else            { ret++; lo++; hi--; }
        }

        return ret;
    }
}
