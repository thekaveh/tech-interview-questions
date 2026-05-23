package codesignal.intro.chess_knight;
import java.util.*;
import java.util.stream.*;
import java.math.*;

// Approach: TODO.
class Solution1 {
    static int solution(String cell) {
        var r = cell.charAt(1) - '1' + 1;
        var c = cell.charAt(0) - 'a' + 1;
        
        var moves = 0;
        
        for(var move : moves(r, c)) {
            if(!isValidPos(move[0], move[1])) { continue; }
            
            moves++;
        }
        
        return moves;
    }

    static int[][] moves(int r, int c) {
        return new int[][] {
            { r - 2, c - 1 }
            , { r - 1, c - 2 }
            , { r + 1, c - 2 }
            , { r + 2, c - 1 }
            , { r + 2, c + 1 }
            , { r + 1, c + 2 }
            , { r - 1, c + 2 }
            , { r - 2, c + 1 }  
        };
    }

    static boolean isValidPos(int r, int c) {
        return 1 <= r && r <= 8 && 1 <= c && c <= 8;
    }
}
