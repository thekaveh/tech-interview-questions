package codesignal.intro.bishop_and_pawn;
import java.util.*;
import java.util.stream.*;
import java.math.*;

// Approach: Diagonal check via equal absolute row/column differences.
class Solution1 {
    static boolean solution(String bishop, String pawn) {
        var bishopR = Integer.valueOf(bishop.charAt(1));
        var bishopC = Integer.valueOf(bishop.charAt(0) - 'a') + 1;
        
        var pawnR = Integer.valueOf(pawn.charAt(1));
        var pawnC = Integer.valueOf(pawn.charAt(0) - 'a') + 1;
        
        return Math.abs(bishopR - pawnR) == Math.abs(bishopC - pawnC);
    }
}
