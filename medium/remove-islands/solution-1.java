import java.util.*;

class Program {
    public int[][] removeIslands(int[][] A) {
        var R = A.length;
        var C = A[0].length;

        var ccIdx = 0;
        var CC = new int[R][C];
        var M = new boolean[R][C];

        for(var r = 0; r < R; r++) { Arrays.fill(CC[r], -1); }

        for(var r = 0; r < R; r++) {
            for(var c = 0; c < C; c++) {
                visitDFS(r, c, ccIdx++, A, M, CC);
            }
        }

        var excCC = new HashSet<Integer>(Arrays.asList(-1));
        for(var r = 0; r < R; r++) { excCC.add(CC[r][0]); excCC.add(CC[r][C - 1]); }
        for(var c = 0; c < C; c++) { excCC.add(CC[0][c]); excCC.add(CC[R - 1][c]); }

        for(var r = 0; r < R; r++) {
            for(var c = 0; c < C; c++) {
                if(!excCC.contains(CC[r][c])) { A[r][c] = 0; }
            }
        }

        return A;
    }

    private static int[][] adj(int c, int r) {
        return new int[][] { { c - 1, r}, {c + 1, r}, { c, r - 1 }, { c, r + 1 } };
    }

    private static void visitDFS(int r, int c, int ccIdx, int[][] A, boolean[][] M, int[][] CC) {
        var R = A.length;
        var C = A[0].length;

        if(r < 0 || r >= R) { return; }
        if(c < 0 || c >= C) { return; }
        
        if(A[r][c] == 0)    { return; }
        if(M[r][c])         { return; }

        M[r][c] = true;
        CC[r][c] = ccIdx;

        for(var adj : adj(r, c)) { visitDFS(adj[0], adj[1], ccIdx, A, M, CC); }
    }
}