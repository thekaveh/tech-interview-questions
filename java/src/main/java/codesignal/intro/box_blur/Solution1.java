package codesignal.intro.box_blur;
import java.util.*;
import java.util.stream.*;
import java.math.*;

// Approach: TODO.
class Solution1 {
    static int[][] solution(int[][] A) {
        var R = A.length;
        var C = A[0].length;
        
        var B = new int[R - 2][C - 2];
        
        for(var r = 1; r < R - 1; r++) {
            for(var c = 1; c < C - 1; c++) {
                for(var pos : box(r, c)) {
                    B[r - 1][c - 1] += A[pos[0]][pos[1]];
                }
                
                B[r - 1][c - 1] /= 9;
            }
        }
        
        return B;
    }

    private static int[][] box(int r, int c) {
        return new int[][] {
            { r - 1, c - 1 }, { r - 1, c }, { r - 1, c + 1 }
            , { r, c - 1 }, { r, c }, { r, c + 1 }
            , { r + 1, c - 1 }, { r + 1, c }, { r + 1, c + 1 }
        };
    }
}
