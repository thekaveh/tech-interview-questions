import java.util.*;

class Solution2 {
    public int minimumPassesOfMatrix(int[][] A) {
        var R = A.length;
        var C = A[0].length;

        var passes = 0;
        Queue<int[]> Q = new LinkedList<>();

        for(var r = 0; r < R; r++) {
            for(var c = 0; c < C; c++) {
                if(A[r][c] > 0) { Q.add(new int[] { r, c }); }
            }
        }

        while(!Q.isEmpty()) {
            var L = Q.size();
            var converted = false;

            for(var i = 0; i < L; i++) {
                var pos = Q.poll();

                for(var adj : adj(pos[0], pos[1])) {
                    var r = adj[0];
                    var c = adj[1];

                    if(!isValidPosition(r, c, A))   { continue; }
                    if(A[r][c] >= 0)                { continue; }

                    A[r][c] *= -1;
                    converted = true;

                    Q.offer(new int[] { r, c });
                }
            }

            if(converted) { passes++; }
        }

        return isAllPositives(A) ? passes : -1;
    }

    private static int[][] adj(int r, int c) {
        return new int[][] { { r - 1, c }, { r + 1, c }, { r, c - 1}, { r, c + 1 } };
    }

    private static boolean isValidPosition(int r, int c, int[][] A) {
        var R = A.length;
        var C = A[0].length;

        if(r < 0 || R <= r) { return false; }
        if(c < 0 || C <= c) { return false; }

        return true;
    }

    private static boolean isAllPositives(int[][] A) {
        var R = A.length;
        var C = A[0].length;

        for(var r = 0; r < R; r++) {
            for(var c = 0; c < C; c++) {
                if(A[r][c] < 0) { return false; }
            }
        }

        return true;
    }
}