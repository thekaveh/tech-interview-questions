package codesignal.intro.mine_sweeper;
import java.util.*;
import java.util.stream.*;
import java.math.*;

// Approach: TODO.
class Solution1 {
    static int[][] solution(boolean[][] A) {
        var R = A.length;
        var C = A[0].length;
        
        var B = new int[R][C];
        
        for(var r = 0; r < R; r++) {
            for(var c = 0; c < C; c++) {
                if(!A[r][c]) { continue; }
                
                for(var pos : adj(r, c)) {
                    var posR = pos[0];
                    var posC = pos[1];
                    
                    if(!isValidPos(posR, posC, A)) { continue; }
                    
                    B[posR][posC]++;
                }
            }
        }
        
        return B;
    }

    private static int[][] adj(int r, int c) {
        return new int[][] {
            { r - 1, c - 1 }, { r - 1, c }, { r - 1, c + 1 }
            , { r, c - 1 }, { r, c + 1 }
            , { r + 1, c - 1 }, { r + 1, c }, { r + 1, c + 1 }  
        };
    }

    private static boolean isValidPos(int r, int c, boolean[][] A) {
        var R = A.length;
        var C = A[0].length;
        
        if(r < 0 || r >= R) { return false; }
        if(c < 0 || c >= C) { return false; }
        
        return true;
    }
}
