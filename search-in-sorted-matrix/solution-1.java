import java.util.*;

class Program {
    public static int[] searchInSortedMatrix(int[][] M, int v) {
        var R = M.length;
        var C = M[0].length;

        for(var row = R - 1; row >= 0; row--) {
            for(var col = 0; col < C; col++) {
                var cmp = new Integer(M[row][col]).compareTo(v);

                if      (cmp < 0) { continue; }
                else if (cmp > 0) { break;  }
                else              { return new int[] { row, col }; }
            }
        }

        return new int[] {-1, -1};
    }
}