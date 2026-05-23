package algoexpert.medium.minimum_passes_of_matrix;
import java.util.*;

// Approach: Naive: repeatedly scan for convertible negatives.
class Solution1 {
    public int minimumPassesOfMatrix(int[][] A) {
        var passes = 0;

        var VN = validNegatives(A);

        while(!VN.isEmpty()) {
            for(var vn : VN) { A[vn[0]][vn[1]] *= -1; }

            passes++;

            VN = validNegatives(A);
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

    private static boolean isValidNegative(int r, int c, int[][] A) {
        if(!isValidPosition(r, c, A)) { return false; }

        if(A[r][c] >= 0) { return false; }

        for(var adj : adj(r, c)) {
            if(!isValidPosition(adj[0], adj[1], A)) { continue; }

            if(A[adj[0]][adj[1]] > 0) { return true; }
        }

        return false;
    }

    private static List<int[]> validNegatives(int[][] A) {
        var R = A.length;
        var C = A[0].length;

        var VN = new ArrayList<int[]>();

        for(var r = 0; r < R; r++) {
            for(var c = 0; c < C; c++) {
                if(isValidNegative(r, c, A)) {
                    VN.add(new int[] { r, c });
                }
            }
        }

        return VN;
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
