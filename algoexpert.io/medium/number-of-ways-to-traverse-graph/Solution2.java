import java.util.*;

class Solution2 {
    // T: O(C * R) - S: O(C * R)
    public int numberOfWaysToTraverseGraph(int C, int R) {
        var M = new Integer[R + 1][C + 1];

        return solve(C, R, M);
    }

    private static int solve(int C, int R, Integer[][] M) {
        if(M[R][C] != null) { return M[R][C]; }

        if(C == 1 || R == 1) { return M[R][C] = 1; }

        return M[R][C] = solve(C - 1, R, M) + solve(C, R - 1, M);
    }
}