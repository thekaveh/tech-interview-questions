package algoexpert.medium.stable_internship;
import java.util.*;

// Approach: Gale-Shapley (intern-proposes) algorithm.
class Solution1 {
    public int[][] stableInternships(int[][] interns, int[][] teams) {
        var N = interns.length;

        var I = new int[N]; // Keeps track of which team each intern is matched to
        var T = new int[N]; // Keeps track of which intern each team is matched to
        var M = new int[N]; // Keeps track of the next rank each intern will propose to

        Arrays.fill(I, -1);
        Arrays.fill(T, -1);

        // Convert team preferences to a ranking for easier comparison
        var P = new int[N][N];
        for (var t = 0; t < N; t++) {
            for (var r = 0; r < N; r++) {
                P[t][teams[t][r]] = r;
            }
        }

        // Free interns who have yet to be matched
        var Q = new LinkedList<Integer>();
        for (var i = 0; i < N; i++) {
            Q.offer(i);
        }

        while (!Q.isEmpty()) {
            var i = Q.poll();
            var t = interns[i][M[i]++]; // Get the team this intern is proposing to next

            if (T[t] == -1) { // If the team is free, match them
                I[i] = t;
                T[t] = i;
            } else {
                var x = T[t];

                if (P[t][i] < P[t][x]) { // The team is already matched, check if it prefers this intern
                    I[i] = t;
                    T[t] = i;

                    Q.offer(x);
                    I[x] = -1;
                } else { // Team prefers the current intern, so this intern remains free
                    Q.offer(i);
                }
            }
        }

        var R = new int[N][2];
        for (var i = 0; i < N; i++) {
            R[i][0] = i;
            R[i][1] = I[i];
        }

        return R;
    }
}
