import java.util.*;

class Program {
    public static List<Integer> riverSizes(int[][] M) {
        var R = M.length;
        var C = M[0].length;

        var V = new boolean[R][C];
        var CCC = new ArrayList<Integer>();

        for(var r = 0; r < R; r++) {
            for(var c = 0; c < C; c++) {
                if(!canVisit(r, c, M, V)) { continue; }

                CCC.add(visitDFS(r, c, M, V, 0));
            }
        }

        return CCC;
    }

    private static boolean canVisit(int r, int c, int[][] M, boolean[][] V) {
        var R = M.length;
        var C = M[0].length;

        if(r < 0 || R <= r) { return false; }
        if(c < 0 || C <= c) { return false; }
        if(M[r][c] == 0)    { return false; }
        if(V[r][c])         { return false; }

        return true;
    }

    private static int[][] adj(int r, int c) {
        return new int[][] {
            { r - 1, c }
            , { r + 1, c }
            , { r, c - 1 }
            , { r, c + 1 }
        };
    }

    private static int visitDFS(int r, int c, int[][] M, boolean[][] V, int cccc) {
        cccc++;
        V[r][c] = true;

        for(var adj : adj(r, c)) {
            if(!canVisit(adj[0], adj[1], M, V)) { continue; }

            cccc = visitDFS(adj[0], adj[1], M, V, cccc);
        }

        return cccc;
    }
}