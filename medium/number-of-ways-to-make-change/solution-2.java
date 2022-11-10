import java.util.*;

class Program {
	// T: O(S * D) | S: O(S * D)
    public static int numberOfWaysToMakeChange(int S, int[] D) {
        var N = D.length;
        var M = new Integer[N][S + 1];

        return solve(S, D, 0, M);
    }

    private static int solve(int S, int[] D, int at, Integer[][] M) {
        var N = D.length;

        if(S == 0)              { return 1; }
        if(N == 0 || at >= N)   { return 0; }

        if(M[at][S] != null) { return M[at][S]; }

        var altA = (D[at] <= S) ? solve(S - D[at], D, at, M) : 0;   // inc
        var altB = solve(S, D, at + 1, M);                          // exc

        return M[at][S] = altA + altB;
    }
}