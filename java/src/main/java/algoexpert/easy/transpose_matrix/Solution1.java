package algoexpert.easy.transpose_matrix;
import java.util.*;

// Approach: Allocate new matrix, nested loop fill.
class Solution1 {
    public int[][] transposeMatrix(int[][] A) {
        var R = A.length;
        var C = A[0].length;

        var B = new int[C][R];

        for(var r = 0; r < R; r++) {
            for(var c = 0; c < C; c++) {
                B[c][r] = A[r][c];
            }
        }

        return B;
    }
}
