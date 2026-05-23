package codesignal.intro.sudoku;
import java.util.*;
import java.util.stream.*;
import java.math.*;

// Approach: TODO.
class Solution1 {
    static boolean solution(int[][] M) {
        var pattern = new HashMap<Integer, Integer>();
        for(var i = 1; i <= 9; i++) { pattern.put(i, 1); }
        
        for(var r = 0; r < 9; r++) {
            var p = new HashMap<>(pattern);
            
            for(var c = 0; c < 9; c++) {
                if(p.get(M[r][c]) == 0) { return false; }
                
                p.put(M[r][c], 0);
            }
        }
        
        for(var c = 0; c < 9; c++) {
            var p = new HashMap<>(pattern);
            
            for(var r = 0; r < 9; r++) {
                if(p.get(M[r][c]) == 0) { return false; }
                
                p.put(M[r][c], 0);
            }
        }
        
        for(var R = 0; R < 3; R++) {
            for(var C = 0; C < 3; C++) {
                var p = new HashMap<>(pattern);
                
                for(var r = 3 * R; r < 3 * R + 3; r++) {
                    for(var c = 3 * C; c < 3 * C + 3; c++) {
                        if(p.get(M[r][c]) == 0) { return false; }
                        
                        p.put(M[r][c], 0);
                    }
                }
            }
        }
        
        return true;
    }
}
