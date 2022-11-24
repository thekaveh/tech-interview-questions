import java.util.*;

class Program {
    // T: O(C * R) - S: O(C * R)
    public int numberOfWaysToTraverseGraph(int C, int R) {
        var M = new int[R + 1][C + 1];

        for(var r = 1; r <= R; r++) {
            for(var c = 1; c <= C; c++) {
                if(r == 1 || c == 1) { M[r][c] = 1; continue; }

                var altA = M[r - 1][c];
                var altB = M[r][c - 1];

                M[r][c] = altA + altB; 
            }
        }

        return M[R][C];
    }
}