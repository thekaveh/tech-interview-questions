import java.util.*;

class Program {
	// T: O(2 ^ (S + D)) | S: O(S + D)
    public static int numberOfWaysToMakeChange(int S, int[] D) {
        return solve(S, D, 0);
    }

    private static int solve(int S, int[] D, int at) {
        var N = D.length;

        if(S == 0)              { return 1; }
        if(N == 0 || at >= N)   { return 0; }

        var altA = (D[at] <= S) ? solve(S - D[at], D, at) : 0;  // inc
        var altB = solve(S, D, at + 1);                         // exc

        return altA + altB;
    }
}