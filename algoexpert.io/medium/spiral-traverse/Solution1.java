import java.util.*;

class Solution1 {
    public static List<Integer> spiralTraverse(int[][] A) {
        var M = A.length;
        var N = A[0].length;

        var R = new ArrayList<Integer>();

        int rowLo = 0, rowHi = M - 1;
        int colLo = 0, colHi = N - 1;

        while(rowLo <= rowHi && colLo <= colHi) {
            for(var i = colLo; i <= colHi; i++)     { R.add(A[rowLo][i]); }
            for(var i = rowLo + 1; i < rowHi; i++)  { R.add(A[i][colHi]); }

            for(var i = colHi; rowLo != rowHi && i >= colLo; i--)     { R.add(A[rowHi][i]); }
            for(var i = rowHi - 1; colLo != colHi && i > rowLo; i--)  { R.add(A[i][colLo]); }

            rowLo++; rowHi--;
            colLo++; colHi--;
        }

        return R;
    }
}