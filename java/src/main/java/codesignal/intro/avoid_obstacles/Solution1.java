package codesignal.intro.avoid_obstacles;
import java.util.*;
import java.util.stream.*;
import java.math.*;

// Approach: TODO.
class Solution1 {
    static int solution(int[] A) {
        var N = A.length;
        
        Arrays.sort(A);
        
        var C = new ArrayList<Integer>();
        for(var c = 2; c <= A[N - 1] + 1; c++) { C.add(c); }
        
        for(var c : C) {
            var isDivisible = false;
            
            for(var a : A) { if(a % c == 0) { isDivisible = true; break; } }
            
            if(!isDivisible) { return c; }
        }
        
        return -1;
    }
}
