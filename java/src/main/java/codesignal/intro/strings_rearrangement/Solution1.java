package codesignal.intro.strings_rearrangement;
import java.util.*;
import java.util.stream.*;
import java.math.*;

// Approach: Generate all permutations, check each for consecutive one-diff property.
class Solution1 {
    static boolean solution(String[] A) {
        var N = A.length;
        
        var IDX = new ArrayList<Integer>();
        for(var idx = 0; idx < N; idx++) { IDX.add(idx); }
        
        var IDX_P = permutations(IDX);
        
        for(var idx_p : IDX_P) {
            var possible = true;
            
            for(var i = 1; i < N; i++) {
                var strA = A[idx_p.get(i - 1)];
                var strB = A[idx_p.get(i)];
                
                if(!differByOne(strA, strB)) { possible = false; break; }
            }
            
            if(possible) { return true; }
        }
        
        return false;
    }

    static boolean differByOne(String strA, String strB) {
        var N = strA.length();
        
        var differ = false;
        
        for(var i = 0; i < N; i++) {
            if(strA.charAt(i) == strB.charAt(i)) { continue; }
            
            if(differ) { return false; }
            
            differ = true;
        }
        
        return differ;
    }

    static List<List<Integer>> permutations(List<Integer> A) {
        var N = A.size();

        if(N == 0) { return new ArrayList<>(); }

        var Q = new LinkedList<List<Integer>>();

        Q.offer(new ArrayList<>());

        for(var a : A) {
            var L = Q.size();

            for(var i = 0; i < L; i++) {
                var T = Q.poll();

                for(var j = 0; j <= T.size(); j++) {
                    var U = new ArrayList<>(T);

                    U.add(j, a);

                    Q.offer(U);
                }
            }
        }

        return new ArrayList<>(Q);
    }
}
