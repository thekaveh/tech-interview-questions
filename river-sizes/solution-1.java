import java.util.*;

class Program {
    public static List<Integer> riverSizes(int[][] M) {
        var R = M.length;
        var C = M[0].length;

        var V = new boolean[R][C];
        var CCC = new ArrayList<Integer>();

        for(var i = 0; i < R; i++) {
            for(var j = 0; j < C; j++) {
                if(!canVisit(i, j, M, V)) { continue; }

                CCC.add(visitDFS(i, j, M, V, 0));
            }
        }

        return CCC;
    }

    private static int visitDFS(int i, int j, int[][] M, boolean[][] V, int cccc) {
        cccc++;
        V[i][j] = true;

        for(var adj : adj(i, j)) {
            if(!canVisit(adj[0], adj[1], M, V)) { continue; }

            cccc = visitDFS(adj[0], adj[1], M, V, cccc);
        }

        return cccc;
    }

    private static boolean canVisit(int i, int j, int[][] M, boolean[][] V) {
        var R = M.length;
        var C = M[0].length;

        if(i < 0 || i >= R) { return false; }
        if(j < 0 || j >= C) { return false; }
        if(M[i][j] == 0)    { return false; }
        if(V[i][j])         { return false; }

        return true;
    }

    private static int[][] adj(int i, int j) {
        return new int[][] {
            { i - 1, j }
            , { i + 1, j }
            , { i, j - 1 }
            , { i, j + 1 }
        };
    }
}