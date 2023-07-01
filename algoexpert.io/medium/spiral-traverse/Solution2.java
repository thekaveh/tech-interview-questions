import java.util.*;

class Solution2 {
    public static List<Integer> spiralTraverse(int[][] A) {
        var R = A.length;
        var C = A[0].length;

        int loR = 0, hiR = R - 1;
        int loC = 0, hiC = C - 1;

        var S = new ArrayList<Integer>();

        while(loR <= hiR && loC <= hiC) {
            for(var c = loC; c <= hiC; c++)     { S.add(A[loR][c]); }
            for(var r = loR + 1; r < hiR; r++)  { S.add(A[r][hiC]); }
            
            for(var c = hiC; loR != hiR && loC <= c; c--)       { S.add(A[hiR][c]); }
            for(var r = hiR - 1; loC != hiC && loR < r; r--)    { S.add(A[r][loC]); }

            loR++; hiR--;
            loC++; hiC--;
        }

        return S;
    }
}