package algoexpert.medium.minimum_passes_of_matrix;
import java.util.*;

// Approach: Multi-source BFS, alternate list/queue form.
class Solution3 {

    public int minimumPassesOfMatrix(int[][] A) {
        var passes = 0;
        var R = A.length;
        var C = A[0].length;
        var Q = new LinkedList<int[]>();

        for (var r = 0; r < R; r++) {
            for (var c = 0; c < C; c++) {
                if (A[r][c] <= 0) { continue; }

                Q.offer(new int[] { r, c });
            }
        }

        while (!Q.isEmpty()) {
            var L = Q.size();
            var convert = false;

            for (var i = 0; i < L; i++) {
                var v = Q.poll();

                var r = v[0];
                var c = v[1];

                for (var w : Arrays.asList(new int[] { r - 1, c }, new int[] { r, c - 1 }, new int[] { r + 1, c },
                        new int[] { r, c + 1 })) {
                    if (w[0] < 0 || R <= w[0])  { continue; }
                    if (w[1] < 0 || C <= w[1])  { continue; }
                    if (A[w[0]][w[1]] >= 0)     { continue; }

                    convert = true;
                    A[w[0]][w[1]] *= -1;

                    Q.offer(w);
                }
            }

            if (convert) { passes++; }
        }

        for (var r = 0; r < R; r++) {
            for (var c = 0; c < C; c++) {
                if (A[r][c] < 0) {
                    return -1;
                }
            }
        }

        return passes;
    }
}
