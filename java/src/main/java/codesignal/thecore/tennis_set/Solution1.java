package codesignal.thecore.tennis_set;
import java.util.*;
import java.util.stream.*;
import java.math.*;

// Approach: TODO.
class Solution1 {
    static boolean solution(int score1, int score2) {
        if(score1 == score2) { return false; }
        
        var bigger = Math.max(score1, score2);
        var smaller = Math.min(score1, score2);
        
        if(bigger == 6 && smaller < 5) { return true; }
        if(bigger == 7 && 5 <= smaller && smaller < 7) { return true; }
        
        return false;
    }
}
