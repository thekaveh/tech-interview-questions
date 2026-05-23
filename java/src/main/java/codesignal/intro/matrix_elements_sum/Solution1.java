package codesignal.intro.matrix_elements_sum;
import java.util.*;
import java.util.stream.*;
import java.math.*;

// Approach: TODO.
class Solution1 {
    static int solution(int[][] M) {
        var R = M.length;
        var C = M[0].length;
        
        var T = 0;
        var H = new boolean[C];
        
        for(var r = 0; r < R; r++) {
            for(var c = 0; c < C; c++) {
                if(M[r][c] == 0 || H[c]) { H[c] = true; continue; }
                
                T += M[r][c];
            }
        }
        
        return T;
    }
}
