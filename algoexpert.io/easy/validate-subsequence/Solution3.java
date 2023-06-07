import java.util.*;

class Solution3 {
    public static boolean isValidSubsequence(List<Integer> A, List<Integer> S) {
        var M = A.size();
        var N = S.size();
        
        var i = 0;
        var j = 0;
            
        while(j < N) {
            if(i >= M) { return false; }
            
            if(A.get(i++).equals(S.get(j))) { j++; }
        }

        return true;
    }
}