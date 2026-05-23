package codesignal.intro.matrix_elements_sum;
import java.util.*;
import java.util.stream.*;
import java.math.*;

// Approach: TODO.
class Solution2 {
    static int solution(int[][] M) {
        var R = M.length;
        var C = M[0].length;
        
        var T = 0;
        
        for(var c = 0; c < C; c++) {
            for(var r = 0; r < R; r++) {
                if(M[r][c] > 0) { T += M[r][c]; }
                else            { break; }
            }
        }
        
        return T;
    }
}
