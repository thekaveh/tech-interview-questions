import java.util.*;

class Program {
    public int bestSeat(int[] A) {
        var N = A.length;

        var bestLen = 0;
        var bestIdx = -1;

        for (var lo = 1; lo < N - 1; lo++) {
            if (A[lo] == 1) {
                continue;
            }

            var hi = lo;
            while (hi < N - 1 && A[hi] == 0) {
                hi++;
            }

            if (hi - lo > bestLen) {
                bestLen = hi - lo;
                bestIdx = lo + bestLen / 2;

                if (bestLen % 2 == 0) {
                    bestIdx--;
                }
            }

            lo = hi;
        }

        return bestIdx;
    }
}