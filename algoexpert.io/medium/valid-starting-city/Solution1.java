import java.util.*;

class Solution1 {
    public int validStartingCity(int[] distances, int[] fuels, int mpg) {
        var N = distances.length;

        for (var src = 0; src < N; src++) {
            var currentRange = 0;

            for (var dst = src; dst < src + N; dst++) {
                var idx = dst % N;

                currentRange += fuels[idx] * mpg;
                currentRange -= distances[idx];

                if (currentRange < 0) { break; }
            }

            if (0 <= currentRange) { return src; }
        }

        return -1;
    }
}