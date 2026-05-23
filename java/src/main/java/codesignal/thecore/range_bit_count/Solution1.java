package codesignal.thecore.range_bit_count;
import java.util.*;
import java.util.stream.*;
import java.math.*;

// Approach: Iterate over each number in [a,b] and count its set bits via bit-shift loop.
class Solution1 {
    static int solution(int a, int b) {
        var s = 0;

        for(var x = a; x <= b; x++) {
            var t = x;

            while(t > 0) {
                s += t % 2;

                t /= 2;
            }
        }

        return s;
    }
}
