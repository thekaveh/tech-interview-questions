package codesignal.intro.spiral_numbers;
import java.util.*;
import java.util.stream.*;
import java.math.*;

// Approach: Boundary-shrinking spiral fill (top, right, bottom, left).
class Solution1 {
    static int[][] solution(int N) {
        var R = new int[N][N];
        
        var loR = 0;
        var hiR = N - 1;
        
        var loC = 0;
        var hiC = N - 1;
        
        var k = 1;
        
        while(k <= N * N) {
            for(var c = loC; c <= hiC; c++) { R[loR][c] = k++; } loR++;
            for(var r = loR; r <= hiR; r++) { R[r][hiC] = k++; } hiC--;
            for(var c = hiC; c >= loC; c--) { R[hiR][c] = k++; } hiR--;
            for(var r = hiR; r >= loR; r--) { R[r][loC] = k++; } loC++;
        }
        
        return R;
    }
}
